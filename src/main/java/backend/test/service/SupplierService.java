package backend.test.service;

import org.springframework.stereotype.Service;

import backend.test.dto.ProductSupplierDto;
import backend.test.dto.SupplierDto;
import backend.test.model.ProductSupplier;
import backend.test.model.Supplier;
import backend.test.repository.ProductSupplierRepository;
import backend.test.repository.SupplierRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class SupplierService {

	private final SupplierRepository supplierRepository;
	private final ProductSupplierRepository productSupplierRepository;

	public SupplierService(SupplierRepository supplierRepository, ProductSupplierRepository productSupplierRepository) {
		this.supplierRepository = supplierRepository;
		this.productSupplierRepository = productSupplierRepository;
	}


	/**
	 * Returns a list of all suppliers with their products
	 *
	 * @return list of suppliers
	 */
	public List<ProductSupplierDto> getSuppliersWithProducts() {
		List<ProductSupplierDto> listProductSupplier = new ArrayList<ProductSupplierDto>();
		List<ProductSupplier> listComplete = productSupplierRepository.findAll();

		for (ProductSupplier prodSupp : listComplete) {
			ProductSupplierDto td = new ProductSupplierDto(prodSupp.getCreationDate(), prodSupp.getSupplierId(), prodSupp.getProductId());
			listProductSupplier.add(td);
		}

		return listProductSupplier;
	}

	/**
	 * Creates a new supplier
	 *
	 * @param supplierDto data of new supplier
	 * @return id of the created supplier
	 */
	public Long addSupplier(SupplierDto supplierDto) {
		LocalDateTime now = LocalDateTime.now();
		Supplier supplier = new Supplier();
		supplier.setIdentificatorNumber(supplierDto.getIdentificatorNumber());
		supplier.setName(supplierDto.getName());
		supplier.setCreationDate(now);
		return supplierRepository.save(supplier).getId();
	}
	
	/**
	 * Add products to supplier
	 *
	 * @param productSupplierDto data of new supplier
	 * @return id of the created productSupplier
	 */
	public List<ProductSupplierDto> addProductsSupplier(List<ProductSupplierDto> listProductSupplierDto) {
		List<ProductSupplier> listProductSupplier = new ArrayList<ProductSupplier>();
		List<ProductSupplierDto> listProductSupplierSaved = new ArrayList<ProductSupplierDto>();
		for (ProductSupplierDto prodSupp : listProductSupplierDto) {
			LocalDateTime now = LocalDateTime.now();
			ProductSupplier td = new ProductSupplier();
			td.setProductId(prodSupp.getProductId());
			td.setSupplierId(prodSupp.getSupplierId());
			td.setCreationDate(now);
			listProductSupplier.add(td);
		}
		List<ProductSupplier> listResponse = (List<ProductSupplier>) productSupplierRepository.saveAll(listProductSupplier);
		
		for (ProductSupplier prodSupp : listResponse) {
			ProductSupplierDto td = new ProductSupplierDto(prodSupp.getCreationDate(), prodSupp.getSupplierId(), prodSupp.getProductId());
			listProductSupplierSaved.add(td);
		}
		return listProductSupplierSaved;
	}

}
