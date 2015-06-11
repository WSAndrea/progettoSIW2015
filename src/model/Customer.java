package model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name="retrieveAllCustomers", query = "SELECT c from Customer c")
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String firstName;
	@Column
	private String lastName;
	@Column(unique=true,nullable=false)
	private String email;
	@Column
	private String phoneNumber;
	@Column
<<<<<<< HEAD
	private Date dateOfBirth;
=======
	private String giornoDiNascita;
	@Column
	private String meseDiNascita;
	@Column
	private String annoDiNascita;
>>>>>>> refs/remotes/origin/master
	@Column
	@Temporal(TemporalType.DATE)
	private Date registrationDate;
	@Column
	private String via;
	@Column
	private String numeroCivico;
	@Column
	private Integer cap;
	@Column
	private String state;
	@OneToMany(cascade = {CascadeType.PERSIST,CascadeType.REMOVE,CascadeType.MERGE},mappedBy = "customer",fetch = FetchType.LAZY)
	private List<Orders> orders;

	public Customer() {

	}

	public Customer(Long id, String firstName, String lastName, String email,
<<<<<<< HEAD
			String phoneNumber, Date dateOfBirth ,Date registrationDate,
			Address address, List<Orders> orders) {
=======
			String phoneNumber, String giornoDiNascita, String meseDiNascita,String annoDiNascita,Date registrationDate,
		String via, String numeroCivico, Integer cap,String state, List<Orders> orders) {
>>>>>>> refs/remotes/origin/master
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.giornoDiNascita = giornoDiNascita;
		this.meseDiNascita=meseDiNascita;
		this.annoDiNascita=annoDiNascita;
		this.registrationDate = registrationDate;
		this.via =via;
		this.numeroCivico=numeroCivico;
		this.cap=cap;
		this.state=state;
		this.orders = orders;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

<<<<<<< HEAD
=======
	public String getGiornoDiNascita() {
		return giornoDiNascita;
	}

	public void setGiornoDiNascita(String giornoDiNascita) {
		this.giornoDiNascita = giornoDiNascita;
	}

	public String getMeseDiNascita() {
		return meseDiNascita;
	}

	public void setMeseDiNascita(String meseDiNascita) {
		this.meseDiNascita = meseDiNascita;
	}

	public String getAnnoDiNascita() {
		return annoDiNascita;
	}

	public void setAnnoDiNascita(String annoDiNascita) {
		this.annoDiNascita = annoDiNascita;
	}

>>>>>>> refs/remotes/origin/master
	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
<<<<<<< HEAD
=======
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getNumeroCivico() {
		return numeroCivico;
	}

	public void setNumeroCivico(String numeroCivico) {
		this.numeroCivico = numeroCivico;
	}

	public Integer getCap() {
		return cap;
	}

	public void setCap(Integer cap) {
		this.cap = cap;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
>>>>>>> refs/remotes/origin/master
	}

	public List<Orders> getOrders() {
		return orders;
	}

	public void setOrders(List<Orders> orders) {
		this.orders = orders;
	}

<<<<<<< HEAD
	public Date getDateOfBirth() {
		return dateOfBirth;
=======
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((annoDiNascita == null) ? 0 : annoDiNascita.hashCode());
		result = prime * result + ((cap == null) ? 0 : cap.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((giornoDiNascita == null) ? 0 : giornoDiNascita.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result
				+ ((meseDiNascita == null) ? 0 : meseDiNascita.hashCode());
		result = prime * result
				+ ((numeroCivico == null) ? 0 : numeroCivico.hashCode());
		result = prime * result + ((orders == null) ? 0 : orders.hashCode());
		result = prime * result
				+ ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		result = prime
				* result
				+ ((registrationDate == null) ? 0 : registrationDate.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((via == null) ? 0 : via.hashCode());
		return result;
>>>>>>> refs/remotes/origin/master
	}

<<<<<<< HEAD
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
=======
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (annoDiNascita == null) {
			if (other.annoDiNascita != null)
				return false;
		} else if (!annoDiNascita.equals(other.annoDiNascita))
			return false;
		if (cap == null) {
			if (other.cap != null)
				return false;
		} else if (!cap.equals(other.cap))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (giornoDiNascita == null) {
			if (other.giornoDiNascita != null)
				return false;
		} else if (!giornoDiNascita.equals(other.giornoDiNascita))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (meseDiNascita == null) {
			if (other.meseDiNascita != null)
				return false;
		} else if (!meseDiNascita.equals(other.meseDiNascita))
			return false;
		if (numeroCivico == null) {
			if (other.numeroCivico != null)
				return false;
		} else if (!numeroCivico.equals(other.numeroCivico))
			return false;
		if (orders == null) {
			if (other.orders != null)
				return false;
		} else if (!orders.equals(other.orders))
			return false;
		if (phoneNumber == null) {
			if (other.phoneNumber != null)
				return false;
		} else if (!phoneNumber.equals(other.phoneNumber))
			return false;
		if (registrationDate == null) {
			if (other.registrationDate != null)
				return false;
		} else if (!registrationDate.equals(other.registrationDate))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (via == null) {
			if (other.via != null)
				return false;
		} else if (!via.equals(other.via))
			return false;
		return true;
>>>>>>> refs/remotes/origin/master
	}

<<<<<<< HEAD
	public Address getAddress() {
		return address;
=======
	@Override
	public String toString() {
		return "Customer [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email
				+ ", phoneNumber=" + phoneNumber + ", giornoDiNascita="
				+ giornoDiNascita + ", meseDiNascita=" + meseDiNascita
				+ ", annoDiNascita=" + annoDiNascita + ", registrationDate="
				+ registrationDate + ", via=" + via + ", numeroCivico="
				+ numeroCivico + ", cap=" + cap + ", state=" + state
				+ ", orders=" + orders + "]";
>>>>>>> refs/remotes/origin/master
	}

<<<<<<< HEAD
	public void setAddress(Address address) {
		this.address = address;
	}
}
=======
	}
>>>>>>> refs/remotes/origin/master
