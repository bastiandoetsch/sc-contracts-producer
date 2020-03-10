package contracts.payment

import org.springframework.cloud.contract.spec.Contract

type = "paymentReleased"
paymentId = "asd123"
amount = "23.28"
currency = "EUR"

Contract.make {
    description("should send a payment released event")
    input {
        triggeredBy("releasePayment(\"$paymentId\", \"$amount\", \"$currency\")")
    }
    outputMessage {
        sentTo("payment-released")
        body([
                paymentId: "$paymentId",
                amount   : "$amount",
                currency : "$currency"
        ])
        headers {
            header("aggregateId", "$paymentId")
            header("eventType", "$type")
        }
    }

}
