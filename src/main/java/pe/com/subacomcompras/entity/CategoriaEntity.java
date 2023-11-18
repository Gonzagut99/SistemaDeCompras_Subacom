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
@Entity(name = "CategoriaEntity")
@Table(name = "categoria")

public class CategoriaEntity extends BaseEntity implements Serializable{
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_category")
    private long id_category;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El nombre de la categoria tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="category_name")
    private String category_name;
    
    @NotEmpty
    @Size(min = 5, max = 20, message = "La descripcion de la categoria tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="category_description")
    private String category_description;
}
