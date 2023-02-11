package sube.interviews.mareoenvios.DTO;

import sube.interviews.mareoenvios.model.Product;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ProductDTO implements Serializable {
    private final Long id;
    private final String description;
    private final double weight;
    private final List<ShippingItemDTO> shipping_items;

    public ProductDTO(Product product) {
        this.id = product.getId();
        this.description = product.getDescription();
        this.weight = product.getWeight();
        this.shipping_items = product.getShipping_items().stream().map(ShippingItemDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public double getWeight() {
        return weight;
    }

    public List<ShippingItemDTO> getShipping_items() {
        return shipping_items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductDTO entity = (ProductDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.weight, entity.weight) &&
                Objects.equals(this.shipping_items, entity.shipping_items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, weight, shipping_items);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "description = " + description + ", " +
                "weight = " + weight + ", " +
                "shipping_items = " + shipping_items + ")";
    }
}
