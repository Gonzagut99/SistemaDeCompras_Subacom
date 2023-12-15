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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.subacomcompras.entity.PedidoEntity;
import pe.com.subacomcompras.entity.ProductoEntity;

import pe.com.subacomcompras.service.gestion.CategoriaService;
import pe.com.subacomcompras.service.gestion.ProductoService;
import pe.com.subacomcompras.service.gestion.ProveedorService;

@Controller
public class ProductosController {
    @Autowired
    private ProductoService servicio;
    
    @Autowired
    private ProveedorService servicioProveedor;

    // @Autowired
    // private CategoriaService servicioCategoria;
    
    @GetMapping("/productos")
    public String MostrarProductosPage(Model modelo, @RequestParam(defaultValue="0") int page, @RequestParam(defaultValue="5") int size){
        Page<ProductoEntity> productPage = servicio.findAllCustomPaginated(PageRequest.of(page, size));
        modelo.addAttribute("productos", productPage.getContent());
        modelo.addAttribute("proveedores",servicioProveedor.findAllCustom());
        modelo.addAttribute("currentPage", page);
        modelo.addAttribute("totalPages", productPage.getTotalPages());
        modelo.addAttribute("page", productPage);
        return "Productos/productos";
    }
    
    /*@PostMapping("/productos/seleccionados")
    public String procesarFormulario(@ModelAttribute("productos") Productos productos, Model model) {
        List<Producto> seleccionados = productos.getLista().stream()
            .filter(p -> p.isSelected())
            .collect(Collectors.toList());

        PedidoEntity pedido = new PedidoEntity();
        // Aquí debes establecer los valores para los campos de pedido

        for (Producto producto : seleccionados) {
            DetallePedidoEntity detalle = new DetallePedidoEntity();
            detalle.setProducto(producto);
            detalle.setPedido(pedido);
        }


        return "redirect:/";
    }*/
}

