package backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity
public class OrderDetail {

	@Id
	@GeneratedValue
	private Long id;
		
	@Getter
    @Setter
    @Column
    private Long orderHeaderId;
	
	@Getter
    @Setter
    @Column
    private Long productSupplierId;
	
	public Long getId() {
		return id;
	}

}