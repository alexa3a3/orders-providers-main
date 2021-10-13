package backend.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.test.model.ProductSupplier;

public interface ProductSupplierRepository extends JpaRepository<ProductSupplier, Long> {
	
}
