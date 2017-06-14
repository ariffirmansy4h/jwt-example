package com.bpr.route.Security;

import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.bpr.route.Users.UserDAO;
import com.bpr.route.Users.UserRoles;

@Service("userDetailsService")
public class JWTUserDetailsService implements UserDetailsService {

    @Autowired
    UserDAO userDao;

    @Transactional(readOnly=true)
    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        com.bpr.route.Users.User user = userDao.findByUsername(username);
        List<GrantedAuthority> authorities = buildUserAuthority(user.getUserRoles());

		return buildUserForAuthentication(user, authorities);
    }

    private User buildUserForAuthentication(com.bpr.route.Users.User user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(),
			user.getEnabled(), true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(List<UserRoles> userRoles) {

        Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		for (UserRoles userRole : userRoles) {
			setAuths.add(new SimpleGrantedAuthority(userRole.getRoles()));
		}

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}