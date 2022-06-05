package com.mysite.sbb.siteuser;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class SiteUserService {

	private final SiteUserRepository siteUserRepository;
    private final PasswordEncoder passwordEncoder;

	public void create(String identity, String email, String password) {
		SiteUser siteUser = new SiteUser();
		// 중복 확인 
		siteUser.setIdentity(identity);
		siteUser.setEmail(email);
        siteUser.setPassword(passwordEncoder.encode(password));
	
        this.siteUserRepository.save(siteUser);

	}
}
