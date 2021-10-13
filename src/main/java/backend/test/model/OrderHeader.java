package backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class OrderHeader {

	@Id
	@GeneratedValue
	private Long id;
	
	@Getter
	@Setter
	@Column(length = 30)
	private String code;
	
	@Getter
	@Setter
	@Column
	private LocalDateTime creationDate;
	
	@Getter
	@Setter
	@Column
	private LocalDateTime deliveryDate;
	
	@Getter
    @Setter
    @Column
    private Long clientId;
	
	public Long getId() {
		return id;
	}

}