package org.jsp.merchantproductapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int id;
	@Column(nullable=false)
	private long phone;
	@Column(nullable=false)
	private String email;
	@Column(nullable=false)
	private int gst_number;
	@Column(nullable=false)
	private String password;
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "m")
	private List<Product> Product;
	@Override
	public String toString() {
		return "Merchant [id=" + id + ", phone=" + phone + ", email=" + email + ", gst_number=" + gst_number
				+ ", password=" + password +  "]";
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public long getPhone() {
		return phone;
	}
	public void setPhone(long phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getGst_number() {
		return gst_number;
	}
	public void setGst_number(int gst_number) {
		this.gst_number = gst_number;
	}
	public List<Product> getProduct() {
		return Product;
	}
	public void setProduct(List<Product> product) {
		Product = product;
	}
//	public Object getName() {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	

}
