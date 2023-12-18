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
import pe.com.subacomcompras.entity.CategoriaEntity;
import pe.com.subacomcompras.repository.CategoriaRepository;
import pe.com.subacomcompras.service.gestion.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService{
    @Autowired
    private CategoriaRepository repositorio;
    
    @Override
    public List<CategoriaEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<CategoriaEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public Optional<CategoriaEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public CategoriaEntity add(CategoriaEntity t) {
       return repositorio.save(t);
    }

    @Override
    public CategoriaEntity update(CategoriaEntity t) {
       CategoriaEntity objCategoria = repositorio.getById(t.getId_category());
       BeanUtils.copyProperties(t, objCategoria);
       return repositorio.save(objCategoria);
    }

    @Override
    public CategoriaEntity delete(CategoriaEntity t) {
       CategoriaEntity objCategoria = repositorio.getById(t.getId_category());
       objCategoria.setEstado(false);
       return repositorio.save(objCategoria);
    }

    @Override
    public CategoriaEntity enable(CategoriaEntity t) {
       CategoriaEntity objCategoria = repositorio.getById(t.getId_category());
       objCategoria.setEstado(true);
       return repositorio.save(objCategoria);
    }
    
}
