package pe.com.megacentimetros.compras.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.compras.client.PersonaFeignClient;
import pe.com.megacentimetros.compras.exception.ResourceNotFoundException;
import pe.com.megacentimetros.compras.entity.OrdenCompraEntity;
import pe.com.megacentimetros.compras.repository.OrdenCompraRepository;
import pe.com.megacentimetros.compras.service.OrdenCompraService;

@Service
public class OrdenCompraServiceImpl implements OrdenCompraService {

	private OrdenCompraRepository repositorio;
	private PersonaFeignClient personaFeignClient;

	public OrdenCompraServiceImpl(OrdenCompraRepository repositorio,
			PersonaFeignClient personaFeignClient) {
		this.repositorio = repositorio;
		this.personaFeignClient = personaFeignClient;
	}

	@Override
	public List<OrdenCompraEntity> findAll() {
		List<OrdenCompraEntity> lista = repositorio.findAll();
		for (OrdenCompraEntity ordenCompra : lista) {
			ordenCompra.setProveedor(personaFeignClient.getProveedor(ordenCompra.getCodprov()));
		}
		return lista;
	}
	@Override
	public List<OrdenCompraEntity> findAllCustom() {
		List<OrdenCompraEntity> lista = repositorio.findAllCustom();
		for (OrdenCompraEntity ordenCompra : lista) {
			ordenCompra.setProveedor(personaFeignClient.getProveedor(ordenCompra.getCodprov()));
		}
		return lista;
	}
	@Override
	public OrdenCompraEntity findById(Long id) {
		OrdenCompraEntity ordenCompra = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrdenCompra con id " + id + " no existe"));
		ordenCompra.setProveedor(personaFeignClient.getProveedor(ordenCompra.getCodprov()));
		return ordenCompra;
	}
	@Override
	public OrdenCompraEntity add(OrdenCompraEntity obj) {
		obj.setEstado(true);
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		if (obj.getSituacion() == null) {
			obj.setSituacion("PENDIENTE");
		}
		if (obj.getSubtotal() == null) {
			obj.setSubtotal(java.math.BigDecimal.ZERO);
		}
		if (obj.getIgv() == null) {
			obj.setIgv(java.math.BigDecimal.ZERO);
		}
		if (obj.getTotal() == null) {
			obj.setTotal(java.math.BigDecimal.ZERO);
		}
		return repositorio.save(obj);
	}
	@Override
	public OrdenCompraEntity update(OrdenCompraEntity obj, Long id) {
		OrdenCompraEntity objord = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrdenCompra con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objord, "codigo");
		return repositorio.save(objord);
	}
	@Override
	public OrdenCompraEntity delete(Long id) {
		OrdenCompraEntity objord = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrdenCompra con id " + id + " no existe"));
		objord.setEstado(false);
		return repositorio.save(objord);
	}
	@Override
	public OrdenCompraEntity enable(Long id) {
		OrdenCompraEntity objord = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("OrdenCompra con id " + id + " no existe"));
		objord.setEstado(true);
		return repositorio.save(objord);
	}
}
