package pe.com.megacentimetros.compras.service;

import java.util.List;
import pe.com.megacentimetros.compras.entity.DetalleRecepcionEntity;

public interface DetalleRecepcionService {

	List<DetalleRecepcionEntity> findAll();

	List<DetalleRecepcionEntity> findAllCustom();

	DetalleRecepcionEntity findById(Long id);

	DetalleRecepcionEntity add(DetalleRecepcionEntity obj);

	DetalleRecepcionEntity update(DetalleRecepcionEntity obj, Long id);

	DetalleRecepcionEntity delete(Long id);

	DetalleRecepcionEntity enable(Long id);
}
