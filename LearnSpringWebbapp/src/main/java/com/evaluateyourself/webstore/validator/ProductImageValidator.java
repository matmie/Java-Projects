/**
 * 
 */
package com.evaluateyourself.webstore.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.multipart.MultipartFile;

import com.evaluateyourself.webstore.domain.Product;

/**
 * @author Mateusz Miernik [mateusz.miernik86@gmail.com]
 *
 */
@Component
public class ProductImageValidator implements Validator {
	private long allowedSize;
	/**
	 * @return the allowedSize
	 */
	public long getAllowedSize() {
		return allowedSize;
	}

	/**
	 * @param allowedSize the allowedSize to set
	 */
	public void setAllowedSize(long allowedSize) {
		this.allowedSize = allowedSize;
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#supports(java.lang.Class)
	 */
	@Override
	public boolean supports(Class<?> clazz) {
		return Product.class.isAssignableFrom(clazz);
	}

	/* (non-Javadoc)
	 * @see org.springframework.validation.Validator#validate(java.lang.Object, org.springframework.validation.Errors)
	 */
	@Override
	public void validate(Object target, Errors errors) {
		Product product = (Product) target;
		MultipartFile file = product.getProductImage();
		if((file!=null) && (file.getSize() > allowedSize)) {
			errors.rejectValue("productImage", "ProductImageValidator.product.productImage.validation");
		}

	}

}
