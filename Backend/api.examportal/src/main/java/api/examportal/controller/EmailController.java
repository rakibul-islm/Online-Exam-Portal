package api.examportal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import api.examportal.model.EmailRequest;
import api.examportal.model.User;
import api.examportal.model.exam.Exam;
import api.examportal.service.impl.EmailService;

@RestController
@CrossOrigin("*")
public class EmailController {
	
	@Autowired
	private EmailService emailService;
	
	@PostMapping("/sendmail")
	public ResponseEntity<?> sendEmail(@RequestBody EmailRequest request){
	
		
		//System.out.println(request);
		
		
		boolean result = this.emailService.sendEmail(request.getSubject(), request.getMessage(), request.getTo());
		
		if(result) {
			return ResponseEntity.ok("Email Sent Successfull..");
		}else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Email Not Sent !");
		}
		
		
		
	}

}
