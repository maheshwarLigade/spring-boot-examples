package com.techwasti.thymeleafemailTemplate;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import service.EmailSenderService;
import javax.mail.MessagingException;

import com.techwasti.thymeleafemailTemplate.model.Mail;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.log4j.Log4j2;


@SpringBootTest
@Log4j2
class ThymeleafemailTemplateApplicationTests {

	@Autowired
	EmailSenderService senderService;

	@Test
	void contextLoads() throws Exception{

		log.info("sending sample email");

		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("name", "Maheshwar Ligade!");
		properties.put("location", "India");
		properties.put("sign", "Java Developer");

		Mail mail = Mail.builder()
				.from("testfrom@gmail.com")
				.to("testing21@gmail.com")
				.htmlTemplate(new Mail.HtmlTemplate("sample", properties))
				.subject("This is sample email with spring boot and thymeleaf")
				.build();

		senderService.sendEmail(mail);
	}

}
