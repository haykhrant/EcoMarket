package com.example.ecomarket.Services;

import com.example.ecomarket.DOM.BasketProductRequest;
import com.example.ecomarket.DOM.BasketProductResponse;

public interface IBasketService {

    BasketProductResponse addPeoductToBasket(BasketProductRequest basketProductRequest);
}
