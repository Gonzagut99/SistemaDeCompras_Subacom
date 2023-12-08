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
import pe.com.subacomcompras.entity.ProveedorEntity;
import pe.com.subacomcompras.repository.ProveedorRepository;
import pe.com.subacomcompras.service.gestion.ProveedorService;
@Service
public class ProveedorServiceImpl implements ProveedorService{
     @Autowired
    private ProveedorRepository repositorio;

    @Override
    public List<ProveedorEntity> findAll() {
       return repositorio.findAll();
    }

    @Override
    public List<ProveedorEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<ProveedorEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ProveedorEntity add(ProveedorEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ProveedorEntity update(ProveedorEntity t) {
       ProveedorEntity objrol = repositorio.getById(t.getId_supplier());
       BeanUtils.copyProperties(t, objrol);
       return repositorio.save(objrol);
    }

    @Override
    public ProveedorEntity delete(ProveedorEntity t) {
       ProveedorEntity objrol = repositorio.getById(t.getId_supplier());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }

    @Override
    public ProveedorEntity enable(ProveedorEntity t) {
        ProveedorEntity objrol = repositorio.getById(t.getId_supplier());
       objrol.setEstado(true);
       return repositorio.save(objrol);
    }
}
