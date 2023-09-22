package br.com.mbds.productorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbds.productorder.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
