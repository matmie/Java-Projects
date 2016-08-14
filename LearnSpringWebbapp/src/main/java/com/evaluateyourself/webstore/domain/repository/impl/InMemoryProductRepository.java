/**
 * 
 */
package com.evaluateyourself.webstore.domain.repository.impl;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.log4j.helpers.Loader;
import org.springframework.stereotype.Repository;

import com.evaluateyourself.webstore.domain.Product;
import com.evaluateyourself.webstore.domain.repository.ProductRepository;
import com.evaluateyourself.webstore.utils.Utils;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Repository
public class InMemoryProductRepository implements ProductRepository {

	private List<Product> listOfProducts = new ArrayList<Product>();
	private Logger logger = Logger.getLogger(InMemoryProductRepository.class);

	public InMemoryProductRepository() {
		Product iphone = new Product("P1234", "iPhone 5s", new BigDecimal(500));
		iphone.setDescription(
				"Apple iPhone 5s, smatfon z 4-calowym wyswietlaczem o rozdzielczosci 640x1136 oraz 8-megapikselowym aparatem");
		iphone.setCategory("Smart Phone");
		iphone.setManufacturer("Apple");
		iphone.setUnitsInStock(1000);

		Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));
		laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop (czarny) z procesorem Intel Core 3. generacji");
		laptop_dell.setCategory("Laptop");
		laptop_dell.setManufacturer("Dell");
		laptop_dell.setUnitsInStock(1000);

		Product tablet_nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));
		tablet_nexus.setDescription(
				"Google Nexus 7 jest najl¿ejszym 7-calowym tabletem z 4-rdzeniowym procesorem Qualcomm Snapdragon S4 Pro");
		tablet_nexus.setCategory("Tablet");
		tablet_nexus.setManufacturer("Google");
		tablet_nexus.setUnitsInStock(1000);

		listOfProducts.add(iphone);
		listOfProducts.add(laptop_dell);
		listOfProducts.add(tablet_nexus);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evaluateyourself.webstore.domain.repository.ProductRepository#
	 * getAllProducts()
	 */
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return listOfProducts;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.evaluateyourself.webstore.domain.repository.ProductRepository#
	 * getProductById(java.lang.String)
	 */
	public Product getProductById(String productId) {
		Product productById = null;
		for(Product product: listOfProducts){
			if(   (product != null) 
			   && (product.getProductId() != null) 
			   && (product.getProductId().equals(productId))){
				productById = product;
				break;
			}
		}
		
		if(productById == null) {
			throw new IllegalArgumentException("Brak produktu o wskazanym id: " + productId);
		}
		return productById;
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.ProductRepository#getProductsByCategory(java.lang.String)
	 */
	public List<Product> getProductsByCategory(String category) {
		List<Product> productsByCategory = new ArrayList<Product>();
		for(Product product:listOfProducts){
			if(category.equalsIgnoreCase(product.getCategory())){
				productsByCategory.add(product);
			}
		}
		return productsByCategory;
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.ProductRepository#getProductsByFilter(java.util.Map)
	 */
	public Set<Product> getProductsByFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsByBrand = new HashSet<Product>();
		Set<Product> productsByCategory = new HashSet<Product>();
		
		Set<String> criterias = filterParams.keySet();
		if(criterias.contains("brand")){
			for(String brandName: filterParams.get("brand")){
				for(Product product:listOfProducts){
					if(brandName.equalsIgnoreCase(product.getManufacturer())){
						productsByBrand.add(product);
					}
				}
			}
		}
		if(criterias.contains("category")){
			for(String category: filterParams.get("category")){
				productsByCategory.addAll(this.getProductsByCategory(category));
			}
		}
		productsByCategory.retainAll(productsByBrand);
		return productsByCategory;
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.ProductRepository#getProductsByManufacturer(java.lang.String)
	 */
	public List<Product> getProductsByManufacturer(String manufacturer) {
		List<Product> productByManufacturer = new ArrayList<Product>();
		for(Product product:listOfProducts){
			if(manufacturer.equalsIgnoreCase(product.getManufacturer())){
				productByManufacturer.add(product);
			}
		}
		return productByManufacturer;
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.ProductRepository#getProductsByPriceFilter(java.util.Map)
	 */
	public Set<Product> getProductsByPriceFilter(Map<String, List<String>> filterParams) {
		Set<Product> productsMoreThanLow = new HashSet<Product>();
		Set<Product> productsLessThanHigh = new HashSet<Product>();
		Set<String> criterias = filterParams.keySet();
		int result = 0;
		if(criterias.contains("low")){
			for(Product product:listOfProducts){
				result = product.getUnitPrice().compareTo(Utils.convertFromString(filterParams.get("low").get(0)));
				if(result < 0) {
					continue;
				}
				else
				{
					productsMoreThanLow.add(product);
				}
			}
		}
		
		if(criterias.contains("high")){
			for(Product product:listOfProducts){
				result = product.getUnitPrice().compareTo(Utils.convertFromString(filterParams.get("high").get(0)));
				if(result > 0) {
					continue;
				}
				else
				{
					productsLessThanHigh.add(product);
				}
			}
		}
		productsMoreThanLow.retainAll(productsLessThanHigh);
		return productsMoreThanLow;
	}

	/* (non-Javadoc)
	 * @see com.evaluateyourself.webstore.domain.repository.ProductRepository#addProduct(com.evaluateyourself.webstore.domain.Product)
	 */
	public void addProduct(Product product) {
		listOfProducts.add(product);
	}
	
	
	
	
	
	
	
	
	
	

}
