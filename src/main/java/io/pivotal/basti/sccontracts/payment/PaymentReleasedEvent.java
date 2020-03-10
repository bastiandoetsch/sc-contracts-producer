package io.pivotal.basti.sccontracts.payment;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
public class PaymentReleasedEvent {
    private String paymentId, currency;
    private BigDecimal amount;
}
