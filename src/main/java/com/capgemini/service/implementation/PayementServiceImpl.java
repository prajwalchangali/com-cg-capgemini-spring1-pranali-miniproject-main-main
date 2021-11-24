package com.capgemini.service.implementation;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.exceptions.NoSuchCustomerException;
import com.capgemini.model.Customer;
import com.capgemini.model.Payment;
import com.capgemini.model.PaymentStatus;
import com.capgemini.repository.PaymentRepository;
import com.capgemini.service.PaymentService;
@Service
public  class PayementServiceImpl implements PaymentService {

	public static final Logger LOG = LoggerFactory.getLogger(PaymentService.class);

	@Autowired
	private PaymentRepository paymentRepository;

	@Override
	public PaymentStatus payBill(Payment payment) {
		LOG.info("payBill");
		Optional<Payment> paymentOpt = paymentRepository.findById(payment);
		if (paymentOpt.isPresent()) {
			LOG.info(" Success");
			return ((Payment) paymentRepository).getStatus();
		} else {
			LOG.info(" Failed");
		}
		return null;
	}

	@Override
	public void sendEmailOnPaymentCompletion(Long consumerNumber, String email) {
//		LOG.info("sendEmailOnPaymentCompletion");
//		
//		Customer paymentOpt = paymentRepository.findByConsumerNumber(consumerNumber);
//		if (paymentOpt.equals(consumerNumber)) {
//			paymentRepository.save();
//			LOG.info("Employee id is deleted.");
//			return empOpt.get();
//		} else {
//			LOG.info("Employee is NOT available.");
//			throw new EmployeeNotFoundException(eid + " this employee id is not found.");
//		}
	}

	@Override
	public List<Payment> viewHistoricalPayment(Long consumerNumber) throws NoSuchCustomerException {
//		LOG.info("viewHistoricalPayment");
		return paymentRepository.findAllById(consumerNumber);
	}
	


}
