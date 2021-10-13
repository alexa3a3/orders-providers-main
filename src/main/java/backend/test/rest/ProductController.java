package backend.test.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import backend.test.dto.ProductDto;
import backend.test.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	private final ProductService pService;


	public ProductController(ProductService productService) {
		this.pService = productService;
	}
	
	@PostMapping(value = "/product")
	@ResponseStatus(HttpStatus.OK)
	public Long updateProduct(@RequestBody ProductDto product) {
		return pService.updateProductById(product);
	}
	
}
