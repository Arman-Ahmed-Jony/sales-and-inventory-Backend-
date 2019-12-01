package com.getanoutfit.salesAndInventory.User;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
Optional<User> findByUserNameAndPass(String userName, String pass);
}
