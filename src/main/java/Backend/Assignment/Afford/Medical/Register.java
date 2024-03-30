package Backend.Assignment.Afford.Medical;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
public class Register {
	private String companyName;
	private String ownerName;
	
	@Id
	@GeneratedValue
	private Integer rollNo;
	private String ownerEmail;
	private String accessCode;
	
}
