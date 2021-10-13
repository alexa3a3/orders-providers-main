package backend.test.service;

import org.springframework.stereotype.Service;

import backend.test.dto.ProductDto;
import backend.test.repository.ProductRepository;

import java.time.LocalDateTime;

@Service
public class ProductService {

	private final ProductRepository productRepository;

	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}

	/**
	 * Update a product
	 *
	 * @param productDto data of update product
	 * @return id of the updated product
	 */
	public Long updateProductById(ProductDto productDto) {
		LocalDateTime now = LocalDateTime.now();
		productDto.setCreationDate(now);
		productRepository.updateProductById(productDto.getCode(), productDto.getName(), productDto.getDescription(), productDto.getCreationDate(), productDto.getId());
		return productDto.getId();
	}
	
}
