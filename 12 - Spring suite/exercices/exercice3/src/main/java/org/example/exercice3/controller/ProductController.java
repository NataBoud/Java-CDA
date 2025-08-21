package org.example.exercice3.controller;

import org.example.exercice3.dto.ProductReceiveDto;
import org.example.exercice3.dto.ProductResponseDto;
import org.example.exercice3.entity.Product;
import org.example.exercice3.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping()
    public ResponseEntity<List<ProductResponseDto>> getall (){
        return ResponseEntity.ok(service.get());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponseDto> get (@PathVariable long id){
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<ProductResponseDto> create (@RequestBody ProductReceiveDto productReceiveDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(productReceiveDto));
    }
}
