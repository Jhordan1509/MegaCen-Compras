package pe.com.megacentimetros.compras.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.compras.entity.OrdenCompraEntity;
import pe.com.megacentimetros.compras.service.OrdenCompraService;

@RestController
@RequestMapping("/api/ordencompra")
public class OrdenCompraRestController {

	@Autowired
	private OrdenCompraService servicio;

	@GetMapping
	public List<OrdenCompraEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<OrdenCompraEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public OrdenCompraEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public OrdenCompraEntity add(@RequestBody OrdenCompraEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public OrdenCompraEntity update(@RequestBody OrdenCompraEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public OrdenCompraEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public OrdenCompraEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
