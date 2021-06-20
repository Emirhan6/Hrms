package hrms.hrmsDatabase;

//import java.io.File;
import java.io.IOException;
//import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//import com.cloudinary.*;
//import com.cloudinary.utils.ObjectUtils;

@SpringBootApplication
@EnableSwagger2
@EnableAutoConfiguration
public class HrmsDatabaseApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(HrmsDatabaseApplication.class, args);
		
		//Cloudinary cloudinary = new Cloudinary(ObjectUtils.asMap(
				//"cloud_name", "dpl502lxz",
				//"api_key", "312588743187247",
				//"api_secret", "OO6nZ7Ai25ZFl2LfRHHV4lhNJJE"));
		
		//File file = new File("my_image.jpg");
		//Map uploadResult = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
	}
	
	@Bean
    public Docket api() { 
        return new Docket(DocumentationType.SWAGGER_2)  
          .select()                                  
          .apis(RequestHandlerSelectors.basePackage("hrms.hrmsDatabase"))                                     
          .build();                                           
    }

}
