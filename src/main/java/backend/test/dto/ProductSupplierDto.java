package backend.test.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class ProductSupplierDto {

	private LocalDateTime creationDate;
	
	private Long supplierId;

	private Long productId;

}
