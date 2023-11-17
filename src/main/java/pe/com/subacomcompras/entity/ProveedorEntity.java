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
@Entity(name = "ProveedorEntity")
@Table(name = "proveedor")

public class ProveedorEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_supplier")
    private long id_supplier;
    @Column(name="supplier_name")
    private String supplier_name;
    @Column(name="supplier_contact_name")
    private String supplier_contact_name;
    @Column(name="supplier_address")
    private String supplier_address;
    @Column(name="supplier_city")
    private String supplier_city;
    @Column(name="supplier_country")
    private String supplier_country;
    @Column(name="supplier_postal_code")
    private String supplier_postal_code;
    @Column(name="supplier_phone")
    private String supplier_phone;
    
}
