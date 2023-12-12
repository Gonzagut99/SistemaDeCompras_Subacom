/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pe.com.subacomcompras.service.gestion.ProveedorService;

@Controller
public class ProveedorController {
    @Autowired
    private ProveedorService servicio;
    
    @GetMapping("/proveedor")
    public String MostrarRol(Model modelo){
        modelo.addAttribute("proveedores",servicio.findAllCustom());
        return "Proveedor/proveedor";
    }
}
