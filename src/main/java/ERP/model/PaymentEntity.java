package ERP.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Table(name="Payment")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class PaymentEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	private String mode ;
	private LocalDate datePayment ;
	private double montant ;
	
	
	@ManyToOne
	private InvoiceEntiy invoice ;


	public String getMode() {
		return mode;
	}


	public double getMontant() {
		return montant;
	}


	public void setMontant(double montant) {
		this.montant = montant;
	}


	public LocalDate getDatePayment() {
		return datePayment;
	}


	public void setDatePayment(LocalDate datePayment) {
		this.datePayment = datePayment;
	}


	public void setMode(String mode) {
		this.mode = mode;
	}

}