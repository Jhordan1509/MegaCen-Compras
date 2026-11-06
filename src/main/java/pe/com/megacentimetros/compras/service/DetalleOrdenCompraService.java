package pe.com.megacentimetros.compras.service;

import java.util.List;
import pe.com.megacentimetros.compras.entity.DetalleOrdenCompraEntity;

public interface DetalleOrdenCompraService {

	List<DetalleOrdenCompraEntity> findAll();

	List<DetalleOrdenCompraEntity> findAllCustom();

	DetalleOrdenCompraEntity findById(Long id);

	DetalleOrdenCompraEntity add(DetalleOrdenCompraEntity obj);

	DetalleOrdenCompraEntity update(DetalleOrdenCompraEntity obj, Long id);

	DetalleOrdenCompraEntity delete(Long id);

	DetalleOrdenCompraEntity enable(Long id);
}
