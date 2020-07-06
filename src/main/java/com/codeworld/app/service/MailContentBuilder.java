package com.codeworld.app.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
@AllArgsConstructor
public class MailContentBuilder {

	private TemplateEngine templateEngine;

    public String build(String message) {
        Context context = new Context();
        context.setVariable("You have just been registered", message);
        return templateEngine.process("mailTemplate", context);
    }
}
