package pe.com.megacentimetros.compras.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.compras.client.InventarioFeignClient;
import pe.com.megacentimetros.compras.exception.ResourceNotFoundException;
import pe.com.megacentimetros.compras.entity.RecepcionCompraEntity;
import pe.com.megacentimetros.compras.repository.RecepcionCompraRepository;
import pe.com.megacentimetros.compras.service.RecepcionCompraService;

@Service
public class RecepcionCompraServiceImpl implements RecepcionCompraService {

	private RecepcionCompraRepository repositorio;
	private InventarioFeignClient inventarioFeignClient;

	public RecepcionCompraServiceImpl(RecepcionCompraRepository repositorio,
			InventarioFeignClient inventarioFeignClient) {
		this.repositorio = repositorio;
		this.inventarioFeignClient = inventarioFeignClient;
	}

	@Override
	public List<RecepcionCompraEntity> findAll() {
		List<RecepcionCompraEntity> lista = repositorio.findAll();
		for (RecepcionCompraEntity recepcionCompra : lista) {
			recepcionCompra.setAlmacen(inventarioFeignClient.getAlmacen(recepcionCompra.getCodalm()));
		}
		return lista;
	}
	@Override
	public List<RecepcionCompraEntity> findAllCustom() {
		List<RecepcionCompraEntity> lista = repositorio.findAllCustom();
		for (RecepcionCompraEntity recepcionCompra : lista) {
			recepcionCompra.setAlmacen(inventarioFeignClient.getAlmacen(recepcionCompra.getCodalm()));
		}
		return lista;
	}
	@Override
	public RecepcionCompraEntity findById(Long id) {
		RecepcionCompraEntity recepcionCompra = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RecepcionCompra con id " + id + " no existe"));
		recepcionCompra.setAlmacen(inventarioFeignClient.getAlmacen(recepcionCompra.getCodalm()));
		return recepcionCompra;
	}
	@Override
	public RecepcionCompraEntity add(RecepcionCompraEntity obj) {
		obj.setEstado(true);
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		if (obj.getSituacion() == null) {
			obj.setSituacion("REGISTRADA");
		}
		return repositorio.save(obj);
	}
	@Override
	public RecepcionCompraEntity update(RecepcionCompraEntity obj, Long id) {
		RecepcionCompraEntity objrec = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RecepcionCompra con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objrec, "codigo");
		return repositorio.save(objrec);
	}
	@Override
	public RecepcionCompraEntity delete(Long id) {
		RecepcionCompraEntity objrec = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RecepcionCompra con id " + id + " no existe"));
		objrec.setEstado(false);
		return repositorio.save(objrec);
	}
	@Override
	public RecepcionCompraEntity enable(Long id) {
		RecepcionCompraEntity objrec = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("RecepcionCompra con id " + id + " no existe"));
		objrec.setEstado(true);
		return repositorio.save(objrec);
	}
}
