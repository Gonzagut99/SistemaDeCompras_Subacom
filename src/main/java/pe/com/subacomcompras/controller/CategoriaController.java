/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pe.com.subacomcompras.entity.CategoriaEntity;
import pe.com.subacomcompras.service.gestion.CategoriaService;

@Controller
public class CategoriaController {
    @Autowired
    private CategoriaService servicio;
    
    @PostMapping("/registrarcategoria")
    public String RegistrarRol(
            @ModelAttribute("categoria") CategoriaEntity c) {
        servicio.add(c);
        return "redirect:/producto";
    }
    
    @PostMapping("/actualizarcategoria/{id}")
    public String ActualizarCategoria(@PathVariable Long id,
            @ModelAttribute("categoria") CategoriaEntity c) {
        c.setId_category(id);
        servicio.update(c);
        return "redirect:/producto";
    }
    
    @GetMapping("/eliminarcategoria/{id}")
    public String EliminarEmpleado(@PathVariable Long id) {
        CategoriaEntity objcategoria = servicio.findById(id).get();
        if (objcategoria.isEstado()) {
            servicio.delete(objcategoria);
        }else{
            servicio.enable(objcategoria);
        }
        return "redirect:/producto";
    }
}
