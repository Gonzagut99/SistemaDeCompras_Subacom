package pe.com.subacomcompras.entity.base;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
@Data
@MappedSuperclass

public class BaseEntity {
    @Column(name="estado")
    private boolean estado;
}
