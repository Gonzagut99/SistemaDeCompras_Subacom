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
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.repository.EmpleadoRepository;
import pe.com.subacomcompras.service.seguridad.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
    @Autowired
    private EmpleadoRepository repositorio;
    
    @Override
    public List<EmpleadoEntity> findAll() {
        return repositorio.findAll();
    }

    @Override
    public List<EmpleadoEntity> findAllCustom() {
        return repositorio.findAllCustom();
    }
    
    @Override
    public Optional<EmpleadoEntity> findById(Long id) {
        return repositorio.findById(id);
    }

    @Override
    public EmpleadoEntity add(EmpleadoEntity t) {
       return repositorio.save(t);
    }

    @Override
    public EmpleadoEntity update(EmpleadoEntity t) {
       EmpleadoEntity objrol = repositorio.getById(t.getId_employee());
       BeanUtils.copyProperties(t, objrol);
       return repositorio.save(objrol);
    }

    @Override
    public EmpleadoEntity delete(EmpleadoEntity t) {
       EmpleadoEntity objrol = repositorio.getById(t.getId_employee());
       objrol.setEstado(false);
       return repositorio.save(objrol);
    }

    @Override
    public EmpleadoEntity enable(EmpleadoEntity t) {
       EmpleadoEntity objrol = repositorio.getById(t.getId_employee());
       objrol.setEstado(true);
       return repositorio.save(objrol);
    }

    @Override
    public List<EmpleadoEntity> findByDni(String employee_dni) {
        return repositorio.findByDni(employee_dni);
    }
    
}
