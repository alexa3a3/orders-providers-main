package backend.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import backend.test.model.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {
	
}