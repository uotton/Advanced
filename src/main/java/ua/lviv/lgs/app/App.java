package ua.lviv.lgs.app;

import java.sql.Date;

import ua.lviv.lgs.domain.Bucket;
import ua.lviv.lgs.domain.Product;
import ua.lviv.lgs.domain.User;
import ua.lviv.lgs.service.BucketService;
import ua.lviv.lgs.shared.impl.BucketServiceImpl;
import ua.lviv.lgs.shared.impl.ProductServiceImpl;
import ua.lviv.lgs.shared.impl.UserServiceImpl;

public class App {
	public static void main(String[] args) {
		UserServiceImpl userService = new UserServiceImpl();
		ProductServiceImpl productService = new ProductServiceImpl();
		BucketService bucketService = new BucketServiceImpl();
		
		userService.create(new User("Harry", "Potter", "Hedwigo@gmail.com", "admin")); 
		userService.update(new User("Ron", "Weasley", "Weasley533@gmail.com", "user"));
		userService.update(new User(1,"Hermione", "Granger", "Hermione_Granger@gmail.com", "user"));
		System.out.println(userService.readAll());
//		userService.delete(1);
//		System.out.println(userService.readAll());
		
		productService.create(new Product("Fantastic beast and where to find them", "Description", 350.00));
		productService.update(new Product(1, "Defence aginst the dark arts", "Description", 550.00));
		System.out.println(productService.readAll());
//		productService.delete(1);
//		System.out.println(productService.readAll());
		
		bucketService.create(new Bucket(1, 1, Date.valueOf("2020-10-29")));
		System.out.println(bucketService.readAll());
//		bucketService.delete(1);
//		System.out.println(bucketService.readAll());
	}
}
