/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.subacomcompras.entity.CategoriaEntity;

import pe.com.subacomcompras.entity.ProductoEntity;
import pe.com.subacomcompras.service.gestion.CategoriaService;
import pe.com.subacomcompras.service.gestion.ProductoService;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService servicio;

    @Autowired
    private CategoriaService servicioCategoria;
    
    @GetMapping("/producto")
    public String MostrarProducto(Model modelo, @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size){
        modelo.addAttribute("producto", new ProductoEntity());
        modelo.addAttribute("categoria", new CategoriaEntity());
        
        Page<ProductoEntity> productPage = servicio.findAllPaginated(PageRequest.of(page, size));
        modelo.addAttribute("productos", productPage.getContent());
        modelo.addAttribute("categorias",servicioCategoria.findAllCustom());
        modelo.addAttribute("allCategorias",servicioCategoria.findAll());
        modelo.addAttribute("currentPage", page);
        modelo.addAttribute("totalPages", productPage.getTotalPages());
        modelo.addAttribute("page", productPage);
        return "Producto/producto";
        
    }

    @PostMapping("/registrarproducto")
    public String RegistrarEmpleado(
            @ModelAttribute("producto") ProductoEntity p) {
        ProductoEntity existingProducto = new ProductoEntity();
        existingProducto.setProduct_name(p.getProduct_name());
        existingProducto.setUnit_price(p.getUnit_price());
        existingProducto.setProduct_stock(p.getProduct_stock());
        existingProducto.setProduct_photo_url(p.getProduct_photo_url());
        existingProducto.setWarranty_time(p.getWarranty_time());
        existingProducto.setWarranty_time_unit(p.getWarranty_time_unit());
        existingProducto.setProduct_description(p.getProduct_description());
        existingProducto.setEstado(p.isEstado());

        // Buscar la categoría en la base de datos
        CategoriaEntity categoria = servicioCategoria.findById(p.getCategoria().getId_category()).get();
        existingProducto.setCategoria(categoria);
        servicio.add(existingProducto);
        return "redirect:/producto";
    }

    @GetMapping("/actualizarproductopage/{id}")
    public String MostrarActualizarEmpleado(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("producto",
                servicio.findById(id).get());
        modelo.addAttribute("categorias",
                servicioCategoria.findAllCustom());
        return "Producto/actualizarProducto";
    }
    
    @GetMapping("/actualizarcategoriapage/{id}")
    public String MostrarActualizarCategoria(@PathVariable Long id,
            Model modelo) {
        modelo.addAttribute("categoria",
                servicioCategoria.findById(id).get());
        return "Producto/actualizarCategoria";
    }

    @PostMapping("/actualizarproducto/{id}")
    public String ActualizarProducto(@PathVariable Long id,
            @ModelAttribute("producto") ProductoEntity p) {
        ProductoEntity existingProducto = servicio.findById(id).get();
        existingProducto.setProduct_name(p.getProduct_name());
        existingProducto.setUnit_price(p.getUnit_price());
        existingProducto.setProduct_stock(p.getProduct_stock());
        existingProducto.setProduct_photo_url(p.getProduct_photo_url());
        existingProducto.setWarranty_time(p.getWarranty_time());
        existingProducto.setWarranty_time_unit(p.getWarranty_time_unit());
        existingProducto.setProduct_description(p.getProduct_description());
        existingProducto.setEstado(p.isEstado());

        // Buscar la categoría en la base de datos
        CategoriaEntity categoria = servicioCategoria.findById(p.getCategoria().getId_category()).get();
        existingProducto.setCategoria(categoria); // Aquí es donde actualizas la categoría

        servicio.update(existingProducto);
        return "redirect:/producto";
    }

    @GetMapping("/eliminarproducto/{id}")
    public String EliminarEmpleado(@PathVariable Long id, @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {
        ProductoEntity objproducto = servicio.findById(id).get();
        if (objproducto.isEstado()) {
            servicio.delete(objproducto);
        }else{
            servicio.enable(objproducto);
        }
        
        return String.format("redirect:/producto?page=%d&size=%d", page, size);
    }
}
