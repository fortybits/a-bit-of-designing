package edu.bit.designing.messaging.entity;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class Message {
    String messageId;
    String text;
}
