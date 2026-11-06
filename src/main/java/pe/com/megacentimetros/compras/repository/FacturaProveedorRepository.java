package pe.com.megacentimetros.compras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.compras.entity.FacturaProveedorEntity;

public interface FacturaProveedorRepository extends JpaRepository<FacturaProveedorEntity, Long> {

	@Query("select d from FacturaProveedorEntity d where d.estado = true")
	List<FacturaProveedorEntity> findAllCustom();
}
