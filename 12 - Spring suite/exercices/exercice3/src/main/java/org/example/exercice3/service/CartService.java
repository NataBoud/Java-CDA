package org.example.exercice3.service;

import jakarta.servlet.http.HttpSession;
import org.example.exercice3.dto.CartResponseDto;
import org.example.exercice3.dto.ProductResponseDto;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CartService {

    private ProductService service;
    private HttpSession session;

    public CartService(ProductService service,HttpSession session) {
        this.service = service;
        this.session = session;
    }

    public void addProductToCart (long id,int quantity){
        Map<Long,Integer> cart = (Map<Long,Integer>) session.getAttribute("cart");
        if(cart == null){
            cart = new HashMap<>();
        }

        cart.put(service.get(id).getId(),quantity);

        session.setAttribute("cart",cart);
    }

    public void removeProductToCart (long id,int quantity){
        Map<Long,Integer> cart = (Map<Long,Integer>) session.getAttribute("cart");
        if(cart == null){
            return;
        }
        service.get(id);

        if(cart.containsKey(id)){
            if(quantity == 0){
                cart.remove(id);
            }else if(quantity < cart.get(id)){
                cart.put(id,quantity);
            }
        }

        session.setAttribute("cart",cart);
    }

    public CartResponseDto checkCart (){
        Map<Long,Integer> cart = (Map<Long,Integer>) session.getAttribute("cart");
        if(cart == null){
            return null;
        }
        double totalPrice = 0;
        Map<ProductResponseDto,Integer> cartResponse = new HashMap<>();
        for(Map.Entry<Long,Integer> entry : cart.entrySet()){
            ProductResponseDto product = service.get(entry.getKey());
            cartResponse.put(product,entry.getValue());
            totalPrice += product.getPrice() * entry.getValue();
        }

        return CartResponseDto.builder().cart(cartResponse).totalPrice(totalPrice).build();
    }
}
