package sube.interviews.mareoenvios.DTO;

import sube.interviews.mareoenvios.model.Customer;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerDTO {
    private Long id;
    private String first_name;
    private String last_name;
    private String address;
    private String city;
    private List<ShippingDTO> shippings;

    public CustomerDTO(Customer customer) {
        this.id = customer.getId();
        this.first_name = customer.getFirst_name();
        this.last_name = customer.getLast_name();
        this.address = customer.getAddress();
        this.city = customer.getCity();
        this.shippings = customer.getShippings().stream().map(ShippingDTO::new).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<ShippingDTO> getShippings() {
        return shippings;
    }

    public void setShippings(List<ShippingDTO> shippings) {
        this.shippings = shippings;
    }
}
