package com.mysite.sbb.question;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class QuestionForm {
    @NotEmpty(message = "가득")
    @Size(max = 200)
    private String subject;

    @NotEmpty(message = "가득")
    private String content;
}