package com.example.cinemahoanghuy.service.serviceImpl;

import com.example.cinemahoanghuy.dto.TBillDTO;
import com.example.cinemahoanghuy.entity.*;
import com.example.cinemahoanghuy.repo.*;
import com.example.cinemahoanghuy.service.IBillService;
import com.example.cinemahoanghuy.util.QRCodeUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BillService implements IBillService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ScheduleRepository scheduleRepository;
    @Autowired
    private RoomRepository roomRepository;
    @Autowired
    private BillRepository billRepository;
    @Autowired
    private SeatRepository seatRepository;

    @Autowired
    private ModelMapper modelMapper;

    private boolean checkPositionSeatInRoomAndSchedule(List<String> listPosition, Long scheduleId, Long roomId, Room room) {
        Optional<List<Seat>> seats = seatRepository.findAllByScheduleIdAndRoomId(scheduleId, roomId, listPosition);
        int sizeRoom = room.getTotalSeat();
        Collections.sort(listPosition);
        int max = Integer.parseInt(listPosition.get(listPosition.size() - 1));
        int min = Integer.parseInt(listPosition.get(0));
        int isSeatsInRoom = seats.orElse(new ArrayList<>()).size();
        return isSeatsInRoom <= 0
                && max <= sizeRoom
                && min > 0;
    }


    @Override
    @Transactional
    public TBillDTO createBill(Long userId, String username, Long roomId, Long scheduleId, List<String> listPosition) {
        Optional<User> user = userRepository.findById(userId);
        Bill bill = null;
        if (user.isPresent() && user.orElse(new User()).getUsername().equals(username)) {
            Optional<Schedule> scheduleOptional = scheduleRepository.findById(scheduleId);
            if (scheduleOptional.isPresent()) {
                Room room = roomRepository.findById(roomId).get();
                if (checkPositionSeatInRoomAndSchedule(listPosition, scheduleId, roomId, room)) {
                    Schedule schedule = scheduleOptional.get();
                    User userCurrent = user.get();

                    bill = Bill.builder().user(userCurrent).build();

                    List<Ticket> tickets = new ArrayList<>();
                    for (String position :
                            listPosition) {

                        Seat seat = Seat.builder().position(position).scheduleId(scheduleId).room(room).build();

                        String qrCode = QRCodeUtil.createBase64QRCode(
                                "user " + userCurrent.getUsername() + " have position :" + position + " in " + schedule.getShowDate()
                                , 100, 100);
                        System.out.println(qrCode);
                        tickets.add(Ticket.builder().bill(bill).QRCode(qrCode).seat(seat).schedule(schedule).build());
                    }
                    BigDecimal price = schedule.getPrice();
                    BigDecimal quantity = new BigDecimal(listPosition.size() + ".0");
                    BigDecimal totalPrice = price.multiply(quantity);
                    bill.setTotal(totalPrice);
                    bill.setQuantityTicket(listPosition.size());
                    bill.setTickets(tickets);
                    bill = billRepository.saveAndFlush(bill);
                }
            }
        }
        return bill != null ? modelMapper.map(bill, TBillDTO.class) : null;
    }

    @Override
    public List<TBillDTO> findAllByUserId(Long userId) {

        List<TBillDTO> tBillDTOS = billRepository
                .findAllByUserId(userId)
                .orElse(new ArrayList<>())
                .stream()
                .map(
                        bill ->  modelMapper.map(bill, TBillDTO.class)
                )

                .collect(Collectors.toList());
        return tBillDTOS;
    }

    @Override
    public List<TBillDTO> findALl() {
        return null;
    }

    @Override
    public Optional<TBillDTO> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public TBillDTO save(TBillDTO tBillDTO) {
        return null;
    }

    @Override
    public void delete(TBillDTO tBillDTO) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public TBillDTO update(TBillDTO tBillDTO) {
        return null;
    }


}
