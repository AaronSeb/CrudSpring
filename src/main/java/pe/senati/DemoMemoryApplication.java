package pe.senati;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class DemoMemoryApplication  /*implements CommandLineRunner*/{

	/*@Autowired
	private PasswordEncoder passwordEncoder;*/
	public static void main(String[] args) {
		
		SpringApplication.run(DemoMemoryApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		System.out.println("r123: "+passwordEncoder.encode("r123"));
		System.out.println("j123: "+passwordEncoder.encode("j123"));
		System.out.println("a123: "+passwordEncoder.encode("a123"));
		System.out.println("f123: "+passwordEncoder.encode("f123"));
		
	}*/
	
	

}
