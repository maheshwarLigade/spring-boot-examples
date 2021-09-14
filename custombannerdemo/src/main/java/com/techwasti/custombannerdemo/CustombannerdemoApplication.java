package com.techwasti.custombannerdemo;

import org.springframework.boot.Banner;
import org.springframework..boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class CustombannerdemoApplication {

	public static void main(String[] args) {
		new SpringApplicationBuilder(CustombannerdemoApplication.class);
                // .bannerMode(Banner.Mode.OFF)
                // .run(args);
		
	}

}
