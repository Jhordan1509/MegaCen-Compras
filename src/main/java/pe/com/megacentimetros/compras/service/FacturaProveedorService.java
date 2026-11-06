package pe.com.megacentimetros.compras.service;

import java.util.List;
import pe.com.megacentimetros.compras.entity.FacturaProveedorEntity;

public interface FacturaProveedorService {

	List<FacturaProveedorEntity> findAll();

	List<FacturaProveedorEntity> findAllCustom();

	FacturaProveedorEntity findById(Long id);

	FacturaProveedorEntity add(FacturaProveedorEntity obj);

	FacturaProveedorEntity update(FacturaProveedorEntity obj, Long id);

	FacturaProveedorEntity delete(Long id);

	FacturaProveedorEntity enable(Long id);
}
