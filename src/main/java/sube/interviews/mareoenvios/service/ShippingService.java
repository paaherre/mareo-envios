package sube.interviews.mareoenvios.service;

import sube.interviews.mareoenvios.DTO.ShippingTransitionDTO;
import sube.interviews.mareoenvios.model.Shipping;
import sube.interviews.mareoenvios.model.ShippingState;
import org.springframework.stereotype.Service;

import java.util.InvalidPropertiesFormatException;

@Service
public class ShippingService {

    public void shippingTransition(Shipping shipping, ShippingTransitionDTO shippingTransition) throws InvalidPropertiesFormatException {
        ShippingState state = ShippingState.fromString(shippingTransition.getTransition());
        if(shipping.getShippingState().canTranstionTo(state)) {
            shipping.setShippingState(state);
        } else {
            throw new InvalidPropertiesFormatException("No es posible realizar transición de estado a "+ shippingTransition.getTransition());
        }

    }
}