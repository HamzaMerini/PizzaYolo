package pizzayoloFront.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

import pizzayolo.config.PizzayoloConfig;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"pizzayoloFront.restController"})
@Import(PizzayoloConfig.class)
public class WebConfig {

	public WebConfig() {
		System.out.println("web");
	}
	
	
}
