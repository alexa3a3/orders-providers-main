package backend.test.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class OrderDto {

	private Long id;

	private Long clientId;
	
	private String code;

	private LocalDateTime creationDate;

	private LocalDateTime deliveryDate;
	
	private LocalDateTime beginCreationDate;
	
	private LocalDateTime endCreationDate;
	
	private List<OrderDetailDto> listOrderDetail; 

}
