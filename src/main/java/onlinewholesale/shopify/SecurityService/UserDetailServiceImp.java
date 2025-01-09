package onlinewholesale.shopify.SecurityService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import onlinewholesale.shopify.Entity.User;
import onlinewholesale.shopify.Repository.UserRepo;

@Service
public class UserDetailServiceImp implements UserDetailsService{

	@Autowired
	UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user =  userRepo.findByEmail(email)
		        .orElseThrow(() -> new UsernameNotFoundException("User Not Found with  " + email));

		    return UserDetailsImp.build(user);
	}
	
}
