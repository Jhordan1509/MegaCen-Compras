package pe.com.megacentimetros.compras;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MegacentimetrosMicroservicioComprasApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegacentimetrosMicroservicioComprasApplication.class, args);
	}

}
