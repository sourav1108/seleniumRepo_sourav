package genericutility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {

	public String getStringDataFromExcel(String sheetName, int rowIndex, int colIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream("./src/test/resources/DemoWSebShopProject.xlsx");
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getStringCellValue();

	}

	public boolean getBooleanDataFromExcel(String sheetName, int rowIndex, int colIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis1 = new FileInputStream("./src/test/resources/DemoWSebShopProject.xlsx");
		Workbook workbook1 = WorkbookFactory.create(fis1);
		return workbook1.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getBooleanCellValue();
	}

	public double getNumericDataFromExcel(String sheetName, int rowIndex, int colIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream("./src/test/resources/DemoWSebShopProject.xlsx");
		Workbook workbook2 = WorkbookFactory.create(fis2);
		return workbook2.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getNumericCellValue();
	}

	public LocalDateTime localDateAndTime(String sheetName, int rowIndex, int colIndex)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis2 = new FileInputStream("./src/test/resources/DemoWSebShopProject.xlsx");
		Workbook workbook2 = WorkbookFactory.create(fis2);
		return workbook2.getSheet(sheetName).getRow(rowIndex).getCell(colIndex).getLocalDateTimeCellValue();
	}
}