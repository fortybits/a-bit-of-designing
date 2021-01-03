package edu.bit.designing.messaging.service;

import edu.bit.designing.messaging.entity.Message;

public interface Source {

    boolean produce(String queueId, String producerId, Message message);
}