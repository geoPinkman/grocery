package com.grocery.api.repository;

import com.grocery.api.domain.Product;
import com.grocery.api.dto.ProductDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, Long> {

    void save(ProductDto product);

    Product getByName(String name);

    List<Product> findAll();

    //void delete(long id);
}
