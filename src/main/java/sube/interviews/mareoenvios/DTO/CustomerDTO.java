package sube.interviews.mareoenvios.DTO;

import sube.interviews.mareoenvios.model.Customer;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class CustomerDTO implements Serializable {
    private final Long id;
    private final String first_name;
    private final String last_name;
    private final String address;
    private final String city;
    private final List<ShippingDTO> shippings;

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

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public List<ShippingDTO> getShippings() {
        return shippings;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerDTO entity = (CustomerDTO) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.first_name, entity.first_name) &&
                Objects.equals(this.last_name, entity.last_name) &&
                Objects.equals(this.address, entity.address) &&
                Objects.equals(this.city, entity.city) &&
                Objects.equals(this.shippings, entity.shippings);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, first_name, last_name, address, city, shippings);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "first_name = " + first_name + ", " +
                "last_name = " + last_name + ", " +
                "address = " + address + ", " +
                "city = " + city + ", " +
                "shippings = " + shippings + ")";
    }
}
