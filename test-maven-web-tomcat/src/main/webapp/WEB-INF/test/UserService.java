package com.egym.serivce;


import com.egym.repository.UserRepository;
import com.egym.repository.enums.RoleEnum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserService implements UserDetailsService {

	@Autowired
    private UserRepository userRepository;


	@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.egym.entity.User user = userRepository.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("No user present with username : " + username);
        }
        else {
    		List<GrantedAuthority> authorities = buildUserAuthority(user.getRoles());
        	return buildUserForAuthentication(user, authorities);
        }
    }
    

	// Converts com.mkyong.users.model.User user to
	// org.springframework.security.core.userdetails.User
	private User buildUserForAuthentication(com.egym.entity.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), 
			user.getPassword(), user.isEnabled(), 
                        true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<RoleEnum> userRoles) {

		Set<GrantedAuthority> setAuths = new HashSet<>();

		// Build user's authorities
		for (RoleEnum userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.name()));
		}

		List<GrantedAuthority> Result = new ArrayList<>(setAuths);

		return Result;
	}
}
