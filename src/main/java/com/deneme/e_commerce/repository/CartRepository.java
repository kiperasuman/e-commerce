package com.deneme.e_commerce.repository;
import com.deneme.e_commerce.model.Cart;
import com.deneme.e_commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser(User user);
}
