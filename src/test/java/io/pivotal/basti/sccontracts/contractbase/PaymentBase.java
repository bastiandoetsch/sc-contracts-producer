package io.pivotal.basti.sccontracts.contractbase;

import io.pivotal.basti.sccontracts.payment.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;

import java.math.BigDecimal;

@SpringBootTest
@AutoConfigureMessageVerifier
public class PaymentBase {
    @Autowired
    PaymentService paymentService;

    public void releasePayment(String paymentId, String amount, String currency) {
        paymentService.releasePayment(paymentId, new BigDecimal(amount), currency);
    }
}
