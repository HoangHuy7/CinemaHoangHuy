package com.example.cinemahoanghuy.api;


import com.example.cinemahoanghuy.dto.TBillDTO;
import com.example.cinemahoanghuy.security.UserPrincipal;
import com.example.cinemahoanghuy.service.IBillService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@CrossOrigin("*")
@RequestMapping("/api/v1/bill")
@RestController
@RequiredArgsConstructor
public class BillController {


    @Autowired
    private IBillService billService;

    @GetMapping("/findAllByUserId/{userId}")
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<?> findAllByUserId(@PathVariable("userId") Long userid){
        Map<String, Object> response = new HashMap<>();
        response.put("message", "true");
        response.put("data", billService.findAllByUserId(userid));
        return ResponseEntity
                .ok()
                .body(response);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @PreAuthorize("hasAnyAuthority('USER')")
    public ResponseEntity<?> createBill(@RequestBody @NotNull BillCreate BillCreate
            ,
                                        Principal principal) {

        Map<String, Object> message = new HashMap<>();

        TBillDTO tBillDTO =

        billService.createBill(
                BillCreate.userId,
                principal.getName(),
                BillCreate.roomId,
                BillCreate.scheduleId,
                BillCreate.listPosition
        );
        if (tBillDTO == null) {
            message.put("message", "false");
            message.put("description", "Position have other choice or position not in room");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
        message.put("message", "true");
        message.put("data", tBillDTO);
        return ResponseEntity.ok().body(message);
    }

    @Data
    static class BillCreate {
        private Long userId;
        private Long roomId;
        private Long scheduleId;
        private List<String> listPosition;
    }
}
