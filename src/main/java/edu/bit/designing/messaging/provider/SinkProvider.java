package edu.bit.designing.messaging.provider;

import edu.bit.designing.messaging.entity.Message;
import edu.bit.designing.messaging.service.Sink;

public class SinkProvider implements Sink {

    QueueServiceProvider queueServiceProvider;

    public SinkProvider(){
        queueServiceProvider = new QueueServiceProvider();
    }

    public void notified(String queueId, String consumerId) {
        System.out.println(consumerId + " got notified by " + queueId);
        consume(queueId, consumerId);
    }

    public void consume(String queueId, String consumerId) {
        Message message = queueServiceProvider.readTopMessage(queueId);
        System.out.println(consumerId + " has consumed " + message.getMessageId() + " from " + queueId);
    }
}