package sube.interviews.mareoenvios.controller;
import sube.interviews.mareoenvios.DTO.ShippingDTO;
import sube.interviews.mareoenvios.DTO.ShippingTransitionDTO;
import sube.interviews.mareoenvios.exception.InvalidShippingStateException;
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
    public ResponseEntity<ShippingDTO> getShippingById(@PathVariable(value = "id") Long shippingId){
        ShippingDTO shippingDTO = shippingRepository.findById(shippingId).map(ShippingDTO::new).orElse(null);
        if( shippingDTO == null){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(shippingDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ShippingDTO> updateShipping(@PathVariable(value = "id") Long shippingId,
                                                   @RequestBody ShippingTransitionDTO shippingTransition) throws InvalidPropertiesFormatException, InvalidShippingStateException {
        Shipping shippingDTO = shippingRepository.findById(shippingId).orElse(null);
        if( shippingDTO == null) {
            return ResponseEntity.notFound().build();
        }
        shippingService.shippingTransition(shippingDTO, shippingTransition);
        return ResponseEntity.ok().build();

    }
}
