package backend.test.service;

import org.springframework.stereotype.Service;

import backend.test.dto.OrderDetailDto;
import backend.test.dto.OrderDto;
import backend.test.model.OrderDetail;
import backend.test.model.OrderHeader;
import backend.test.repository.OrderDetailRepository;
import backend.test.repository.OrderRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class OrderService {

	private final OrderRepository orderRepository;
	private final OrderDetailRepository orderDetailRepository;

	public OrderService(OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
		this.orderRepository = orderRepository;
		this.orderDetailRepository = orderDetailRepository;
	}

	/**
	 * Creates a new order
	 *
	 * @param orderDto data of new order
	 * @return list of details order created
	 */
	public List<OrderDetail> addOrder(OrderDto orderDto) {
		LocalDateTime now = LocalDateTime.now();
		OrderHeader ordHea = new OrderHeader();
		ordHea.setClientId(orderDto.getClientId());
		ordHea.setCode(orderDto.getCode());
		ordHea.setDeliveryDate(orderDto.getDeliveryDate());
		ordHea.setCreationDate(now);
		Long idOrderHeader = orderRepository.save(ordHea).getId();
		
		List<OrderDetail> listOrderDetail = new ArrayList<OrderDetail>();
		for (OrderDetailDto ordDetDto : orderDto.getListOrderDetail()) {
			OrderDetail ordDet = new OrderDetail();
			ordDet.setOrderHeaderId(idOrderHeader);
			ordDet.setProductSupplierId(ordDetDto.getProductSupplierId());
			listOrderDetail.add(ordDet);
		}
		
		List<OrderDetail> listResponse = (List<OrderDetail>) orderDetailRepository.saveAll(listOrderDetail);
		return listResponse;
	}
	
	/**
	 * Returns a list of orders passing clientId and a range of creationDates.
	 *
	 * @param orderDto data of order
	 * @return list of orders
	 */
	public List<OrderDto> getOrdersForClientIdAndCreationDates(OrderDto orderDto) {
		List<OrderDto> listOrder = new ArrayList<OrderDto>();
		List<OrderHeader> list = orderRepository.findByClientIdAndCreationDates(orderDto.getClientId(), orderDto.getBeginCreationDate(), orderDto.getEndCreationDate());

		for (OrderHeader oH : list) {
			OrderDto od = new OrderDto();
			od.setId(oH.getId());
			od.setCode(oH.getCode());
			od.setClientId(oH.getClientId());
			od.setCreationDate(oH.getCreationDate());
			od.setDeliveryDate(oH.getDeliveryDate());
			listOrder.add(od);
		}

		return listOrder;
	}
	
	/**
	 * Delets a order passing orderId
	 *
	 * @param orderDto data of  order
	 * @return list of details order created
	 */
	public String deleteOrder(Long idOrder) {
		orderRepository.deleteById(idOrder);
		return "Order con id " +idOrder+ " eliminada";
	}
}
