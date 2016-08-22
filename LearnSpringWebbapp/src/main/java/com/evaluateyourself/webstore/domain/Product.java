/**
 * 
 */
package com.evaluateyourself.webstore.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.springframework.web.multipart.MultipartFile;

import com.evaluateyourself.webstore.validator.Category;
import com.evaluateyourself.webstore.validator.ProductId;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@XmlRootElement
public class Product implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8569558439999239204L;
	@Pattern(regexp="P[0-9]+", message="{Pattern.Product.productId.validation}") 
	@ProductId(message="{ProductId.Product.productId.validation}")
	private String productId;
	@Size(min=4, max=50, message="{Size.Product.name.validation}")
	private String name;
	
	@Min(value=0, message="{Min.Product.unitPrice.validation}")
	@Digits(integer=8, fraction=2, message="{Digits.Product.unitPrice.validation}")
	@NotNull(message="{NotNull.Product.unitPrice.validation}")
	private BigDecimal unitPrice;
	private String description;
	private String manufacturer;
	@Size(min=1, max=50, message="{NotNull.Product.category.validation}")
	@NotNull(message="{NotNull.Product.category.validation}")
	@Category(message="{Category.product.category.validation}")
	private String category;
	@Min(value=0, message="{Min.Product.unitsInStock.validation}")
	private long unitsInStock;
	private long unitsInOrder;
	private boolean discontinued;
	private String condition;
	@JsonIgnore
	private MultipartFile productImage;
	@JsonIgnore
	private MultipartFile productPdf;
	
	/**
	 * 
	 */
	public Product() {
		super();
	}

	/**
	 * @param productId
	 * @param name
	 * @param unitPrice
	 */
	public Product(String productId, String name, BigDecimal unitPrice) {
		super();
		this.productId = productId;
		this.name = name;
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the productId
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * @param productId the productId to set
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the unitPrice
	 */
	public BigDecimal getUnitPrice() {
		return unitPrice;
	}

	/**
	 * @param unitPrice the unitPrice to set
	 */
	public void setUnitPrice(BigDecimal unitPrice) {
		this.unitPrice = unitPrice;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the manufacturer
	 */
	public String getManufacturer() {
		return manufacturer;
	}

	/**
	 * @param manufacturer the manufacturer to set
	 */
	public void setManufacturer(String manufacturer) {
		this.manufacturer = manufacturer;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the unitsInStock
	 */
	public long getUnitsInStock() {
		return unitsInStock;
	}

	/**
	 * @param unitsInStock the unitsInStock to set
	 */
	public void setUnitsInStock(long unitsInStock) {
		this.unitsInStock = unitsInStock;
	}

	/**
	 * @return the unitsInOrder
	 */
	public long getUnitsInOrder() {
		return unitsInOrder;
	}

	/**
	 * @param unitsInOrder the unitsInOrder to set
	 */
	public void setUnitsInOrder(long unitsInOrder) {
		this.unitsInOrder = unitsInOrder;
	}

	/**
	 * @return the discontinued
	 */
	public boolean isDiscontinued() {
		return discontinued;
	}

	/**
	 * @param discontinued the discontinued to set
	 */
	public void setDiscontinued(boolean discontinued) {
		this.discontinued = discontinued;
	}

	/**
	 * @return the condition
	 */
	public String getCondition() {
		return condition;
	}

	/**
	 * @param condition the condition to set
	 */
	public void setCondition(String condition) {
		this.condition = condition;
	}
	

	/**
	 * @return the productImage
	 */
	@XmlTransient
	public MultipartFile getProductImage() {
		return productImage;
	}

	/**
	 * @param productImage the productImage to set
	 */
	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}
	
	
	/**
	 * @return the productPdf
	 */
	@XmlTransient
	public MultipartFile getProductPdf() {
		return productPdf;
	}

	/**
	 * @param productPdf the productPdf to set
	 */
	public void setProductPdf(MultipartFile productPdf) {
		this.productPdf = productPdf;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + "]";
	}
	
	
}
