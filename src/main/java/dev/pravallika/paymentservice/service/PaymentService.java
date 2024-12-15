package dev.pravallika.paymentservice.service;

import com.stripe.exception.StripeException;
import dev.pravallika.paymentservice.dao.OrderDetailsDao;
import dev.pravallika.paymentservice.model.OrderDetails;
import org.springframework.stereotype.Service;

@Service
public class PaymentService{
    public PaymentGatewaySelector paymentGatewaySelector;
    public OrderDetailsDao orderDetailsDao;
    public PaymentService(PaymentGatewaySelector paymentGatewaySelector, OrderDetailsDao orderDetailsDao){
          this.paymentGatewaySelector = paymentGatewaySelector;
          this.orderDetailsDao = orderDetailsDao;
    }

    public String initiatePayment(Long id, String orderId, String userId, long amount) {
        OrderDetails orderDetails = new OrderDetails();
        orderDetails.setId(id);
        orderDetails.setAmount(amount);
        orderDetails.setStatus("INITIATED");
        orderDetails.setOrderId(orderId);
        orderDetails.setUserId(userId);
        orderDetailsDao.save(orderDetails);
        try {
            return paymentGatewaySelector.getPaymentService().generatePaymentLink(orderDetails);
        } catch (StripeException e) {
            throw new RuntimeException(e);
        }
    }
}
