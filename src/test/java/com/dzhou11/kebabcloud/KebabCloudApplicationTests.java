package com.dzhou11.kebabcloud;

import com.dzhou11.kebabcloud.controllers.HomeController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.containsString;

@WebMvcTest(KebabCloudApplication.class)
@Import(HomeController.class)
public class KebabCloudApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	void testHomePage() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.view().name("home"))
				.andExpect(MockMvcResultMatchers.content().string(
						containsString("Welcome to ...")
				));
	}
	@Test
	void contextLoads() {
	}

}
