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
public class OrderController {
	@Autowired
	private OrderRespository orderRespository;
	
	@RequestMapping("/orders")
	public Iterable<Order> orders(){
		return orderRespository.findAll();
	}
	
	@RequestMapping("/order/{id}")
	public Optional<Order> getOrder(@PathVariable("id") int id){
		return orderRespository.findById(id);
	}
	
	@RequestMapping(value = "/order" , method = RequestMethod.POST,produces={"application/json","application/xml"})
    public @ResponseBody Order create(@RequestBody Order item) {
    	return orderRespository.save(item);
} 
	
    @RequestMapping(value = "/order" , method = RequestMethod.PUT)
    public @ResponseBody Order update(@RequestBody Order item) {
    	return orderRespository.save(item);
    } 
    
    @RequestMapping(value = "/order" , method = RequestMethod.DELETE)
    public void delete(@RequestBody Order item) {
    	orderRespository.delete(item);
    }
}
