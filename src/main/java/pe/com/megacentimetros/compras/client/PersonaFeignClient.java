package pe.com.megacentimetros.compras.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-persona", url = "http://localhost:9092/pmega/api/")
public interface PersonaFeignClient {
	@GetMapping("/proveedor/{id}")
	Object getProveedor(@PathVariable("id") Long id);
}
