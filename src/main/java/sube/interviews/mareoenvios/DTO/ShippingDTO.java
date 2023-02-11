package sube.interviews.mareoenvios.DTO;

import sube.interviews.mareoenvios.model.Shipping;
import sube.interviews.mareoenvios.model.ShippingItem;
import sube.interviews.mareoenvios.model.ShippingState;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShippingDTO implements Serializable {
    private final Long id;
    private final ShippingState shippingState;
    private final Date send_date;
    private final Date arrive_date;
    private final int priority;
    private final List<ShippingItemDTO> shipping_items;

    public ShippingDTO(Shipping shipping) {
        this.id = shipping.getId();
        this.shippingState = shipping.getShippingState();
        this.send_date = shipping.getSend_date();
        this.arrive_date = shipping.getArrive_date();
        this.priority = shipping.getPriority();
        this.shipping_items = shipping.getShipping_items().stream().map(ShippingItemDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public ShippingState getShippingState() {
        return shippingState;
    }

    public Date getSend_date() {
        return send_date;
    }

    public Date getArrive_date() {
        return arrive_date;
    }

    public int getPriority() {
        return priority;
    }

    public List<ShippingItemDTO> getShipping_items() {
        return shipping_items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ShippingDTO entity = (ShippingDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.shippingState, entity.shippingState) &&
                Objects.equals(this.send_date, entity.send_date) &&
                Objects.equals(this.arrive_date, entity.arrive_date) &&
                Objects.equals(this.priority, entity.priority) &&
                Objects.equals(this.shipping_items, entity.shipping_items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(shippingState, send_date, arrive_date, priority, shipping_items);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "shippingState = " + shippingState + ", " +
                "send_date = " + send_date + ", " +
                "arrive_date = " + arrive_date + ", " +
                "priority = " + priority + ", " +
                "shipping_items = " + shipping_items + ")";
    }
}
