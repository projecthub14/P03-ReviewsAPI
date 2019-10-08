package com.udacity.course3.reviews.repository;

import com.udacity.course3.reviews.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {
     List<Product> findAll();
     Optional<Product> findById(int id);
}
