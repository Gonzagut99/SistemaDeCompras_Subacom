/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.controller;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pe.com.subacomcompras.entity.DetallePedidoEntity;
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.entity.PedidoEntity;
import pe.com.subacomcompras.entity.ProductoEntity;
import pe.com.subacomcompras.entity.ProductoToDetail;
import pe.com.subacomcompras.entity.ProveedorEntity;
import pe.com.subacomcompras.service.gestion.DetallePedidoService;
import pe.com.subacomcompras.service.gestion.PedidoService;
import pe.com.subacomcompras.service.gestion.ProductoService;
import pe.com.subacomcompras.service.gestion.ProveedorService;
import pe.com.subacomcompras.service.seguridad.EmpleadoService;

@Controller
public class PedidoController {
    @Autowired
    private PedidoService servicio;
    
    @Autowired
    private ProveedorService proveedorServicio;
    
    @Autowired
    private EmpleadoService empleadoServicio;
    
    @Autowired
    private DetallePedidoService detallePedidoervicio;
    
    @Autowired
    private ProductoService productoService;
    
    @GetMapping("/pedidos")
    public String MostrarPedidosPage(Model modelo){
        modelo.addAttribute("pedidos",servicio.findAllCustom());
        return "Pedidos/pedidos";
    }
    
    @GetMapping("/detallepedidopage/{id}")
    public String MostrarDetallePedidoPage(@PathVariable Long id, Model modelo){
        modelo.addAttribute("productospedidos",detallePedidoervicio.findByPedidoId(id));
        return "Pedidos/detallePedido";
    }
    
    @PostMapping("/registrarpedido")
    public String RegistrarPedido(
            ) {
            /*Timer timer = new Timer();
            timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("Ejecutado después de 2 segundos");
            }
        }, 2000);*/
        return "redirect:/pedidos";
    }
    
}
