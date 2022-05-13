package pizzayolo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import pizzayolo.config.PizzayoloConfig;

public class MainRun {
	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext aca = new AnnotationConfigApplicationContext(PizzayoloConfig.class);
		
		aca.getBeanFactory().createBean(QuestPizzayoloSpring.class).run();
		
		aca.close();
		
		
	}
	
}
