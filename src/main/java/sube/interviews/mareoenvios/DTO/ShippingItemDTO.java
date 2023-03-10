package sube.interviews.mareoenvios.DTO;

import sube.interviews.mareoenvios.model.ShippingItem;

import java.io.Serializable;
import java.util.Objects;

public class ShippingItemDTO implements Serializable {
    private final Long id;
    private final String description;
    private final int product_count;

    public ShippingItemDTO(ShippingItem shippingItem) {
        this.id = shippingItem.getId();
        this.description = shippingItem.getProduct().getDescription();
        this.product_count = shippingItem.getProduct_count();
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
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
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.product_count, entity.product_count);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description= " + description + ", " +
                "product_count = " + product_count + ")";
    }
}
