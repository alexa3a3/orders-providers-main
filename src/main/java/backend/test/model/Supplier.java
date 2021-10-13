package backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Supplier {

	@Id
	@GeneratedValue
	private Long id;
	
	@Getter
	@Setter
	@Column(length = 13)
	private String identificatorNumber;

	@Getter
	@Setter
	@Column(length = 200)
	private String name;

	@Getter
	@Setter
	private LocalDateTime creationDate;
	
	public Long getId() {
		return id;
	}

}