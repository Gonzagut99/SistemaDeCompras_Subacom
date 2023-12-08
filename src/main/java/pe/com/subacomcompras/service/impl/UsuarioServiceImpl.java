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
import pe.com.subacomcompras.entity.UsuarioEntity;
import pe.com.subacomcompras.repository.UsuarioRepository;
import pe.com.subacomcompras.service.seguridad.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService{
     @Autowired
    private UsuarioRepository repositorio;

    @Override
    public List<UsuarioEntity> findAll() {
       return repositorio.findAll();
    }

    @Override
    public List<UsuarioEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }

    @Override
    public Optional<UsuarioEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public UsuarioEntity add(UsuarioEntity t) {
        return repositorio.save(t);
    }

    @Override
    public UsuarioEntity update(UsuarioEntity t) {
       UsuarioEntity objrol = repositorio.getById(t.getId_user());
       BeanUtils.copyProperties(t, objrol);
       return repositorio.save(objrol);
    }

    @Override
    public UsuarioEntity delete(UsuarioEntity t) {
       UsuarioEntity objrol = repositorio.getById(t.getId_user());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }

    @Override
    public UsuarioEntity enable(UsuarioEntity t) {
        UsuarioEntity objrol = repositorio.getById(t.getId_user());
       objrol.setEstado(true);
       return repositorio.save(objrol);
    }
}
