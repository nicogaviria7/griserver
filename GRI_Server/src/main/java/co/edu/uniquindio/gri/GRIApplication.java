package co.edu.uniquindio.gri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Clase GRIApplication.
 */
@SpringBootApplication
@EnableJpaAuditing
public class GRIApplication extends SpringBootServletInitializer {
	
	/**
	 * Método principal para ejecutar SpringBoot.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		SpringApplication.run(GRIApplication.class, args);
	}
	
	/* (non-Javadoc)
	 * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure(org.springframework.boot.builder.SpringApplicationBuilder)
	 * Permite la ejecución de una aplicación Spring Boot en un entorno distinto al embebido.
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(GRIApplication.class);
	}
}
