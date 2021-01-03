package edu.bit.designing.messaging;

import edu.bit.designing.messaging.entity.Message;
import edu.bit.designing.messaging.provider.QueueServiceProvider;
import edu.bit.designing.messaging.provider.SourceProvider;

public class MessagingService {

    public static void main(String[] args) {
        SourceProvider sourceProvider = new SourceProvider();
        boolean works = sourceProvider.produce("Q1", "P1", Message.builder()
                .messageId("M1")
                .text("Hello World !")
                .build());
        if (works) {
            QueueServiceProvider queueServiceProvider = new QueueServiceProvider();
            queueServiceProvider.notifyConsumers("Q1");
        }
    }
}