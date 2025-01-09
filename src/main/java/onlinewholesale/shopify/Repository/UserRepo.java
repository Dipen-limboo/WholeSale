package onlinewholesale.shopify.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import onlinewholesale.shopify.Entity.User;

public interface UserRepo extends JpaRepository<User, Long> {

	@Query("SELECT u from User u Where u.email =:email")
	Optional<User> findByEmail(@Param("email") String email);

}
