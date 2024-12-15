package dev.pravallika.paymentservice.service;

import com.stripe.exception.StripeException;
import dev.pravallika.paymentservice.model.OrderDetails;

public interface Payment {
    String generatePaymentLink(OrderDetails orderDetails) throws StripeException;
}
