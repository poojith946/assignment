package com.people10.assignment.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.people10.assignment.model.Customer;
import com.people10.assignment.service.CustomerService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = CustomerController.class)
public class CustomerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CustomerService studentService;

	Customer mockCourse = new Customer();

	@Test
	public void retrieveDetailsForCourse() throws Exception {
		mockCourse.setEmail("poojith@gmail.com");
		mockCourse.setFirstName("poojith");
		mockCourse.setLastName("p");
		mockCourse.setPassword("fdgdfgdfgfd");
		mockCourse.setId((long) 1);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
		String dateInString = "7-Jun-2013";
		Date date = formatter.parse(dateInString);
		mockCourse.setDob(date);

		Mockito.when(studentService.findById(Mockito.anyLong())).thenReturn(mockCourse);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/v/1/student/1")
				.accept(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		String expected = "{\"id\":1,\"firstName\":\"poojith\",\"lastName\":\"p\",\"email\":\"poojith@gmail.com\",\"dob\":\"2013-06-06T18:30:00.000+00:00\",\"password\":\"fdgdfgdfgfd\"}";
		JSONAssert.assertEquals(expected, result.getResponse().getContentAsString(), false);
	}

}
