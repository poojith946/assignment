package com.people10.assignment.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people10.assignment.exception.CustomerNotFoundException;
import com.people10.assignment.exception.HandleUniqueExceptions;
import com.people10.assignment.model.Customer;
import com.people10.assignment.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer findById(Long id) {
		Optional<Customer> student = customerRepository.findById(id);
		if (!student.isPresent())
			throw new CustomerNotFoundException("Customer with id-" + id + " is not available.");
		return student.get();
	}

	@Override
	public void save(Customer customer) throws InstantiationException {
		Customer objCustomerUnique = customerRepository.findByFirstNameAndLastName(customer.getFirstName(),
				customer.getLastName());
		if (objCustomerUnique != null && objCustomerUnique.getEmail() != null) {
			throw new HandleUniqueExceptions("Customer with userName-" + customer.getFirstName() + " "
					+ customer.getLastName() + " is already aviable available.");
		} else {
			customerRepository.save(customer);
		}
	}
}
