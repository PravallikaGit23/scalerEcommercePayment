package dev.pravallika.paymentservice.controller;

import dev.pravallika.paymentservice.dto.OrderRequestDTO;
import dev.pravallika.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
public class WebhookController {
    public PaymentService paymentService;

    public WebhookController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }


    @PostMapping("/webhook")
    public void initiatePayment(@RequestBody Object object) {
        System.out.println("payment updated.." + object);

    }

    @GetMapping("/webhook")
    public void initiatePayment() {
        System.out.println("payment successfully..");

    }

}
