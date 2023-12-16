/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.service.gestion;

import java.util.List;
import pe.com.subacomcompras.entity.DetallePedidoEntity;
import pe.com.subacomcompras.entity.ProductoToDetail;
import pe.com.subacomcompras.service.generico.GenericoService;

public interface DetallePedidoService extends GenericoService<DetallePedidoEntity>{
    void setListaProductos(List<ProductoToDetail> listaProductos);
    List<ProductoToDetail> getListaProductos();
    
    List<DetallePedidoEntity> findByPedidoId(Long pedidoId);
}
