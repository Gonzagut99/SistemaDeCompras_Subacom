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
import pe.com.subacomcompras.entity.PedidoEntity;
import pe.com.subacomcompras.repository.PedidoRepository;
import pe.com.subacomcompras.service.gestion.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService{
     @Autowired
    private PedidoRepository repositorio;

    @Override
    public List<PedidoEntity> findAll() {
       return repositorio.findAll();
    }

    @Override
    public List<PedidoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<PedidoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public PedidoEntity add(PedidoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public PedidoEntity update(PedidoEntity t) {
       PedidoEntity objrol = repositorio.getById(t.getId_order());
       BeanUtils.copyProperties(t, objrol);
       return repositorio.save(objrol);
    }

    @Override
    public PedidoEntity delete(PedidoEntity t) {
       PedidoEntity objrol = repositorio.getById(t.getId_order());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }

    @Override
    public PedidoEntity enable(PedidoEntity t) {
        PedidoEntity objrol = repositorio.getById(t.getId_order());
       objrol.setEstado(true);
       return repositorio.save(objrol);
    }
}
