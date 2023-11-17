package pe.com.subacomcompras.entity;

import lombok.*;
import java.util.Date;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import java.io.Serializable;
import pe.com.subacomcompras.entity.base.BaseEntity;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "EmpleadoEntity")
@Table(name = "empleado")

public class EmpleadoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
        
    @Id
    @Column(name="id_employee")
    private long id_employee;
    @Column(name="employee_name")
    private String employee_name;
    @Column(name="employee_first_name")
    private String employee_first_name;
    @Column(name="employee_second_name")
    private String employee_second_name;
    @Column(name="employee_email")
    private String employee_email;
    @Column(name="hire_date")
    private Date hire_date;
    @Column(name="employee_phone")
    private String employee_phone;
    @Column(name="employee_gender")
    private String employee_gender;
    @Column(name="employee_dni")
    private String employee_dni;
    @Column(name="employee_delete_state")
    private boolean employee_delete_state;
    @ManyToOne
    @JoinColumn(name="id_user",nullable = false)
    private UsuarioEntity usuario;
}
    