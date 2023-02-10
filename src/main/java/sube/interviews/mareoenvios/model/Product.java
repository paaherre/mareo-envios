package sube.interviews.mareoenvios.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "weight", nullable = false)
    private double weight;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShippingItem> shipping_items;

    public Product() {
    }

    public Product(Long id, String description, double weight, List<ShippingItem> shipping_items) {
        this.id = id;
        this.description = description;
        this.weight = weight;
        this.shipping_items = shipping_items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public List<ShippingItem> getShipping_items() {
        return shipping_items;
    }

    public void setShipping_items(List<ShippingItem> shipping_items) {
        this.shipping_items = shipping_items;
    }
}
