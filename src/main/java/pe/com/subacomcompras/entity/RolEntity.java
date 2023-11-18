package pe.com.subacomcompras.entity;

import lombok.*;
import lombok.experimental.SuperBuilder;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import java.io.Serializable;
import pe.com.subacomcompras.entity.base.BaseEntity;


@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode(callSuper = false)
@Entity(name = "RolEntity")
@Table(name = "rol")

public class RolEntity extends BaseEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_role")
    private long id_role;
    
    @NotEmpty
    @Size(min = 5, max = 70, message = "El nombre del rol tiene qeu estar entre el {min} caracteres y {max} caracteres")
    @Column(name="role_name")
    private String role_name; 
    
}
