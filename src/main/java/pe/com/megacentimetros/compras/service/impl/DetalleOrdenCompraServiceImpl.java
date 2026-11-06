package pe.com.megacentimetros.compras.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.compras.client.InventarioFeignClient;
import pe.com.megacentimetros.compras.exception.ResourceNotFoundException;
import pe.com.megacentimetros.compras.entity.DetalleOrdenCompraEntity;
import pe.com.megacentimetros.compras.repository.DetalleOrdenCompraRepository;
import pe.com.megacentimetros.compras.service.DetalleOrdenCompraService;

@Service
public class DetalleOrdenCompraServiceImpl implements DetalleOrdenCompraService {

	private DetalleOrdenCompraRepository repositorio;
	private InventarioFeignClient inventarioFeignClient;

	public DetalleOrdenCompraServiceImpl(DetalleOrdenCompraRepository repositorio,
			InventarioFeignClient inventarioFeignClient) {
		this.repositorio = repositorio;
		this.inventarioFeignClient = inventarioFeignClient;
	}

	@Override
	public List<DetalleOrdenCompraEntity> findAll() {
		List<DetalleOrdenCompraEntity> lista = repositorio.findAll();
		for (DetalleOrdenCompraEntity detalleOrdenCompra : lista) {
			detalleOrdenCompra.setProducto(inventarioFeignClient.getProducto(detalleOrdenCompra.getCodprod()));
		}
		return lista;
	}
	@Override
	public List<DetalleOrdenCompraEntity> findAllCustom() {
		List<DetalleOrdenCompraEntity> lista = repositorio.findAllCustom();
		for (DetalleOrdenCompraEntity detalleOrdenCompra : lista) {
			detalleOrdenCompra.setProducto(inventarioFeignClient.getProducto(detalleOrdenCompra.getCodprod()));
		}
		return lista;
	}
	@Override
	public DetalleOrdenCompraEntity findById(Long id) {
		DetalleOrdenCompraEntity detalleOrdenCompra = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleOrdenCompra con id " + id + " no existe"));
		detalleOrdenCompra.setProducto(inventarioFeignClient.getProducto(detalleOrdenCompra.getCodprod()));
		return detalleOrdenCompra;
	}
	@Override
	public DetalleOrdenCompraEntity add(DetalleOrdenCompraEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public DetalleOrdenCompraEntity update(DetalleOrdenCompraEntity obj, Long id) {
		DetalleOrdenCompraEntity objdet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleOrdenCompra con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objdet, "codigo");
		return repositorio.save(objdet);
	}
	@Override
	public DetalleOrdenCompraEntity delete(Long id) {
		DetalleOrdenCompraEntity objdet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleOrdenCompra con id " + id + " no existe"));
		objdet.setEstado(false);
		return repositorio.save(objdet);
	}
	@Override
	public DetalleOrdenCompraEntity enable(Long id) {
		DetalleOrdenCompraEntity objdet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleOrdenCompra con id " + id + " no existe"));
		objdet.setEstado(true);
		return repositorio.save(objdet);
	}
}
