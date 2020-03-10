package io.pivotal.basti.sccontracts.payment;

import lombok.val;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;


@EnableBinding(PaymentReleasedChannel.class)
@Service
public class PaymentService {

    final PaymentReleasedChannel paymentReleasedChannel;

    public PaymentService(PaymentReleasedChannel paymentReleasedChannel) {
        this.paymentReleasedChannel = paymentReleasedChannel;
    }

    public void releasePayment(String id, BigDecimal amount, String currency) {
        val paymentReleasedEvent = PaymentReleasedEvent.builder().amount(amount).currency(currency).paymentId(id).build();
        paymentReleasedChannel.output().send(getPaymentReleasedMessage(paymentReleasedEvent));
    }

    private Message<PaymentReleasedEvent> getPaymentReleasedMessage(PaymentReleasedEvent paymentReleasedEvent) {
        return MessageBuilder
                .withPayload(paymentReleasedEvent)
                .setHeader("aggregateId", paymentReleasedEvent.getPaymentId())
                .setHeader("eventType", "paymentReleased")
                .build();
    }


}
