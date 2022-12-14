package com.example.cinemahoanghuy;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.cinemahoanghuy.dto.TMoviesDTO;
import com.example.cinemahoanghuy.entity.*;
import com.example.cinemahoanghuy.repo.ScheduleRepository;
import com.example.cinemahoanghuy.repo.TheaterRepository;
import com.example.cinemahoanghuy.service.*;
import com.example.cinemahoanghuy.service.serviceImpl.TheaterService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

@SpringBootApplication
@RequiredArgsConstructor
@Slf4j
public class CinemaHoangHuyApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(CinemaHoangHuyApplication.class, args);
    }

    @Bean
    public SimpleDateFormat initSimpleDateFormat(){
           return new SimpleDateFormat("dd/MM/yyyy HH:mm");
    }

    @Bean
    public DateTimeFormatter initDateTimeFormatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return formatter;
    }

    @Autowired
    private SimpleDateFormat simpleDateFormat;
    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPermissionService permissionService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IMovieService movieService;

    @Autowired
    private IBranchService branchService;


    @Autowired
    private TheaterRepository theaterRepository;

    @Autowired
    private TheaterService theaterService;

    @Autowired
    private ScheduleRepository scheduleRepository;
    @Bean
    public ModelMapper initModelMaper() {
        return new ModelMapper();
    }

    @Override
    public void run(String... args) throws Exception {
//        User user = User.builder().fullName("huy").password(passwordEncoder.encode("1234")).username("huy").build();
//        Role role = Role.builder().name("ADMIN").build();
//        Permission permission = Permission.builder().name("CREATE").build();
//
//
//        System.out.println(userService.save(user));
//        roleService.save(role);
//        userService.addRoleToUser("huy", "ADMIN");
//        permissionService.save(permission);
//        roleService.addPermissionToRole("ADMIN", "CREATE");

//        // T???o chi nh??nh
//        Branch branch1 = Branch.builder().name("HO CHI MINH")
//                .address("HO CHI MINH")
//                .mapURL("HINH ANH HO CHI MINH")
//                .phone("0982738308")
//                .build();
//
//        Branch branch2 = Branch.builder().name("TRA VINH")
//                .address("Tr?? Vinh")
//                .mapURL("hinh_anh_dia_chi_tv")
//                .phone("0982738308")
//                .build();
//
//        log.warn(branchService.save(branch1) + "\t" +"???? th??m chi nh??nh 1");
//        log.warn(branchService.save(branch2) + "\t" + "???? th??m chi nh??nh 2");
//        // t???o phim
//        Movies movies1 = Movies.builder()
//                .name("NG?????I NH???N KH??NG C??N NH??")
//                .premiere(new Date(System.currentTimeMillis()))
//                .description("phim hay l???m c?? b???n t??")
//                .imageURL("https://www.cgv.vn/media/catalog/product/cache/1/thumbnail/190x260/2e2b8cd282892c71872b9e67d2cb5039/s/n/snwh_new_fb1080x1350_1_.jpg")
//                .trailerURL("https://www.youtube.com/watch?v=m6Js2_43xBw")
//                .build();
//        Movies movies2 = Movies.builder()
//                .name("MINIONS: S??? TR???I D???Y C???A GRU")
//                .premiere(new Date(System.currentTimeMillis()))
//                .description("phim de th????ng l???m")
//                .imageURL("https://www.cgv.vn/media/catalog/product/cache/1/thumbnail/190x260/2e2b8cd282892c71872b9e67d2cb5039/m/i/minions_2_-_kc_01.7.22_1__1.jpg")
//                .trailerURL("https://www.youtube.com/watch?v=dTQXlDV16SY")
//                .build();
//        Movies movies3 = Movies.builder()
//                .name("C?? LAO X??C S???NG")
//                .premiere(new Date(System.currentTimeMillis()))
//                .description("??n th???t ng?????i")
//                .imageURL("https://www.cgv.vn/media/catalog/product/cache/1/thumbnail/190x260/2e2b8cd282892c71872b9e67d2cb5039/m/a/main_1_fa_1080x1350.jpg")
//                .trailerURL("https://www.youtube.com/watch?v=c7wh9mwkDK8")
//                .build();
//
//        ModelMapper modelMapper = initModelMaper();
//        log.warn(movieService.save(modelMapper.map(movies1, TMoviesDTO.class) ) + "\t" + "???? th??m phim 1");
//        log.warn(movieService.save(modelMapper.map(movies2, TMoviesDTO.class)) + "\t" + "???? th??m phim 3");
//        log.warn(movieService.save(modelMapper.map(movies3, TMoviesDTO.class)) + "\t" + "???? th??m phim 2");


//        // th??m r???p
//        Theater theater1 = Theater.builder().name("ViVo City")
//                .address("Qu???n 7")
//                .image("h??nh ???nh")
//                .imageUrl("h??nh ???nh")
//                .shortName("VIVOCITYQUAN7")
//                .build();
//        Theater theater2 = Theater.builder().name("Viccom Tr?? Vinh")
//                .address("Qu???n 7")
//                .image("h??nh ???nh")
//                .imageUrl("h??nh ???nh")
//                .shortName("VIVOCITYQUAN7")
//                .build();
//        Theater theater3 = Theater.builder().name("VAN HANH MALL")
//                .address("Qu???n 10")
//                .image("h??nh ???nh")
//                .imageUrl("h??nh ???nh")
//                .shortName("VANHANHMALLQUAN10")
//                .build();


//        log.warn(theaterRepository.save(theater1) +"\n" + "???? th??m r???p 1");
//        log.warn(theaterRepository.save(theater2) +"\n" + "???? th??m r???p 2");
//        log.warn(theaterRepository.save(theater3) +"\n" + "???? th??m r???p 3");
//
//
//        //add theater to branch
//        branchService.addTheaterToBranch("ViVo City","HO CHI MINH");
//        branchService.addTheaterToBranch("Viccom Tr?? Vinh","TRA VINH");
//        branchService.addTheaterToBranch("VAN HANH MALL","HO CHI MINH");
        // th??m l???ch chi???u
//        Schedule schedule1 = Schedule.builder()
//                .price(new BigDecimal(70000))
//                .showDate( simpleDateFormat.parse("20/07/2022 00:00"))
//                .timeStart( simpleDateFormat.parse("20/07/2022 10:00"))
//                .build();
//
//        Schedule schedule2 = Schedule.builder()
//                .price(new BigDecimal(80000))
//                .showDate( simpleDateFormat.parse("20/07/2022 00:00"))
//                .timeStart( simpleDateFormat.parse("20/07/2022 19:30"))
//                .build();
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm");
//        String time = "17:00";
//        String date = "20/07/2022";
//        LocalDate localDate = LocalDate.parse(date, formatter);
//        LocalTime localTime = LocalTime.parse(time,formatter2);
//
//                Schedule schedule3 = Schedule.builder()
//                .price(new BigDecimal(80000))
//                .showDate( localDate)
//                .timeStart( localTime)
//                .build();
//
//        log.warn(scheduleRepository.save(schedule1) + "\n ???? th??m l???ch 1");
//        log.warn(scheduleRepository.save(schedule2) + "\n ???? th??m l???ch 2");
//            log.warn(scheduleRepository.save(schedule3) + "\n ???? th??m l???ch 3");

//        theaterService.addScheduleToTheater("Viccom Tr?? Vinh",3L);
//        theaterService.addScheduleToTheater("",4L);
    }
}
