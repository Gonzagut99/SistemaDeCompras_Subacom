package pe.com.subacomcompras.entity.base;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass

public class BaseEntity {
    
    @Column(name="estado")
    @NotEmpty
    private boolean estado;
}
