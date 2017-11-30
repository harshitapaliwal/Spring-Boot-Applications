package com.cg.emp.Demo_Emp;



import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.cg.emp.model.Employee;
import com.fasterxml.jackson.databind.ObjectMapper;




@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoEmpApplicationTests {
	
	private MockMvc mockMvc;
	private ObjectMapper om = new ObjectMapper();
	@Autowired(required = true)
	private WebApplicationContext webApplicationContext;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext)
				.build();
	}

	
	@Test
	public void testaddEmployee() throws Exception{
		Employee employee = new Employee();
		employee.setEmp_id((long) 8);
		employee.setEmp_name("mohit");
		employee.setEmp_dept("ServiceDesk");
		employee.setEmp_salary(18000);
		
		String request = om.writeValueAsString(employee);
		MvcResult result = mockMvc
				.perform(
						post("/addEmployee").content(request).contentType(
								MediaType.APPLICATION_JSON_VALUE))
				.andExpect(status().isOk()).andReturn();
		
		String resultContent = result.getResponse().getContentAsString();
		Employee new_Employee= om.readValue(resultContent, Employee.class);
		System.out.println("result.getResponse().getContentAsString(): "+result.getResponse().getContentAsString());
		System.out.println("result content: "+resultContent);
		System.out.println("result: "+result.toString());
		assertEquals("mohit",new_Employee.getEmp_name());
		
	}

	@Test
	
	public void getAllEmployeeTest() throws Exception {
		boolean flag =false;
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/emp/allemployee")
								.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();

		assertEquals(flag,resultContent.isEmpty());
	}

	@Test

	public void getEmployeeTest() throws Exception {
		int id = 6;
		MvcResult result = mockMvc
				.perform(
						MockMvcRequestBuilders.get("/getEmployee/" + id)
								.contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
		String resultContent = result.getResponse().getContentAsString();
		Employee new_Employee= om.readValue(resultContent, Employee.class);
		Assert.assertTrue(id==new_Employee.getEmp_id());
	}
	

}
