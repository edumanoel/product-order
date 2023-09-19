package br.com.mbds.productorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbds.productorder.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
