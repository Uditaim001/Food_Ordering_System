package com.dinegood.springbootproject;

import com.dinegood.springbootproject.services.UserService;
import com.dinegood.springbootproject.model.Itemdetails;
import com.dinegood.springbootproject.model.UserDetails;
import com.dinegood.springbootproject.repo.ItemRepo;
import com.dinegood.springbootproject.repo.Repo;
import com.dinegood.springbootproject.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication(scanBasePackages = "com.dinegood.springbootproject")
@EnableCaching
public class SpringbootprojectApplication {
	@Autowired
	private UserService userService;
	public static void main(String[] args) throws Exception {

		ConfigurableApplicationContext context = SpringApplication.run(SpringbootprojectApplication.class, args);
		SpringbootprojectApplication application = context.getBean(SpringbootprojectApplication.class);


}
