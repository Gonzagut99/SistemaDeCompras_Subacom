package pe.com.subacomcompras.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
import pe.com.subacomcompras.entity.base.BaseEntity;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "PlanSuministrosEntity")
@Table(name = "plan_suministros")

public class PlanSuministrosEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_need")
    private long id_need;
    
    @NotEmpty
    @Column(name="needed_quantity")
    private int needed_quantity;
    
    @NotEmpty
    @Column(name="planned_quantity")
    private int planned_quantity;
    
    @NotEmpty
    @Column(name="planned_date_order")  
    private Date planned_date_order;
    
    @NotEmpty
    @Column(name="need_delete_state")
    private boolean need_delete_state;
    
    
    @ManyToOne
    @JoinColumn(name="id_product",nullable = false)
    private ProductoEntity producto;
}
