package backend.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private Long id;
	
	@Getter
	@Setter
	@Column(length = 20)
	private String code;

	@Getter
	@Setter
	@Column(length = 150)
	private String name;
	
	@Getter
	@Setter
	@Column(length = 200)
	private String description;

	@Getter
	@Setter
	private LocalDateTime creationDate;
	
	public Long getId() {
		return id;
	}

}