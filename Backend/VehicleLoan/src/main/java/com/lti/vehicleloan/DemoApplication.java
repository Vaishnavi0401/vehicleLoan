package com.lti.vehicleloan;

import javax.annotation.Resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lti.vehicleloan.layer4.FileStorageService;

@SpringBootApplication
public class DemoApplication {

	@Resource
	FileStorageService storageService;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		System.out.println("Spring applocation started!");
	}

	public void run(String... arg) throws Exception {
	    storageService.deleteAll();
	    storageService.init();
	  }
	
}


