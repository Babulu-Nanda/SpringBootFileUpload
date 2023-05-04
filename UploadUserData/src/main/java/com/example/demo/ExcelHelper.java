package com.example.demo;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.web.multipart.MultipartFile;

import org.springframework.web.multipart.MultipartFile;

public class ExcelHelper {
	public static String TYPE = "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet";
	static String[] HEADERs = { "id", "Username", "companycode", "mobilenumber", "merchantname", "pannumber",
			"district", "state", "postalcode", "createdDate", "updatedDate", "aadharFrontUrl",
			"aadharBackUrl", "panUrl", "onboardingStatus", "remarks", "Merchant Id" };
	static String SHEET = "Sheet1";

	public static boolean hasExcelFormat(MultipartFile file) {

		if (!TYPE.equals(file.getContentType())) {
			return false;
		}

		return true;
	}

	public static List<MATMUserOnboard> excelToTutorials(InputStream is)  {
		try {
			Workbook workbook = new XSSFWorkbook(is);

			Sheet sheet = workbook.getSheet(SHEET);
			Iterator<Row> rows = sheet.iterator();

			List<MATMUserOnboard> tutorials = new ArrayList<MATMUserOnboard>();

			int rowNumber = 0;
			while (rows.hasNext()) {
				Row currentRow = rows.next();

				// skip header
				if (rowNumber == 0) {
					rowNumber++;
					continue;
				}

				Iterator<Cell> cellsInRow = currentRow.iterator();

				MATMUserOnboard tutorial = new MATMUserOnboard();

				int cellIdx = 0;
				while (cellsInRow.hasNext()) {
					Cell currentCell = cellsInRow.next();

					switch (cellIdx) {
					case 0:
						System.out.println("Id="+(long) currentCell.getNumericCellValue());
						tutorial.setId((long) currentCell.getNumericCellValue());
						break;
					case 1:
						System.out.println("Username="+currentCell.getStringCellValue());
						tutorial.setUsername(currentCell.getStringCellValue());
						break;

					case 2:
						System.out.println("CompanyCode="+(long)currentCell.getNumericCellValue());
						tutorial.setCompanyCode(String.valueOf((long)currentCell.getNumericCellValue()));
						break;
					case 3:
						System.out.println("MobileNo"+(long)(currentCell.getNumericCellValue()));
						
						tutorial.setMobilenumber(String.valueOf((long)currentCell.getNumericCellValue()));
						break;

					case 4:
						System.out.println("MerchantName="+(currentCell.getStringCellValue()));
						tutorial.setMerchantname(currentCell.getStringCellValue());
						break;

					case 5:
						System.out.println("Pan No="+currentCell.getStringCellValue());
						tutorial.setPannumber(currentCell.getStringCellValue());
						break;

					case 6:
						System.out.println("District="+currentCell.getStringCellValue());
						tutorial.setDistrict(currentCell.getStringCellValue());
						break;

					case 7:
						System.out.println("State="+currentCell.getStringCellValue());
						tutorial.setState(currentCell.getStringCellValue());
						break;

					case 8:
						System.out.println("PostalCode="+currentCell.getNumericCellValue());
						tutorial.setPostalcode(String.valueOf((long)currentCell.getNumericCellValue()));
						break;

					case 9:
						System.out.println("CreatedDate="+currentCell.getDateCellValue());
						DateFormat format = new SimpleDateFormat("dd-mm-yyyy HH:mm:ss z");
						tutorial.setCreatedDate(currentCell.getDateCellValue());
						break;
					case 10:
						System.out.println("UpdateDate="+currentCell.getDateCellValue());
						tutorial.setUpdatedDate(currentCell.getDateCellValue());
						break;

					case 11:
						tutorial.setAadharFrontUrl(currentCell.getStringCellValue());
						break;

					case 12:
						tutorial.setAadharBackUrl(currentCell.getStringCellValue());
						break;
					case 13:
						tutorial.setPanUrl(currentCell.getStringCellValue());
						break;

					case 14:
						tutorial.setOnboardingStatus(currentCell.getStringCellValue());
						break;

					case 15:
						tutorial.setRemarks(currentCell.getStringCellValue());
						break;
					case 16:
						System.out.println("MerchantId="+(long)currentCell.getNumericCellValue());
						tutorial.setMerchantid(String.valueOf((long)currentCell.getNumericCellValue()));
						break;

					default:
						break;
					}

					cellIdx++;
				}

				tutorials.add(tutorial);
			}

			workbook.close();

			return tutorials;
		} catch (Exception e) {
			throw new RuntimeException("fail to parse Excel file: " + e.getMessage());
		}
	}
}
