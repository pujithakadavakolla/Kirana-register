package com.kirana.service;

import com.kirana.model.Transaction;
import com.kirana.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction recordTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }

    public List<Transaction> getTransactions(LocalDate start, LocalDate end) {
        return transactionRepository.findByTimestampBetween(start, end);
    }
}
