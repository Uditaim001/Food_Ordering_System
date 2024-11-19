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
		application.run(context);
		Repo category= context.getBean(Repo.class);
//		Categorydetails type= new Categorydetails();
////		Categorydetails
//		type.setRating(4);
//		type.setName("Snacks");
//	    Categorydetails type1= category.save(type);
//		System.out.println(type1);
		ItemRepo Item=context.getBean(ItemRepo.class);
		Itemdetails Item1=new Itemdetails();
//		Item1.setName("Filter Coffee");
//		Item1.setCategory(1);
//		Item1.setCost(20);
//		Item1.setRating(5);
//		Itemdetails Item2= Item.save(Item1);
//		System.out.println(Item2);


//		UserDetails user1=new UserDetails();
//		user1.setUserName("Abhinav");
//		user1.setEmail("Abhinav@123@gmail.com");
//		user1.setMobileNo("+91 9054157315");
//		userService.saveUser(user1);
//		UserDetails user2=user.save(user1);
//		System.out.println(user2);
	}
	public void run(ConfigurableApplicationContext context) throws Exception {

//		UserRepo user=context.getBean(UserRepo.class);
//		UserDetails user1 = new UserDetails();
//		user1.setUserName("Abhinav");
//		user1.setEmail("Abhinav@123@gmail.com");
//		user1.setMobileNo("+91 9054157315");
//
//		userService.saveUser(user1);
//		UserDetails user2 = user.save(user1);
//		System.out.println(user2);
	}

}
