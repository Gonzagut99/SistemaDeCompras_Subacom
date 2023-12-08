/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.subacomcompras.service.gestion.ProductoService;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService servicio;
    
    @GetMapping("/producto")
    public String MostrarRol(Model modelo){
        modelo.addAttribute("productos",servicio.findAllCustom());
        return "Producto/producto";
    }
}
