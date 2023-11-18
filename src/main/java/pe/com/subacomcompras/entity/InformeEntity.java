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
@Entity(name = "InformeEntity")
@Table(name = "informe")

public class InformeEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_report")
    private long id_report;
    
    @NotEmpty
    @Column(name="report_date")
    private Date report_date;
    
    @NotEmpty
    @Column(name="report_type")
    private String report_type;
    
}
