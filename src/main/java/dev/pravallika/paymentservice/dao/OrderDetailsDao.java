package dev.pravallika.paymentservice.dao;

import dev.pravallika.paymentservice.model.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderDetailsDao extends JpaRepository<OrderDetails,Long> {

    public OrderDetails save(OrderDetails orderDetails);
}
