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
@Entity(name = "ProductoEntity")
@Table(name = "producto")


public class ProductoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_product")
    private long id_product;
    @Column(name="product_name")
    private String product_name;
    @Column(name="product_description")
    private String product_description;
    @Column(name="unit_price")
    private float unit_price;
    @Column(name="product_stock")
    private int product_stock;
    @Column(name="warranty_time")
    private String warranty_time;
    @Column(name="product_photo_url")
    private String product_photo_url;
    @ManyToOne
    @JoinColumn(name="id_category",nullable = false)
    private CategoriaEntity categoria;
    @ManyToOne
    @JoinColumn(name="id_supplier",nullable = false)
    private ProveedorEntity proveedor;
}
