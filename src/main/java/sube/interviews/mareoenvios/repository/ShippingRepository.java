package sube.interviews.mareoenvios.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sube.interviews.mareoenvios.model.Shipping;

import java.util.Map;

@Repository
public interface ShippingRepository extends JpaRepository <Shipping, Long> {

}
