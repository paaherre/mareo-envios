package sube.interviews.mareoenvios.DTO;

import sube.interviews.mareoenvios.model.Customer;
import sube.interviews.mareoenvios.model.Shipping;
import sube.interviews.mareoenvios.model.ShippingState;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ShippingDTO {
    private Long id;
    private ShippingState shippingState;
    private Date send_date;
    private Date arrive_date;
    private int priority;

    public ShippingDTO(Shipping shipping) {
        this.id = shipping.getId();
        this.shippingState = shipping.getShippingState();
        this.send_date = shipping.getSend_date();
        this.arrive_date = shipping.getArrive_date();
        this.priority = shipping.getPriority();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ShippingState getShippingState() {
        return shippingState;
    }

    public void setShippingState(ShippingState shippingState) {
        this.shippingState = shippingState;
    }

    public Date getSend_date() {
        return send_date;
    }

    public void setSend_date(Date send_date) {
        this.send_date = send_date;
    }

    public Date getArrive_date() {
        return arrive_date;
    }

    public void setArrive_date(Date arrive_date) {
        this.arrive_date = arrive_date;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
