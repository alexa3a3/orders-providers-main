package backend.test.rest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import backend.test.dto.ProductSupplierDto;
import backend.test.dto.SupplierDto;
import backend.test.service.SupplierService;

import java.util.List;


@RestController
@RequestMapping("/suppliers")
public class SupplierController {

	private final SupplierService sService;


	public SupplierController(SupplierService supplierService) {
		this.sService = supplierService;
	}
	
	@PostMapping(value = "/supplier")
	@ResponseStatus(HttpStatus.CREATED)
	public Long addSupplier(@RequestBody SupplierDto supplier) {
		return sService.addSupplier(supplier);
	}
	
	@PostMapping(value = "/productsSupplier")
	@ResponseStatus(HttpStatus.CREATED)
	public List<ProductSupplierDto> addProductsSupplier(@RequestBody List<ProductSupplierDto> productsSupplier) {
		return sService.addProductsSupplier(productsSupplier);
	}
	
	@GetMapping(value = "/productsSupplier")
	@ResponseStatus(HttpStatus.OK)
	public List<ProductSupplierDto> getSuppliersWithProducts () {
		return sService.getSuppliersWithProducts();
	}

}
