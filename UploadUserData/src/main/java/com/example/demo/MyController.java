package com.example.demo;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.service.annotation.GetExchange;


@CrossOrigin("http://localhost:8081")
@RestController


public class MyController {

	@Autowired
	private MATMUserOnboardJpaRepository matmOnboardRepo;
	@Autowired
	private FileService fileService;
	@Autowired
	Environment env;

	@GetMapping("/")
	public String userNameUpdate() {
		return "Starting ";
	}

	@PostMapping("/uplaodExcellData")
	public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file)
	{
		
		
		    String message = "";

		    if (ExcelHelper.hasExcelFormat(file)) {
		      try {
		        fileService.uploadExcellFile(file);

		        message = "Uploaded the file successfully: " + file.getOriginalFilename();
		        return ResponseEntity.status(HttpStatus.OK).body(message);
		      } catch (Exception e) {
		        message = "Could not upload the file: " + file.getOriginalFilename() + "!";
		        return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(message);
		      }
		    }

		    message = "Please upload an excel file!";
		    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
		  }
		
	
	
	@PostMapping("/updatestatus")
	public ResponseEntity<?> getUserData(@RequestBody UserRequest requestpojo) {
		List<String> usernamelist = requestpojo.getUsername();
		MATMUserOnboard matmUserOnboard = new MATMUserOnboard();
		if (usernamelist.size() != 0) {
			for (String userName : usernamelist) {

				matmUserOnboard.setUsername(userName);
				System.out.println(userName);
				sendUserData(matmUserOnboard);

			}
			return ResponseEntity.status(HttpStatus.OK).body("userDataUpdated SuccessFully");
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("please provide  ListOf Username");
	}

	
	

	private void sendUserData(MATMUserOnboard matmUserOnboard) {
		try {
			MATMUserOnboard matmonbaors = matmOnboardRepo.findFirstByUsername(matmUserOnboard.getUsername());
			System.out.println(matmonbaors.toString());
			
			matmonbaors.setOnboardingStatus("INITIATED");
			matmOnboardRepo.save(matmonbaors);
			System.out.println("After Onboarding status change status is:" + matmonbaors.getOnboardingStatus());

		} catch (Exception e) {
			System.out.println("Exception Occured");
		}
	}

}