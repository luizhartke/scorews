package com.battycode.scorews.controller;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.IntegrationTest;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.battycode.scorews.config.ScorewsConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ScorewsConfig.class)
@WebAppConfiguration
@IntegrationTest({ "server.port=0", "management.port=0" })
@DirtiesContext
public class ScoreControllerTest {

	@Value("${local.server.port}")
	private int port;

	@Value("${local.management.port}")
	private int mgt;

	@Test
	public void testDefaultUserScore() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port + "/user-score", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Integer userId = (Integer) entity.getBody().get("userId");
		assertEquals(new Integer(0), userId);
	}
	
	@Test
	public void testSingleUserScore() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity("http://localhost:" + this.port + 
				"/user-score" + "?userId=" + 10, Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
		Integer userId = (Integer) entity.getBody().get("userId");
		assertEquals(new Integer(10), userId);
	}

	@Test
	public void testInfo() throws Exception {
		@SuppressWarnings("rawtypes")
		ResponseEntity<Map> entity = new TestRestTemplate().getForEntity(
				"http://localhost:" + this.mgt + "/info", Map.class);
		assertEquals(HttpStatus.OK, entity.getStatusCode());
	}

}
