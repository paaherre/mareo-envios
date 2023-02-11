package sube.interviews.mareoenvios.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sube.interviews.mareoenvios.DTO.TopSentDTO;
import sube.interviews.mareoenvios.model.ShippingItem;
import sube.interviews.mareoenvios.repository.ProductRepository;
import sube.interviews.mareoenvios.repository.ShippingItemRepository;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SentService {

    @Autowired
    ShippingItemRepository shippingItemRepository;

    @Autowired
    ProductRepository productRepository;

    public List<TopSentDTO> topSent(){
        List<ShippingItem> shippingItems = shippingItemRepository.findAll().stream().sorted(Comparator.comparing(ShippingItem::getProduct_count).reversed()).collect(Collectors.toList());
        List<TopSentDTO> topSentDTOS = shippingItems.stream().map( shippingItem -> new TopSentDTO(shippingItem.getProduct_count(), shippingItem.getProduct().getDescription())).collect(Collectors.toList());
        return topSentDTOS.size() > 2 ? topSentDTOS.subList(0, 3) : topSentDTOS;
    }
}
