package com.capgemini.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.model.Payment;
import com.capgemini.model.PaymentStatus;
import com.capgemini.service.PaymentService;
@Component
@RestController
public class PaymentController {

	private static final Logger LOG = LoggerFactory.getLogger(PaymentController.class);

	@Autowired
	private PaymentService paymentService;

	@GetMapping("getPaymentStatus")
	public ResponseEntity<PaymentStatus>payBill(@RequestBody Payment payment) {
		LOG.info("getPaymentById");
		PaymentStatus payment1 = paymentService.payBill(payment); // line
		HttpHeaders headers = new HttpHeaders();
		headers.add("message", "This payBill is success.");
		LOG.info(headers.toString());
		ResponseEntity<PaymentStatus> response = new ResponseEntity<PaymentStatus>(payment1, headers, HttpStatus.OK);
		return response;
	}
	
//	public ResponseEntity<void> sendEmailOnPaymentCompletion(@RequestBody Long paymentId, string email) {
//		LOG.info("sendEmailOnPaymentCompletion");
//		Long paymentId=paymentService.
//		
//	}
	
	@GetMapping("/viewHistoricalpayment/{companyId}")
	public List<Payment> viewHistoricalPayment( @PathVariable(name = "consumerNumber") Long consumerNumber) throws NoSuchCustomerException{
		List<Payment> pl= paymentService.viewHistoricalPayment(consumerNumber);
		return pl;
		
	}
}
