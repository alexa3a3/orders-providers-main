package backend.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.test.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {

}
