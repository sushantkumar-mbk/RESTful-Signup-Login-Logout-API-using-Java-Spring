package hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private UserRepository repository;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new User("manav", bCryptPasswordEncoder.encode("manav123")));
		repository.save(new User("vishal", bCryptPasswordEncoder.encode("vishal123")));
		repository.insert(new User("amit", bCryptPasswordEncoder.encode("amit123")));


		System.out.println("Multiple Records Added!");
	}

}
