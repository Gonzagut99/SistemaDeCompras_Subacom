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
import pe.com.subacomcompras.entity.RolEntity;
import pe.com.subacomcompras.repository.RolRepository;
import pe.com.subacomcompras.service.seguridad.RolService;

@Service
public class RolServiceImpl implements RolService{
    @Autowired
    private RolRepository repositorio;
    
    @Override
    public List<RolEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<RolEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public Optional<RolEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public RolEntity add(RolEntity t) {
       return repositorio.save(t);
    }

    @Override
    public RolEntity update(RolEntity t) {
       RolEntity objrol = repositorio.getById(t.getId_role());
       BeanUtils.copyProperties(t, objrol);
       return repositorio.save(objrol);
    }

    @Override
    public RolEntity delete(RolEntity t) {
       RolEntity objrol = repositorio.getById(t.getId_role());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }

    @Override
    public RolEntity enable(RolEntity t) {
       RolEntity objrol = repositorio.getById(t.getId_role());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }
       
}
