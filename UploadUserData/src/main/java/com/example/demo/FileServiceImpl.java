package com.example.demo;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
@Service
public class FileServiceImpl  implements FileService{

	@Autowired
	private MATMUserOnboardJpaRepository matmOnboardRepo;

	@Override
	public void uploadExcellFile(MultipartFile file) {
		 try {
			 BufferedWriter bufferedWriter=null;
			 List<String> onboardExcell=new ArrayList<>();
		      List<MATMUserOnboard> onboardExcellData = ExcelHelper.excelToTutorials(file.getInputStream());
		     
		      System.out.println("Size of ExcellData="+onboardExcellData.size());
		      for (MATMUserOnboard  matmonboard : onboardExcellData) {

					String userName=matmonboard.getUsername();
					System.out.println(userName);
					MATMUserOnboard onboarddata=sendUserData(matmonboard);
					if(onboarddata==null) {
						matmOnboardRepo.save(matmonboard);
						System.out.println("Saved Data:"+matmonboard.toString());
					}

					if(onboarddata.getRemarks().equals("REGISTRATIONDATA")) {
						onboardExcell.add("Username:"+onboarddata.getUsername()+",MerchantId:"+onboarddata.getMerchantid());
						
					}
					
				}
		      FileWriter fileWriter=null;
		      System.out.println("Exception OccureSie=="+onboardExcell.size());
		      for(String matmonbaors1:onboardExcell) {
		    	  
		    	  Path output = Paths.get("d:/sampleFile.txt");
		    	 //fileWriter = new FileWriter("d:/sampleFile.txt");
		    	 Files.writeString(output, matmonbaors1+System.lineSeparator(),StandardOpenOption.APPEND );
		    	 
		    	  
		    	 
		         System.out.println(output.toFile().getAbsolutePath());
			System.out.println("");
			System.out.println("write this user Data"+matmonbaors1);
			
			//matmOnboardRepo.save(matmonbaors);
		      }
		   
			fileWriter.close();
		     
		      

		      
		      
		      
		    } catch (IOException e) {
		     System.out.println("fail to store excel data: ");
		    }
		  }
		
	


private MATMUserOnboard sendUserData(MATMUserOnboard matmUserOnboard) throws IOException {
	MATMUserOnboard matmonbaors=null;
	
	try {
		matmonbaors = matmOnboardRepo.findFirstByUsername(matmUserOnboard.getUsername());
		System.out.println(matmonbaors.toString());
		matmonbaors.setOnboardingStatus("COMPLETED");
		matmonbaors.setMerchantid(matmUserOnboard.getMerchantid());
		matmOnboardRepo.save(matmonbaors);
		//System.out.println("After Onboarding status change status is:" + matmonbaors.getOnboardingStatus());
		return matmonbaors;

	} catch (Exception e) {
		System.out.println("Exception Occured");
		matmonbaors.setRemarks("REGISTRATIONDATA");
		 
	
		
		return matmonbaors; 
		
	}
}

}
