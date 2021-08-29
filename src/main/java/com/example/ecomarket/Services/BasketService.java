package com.example.ecomarket.Services;

import com.example.ecomarket.DOM.BasketProductRequest;
import com.example.ecomarket.DOM.BasketProductResponse;
import com.example.ecomarket.Facade.DTO.BasketDTO;
import com.example.ecomarket.Models.Basket;
import com.example.ecomarket.Models.BasketProducts;
import com.example.ecomarket.Models.Product;
import com.example.ecomarket.Repositories.IBasketProductRepository;
import com.example.ecomarket.Repositories.IBasketRepository;
import com.example.ecomarket.Repositories.ICategoryRepository;
import com.example.ecomarket.Repositories.IProductRepository;
import org.springframework.stereotype.Service;

@Service
public class BasketService extends GeneralService implements IBasketService{
    private final IBasketRepository iBasketRepository;
    private final IBasketProductRepository iBasketProductRepository;
    private final IProductRepository iProductRepository;

    public BasketService(IBasketRepository iBasketRepository,IBasketProductRepository iBasketProductRepository,
                         IProductRepository iProductRepository)
    {
        this.iBasketRepository = iBasketRepository;
        this.iBasketProductRepository = iBasketProductRepository;
        this.iProductRepository = iProductRepository;
    }

    @Override
    public BasketProductResponse addPeoductToBasket(BasketProductRequest basketProductRequest){
        Basket basket = iBasketRepository.getById(basketProductRequest.getBasketId());
        Product product = iProductRepository.getById(basketProductRequest.getProductId());
        BasketProducts basketProducts = new BasketProducts();
        basketProducts.setBasket(basket);
        basketProducts.setProduct(product);
        basketProducts = iBasketProductRepository.save(basketProducts);
        BasketProductResponse response = new BasketProductResponse();
        response.setId(basketProducts.getId());
        response.setProductId(basketProducts.getProduct().getId());
        response.setBasketId(basketProducts.getBasket().getId());
        return response;
    }

}
