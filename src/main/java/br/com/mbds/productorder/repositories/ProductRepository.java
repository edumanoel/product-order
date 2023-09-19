package br.com.mbds.productorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbds.productorder.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
