package backend.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class ProductDto {
	
	private Long id;

	private String code;

	private String name;
	
	private String description;

	private LocalDateTime creationDate;

}
