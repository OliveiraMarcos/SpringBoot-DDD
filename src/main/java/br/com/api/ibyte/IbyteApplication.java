package br.com.api.ibyte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.annotations.Contact;
import io.swagger.annotations.Info;
import io.swagger.annotations.License;
import io.swagger.annotations.Tag;

/**
 *
 * @author marcos.oliveira
 */
// @OpenAPIDefinition(
//     tags = {
//             @Tag(name="widget", description="Widget operations."),
//             @Tag(name="gasket", description="Operations related to gaskets")
//     },
//     info = @Info(
//         title="Example API",
//         version = "1.0.1",
//         contact = @Contact(
//             name = "Example API Support",
//             url = "http://exampleurl.com/contact",
//             email = "techsupport@example.com"),
//         license = @License(
//             name = "Apache 2.0",
//             url = "https://www.apache.org/licenses/LICENSE-2.0.html"))
// )
@SpringBootApplication
public class IbyteApplication {

	public static void main(String[] args) {
		SpringApplication.run(IbyteApplication.class, args);
	}

}
