package sube.interviews.mareoenvios.DTO;

import sube.interviews.mareoenvios.model.Product;
import sube.interviews.mareoenvios.model.Shipping;
import sube.interviews.mareoenvios.model.ShippingItem;

import java.io.Serializable;
import java.util.Objects;

public class ShippingItemDTO implements Serializable {
    private final Long id;
    private final Shipping shipping;
    private final Product product;
    private final int product_count;

    public ShippingItemDTO(ShippingItem shippingItem) {
        this.id = shippingItem.getId();
        this.shipping = shippingItem.getShipping();
        this.product = shippingItem.getProduct();
        this.product_count = shippingItem.getProduct_count();
    }

    public Long getId() {
        return id;
    }

    public Shipping getShipping() {
        return shipping;
    }

    public Product getProduct() {
        return product;
    }

    public int getProduct_count() {
        return product_count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingItemDTO entity = (ShippingItemDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.shipping, entity.shipping) &&
                Objects.equals(this.product, entity.product) &&
                Objects.equals(this.product_count, entity.product_count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, shipping, product, product_count);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "shipping = " + shipping + ", " +
                "product = " + product + ", " +
                "product_count = " + product_count + ")";
    }
}
