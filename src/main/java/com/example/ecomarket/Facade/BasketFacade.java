package com.example.ecomarket.Facade;
import com.example.ecomarket.DOM.BasketProductRequest;
import com.example.ecomarket.DOM.BasketProductResponse;
import com.example.ecomarket.Services.IBasketService;
import com.example.ecomarket.anotations.Facade;
import org.springframework.beans.factory.annotation.Autowired;

@Facade
public class BasketFacade {

    private final IBasketService iBasketService;

    @Autowired
    public BasketFacade( IBasketService iBasketService) {
        this.iBasketService = iBasketService;
    }

    public BasketProductResponse addToBasket(BasketProductRequest basketProductRequest){
        return iBasketService.addPeoductToBasket(basketProductRequest);
    }
}
