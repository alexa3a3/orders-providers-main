package backend.test.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import backend.test.dto.OrderDto;
import backend.test.model.OrderDetail;
import backend.test.service.OrderService;

import java.util.List;


@RestController
@RequestMapping("/orders")
public class OrderController {

	private final OrderService oService;


	public OrderController(OrderService orderService) {
		this.oService = orderService;
	}
	
	@PostMapping(value = "/order")
	@ResponseStatus(HttpStatus.CREATED)
	public List<OrderDetail> addOrder(@RequestBody OrderDto order) {
		return oService.addOrder(order);
	}
	
	@GetMapping(value = "/listOrders")
	@ResponseStatus(HttpStatus.OK)
	public List<OrderDto> getOrdersForClientIdAndCreationDates (@RequestBody OrderDto order) {
		return oService.getOrdersForClientIdAndCreationDates(order);
	}
	
	@PostMapping(value = "{id}/deleteOrder")
	@ResponseStatus(HttpStatus.OK)
	public String deleteOrder(@PathVariable Long id) {
		return oService.deleteOrder(id);
	}
	
}
