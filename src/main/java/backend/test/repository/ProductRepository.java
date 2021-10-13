package backend.test.repository;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import backend.test.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Modifying
	@Transactional
	@Query("update Product p set p.code = ?1, p.name = ?2, p.description = ?3, p.creationDate = ?4 where p.id = ?5")
	void updateProductById(String code, String name, String description, LocalDateTime creationDate, Long id);
	
}
