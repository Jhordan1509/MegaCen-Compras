package pe.com.megacentimetros.compras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.compras.entity.DetalleRecepcionEntity;

public interface DetalleRecepcionRepository extends JpaRepository<DetalleRecepcionEntity, Long> {

	@Query("select d from DetalleRecepcionEntity d where d.estado = true")
	List<DetalleRecepcionEntity> findAllCustom();
}
