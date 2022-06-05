package com.mysite.sbb.siteuser;
import org.springframework.data.jpa.repository.JpaRepository;

import com.mysite.sbb.siteuser.SiteUser;

import java.util.List;

public interface SiteUserRepository extends JpaRepository<SiteUser, Long> {
	List<SiteUser> findByIdentity(String identity);


}
