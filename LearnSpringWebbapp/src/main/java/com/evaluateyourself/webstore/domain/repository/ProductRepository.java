/**
 * 
 */
package com.evaluateyourself.webstore.domain.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.evaluateyourself.webstore.domain.Product;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
public interface ProductRepository {
	List<Product> getAllProducts();
	Product getProductById(String productId);
	List<Product> getProductsByCategory(String category);
	Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams);
	Set<Product> getProductsByFilter(Map<String, List<String>> filterParams);
	List<Product> getProductsByManufacturer(String manufacturer);
	void addProduct(Product product);
}
