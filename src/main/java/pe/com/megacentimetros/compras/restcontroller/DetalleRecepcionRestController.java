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
import pe.com.megacentimetros.compras.entity.DetalleRecepcionEntity;
import pe.com.megacentimetros.compras.service.DetalleRecepcionService;

@RestController
@RequestMapping("/api/detallerecepcion")
public class DetalleRecepcionRestController {

	@Autowired
	private DetalleRecepcionService servicio;

	@GetMapping
	public List<DetalleRecepcionEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<DetalleRecepcionEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public DetalleRecepcionEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public DetalleRecepcionEntity add(@RequestBody DetalleRecepcionEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public DetalleRecepcionEntity update(@RequestBody DetalleRecepcionEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public DetalleRecepcionEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public DetalleRecepcionEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
