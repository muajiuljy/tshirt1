package fi.vamk.e1601126.tshirts1;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductRepository productRepository;
	
	@RequestMapping("/products")
	public Iterable<Product> products(){
		return productRepository.findAll();
	}
	
	@RequestMapping("/product/{id}")
	public Optional<Product> getProduct(@PathVariable("id") int id){
		return productRepository.findById(id);
	}
	
	@RequestMapping(value = "/product" , method = RequestMethod.POST,produces={"application/json","application/xml"})
    public @ResponseBody Product create(@RequestBody Product item) {
    	return productRepository.save(item);
} 
	
    @RequestMapping(value = "/product" , method = RequestMethod.PUT)
    public @ResponseBody Product update(@RequestBody Product item) {
    	return productRepository.save(item);
    } 
    
    @RequestMapping(value = "/product" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Product item) {
    	productRepository.delete(item);
    }
}
