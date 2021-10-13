package backend.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class SupplierDto {

	private String identificatorNumber;

	private String name;

	private LocalDateTime creationDate;

}
