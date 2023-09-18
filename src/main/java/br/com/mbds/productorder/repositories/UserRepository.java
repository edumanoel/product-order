package br.com.mbds.productorder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.mbds.productorder.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
