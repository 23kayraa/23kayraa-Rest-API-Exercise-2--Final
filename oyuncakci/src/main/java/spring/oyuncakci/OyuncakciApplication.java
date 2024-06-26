package spring.oyuncakci;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class OyuncakciApplication {

	public static void main(String[] args) {
		SpringApplication.run(OyuncakciApplication.class, args);
	}
	@Bean
	public Docket api (){
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("spring.oyuncakci"))
				.build();
	}
}
