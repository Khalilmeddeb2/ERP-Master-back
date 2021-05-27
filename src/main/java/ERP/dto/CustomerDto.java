package ERP.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	
	
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private int phonenumber;
	private String address;
	private String type;
	
}