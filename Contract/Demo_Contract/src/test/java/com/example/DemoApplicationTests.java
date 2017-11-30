package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.example.DemoApplication.Controller;
import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;



@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@AutoConfigureRestDocs(outputDir = "target/snippets")
@AutoConfigureMockMvc
public class DemoApplicationTests {
	@Autowired Controller controller;

	@Before
	public void setup() {
		RestAssuredMockMvc.standaloneSetup(this.controller);
	}
		@Autowired private MockMvc mockMvc;

	@Test
	public void should_accept_a_get_message() throws Exception {
	
		mockMvc.perform(MockMvcRequestBuilders.get("/example"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andDo(MockMvcRestDocumentation.document("message"));
	}
}
