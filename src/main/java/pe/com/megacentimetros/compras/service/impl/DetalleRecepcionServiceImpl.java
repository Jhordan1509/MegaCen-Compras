package pe.com.megacentimetros.compras.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.compras.exception.ResourceNotFoundException;
import pe.com.megacentimetros.compras.entity.DetalleRecepcionEntity;
import pe.com.megacentimetros.compras.repository.DetalleRecepcionRepository;
import pe.com.megacentimetros.compras.service.DetalleRecepcionService;

@Service
public class DetalleRecepcionServiceImpl implements DetalleRecepcionService {

	private DetalleRecepcionRepository repositorio;

	public DetalleRecepcionServiceImpl(DetalleRecepcionRepository repositorio) {
		this.repositorio = repositorio;
	}

	@Override
	public List<DetalleRecepcionEntity> findAll() {
		return repositorio.findAll();
	}
	@Override
	public List<DetalleRecepcionEntity> findAllCustom() {
		return repositorio.findAllCustom();
	}
	@Override
	public DetalleRecepcionEntity findById(Long id) {
		DetalleRecepcionEntity detalleRecepcion = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleRecepcion con id " + id + " no existe"));
		return detalleRecepcion;
	}
	@Override
	public DetalleRecepcionEntity add(DetalleRecepcionEntity obj) {
		obj.setEstado(true);
		return repositorio.save(obj);
	}
	@Override
	public DetalleRecepcionEntity update(DetalleRecepcionEntity obj, Long id) {
		DetalleRecepcionEntity objdet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleRecepcion con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objdet, "codigo");
		return repositorio.save(objdet);
	}
	@Override
	public DetalleRecepcionEntity delete(Long id) {
		DetalleRecepcionEntity objdet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleRecepcion con id " + id + " no existe"));
		objdet.setEstado(false);
		return repositorio.save(objdet);
	}
	@Override
	public DetalleRecepcionEntity enable(Long id) {
		DetalleRecepcionEntity objdet = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("DetalleRecepcion con id " + id + " no existe"));
		objdet.setEstado(true);
		return repositorio.save(objdet);
	}
}
