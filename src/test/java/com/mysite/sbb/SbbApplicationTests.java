package com.mysite.sbb;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mysite.sbb.question.QuestionService;

@SpringBootTest
class SbbApplicationTests {

	@Autowired
	private QuestionService questionService;
	
	@Test
	void testJpa() {
		for (int i=1;i<=300;i++) {
			String subject = String.format("test data:[%03d]", i);
			String content = "no";
			this.questionService.create(subject, content, null);
			
		
					
		}
	}
    
}