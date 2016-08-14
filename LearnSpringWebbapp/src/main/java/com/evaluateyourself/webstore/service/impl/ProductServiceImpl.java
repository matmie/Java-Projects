/**
 * 
 */
package com.evaluateyourself.webstore.service.impl;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evaluateyourself.webstore.domain.Product;
import com.evaluateyourself.webstore.domain.repository.ProductRepository;
import com.evaluateyourself.webstore.service.ProductService;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Service
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	private ProductRepository productRepository;
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.ProductService#getAllProducts()
	 */
	public List<Product> getAllProducts() {
		return productRepository.getAllProducts();
	}
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.ProductService#getProductsByCategory(java.lang.String)
	 */
	public List<Product> getProductsByCategory(String category) {
		return productRepository.getProductsByCategory(category);
	}
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.ProductService#getProductsByFilter(java.util.Map)
	 */
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByFilter(filterParams);
	}
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.ProductService#getProductById(java.lang.String)
	 */
	public Product getProductById(String productId) {
		return productRepository.getProductById(productId);
	}
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.ProductService#getProductsByManufacturer(java.lang.String)
	 */
	public List<Product> getProductsByManufacturer(String manufacturer) {
		return productRepository.getProductsByManufacturer(manufacturer);
	}
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.ProductService#getProductsByPriceFilter(java.util.Map)
	 */
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		return productRepository.getProductsByPriceFilter(filterParams);
	}
	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.service.ProductService#addProduct(com.evaluateyourself.webstore.domain.Product)
	 */
	public void addProduct(Product product) {
		productRepository.addProduct(product);
	}
	
	
	
	
	
	
	

}
