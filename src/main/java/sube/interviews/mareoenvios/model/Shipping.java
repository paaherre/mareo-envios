package sube.interviews.mareoenvios.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shipping")
public class Shipping {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name="state", nullable = false)
    @Enumerated(EnumType.STRING)
    private ShippingState shippingState;

    @Column(name = "send_date", nullable = false)
    private Date send_date;

    @Column(name = "arrive_date")
    private Date arrive_date;

    @Column(name = "priority")
    private int priority;

    @OneToMany(mappedBy = "shipping", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShippingItem> shipping_items;

    public Shipping() {
    }

    public Shipping(Customer customer, ShippingState shippingState, Date send_date, Date arrive_date, int priority) {
        this.customer = customer;
        this.shippingState = shippingState;
        this.send_date = send_date;
        this.arrive_date = arrive_date;
        this.priority = priority;
    }

    public List<ShippingItem> getShipping_items() {
        return shipping_items;
    }

    public void setShipping_items(List<ShippingItem> shipping_items) {
        this.shipping_items = shipping_items;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
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

