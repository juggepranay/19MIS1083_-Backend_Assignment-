package Backend.Assignment.Afford.Medical;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class Controller {

	@Autowired
	RegistrationRepo repo;

	@PostMapping(value = "/register")
	public ResponseEntity<String> createUser(@RequestBody Register register) {
		if (register != null) {
			repo.save(register);
			return ResponseEntity.ok("User registered successfully");
		} else {
			return ResponseEntity.badRequest().body("Registration data is null");
		}
	}
	
	@GetMapping(value="/register")
	public List<Register> getUser(){
		return repo.findAll();
	}
	
	
	@Autowired
	 AService apiService;


    @GetMapping("/primes")
    public List<Integer> getPrimes() {
        return apiService.getPrimes();
    }

    @GetMapping("/fibonacci")
    public List<Integer> getFibonacci() {
        return apiService.getFibonacci();
    }

    @GetMapping("/even")
    public List<Integer> getEvenNumbers() {
        return apiService.getEvenNumbers();
    }

    @GetMapping("/random")
    public List<Integer> getRandomNumbers() {
        return apiService.getRandomNumbers();
    }
    
    
    @Autowired
    ProductRepo productRepo ;
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }
    
    
    @PostMapping(value = "/product")
	public ResponseEntity<String> addPrdouct(@RequestBody Product product) {
		if (product != null) {
			productRepo.save(product);
			return ResponseEntity.ok("Product Added successfully");
		} else {
			return ResponseEntity.badRequest().body("Could not add");
		}
	}
    
    @GetMapping(value = "/product/{id}")
	public ResponseEntity<Product>  addPrdouct(@PathVariable int id) {
    	Optional<Product> product=productRepo.findById(id);
    	
    	if (product.isPresent()) {
            
            return ResponseEntity.ok(product.get());
        } else {
            
            return ResponseEntity.notFound().build();
        }
		
	}
    

}
