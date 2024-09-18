package com.kirana.controller;

import com.kirana.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/api/report")
public class ReportingController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/summary")
    public Map<String, Object> generateReport(@RequestParam String period) {
        // Logic to generate report for the given period
    }
}
