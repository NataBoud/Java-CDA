package org.example.exercice3.controller;

import org.example.exercice3.dto.CartResponseDto;
import org.example.exercice3.service.CartService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    private CartService service;

    public CartController(CartService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<CartResponseDto> checkCart (){
        return ResponseEntity.ok(service.checkCart());
    }

    @GetMapping("/{id}/{quantity}")
    public ResponseEntity<String> addProductToCart (@PathVariable long id, @PathVariable int quantity){
        service.addProductToCart(id,quantity);
        return ResponseEntity.ok("Product add to cart");
    }

    @DeleteMapping("/{id}/{quantity}")
    public ResponseEntity<String> removeProductToCart (@PathVariable long id, @PathVariable int quantity){
        service.removeProductToCart(id,quantity);
        return ResponseEntity.ok("Produc remove from cart");
    }
}
