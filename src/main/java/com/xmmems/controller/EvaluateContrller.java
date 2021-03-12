package com.xmmems.controller;

import com.xmmems.domain.Evaluate;
import com.xmmems.service.EvaluateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("evaluate")
public class EvaluateContrller {
    @Autowired
    EvaluateService evaluateService;

    @PostMapping("/add")
    public ResponseEntity<Void> save(@RequestParam(value = "uName") String uName,
                                     @RequestParam(value = "uId") Integer uId,
                                     @RequestParam(value = "role") String role,
                                     @RequestParam(value = "checkedCities", required = false) List<Integer> checkedCities,
                                     @RequestParam(value = "opinion") String opinion) {
        evaluateService.add(uName,uId,role,checkedCities,opinion);

        return ResponseEntity.status(HttpStatus.CREATED).build();
    }


    @GetMapping("/findById")
    public ResponseEntity<Evaluate> findById(@RequestParam(value = "uId") Integer uId){
        Evaluate evaluate = evaluateService.findById(uId);
        return ResponseEntity.ok(evaluate);
    }
}
