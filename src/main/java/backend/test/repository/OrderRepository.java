package backend.test.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import backend.test.model.OrderHeader;

public interface OrderRepository extends CrudRepository<OrderHeader, Long> {
	
	@Query("select o from OrderHeader o where o.clientId = ?1 and o.creationDate between ?2 and ?3")
	List<OrderHeader> findByClientIdAndCreationDates (Long accountId, LocalDateTime beginCreationDate, LocalDateTime endCreationDate);
	
}