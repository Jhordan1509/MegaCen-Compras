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
import pe.com.megacentimetros.compras.entity.DetalleOrdenCompraEntity;
import pe.com.megacentimetros.compras.service.DetalleOrdenCompraService;

@RestController
@RequestMapping("/api/detalleordencompra")
public class DetalleOrdenCompraRestController {

	@Autowired
	private DetalleOrdenCompraService servicio;

	@GetMapping
	public List<DetalleOrdenCompraEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<DetalleOrdenCompraEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public DetalleOrdenCompraEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public DetalleOrdenCompraEntity add(@RequestBody DetalleOrdenCompraEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public DetalleOrdenCompraEntity update(@RequestBody DetalleOrdenCompraEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public DetalleOrdenCompraEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public DetalleOrdenCompraEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
