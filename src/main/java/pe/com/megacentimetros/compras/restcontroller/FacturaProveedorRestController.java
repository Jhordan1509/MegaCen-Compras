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
import pe.com.megacentimetros.compras.entity.FacturaProveedorEntity;
import pe.com.megacentimetros.compras.service.FacturaProveedorService;

@RestController
@RequestMapping("/api/facturaproveedor")
public class FacturaProveedorRestController {

	@Autowired
	private FacturaProveedorService servicio;

	@GetMapping
	public List<FacturaProveedorEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<FacturaProveedorEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public FacturaProveedorEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public FacturaProveedorEntity add(@RequestBody FacturaProveedorEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public FacturaProveedorEntity update(@RequestBody FacturaProveedorEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public FacturaProveedorEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public FacturaProveedorEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
