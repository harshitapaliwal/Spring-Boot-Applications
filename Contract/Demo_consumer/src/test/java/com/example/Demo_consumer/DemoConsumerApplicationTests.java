package com.example.Demo_consumer;

import java.net.URI;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.spring.AutoConfigureStubRunner;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.github.tomakehurst.wiremock.client.WireMock;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureStubRunner(ids = {"com.example:Demo_Contract:+:stubs:8080"},workOffline = true)
@DirtiesContext
public class DemoConsumerApplicationTests {

	@Test
	public void Tests() {
		String json="[\"harshita\",\"paliwal\",\"gayatri\"]";
		
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity<String> entity = restTemplate.getForEntity("http://localhost:8082/example", String.class);
		
		BDDAssertions.then(entity.getStatusCodeValue()).isEqualTo(200);
		BDDAssertions.then(entity.getBody()).isEqualTo(json);
	}
	
	
}
