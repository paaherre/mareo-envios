package sube.interviews.mareoenvios.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sube.interviews.mareoenvios.DTO.TopSentDTO;
import sube.interviews.mareoenvios.service.SentService;

import java.util.List;

@RestController
@RequestMapping("/reports")
public class ReportsController {

    @Autowired
    SentService sentService;

    @GetMapping("/top-sent")
    public ResponseEntity<List<TopSentDTO>> getTopSent(){
        List<TopSentDTO> topSentDTO = sentService.topSent();
        if(topSentDTO.size() > 0){
            return ResponseEntity.ok().body(topSentDTO);
        }else {
            return ResponseEntity.notFound().build();
        }
    }

}
