package org.example.exercice3.service;

import org.example.exercice3.dto.ProductReceiveDto;
import org.example.exercice3.dto.ProductResponseDto;
import org.example.exercice3.entity.Product;
import org.example.exercice3.exception.NotFoundException;
import org.example.exercice3.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductResponseDto create (ProductReceiveDto productReceiveDto){
        return repository.save(productReceiveDto.dtoToEntity()).entityToDto();
    }

    public ProductResponseDto get (long id){
        return repository.findById(id).orElseThrow(NotFoundException::new).entityToDto();
    }

    public List<ProductResponseDto> get (){
        return repository.findAll().stream().map(Product::entityToDto).toList();
    }


}
