package com.mysite.sbb.siteuser;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.dao.DataIntegrityViolationException;

import com.mysite.sbb.siteuser.SiteUserForm;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;

@RequestMapping("/siteUser")
@RequiredArgsConstructor
@Controller
public class SiteUserController {

	private final SiteUserService siteUserService;
	
    @GetMapping("/signup")
    public String questionCreate(SiteUserForm siteUserForm) {
        return "site_user_form";
    }

    @PostMapping("/signup")
    public String questionCreate(@Valid SiteUserForm siteUserForm, BindingResult bindingResult) {
    	// ���⼭ �ߺ�Ȯ�� �ϴ°� �̻ڰڴ�.  
        if (bindingResult.hasErrors()) {
            return "site_user_form";
        }
        
        if (!siteUserForm.getPassword1().equals(siteUserForm.getPassword2())) {
            bindingResult.rejectValue("password2", "passwordInCorrect", 
                    "2���� �н����尡 ��ġ���� �ʽ��ϴ�.");
            return "site_user_form";
        }
       
        
        try {
            siteUserService.create(siteUserForm.getIdentity(), 
            		siteUserForm.getEmail(), siteUserForm.getPassword1());
        }catch(DataIntegrityViolationException e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", "�̹� ��ϵ� ������Դϴ�.");
            return "site_user_form";
        }catch(Exception e) {
            e.printStackTrace();
            bindingResult.reject("signupFailed", e.getMessage());
            return "site_user_form";
        } 
        return "site_user_form";
    }
}
