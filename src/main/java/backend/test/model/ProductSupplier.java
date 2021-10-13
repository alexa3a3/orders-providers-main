package backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class ProductSupplier {

	@Id
	@GeneratedValue
	private Long id;
	
	@Getter
	@Setter
	private LocalDateTime creationDate;
	
	@Getter
    @Setter
    @Column
    private Long supplierId;
	
	@Getter
    @Setter
    @Column
    private Long productId;
	
	public Long getId() {
		return id;
	}

}