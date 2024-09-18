package com.kirana.controller;

import com.kirana.model.Transaction;
import com.kirana.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transaction recordTransaction(@Valid @RequestBody Transaction transaction) {
        return transactionService.recordTransaction(transaction);
    }

    @GetMapping
    public List<Transaction> getTransactions(@RequestParam String start, @RequestParam String end) {
        return transactionService.getTransactions(LocalDate.parse(start), LocalDate.parse(end));
    }
}
