package com.deneme.e_commerce.repository;

import com.deneme.e_commerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    @Query("select p from Product p where p.category.id =:id ")
    List<Product> findByCategoryId(@Param("id") Long categoryId);
}
