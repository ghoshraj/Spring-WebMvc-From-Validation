package com.raj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.raj.entity.product;

public interface ProductRepo extends JpaRepository<product, Integer>{

}
