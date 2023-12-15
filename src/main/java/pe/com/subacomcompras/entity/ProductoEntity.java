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
@Entity(name = "ProductoEntity")
@Table(name = "producto")


public class ProductoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID=1L;
    
    @Id
    @Column(name="id_product")
    private long id_product;
    
    @NotEmpty
    @Size(min = 5, max = 30, message = "El nombre del producto tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="product_name")
    private String product_name;
    
    @NotEmpty
    @Size(min = 5, max = 200, message = "La descripcion del producto tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="product_description")
    private String product_description;
    
    @NotEmpty
    @Column(name="unit_price")
    private float unit_price;
    
    @NotEmpty
    @Column(name="product_stock")
    private int product_stock;
    
    @NotEmpty
    @Size(min = 1, max = 4, message = "La garantia tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="warranty_time")
    private int warranty_time;
    
    @NotEmpty
    @Size(min = 5, max = 20, message = "La garantia tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="warranty_time_unit")
    private String warranty_time_unit;
    
    @NotEmpty
    @Size(min = 5, max = 100, message = "La url del producto tiene que estar entre {min} caracteres y {max} caracteres")
    @Column(name="product_photo_url")
    private String product_photo_url;
    
    @NotEmpty
    @ManyToOne
    @JoinColumn(name="id_category",nullable = false)
    private CategoriaEntity categoria;
}