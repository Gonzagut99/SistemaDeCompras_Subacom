/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.service.impl;

import org.springframework.data.domain.Pageable;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import pe.com.subacomcompras.entity.ProductoEntity;
import pe.com.subacomcompras.repository.ProductoRepository;
import pe.com.subacomcompras.service.gestion.ProductoService;

@Service
public class ProductoServiceImpl implements ProductoService{
     @Autowired
    private ProductoRepository repositorio;

    @Override
    public List<ProductoEntity> findAll() {
       return repositorio.findAll();
    }

    @Override
    public Page<ProductoEntity> findAllCustomPaginated(Pageable pageable) {
        //Pageable page = PageRequest.of(pageNumber, 5); 
        return repositorio.findAllCustomPageable(pageable);
    }
    
    @Override
    public Page<ProductoEntity> findAllPaginated(Pageable pageable) {
        //Pageable page = PageRequest.of(pageNumber, 5); 
        return repositorio.findAllPageable(pageable);
    }

    @Override
    public Optional<ProductoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public ProductoEntity add(ProductoEntity t) {
        return repositorio.save(t);
    }

    @Override
    public ProductoEntity update(ProductoEntity t) {
       ProductoEntity objrol = repositorio.getById(t.getId_product());
       BeanUtils.copyProperties(t, objrol);
       return repositorio.save(objrol);
    }

    @Override
    public ProductoEntity delete(ProductoEntity t) {
       ProductoEntity objrol = repositorio.getById(t.getId_product());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }

    @Override
    public ProductoEntity enable(ProductoEntity t) {
        ProductoEntity objrol = repositorio.getById(t.getId_product());
       objrol.setEstado(true);
       return repositorio.save(objrol);
    }

    @Override
    public List<ProductoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
   
}
