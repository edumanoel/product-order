package br.com.mbds.productorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbds.productorder.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
