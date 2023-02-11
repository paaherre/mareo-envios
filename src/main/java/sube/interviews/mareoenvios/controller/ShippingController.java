package sube.interviews.mareoenvios.controller;
import sube.interviews.mareoenvios.DTO.ShippingTransitionDTO;
import sube.interviews.mareoenvios.repository.ShippingRepository;
import sube.interviews.mareoenvios.model.Shipping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sube.interviews.mareoenvios.service.ShippingService;
import java.util.InvalidPropertiesFormatException;

@RestController
@RequestMapping("/shippings")
public class ShippingController {

    @Autowired
    private ShippingRepository shippingRepository;

    @Autowired
    private ShippingService shippingService;

    @GetMapping("/{id}")
    public ResponseEntity<Shipping> getShippingById(@PathVariable(value = "id") Long shippingId){
        Shipping shipping = shippingRepository.findById(shippingId).orElse(null);
        if( shipping == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(shipping);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Shipping> updateShipping(@PathVariable(value = "id") Long shippingId,
                                                   @RequestBody ShippingTransitionDTO shippingTransition) throws InvalidPropertiesFormatException {
        Shipping shipping = shippingRepository.findById(shippingId).orElse(null);
        if( shipping == null) {
            return ResponseEntity.notFound().build();
        }
        shippingService.shippingTransition(shipping, shippingTransition);
        return ResponseEntity.ok().build();

    }
}
