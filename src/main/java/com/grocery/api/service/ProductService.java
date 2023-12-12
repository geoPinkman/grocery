package com.grocery.api.service;

import com.grocery.api.domain.Product;
import com.grocery.api.dto.ProductDto;
import com.grocery.api.repository.ProductRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ProductService {

    private ProductRepository repository;

    public List<Product> getAll(){
        return repository.findAll();
    }

    public void save(ProductDto product) {
        repository.save(product);
    }

//    public void delete(long id) {
//        repository.delete(id);
//    }

    public Product getByName(String name) {
        return repository.getByName(name);

    }
}
