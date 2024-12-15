package dev.pravallika.paymentservice.controller;

import dev.pravallika.paymentservice.dto.OrderRequestDTO;
import dev.pravallika.paymentservice.service.PaymentService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
    public PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping("/ping")
    public String ping() {
        return "Payment service is up and running.";
    }

    @PostMapping("/initiate-payment")
    public String initiatePayment(@RequestBody OrderRequestDTO orderRequestDTO) {
        System.out.println("payment initiated..");
       return  paymentService.initiatePayment(orderRequestDTO.getId(),
                orderRequestDTO.getOrderId(),
                orderRequestDTO.getUserId(),
                orderRequestDTO.getAmount());
    }
}
