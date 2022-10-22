package com.neirba.neirba;

import com.neirba.neirba.config.RsaKeyConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyConfig.class)
public class NeirbaApplication {

	public static void main(String[] args) {
		SpringApplication.run(NeirbaApplication.class, args);
		
	}

}
