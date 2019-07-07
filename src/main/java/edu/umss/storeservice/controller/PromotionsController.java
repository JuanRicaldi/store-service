/**
 * @author: Johnny penia trujillo
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.PromotionsDto;
import edu.umss.storeservice.model.Client;
import edu.umss.storeservice.model.Promotions;
import edu.umss.storeservice.service.PromotionsService;
import edu.umss.storeservice.service.GenericService;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RestController
@RequestMapping("/promotion")
public class PromotionsController {
    private PromotionsService service;

    public PromotionsController(PromotionsService service) {
        this.service = service;
    }

    @GetMapping
    protected List<Promotions>ListOfPromotions(){
        return this.service.findAll();
    }

    /*@PostMapping
    protected void addPromotion(@RequestBody Promotions promotions){
        service.save(promotions);
    }*/
}