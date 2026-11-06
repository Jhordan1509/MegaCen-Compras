package pe.com.megacentimetros.compras.service;

import java.util.List;
import pe.com.megacentimetros.compras.entity.RecepcionCompraEntity;

public interface RecepcionCompraService {

	List<RecepcionCompraEntity> findAll();

	List<RecepcionCompraEntity> findAllCustom();

	RecepcionCompraEntity findById(Long id);

	RecepcionCompraEntity add(RecepcionCompraEntity obj);

	RecepcionCompraEntity update(RecepcionCompraEntity obj, Long id);

	RecepcionCompraEntity delete(Long id);

	RecepcionCompraEntity enable(Long id);
}
