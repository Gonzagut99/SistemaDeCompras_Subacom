package pe.com.subacomcompras.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Date;
import pe.com.subacomcompras.entity.base.BaseEntity;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "PedidoEntity")
@Table(name = "pedido")

public class PedidoEntity extends BaseEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_order")
    private long id_order;
    @Column(name="order_date")
    private Date order_date;
    @Column(name="order_state")
    private String order_state;
    @Column(name="order_delete_state")
    private boolean order_delete_state;
    @ManyToOne
    @JoinColumn(name="id_supplier",nullable = false)
    private ProveedorEntity proveedor;
    @ManyToOne
    @JoinColumn(name="id_employee",nullable = false)
    private EmpleadoEntity empleado;
    
}
