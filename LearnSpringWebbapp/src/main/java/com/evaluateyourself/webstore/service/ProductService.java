/**
 * 
 */
package com.evaluateyourself.webstore.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.evaluateyourself.webstore.domain.Product;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public interface ProductService {
	List<Product> getAllProducts();
	List<Product> getProductsByCategory(String category);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	Product getProductById(String productId);
	List<Product> getProductsByManufacturer(String manufacturer);
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);
	void addProduct(Product product);
}
