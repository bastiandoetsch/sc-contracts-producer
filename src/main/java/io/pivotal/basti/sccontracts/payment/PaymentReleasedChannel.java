package io.pivotal.basti.sccontracts.payment;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


public interface PaymentReleasedChannel {
    String CHANNEL_NAME = "payment-released";

    @Output(CHANNEL_NAME)
    MessageChannel output();
}

