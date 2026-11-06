package pe.com.megacentimetros.compras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.compras.entity.OrdenCompraEntity;

public interface OrdenCompraRepository extends JpaRepository<OrdenCompraEntity, Long> {

	@Query("select d from OrdenCompraEntity d where d.estado = true")
	List<OrdenCompraEntity> findAllCustom();
}
