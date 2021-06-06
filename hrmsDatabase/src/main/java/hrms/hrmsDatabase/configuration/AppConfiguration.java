package hrms.hrmsDatabase.configuration;

import hrms.hrmsDatabase.core.utilities.imageUploaders.*;

import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class AppConfiguration {

	@Bean
    public ImageService imageService(){
        return new CloudinaryManager();
    }
}
