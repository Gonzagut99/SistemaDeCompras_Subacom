/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.subacomcompras.entity.CategoriaEntity;
import pe.com.subacomcompras.entity.ProveedorEntity;
import pe.com.subacomcompras.service.gestion.ProveedorService;

@Controller
public class ProveedorController {
    @Autowired
    private ProveedorService servicio;
    
    @GetMapping("/proveedor")
    public String MostrarProveedorPage(Model modelo){
        modelo.addAttribute("proveedores",servicio.findAll());
        modelo.addAttribute("proveedor", new ProveedorEntity());
        return "Proveedor/proveedor";
    }
    
    @GetMapping("/actualizarproveedorpage/{id}")
    public String MostrarActualizarProveedorPage(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("proveedor",
                servicio.findById(id).get());
        modelo.addAttribute("proveedores",
                servicio.findAllCustom());
        
        return "Proveedor/actualizarProveedor";
    }
    
    //ACTUALIZAR EMPLEADO
    @PostMapping("/actualizarproveedor/{id}")
    public String ActualizarProveedor(@PathVariable Long id,
            @ModelAttribute("proveedor") ProveedorEntity c) {
        c.setId_supplier(id);
        servicio.update(c);
        return "redirect:/proveedor";
    }
    
    
    
    @GetMapping("/eliminarproveedor/{id}")
    public String EliminarProveedor(@PathVariable Long id) {
        ProveedorEntity objproveedor = servicio.findById(id).get();
        if (objproveedor.isEstado()) {
            servicio.delete(objproveedor);
        }else{
            servicio.enable(objproveedor);
        }
   
        return "redirect:/proveedor";
    }
    
    
    @ModelAttribute("proveedor")
    public ProveedorEntity ModelProveedor(){
        return new ProveedorEntity();
    }
    
    @PostMapping("/registrarproveedor")
    public String RegistrarProveedor(@ModelAttribute ("proveedor") ProveedorEntity r){
        servicio.add(r);
        return "redirect:/proveedor";
    }
}
