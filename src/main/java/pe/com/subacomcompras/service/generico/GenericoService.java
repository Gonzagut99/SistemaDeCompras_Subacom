/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.service.generico;

import java.util.List;
import java.util.Optional;

public interface GenericoService<T> {
    List<T> findAll();
    
    List<T> findAllCustom();
    
    Optional<T> findById();
    
    T add(T t);
    
    T update(T t);
    
    T delete(T t);
    
    T enable(T t);
}