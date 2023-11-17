package pe.com.subacomcompras.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import java.io.Serializable;
import pe.com.subacomcompras.entity.base.BaseEntity;



@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "DetalleReporteEntity")
@Table(name = "detalle_reporte")

public class DetalleReporteEntity extends BaseEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_report")
    private long id_detail_report;
    @Column(name="detailed_report_metric")
    private String detailed_report_metric;
    @Column(name="detailed_report_value")
    private String detailed_report_value;
    @ManyToOne
    @JoinColumn(name="id_report",nullable = false)
    private InformeEntity informe;
}
