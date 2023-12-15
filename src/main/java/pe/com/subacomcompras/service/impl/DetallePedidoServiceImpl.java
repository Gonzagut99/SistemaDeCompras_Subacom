/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.subacomcompras.entity.DetallePedidoEntity;
import pe.com.subacomcompras.repository.DetallePedidoRepository;
import pe.com.subacomcompras.service.gestion.DetallePedidoService;

@Service
public class DetallePedidoServiceImpl implements DetallePedidoService{
    @Autowired
    private DetallePedidoRepository repositorio;
    
    @Override
    public List<DetallePedidoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<DetallePedidoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public Optional<DetallePedidoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public DetallePedidoEntity add(DetallePedidoEntity t) {
       return repositorio.save(t);
    }

    @Override
    public DetallePedidoEntity update(DetallePedidoEntity t) {
       DetallePedidoEntity objrol = repositorio.getById(t.getId_orderdetail());
       BeanUtils.copyProperties(t, objrol);
       return repositorio.save(objrol);
    }

    @Override
    public DetallePedidoEntity delete(DetallePedidoEntity t) {
       DetallePedidoEntity objrol = repositorio.getById(t.getId_orderdetail());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }

    @Override
    public DetallePedidoEntity enable(DetallePedidoEntity t) {
       DetallePedidoEntity objrol = repositorio.getById(t.getId_orderdetail());
       objrol.setEstado(true);
       return repositorio.save(objrol);
    }
    
}
