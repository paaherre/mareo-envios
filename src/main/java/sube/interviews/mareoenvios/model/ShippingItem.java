package sube.interviews.mareoenvios.model;

import javax.persistence.*;

@Entity
@Table(name="shipping_item")
public class ShippingItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="shipping_id")
    private Shipping shipping;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_count", nullable = false)
    private int product_count;

    public ShippingItem() {
    }

    public ShippingItem(Long id, Shipping shipping, Product product, int product_count) {
        this.id = id;
        this.shipping = shipping;
        this.product = product;
        this.product_count = product_count;
    }

    public Long getId() {        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public void setShipping(Shipping shipping) {
        this.shipping = shipping;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getProduct_count() {
        return product_count;
    }

    public void setProduct_count(int product_count) {
        this.product_count = product_count;
    }
}
