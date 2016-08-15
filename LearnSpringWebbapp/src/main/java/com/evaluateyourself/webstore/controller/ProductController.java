package com.evaluateyourself.webstore.controller;

import java.io.File;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.ModelAndViewDefiningException;

import com.evaluateyourself.webstore.domain.Product;
import com.evaluateyourself.webstore.domain.repository.ProductRepository;
import com.evaluateyourself.webstore.exception.NoProductsFoundUnderCategoryException;
import com.evaluateyourself.webstore.exception.ProductNotFoudException;
import com.evaluateyourself.webstore.service.ProductService;
import com.evaluateyourself.webstore.service.impl.ProductServiceImpl;

@Controller
@RequestMapping("/products")
public class ProductController {

	/**
	 * Wstrzykiwanie zale¿nosci Springa
	 */
	@Autowired
	private ProductService productService;
	
	@ExceptionHandler(ProductNotFoudException.class)
	public ModelAndView handleError(HttpServletRequest req, ProductNotFoudException exception){
		ModelAndView mav = new ModelAndView();
		mav.addObject("invalidProductId", exception.getProductId());
		mav.addObject("exception", exception);
		mav.addObject("url", req.getRequestURL()+"?"+req.getQueryString());
		mav.setViewName("productNotFound");
		return mav;
	}
	/**
	 * Mówimy tym samym, ¿e obiekt typu Product nie wymaga, aby podawac wartosci
	 * unitsInOrder oraz discontinued
	 * 
	 * @param binder
	 */
	@InitBinder
	public void initialiseBinder(WebDataBinder binder) {
		binder.setDisallowedFields("unitsInOrder", "discontinued");
		binder.setAllowedFields("productId","language","name","productPdf","unitPrice","description","manufacturer","category","unitsInStock","productImage","condition");
	}

	@RequestMapping("/product")
	public String getProductById(@RequestParam("id") String productId, Model model) {
		model.addAttribute("product", productService.getProductById(productId));
		return "product";
	}

	@RequestMapping
	public String list(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	@RequestMapping("/all")
	public String allProducts(Model model) {
		model.addAttribute("products", productService.getAllProducts());
		return "products";
	}

	/**
	 * @PathVariable s³u¿y do odczytania zmiennej z szablonu URI
	 * @param model
	 * @param productCategory
	 * @return
	 */
	@RequestMapping("/{category}")
	public String getProductsByCategory(Model model, @PathVariable("category") String productCategory) {
		List<Product> products = productService.getProductsByCategory(productCategory);
		if((products==null) || (products.isEmpty())){
			throw new NoProductsFoundUnderCategoryException();
		}
		model.addAttribute("products", products);
		return "products";
	}

	@RequestMapping("/filter/{ByCriteria}")
	public String getProductsByFilter(@MatrixVariable(pathVar = "ByCriteria") Map<String, List<String>> filterParams,
			@RequestParam("manufacturer") String manufacturer, Model model) {
		model.addAttribute("products", productService.getProductsByFilter(filterParams));
		return "products";
	}

	@RequestMapping("/{category}/{price}")
	public String filterProducts(@MatrixVariable(pathVar = "price") Map<String, List<String>> filterParams,
			@PathVariable("category") String productCategory, @RequestParam("manufacturer") String manufacturer,
			Model model) {
		List<Product> prodByCategory = productService.getProductsByCategory(productCategory);
		Set<Product> prodByPrice = productService.getProductsByPriceFilter(filterParams);
		List<Product> prodByManufacturer = productService.getProductsByManufacturer(manufacturer);
		prodByCategory.retainAll(prodByPrice);
		prodByCategory.retainAll(prodByManufacturer);
		model.addAttribute("products", prodByCategory);
		return "products";
	}

	@RequestMapping(value = "/add", method = RequestMethod.GET)
	public String getAddNewProductForm(Model model) {
		Product newProduct = new Product();
		model.addAttribute("newProduct", newProduct);
		return "addProduct";
	}
	
	/**
	 * 
	 * @param newProduct
	 * @param result
	 * @param request parametr typu HttpServletRequest zawiera informacje o aktualnym ¿¹daniu HTTP
	 * @return
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String proccessAddNewProductForm(@ModelAttribute("newProduct") @Valid Product newProduct, BindingResult result, HttpServletRequest request) {
		if(result.hasErrors()){
			return "addProduct";
		}
		String[] suppressedFields = result.getSuppressedFields();
		if(suppressedFields.length > 0) {
			throw new RuntimeException("Próba wi¹zania niedozwolonych pól " + StringUtils.arrayToCommaDelimitedString(suppressedFields));
		}
		MultipartFile productImage = newProduct.getProductImage();
		MultipartFile productPdf = newProduct.getProductPdf();
		String rootDirectory = request.getSession().getServletContext().getRealPath("/");
		
		if((productImage != null) && (!productImage.isEmpty())){
			try {
				productImage.transferTo(new File(rootDirectory+"resources\\images\\"+newProduct.getProductId()+".png"));
				productPdf.transferTo(new File(rootDirectory+"resources\\pdf\\"+newProduct.getProductId()+".pdf"));
			} catch (Exception e) {
				throw new RuntimeException("Niepowodzenie podczas próby zapisu obrazka produktu", e);
			}
		}
		productService.addProduct(newProduct);
		return "redirect:/products";
	}
	@RequestMapping("/invalidPromoCode")
	public String invalidPromoCode(){
		return "invalidPromoCode";
	}
	

}
