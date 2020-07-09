package com.people10.assignment.service;

import com.people10.assignment.model.Customer;

public interface CustomerService {

	public Customer findById(Long id);

	public void save(Customer student) throws InstantiationException;

}
