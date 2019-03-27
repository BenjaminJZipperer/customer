package com.example.demo.com.example.demo.model;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "customers")//No customers yet
public class Customer {

    // Default constructor required by JPA
    public Customer() {}

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Column(name="username")
    @NotBlank(message = "Name ist ein Pflichtfeld.")
    private String username;
    
    @Column(name="email")
    @NotBlank(message = "Email ist ein Pflichtfeld.")
    private String email;
    
    @Column(name="password")
    @NotBlank(message = "Das Paswort ist anzugeben!")
    private String password;
    
    @Column(name="confrimPassword")
   
    private String confirmPassword; // gone
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}