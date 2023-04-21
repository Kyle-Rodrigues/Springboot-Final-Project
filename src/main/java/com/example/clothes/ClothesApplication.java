package com.example.clothes;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.clothes.model.Item;
import com.example.clothes.model.Item.Brand;
import com.example.clothes.repository.ItemRepository;
import com.example.clothes.repository.UserRepository;

@SpringBootApplication
public class ClothesApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClothesApplication.class, args);
	}

	@Bean
	public CommandLineRunner dataLoader(ItemRepository repository, UserRepository userRepository){
		return args -> {
			repository.save(Item.builder()
				.name("Pants")
				.yearCreated(2021)
				.price(1550)
				.brand(Brand.Adidas).build());
				repository.save(Item.builder()
				.name("Shirt")
				.yearCreated(2021)
				.price(2000)
				.brand(Brand.Gucci).build());
				repository.save(Item.builder()
				.name("Shoes")
				.yearCreated(2021)
				.price(1050)
				.brand(Brand.Nike).build());
		};
	}

}
