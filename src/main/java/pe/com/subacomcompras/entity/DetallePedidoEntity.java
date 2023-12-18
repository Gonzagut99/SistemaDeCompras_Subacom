package pe.com.subacomcompras.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import pe.com.subacomcompras.entity.base.BaseEntity;




@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "DetallePedidoEntity")
@Table(name = "detalle_pedido")

public class DetallePedidoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_orderdetail")
    private long id_orderdetail;
    
    @NotEmpty
    @Column(name="quantity")
    private int quantity;
    
    @NotEmpty
    @Column(name="precio_compra")
    private double precio_compra;
    
    
    @ManyToOne
    @JoinColumn(name="id_order",nullable = false)
    private PedidoEntity pedido;
    
    @ManyToOne
    @JoinColumn(name="id_product",nullable = false)
    private ProductoEntity producto;
    
}
