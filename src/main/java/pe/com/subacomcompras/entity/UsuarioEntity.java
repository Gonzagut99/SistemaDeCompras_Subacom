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
@Entity(name = "UsuarioEntity")
@Table(name = "usuario")

public class UsuarioEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    
    @Id
    @Column(name="id_user")
    private long id_user;
    @Column(name="user_name")
    private String user_name;
    @Column(name="user_password")
    private String user_password;
    @Column(name="user_delete_state")
    private boolean user_delete_state;
    @ManyToOne
    @JoinColumn(name="id_role",nullable = false)
    private RolEntity rol;
}
