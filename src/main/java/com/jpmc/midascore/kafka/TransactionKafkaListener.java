package com.jpmc.midascore.kafka;

import com.jpmc.midascore.foundation.Transaction;
import com.jpmc.midascore.service.TransactionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class TransactionKafkaListener {

    private static final Logger logger = LoggerFactory.getLogger(TransactionKafkaListener.class);

    private final TransactionService transactionService;
    private int transactionCount = 0;

    public TransactionKafkaListener(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @KafkaListener(
            topics = "${general.kafka-topic}",
            groupId = "${spring.kafka.consumer.group-id}"
    )
    public void onMessage(Transaction transaction) {
        // Process the transaction
        transactionService.processTransaction(transaction);

        // Increment counter
        transactionCount++;

        // Log progress every 10 transactions
        if (transactionCount % 10 == 0) {
            logger.info("=== Processed {} transactions so far ===", transactionCount);
        }
        // Print every 20 transactions
        if (transactionCount % 20 == 0) {
            System.out.println("\n========================================");
            System.out.println("PROCESSED " + transactionCount + " TRANSACTIONS");
            transactionService.logAllBalances();
            System.out.println("========================================\n");
        }
        // Log all balances every 50 transactions (adjust as needed)
        if (transactionCount % 50 == 0) {
            transactionService.logAllBalances();
        }
    }
}