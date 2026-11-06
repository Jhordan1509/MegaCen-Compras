package pe.com.megacentimetros.compras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.compras.entity.DetalleOrdenCompraEntity;

public interface DetalleOrdenCompraRepository extends JpaRepository<DetalleOrdenCompraEntity, Long> {

	@Query("select d from DetalleOrdenCompraEntity d where d.estado = true")
	List<DetalleOrdenCompraEntity> findAllCustom();
}
