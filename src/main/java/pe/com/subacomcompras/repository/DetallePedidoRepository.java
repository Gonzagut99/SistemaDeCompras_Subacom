/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package pe.com.subacomcompras.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.com.subacomcompras.entity.DetallePedidoEntity;

public interface DetallePedidoRepository extends JpaRepository<DetallePedidoEntity, Long>{
    @Query("select d from DetallePedidoEntity d where d.estado=true")
    List<DetallePedidoEntity> findAllCustom();
    
    @Query("select d from DetallePedidoEntity d where d.pedido.id_order=:pedidoId")
    List<DetallePedidoEntity> findByPedidoId(@Param("pedidoId") Long pedidoId);
}
