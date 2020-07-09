package com.people10.assignment.controller;

import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.people10.assignment.model.Customer;
import com.people10.assignment.service.CustomerService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(path = "/api/v/1")
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService customerService;

	@ApiOperation(value = "Find Customer by ID", notes = "Find Customer by ID", response = Customer.class)
	@ApiResponses({ @ApiResponse(code = 404, message = "Person with id doesn't exists") })
	@GetMapping("/student/{id}")
	public ResponseEntity<Customer> retrieveStudent(
			@ApiParam(value = "RetrieveStudent info", required = true) @PathVariable Long id) {
		logger.info("RetrieveStudent info");
		Customer customer = customerService.findById(id);
		return new ResponseEntity<Customer>(customer, HttpStatus.OK);

	}

	@PostMapping("/student")
	public ResponseEntity<Customer> createStudent(@Valid @RequestBody Customer customer) throws InstantiationException {
		logger.info("creating student info");
		customerService.save(customer);
		return new ResponseEntity<Customer>(HttpStatus.CREATED);
	}
}
