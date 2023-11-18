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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")

public class ProveedorEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_supplier")
    private long id_supplier;
    
    @NotEmpty
    @Size(min = 5, max = 40, message = "El nombre del proveedor tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="supplier_name")
    private String supplier_name;
    
    @NotEmpty
    @Size(min = 5, max = 40, message = "El nombre de contacto del proveedor tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="supplier_contact_name")
    private String supplier_contact_name;
    
    @NotEmpty
    @Size(min = 5, max = 40, message = "La direccion del proveedor tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="supplier_address")
    private String supplier_address;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "La ciudad del proveedor tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="supplier_city")
    private String supplier_city;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El pais del proveedor tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="supplier_country")
    private String supplier_country;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El pais del proveedor tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="supplier_postal_code")
    private String supplier_postal_code;
        
    @NotEmpty
    @Column(name="supplier_phone")
    private String supplier_phone;
    
}
