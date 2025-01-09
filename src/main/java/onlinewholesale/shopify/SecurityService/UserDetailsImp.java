package onlinewholesale.shopify.SecurityService;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;

import onlinewholesale.shopify.Entity.User;

public class UserDetailsImp implements UserDetails {
	private static final long serialVersionUID = 1L;
	private Long id;
	private String username;
	private String email;
	@JsonIgnore
	private String password;
	private String firstname;
	private String middlename;
	private String lastname;
	private Collection<? extends GrantedAuthority> authorities;

	public UserDetailsImp() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailsImp(Long id, String username, String email, String password, String firstname, String middlename,
			String lastname, Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.email = email;
		this.password = password;
		this.firstname = firstname;
		this.middlename = middlename;
		this.lastname = lastname;
		this.authorities = authorities;
	}

	public static UserDetailsImp build(User user) {
		List<GrantedAuthority> authorities = Collections
				.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
		return new UserDetailsImp(user.getId(), user.getUsername(), user.getEmail(), user.getPassword(),
				user.getFirstName(), user.getMiddleName(), user.getLastName(), authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getMiddlename() {
		return middlename;
	}

	public String getLastname() {
		return lastname;
	}

	@Override
	public String getPassword() {
		return password;
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

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImp user = (UserDetailsImp) o;
		return Objects.equals(id, user.id);
	}

}
