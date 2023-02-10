package sube.interviews.mareoenvios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sube.interviews.mareoenvios.model.ShippingItem;

@Repository
public interface ShippingItemRepository extends JpaRepository<ShippingItem, Long> {
}
