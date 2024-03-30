package Backend.Assignment.Afford.Medical;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {
	@Id
	private Integer productId;
	private String productName;
	private Integer price;
	private Float discount;
	private Boolean availabilty;

}
