package com.example.ecomarket.Controllers;

import com.example.ecomarket.DOM.BasketProductRequest;
import com.example.ecomarket.DOM.BasketProductResponse;
import com.example.ecomarket.Facade.BasketFacade;
import com.example.ecomarket.Facade.CustomerFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Component
@RestController
@CrossOrigin(origins = "*" )
public class BasketController {
    private final BasketFacade basketFacade;

    @Autowired
    public BasketController(BasketFacade basketFacade) {
        this.basketFacade = basketFacade;
    }

    @PostMapping("/basket/product")
    public ResponseEntity<BasketProductResponse> create(@RequestBody BasketProductRequest requestModel) {
        BasketProductResponse saved = basketFacade.addToBasket(requestModel);
        return ResponseEntity.ok(saved);
    }
}
