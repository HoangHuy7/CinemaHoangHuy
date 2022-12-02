package com.example.cinemahoanghuy.service;

import com.example.cinemahoanghuy.dto.TBillDTO;

import java.util.List;

public interface IBillService extends IGeneralService<TBillDTO> {

    TBillDTO createBill(Long userId,String username, Long roomId, Long scheduleId, List<String> listPosition);

    List<TBillDTO> findAllByUserId(Long userId);
}
