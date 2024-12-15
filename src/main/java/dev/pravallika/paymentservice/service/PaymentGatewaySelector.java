package dev.pravallika.paymentservice.service;

import org.springframework.stereotype.Component;

@Component
public class PaymentGatewaySelector {

    public RazorpayService razorpayService;
    public StripePaymentService stripePaymentService;

   public PaymentGatewaySelector(RazorpayService razorpayService, StripePaymentService stripePaymentService){
       this.razorpayService = razorpayService;
       this.stripePaymentService = stripePaymentService;
   }

   public Payment getPaymentService(){
       //add logic to select payment service;
       return stripePaymentService;
   }
}
