package digytal.myfriends.restapi.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.modelmapper.ModelMapper;
import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Beans {
    @Bean
    public ModelMapper modelMapper (){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper;
    }

    @Bean
    public OpenAPI springOpenAPI() {
        return new OpenAPI()
                .info(new Info().title("My Friends - Rest API")
                        .description("Spring Boot Rest API")
                        .version("v1.0")
                        .license(new License().name("Digytal").url("www.digytal.com.br")))
                .externalDocs(new ExternalDocumentation()
                        .description("Gleyson Sampaio - Github")
                        .url("https://github.com/glysns"));
    }
}
