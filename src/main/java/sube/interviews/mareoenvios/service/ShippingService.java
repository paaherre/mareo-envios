package sube.interviews.mareoenvios.service;

import org.springframework.beans.factory.annotation.Autowired;
import sube.interviews.mareoenvios.DTO.ShippingTransitionDTO;
import sube.interviews.mareoenvios.exception.InvalidShippingStateException;
import sube.interviews.mareoenvios.managers.ShippingManager;
import sube.interviews.mareoenvios.model.Shipping;
import sube.interviews.mareoenvios.model.ShippingState;
import org.springframework.stereotype.Service;
import sube.interviews.mareoenvios.repository.ShippingRepository;

import java.util.HashMap;
import java.util.Map;

@Service
public class ShippingService {

    @Autowired
    ShippingRepository shippingRepository;

    @Autowired
    ShippingManager shippingManager;

    public void shippingTransition(Shipping shipping, ShippingTransitionDTO shippingTransition) throws  InvalidShippingStateException {
        ShippingState state = ShippingState.fromString(shippingTransition.getTransition());
        if(shipping.getShippingState().canTranstionTo(state)) {
            this.updateShippingState(shipping.getId(), state);

        } else {
            throw new InvalidShippingStateException("El envío actualmente está en "+ shipping.getShippingState()+", no puede cambiar a " + shippingTransition.getTransition());
        }
    }

    public void updateShippingState(Long id, ShippingState shippingState) {
        String sql = "UPDATE shipping SET state = :state WHERE id = :id";

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("id", id);
        parameters.put("state", shippingState.name());

        shippingManager.updateShippingState(sql, parameters);
    }


}
