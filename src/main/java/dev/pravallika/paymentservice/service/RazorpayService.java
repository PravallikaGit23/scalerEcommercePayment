package dev.pravallika.paymentservice.service;

import dev.pravallika.paymentservice.model.OrderDetails;
import org.springframework.stereotype.Service;

@Service
public class RazorpayService implements Payment{
    @Override
    public String generatePaymentLink(OrderDetails orderDetails) {
        return "";
    }
}
