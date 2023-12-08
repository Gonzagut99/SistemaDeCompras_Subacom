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
@Entity(name = "UsuarioEntity")
@Table(name = "usuario")

public class UsuarioEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    
    @Id
    @Column(name="id_user")
    private long id_user;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El nombre del usuario tiene que estar entre el {min} caracteres y {max} caracteres")
    @Column(name="user_name")
    private String user_name;
  
    @NotEmpty
    @Size(min = 5, max = 20, message = "La contraseña del usuario tiene que estar entre el {min} caracteres y {max} caracteres")
    @Column(name="user_password")
    private String user_password;
    
    @ManyToOne
    @JoinColumn(name="id_role",nullable = false)
    private RolEntity rol;
}
