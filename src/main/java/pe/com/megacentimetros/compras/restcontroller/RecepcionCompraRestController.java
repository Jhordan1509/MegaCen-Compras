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
import pe.com.megacentimetros.compras.entity.RecepcionCompraEntity;
import pe.com.megacentimetros.compras.service.RecepcionCompraService;

@RestController
@RequestMapping("/api/recepcioncompra")
public class RecepcionCompraRestController {

	@Autowired
	private RecepcionCompraService servicio;

	@GetMapping
	public List<RecepcionCompraEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<RecepcionCompraEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public RecepcionCompraEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public RecepcionCompraEntity add(@RequestBody RecepcionCompraEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public RecepcionCompraEntity update(@RequestBody RecepcionCompraEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public RecepcionCompraEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public RecepcionCompraEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
