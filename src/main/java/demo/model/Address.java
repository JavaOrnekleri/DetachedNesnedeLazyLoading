package demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Address {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	private Long id;

	private String street;
	private String city;

	@ManyToOne
	@JsonBackReference
	private User owner;

	public Address() {
	}

	public Address(String street, String city) {
		this.street = street;
		this.city = city;
	}

	public User getOwner() {
		return owner;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}
}
