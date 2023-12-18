/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.com.subacomcompras.restController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.com.subacomcompras.entity.DetallePedidoEntity;
import pe.com.subacomcompras.entity.EmpleadoEntity;
import pe.com.subacomcompras.entity.PedidoEntity;
import pe.com.subacomcompras.entity.ProductoEntity;
import pe.com.subacomcompras.entity.ProductoToDetail;
import pe.com.subacomcompras.entity.ProveedorEntity;
import pe.com.subacomcompras.entity.UsuarioEntity;
import pe.com.subacomcompras.service.gestion.DetallePedidoService;
import pe.com.subacomcompras.service.gestion.PedidoService;
import pe.com.subacomcompras.service.gestion.ProductoService;
import pe.com.subacomcompras.service.gestion.ProveedorService;
import pe.com.subacomcompras.service.seguridad.EmpleadoService;

@RestController
@RequestMapping("/pedidoRest")
public class PedidoRestController {
    @Autowired
    private DetallePedidoService detallePedidoServicio;
    
    @Autowired
    private PedidoService servicio;
    
    @Autowired
    private ProveedorService proveedorServicio;
    
    @Autowired
    private EmpleadoService empleadoServicio;
    
    @Autowired
    private ProductoService productoService;
    
    
    @PostMapping("/listaPedidoDetail")
    public ResponseEntity<String> recibirLista(@RequestBody List<ProductoToDetail> listaProductosSeleccionados) {
        // Aquí puedes manejar la lista de objetos
        detallePedidoServicio.setListaProductos(listaProductosSeleccionados);

        return ResponseEntity.ok("Lista recibida correctamente");
    }
    
    @PostMapping("/registrarpedidoRest")
    public ResponseEntity<String> RegistrarPedido(@RequestParam("id_proveedor") Long id_proveedor,@RequestParam("id_employee") Long id_employee) {
        PedidoEntity existingPedido = new PedidoEntity();
        // Crear un objeto LocalDateTime con la fecha y hora actual
        LocalDateTime dateTime = LocalDateTime.now();
        
        // Convertir Date a Timestamp
        Timestamp timestamp = Timestamp.valueOf(dateTime);
        
        existingPedido.setOrder_date(timestamp);
        existingPedido.setOrder_state("Pendiente");
        existingPedido.setEstado(true);

        // Buscar el proveedor en la base de datos
        ProveedorEntity proveedor = proveedorServicio.findById(id_proveedor).get();
        existingPedido.setProveedor(proveedor);
        
        // Buscar el empleado en la base de datos
        EmpleadoEntity empleado = empleadoServicio.findById(id_employee).get();
        existingPedido.setEmpleado(empleado);
        
        PedidoEntity savedPedido = servicio.add(existingPedido);
        Long newPedidoId = savedPedido.getId_order();
        
        // Aquí puedes acceder a la lista de productos
        List<ProductoToDetail> listaProductos = detallePedidoServicio.getListaProductos();
        
        // Ejecuta el método 'registrarDetallePedido' por cada objeto ProductoToDetail de la lista
        for (ProductoToDetail productoSeleccionado : listaProductos) {
            registrarDetallePedido(productoSeleccionado, newPedidoId);
        }
        
        return ResponseEntity.ok("Pedido y detalle pedido registrados correctamente");
    }
    
    public String registrarDetallePedido(
            ProductoToDetail productoSeleccionado, Long pedido_id) {
        Long id_product = Long.valueOf(productoSeleccionado.getId_product());
        int quantity = Integer.parseInt(productoSeleccionado.getQuantity());
        
        DetallePedidoEntity detallePedidoObj = new DetallePedidoEntity();
        PedidoEntity pedidoEncontrado = servicio.findById(pedido_id).get();
        ProductoEntity productoEncontrado = productoService.findById(id_product).get();
        
        detallePedidoObj.setEstado(true);
        detallePedidoObj.setPedido(pedidoEncontrado);
        detallePedidoObj.setProducto(productoEncontrado);
        detallePedidoObj.setQuantity(quantity);
        detallePedidoObj.setPrecio_compra(productoSeleccionado.getPrecio_compra());

        detallePedidoServicio.add(detallePedidoObj);
        
        return "redirect:/pedidos";
    }
    
    
    @GetMapping
    public List<PedidoEntity> findAll() {
        return servicio.findAll();
    }
    
    @GetMapping("/custom")
        public List<PedidoEntity> findAllCustom() {
        return servicio.findAllCustom();
    }
    
        
    @GetMapping("/{id}")
    public Optional<PedidoEntity> findById(@PathVariable Long id) {
        return servicio.findById(id);
    }
    
    @PostMapping
    public PedidoEntity add(@RequestBody PedidoEntity c) {
        return servicio.add(c);
    }
    
    
    @PutMapping("{id}")
    public PedidoEntity update(@PathVariable Long id, @RequestBody PedidoEntity c) {
        c.setId_order(id);
        return servicio.update(c);
    }
    
    @DeleteMapping("{id}")
    public PedidoEntity delete(@PathVariable Long id) {
        PedidoEntity objpedido = new PedidoEntity();
        objpedido.setEstado(false);
        return servicio.delete(PedidoEntity.builder().id_order(id).build());
    }
}
