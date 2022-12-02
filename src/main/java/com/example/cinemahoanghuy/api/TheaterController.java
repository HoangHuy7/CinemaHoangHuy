package com.example.cinemahoanghuy.api;

import com.example.cinemahoanghuy.dto.TTheaterDTO;
import com.example.cinemahoanghuy.service.ITheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/v1/theater")
public class TheaterController {
    @Autowired
    private ITheaterService theaterService;
    @Autowired
    private DateTimeFormatter dateTimeFormatter;


    @GetMapping("/findAll")
    public ResponseEntity<List<TTheaterDTO>> findAll() {
        return ResponseEntity.ok().body(theaterService.findALl());
    }


    @GetMapping("/findAll/{branchName}")
    public ResponseEntity<List<TTheaterDTO>> findAllInBranchName(@PathVariable("branchName") String name) {
        if (name.contains("all")) {
            return ResponseEntity.ok().body(theaterService.findALl());
        } else {
            return ResponseEntity.ok().body(theaterService.findTheaterInBranchName(name));
        }
    }

    @GetMapping("/branches/{branchId}")
    public ResponseEntity<List<TTheaterDTO>> findAllInBranchId(@PathVariable("branchId") Long id) {
        if (id == 0) {
            return ResponseEntity.ok().body(theaterService.findALl());
        } else {
            return ResponseEntity.ok().body(theaterService.findTheaterByBranchId(id));
        }
    }

    @GetMapping("/findAllTheaterByBranchNameAndTheaterNameAndDateShow")
    public ResponseEntity<List<TTheaterDTO>> findAllTheaterByBranchNameAndTheaterNameAndDateShow(@RequestParam Map<String, String> requestMap) {

        String theaterName = requestMap.get("theaterName");
        LocalDate showDate = LocalDate.parse(requestMap.get("showDate"), dateTimeFormatter);
        Long movieId = Long.valueOf(requestMap.get("movieId"));
        String branchName = requestMap.get("branchName");
        List<TTheaterDTO> tTheaterDTOS = theaterService.findAllTByBranchNameAndTheaterNameAndDateShow(theaterName, showDate, movieId, branchName);
        return ResponseEntity.ok().body(tTheaterDTOS);
    }

    @GetMapping("/findAllTheaterByBranchIdAndTheaterIdAndDateShow")
    public ResponseEntity<List<TTheaterDTO>> findAllTheaterByBranchIdAndTheaterIdAndDateShow(@RequestParam Map<String, String> requestMap) {
        List<TTheaterDTO> tTheaterDTOS = new ArrayList<>();

        try {
            DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            Long theaterId = Long.valueOf(requestMap.get("theaterId"));
            LocalDate showDate = LocalDate.parse(requestMap.get("showDate"), formatter2);
            Long movieId = Long.valueOf(requestMap.get("movieId"));
            Long branchId = Long.valueOf(requestMap.get("branchId"));
            tTheaterDTOS = theaterService.findAllTByBranchIdAndTheaterIdAndDateShow(showDate, movieId, branchId, theaterId);
            return ResponseEntity.ok().body(tTheaterDTOS);
        } catch (Exception e) {
            return ResponseEntity.ok().body(tTheaterDTOS);
        }

    }
}
