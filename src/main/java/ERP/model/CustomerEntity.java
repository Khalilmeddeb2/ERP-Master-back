package ERP.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="Customers")
public class CustomerEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private int phonenumber;
	private String address;
	private String type;
	
	@OneToMany(mappedBy = "customer",cascade = CascadeType.REMOVE)
	private List<OrderSaleEntity> salesOrders= new ArrayList<>();


}
