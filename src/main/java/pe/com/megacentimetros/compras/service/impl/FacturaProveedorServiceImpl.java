package pe.com.megacentimetros.compras.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.compras.client.PersonaFeignClient;
import pe.com.megacentimetros.compras.exception.ResourceNotFoundException;
import pe.com.megacentimetros.compras.entity.FacturaProveedorEntity;
import pe.com.megacentimetros.compras.repository.FacturaProveedorRepository;
import pe.com.megacentimetros.compras.service.FacturaProveedorService;

@Service
public class FacturaProveedorServiceImpl implements FacturaProveedorService {

	private FacturaProveedorRepository repositorio;
	private PersonaFeignClient personaFeignClient;

	public FacturaProveedorServiceImpl(FacturaProveedorRepository repositorio,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<FacturaProveedorEntity> findAll() {
		List<FacturaProveedorEntity> lista = repositorio.findAll();
		for (FacturaProveedorEntity facturaProveedor : lista) {
			facturaProveedor.setProveedor(personaFeignClient.getProveedor(facturaProveedor.getCodprov()));
		}
		return lista;
	}
	@Override
	public List<FacturaProveedorEntity> findAllCustom() {
		List<FacturaProveedorEntity> lista = repositorio.findAllCustom();
		for (FacturaProveedorEntity facturaProveedor : lista) {
			facturaProveedor.setProveedor(personaFeignClient.getProveedor(facturaProveedor.getCodprov()));
		}
		return lista;
	}
	@Override
	public FacturaProveedorEntity findById(Long id) {
		FacturaProveedorEntity facturaProveedor = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("FacturaProveedor con id " + id + " no existe"));
		facturaProveedor.setProveedor(personaFeignClient.getProveedor(facturaProveedor.getCodprov()));
		return facturaProveedor;
	}
	@Override
	public FacturaProveedorEntity add(FacturaProveedorEntity obj) {
		obj.setEstado(true);
		if (obj.getIgv() == null) {
			obj.setIgv(java.math.BigDecimal.ZERO);
		}
		if (obj.getSituacion() == null) {
			obj.setSituacion("PENDIENTE");
		}
		return repositorio.save(obj);
	}
	@Override
	public FacturaProveedorEntity update(FacturaProveedorEntity obj, Long id) {
		FacturaProveedorEntity objfac = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("FacturaProveedor con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objfac, "codigo");
		return repositorio.save(objfac);
	}
	@Override
	public FacturaProveedorEntity delete(Long id) {
		FacturaProveedorEntity objfac = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("FacturaProveedor con id " + id + " no existe"));
		objfac.setEstado(false);
		return repositorio.save(objfac);
	}
	@Override
	public FacturaProveedorEntity enable(Long id) {
		FacturaProveedorEntity objfac = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("FacturaProveedor con id " + id + " no existe"));
		objfac.setEstado(true);
		return repositorio.save(objfac);
	}
}
