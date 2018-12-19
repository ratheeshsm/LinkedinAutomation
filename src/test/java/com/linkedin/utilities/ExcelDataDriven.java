package com.linkedin.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataDriven {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

	}

	public ArrayList<String> getdata(String testCaseName) throws IOException

	{
		ArrayList<String> dataValue = new ArrayList<String>();
		FileInputStream fis = new FileInputStream("src/test/resources/com/linkedin/excel/TestData.xlsx");
		XSSFWorkbook wkBook = new XSSFWorkbook(fis);
		int numberSheet = wkBook.getNumberOfSheets();
		for (int i = 0; i < numberSheet; i++)

		{
			if (wkBook.getSheetName(i).equalsIgnoreCase("testdata"))

			{
				XSSFSheet sheet = wkBook.getSheetAt(i);
				Iterator<Row> rows = sheet.iterator();
				Row firstRow = rows.next();
				Iterator<Cell> cell = firstRow.cellIterator();
				int k = 0;
				int column = 0;
				while (cell.hasNext()) {

					Cell value = cell.next();
					if (value.getStringCellValue().equalsIgnoreCase("Testcase"))

					{
						column = k;

					}
					k++;
				}
				
				while (rows.hasNext()) {

					Row rvalue = rows.next();
					if (rvalue.getCell(column).getStringCellValue().equalsIgnoreCase(testCaseName)) {

						Iterator<Cell> cellValue = rvalue.cellIterator();
						while (cellValue.hasNext()) {

							// System.out.println(cellValue.next().getStringCellValue());

							Cell c = cellValue.next();
							
							
							if (c.getCellType() == CellType.STRING) {
								dataValue.add(c.getStringCellValue());

							}

							else {

								dataValue.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}

					}

				}

			}

		}

		return dataValue;

	}

}
