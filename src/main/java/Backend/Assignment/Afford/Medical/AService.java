package Backend.Assignment.Afford.Medical;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Service
@Data
public class AService {
	
	AService(){
		this.restTemplate = new RestTemplate();}
	
    private final RestTemplate restTemplate;

    public AService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Integer> getPrimes() {
        ApiReposonse response = restTemplate.getForObject("http://20.244.56.144/test/primes", ApiReposonse.class);
        return response != null ? response.getNumbers() : null;
    }

    public List<Integer> getFibonacci() {
        ApiReposonse response = restTemplate.getForObject("http://28.244.56.144/test/fibo", ApiReposonse.class);
        return response != null ? response.getNumbers() : null;
    }

    public List<Integer> getEvenNumbers() {
        ApiReposonse response = restTemplate.getForObject("http://28.244.56.144/test/even", ApiReposonse.class);
        return response != null ? response.getNumbers() : null;
    }

    public List<Integer> getRandomNumbers() {
        ApiReposonse response = restTemplate.getForObject("http://28.244.56.144/test/rand", ApiReposonse.class);
        return response != null ? response.getNumbers() : null;
    }
}

