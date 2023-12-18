package pe.com.subacomcompras.entity;

import lombok.*;
import java.util.Date;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import org.springframework.format.annotation.DateTimeFormat;
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
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El nombre del empleado tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="employee_name")
    private String employee_name;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El primer apellido  del empleado tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="employee_first_lastname")
    private String employee_first_lastName;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El segundo apellido  del empleado tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="employee_second_lastname")
    private String employee_second_lastNname;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El correo electronico del empleado tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="employee_email")
    private String employee_email;
    
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name="hire_date")
    private Date hire_date;
    
    @NotEmpty
    @Column(name="employee_phone")
    private String employee_phone;
    
    @NotEmpty
    @Column(name="employee_gender")
    private String employee_gender;
    
    @NotEmpty
    @Column(name="employee_dni")
    private String employee_dni;  
    
    @ManyToOne
    @JoinColumn(name="id_user",nullable = false)
    private UsuarioEntity usuario;
}
    