package com.emerson.curso.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.security.core.userdetails.UserDetails;

import io.jsonwebtoken.lang.Objects;


@Entity
@Table(name="tb_user")
public class User implements UserDetails {
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   @Id
   @GeneratedValue(strategy= GenerationType.IDENTITY)
   private Long id;
   private String name;
   private String email;
   private String phone;
   private String password;
   
   
   @OneToMany(mappedBy="client")
   private List<Order> orders = new ArrayList<>();
   
   @ManyToMany
   @JoinTable(name="tb_user_role", joinColumns= @JoinColumn(name= "user_id"),inverseJoinColumns= @JoinColumn(name= "role_id"))
   private Set<Role> roles = new HashSet<>();
	
   
   public User() {
	   
   }

   public User(Long id, String name, String email, String phone, String password) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.password = password;
    }
   public List<Order> getOrders() {
		return orders;
	}

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhone() {
		return phone;
	}
	
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Set<Role> getRoles(){
		return roles;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return Objects.equals(id, other.id);
	}
	
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return roles;
	}
	
	@Override
	public String getUsername() {
		return email;
	}
	
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() { 
		return true;
	}
    
}