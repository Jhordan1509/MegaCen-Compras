package pe.com.megacentimetros.compras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.compras.entity.RecepcionCompraEntity;

public interface RecepcionCompraRepository extends JpaRepository<RecepcionCompraEntity, Long> {

	@Query("select d from RecepcionCompraEntity d where d.estado = true")
	List<RecepcionCompraEntity> findAllCustom();
}
