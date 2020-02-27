package util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteExcelFile {

	private static final String CEP_FILE = "src/test/resources/excel-output/PesquisaCep.xlsx";
	private static final String LOGRADOURO_FILE = "src/test/resources/excel-output/PesquisaLogradouro.xlsx";
	
	public void criarArquivoCep(ArrayList<String> listColuna, ArrayList<String> listLinha) {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("CEP");
		int rowNum = 0;
		
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

		Row row = sheet.createRow(rowNum++);
		int colNum = 0;
		Cell cell;
		
		for(int j = 0; j < listColuna.size(); j++) {
			cell = row.createCell(colNum++);
			cell.setCellValue((String) listColuna.get(j));
			cell.setCellStyle(headerCellStyle);
		}
		
		row = sheet.createRow(rowNum++);
		colNum = 0;
		
		for(int i = 0; i < listLinha.size(); i++) {
			cell = row.createCell(colNum++);
			cell.setCellValue((String) listLinha.get(i));
			if(listLinha.size() == i) {
				i = 0;
				cell = row.createCell(colNum++);
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(CEP_FILE);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Planilha CEP Criada!");
	}
	
	public void criarArquivoLogradouro(ArrayList<String> listColuna, ArrayList<String> listLinha) {
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Logradouro");
		
		int rowNum = 0;
		
        Font headerFont = workbook.createFont();
        headerFont.setBold(true);
        headerFont.setFontHeightInPoints((short) 14);
        headerFont.setColor(IndexedColors.BLACK.getIndex());

        CellStyle headerCellStyle = workbook.createCellStyle();
        headerCellStyle.setFont(headerFont);

		Row row = sheet.createRow(rowNum++);
		int colNum = 0;
		Cell cell;
		
		for(int j = 0; j < listColuna.size(); j++) {
			cell = row.createCell(colNum++);
			cell.setCellValue((String) listColuna.get(j));
			cell.setCellStyle(headerCellStyle);
		}
		
		row = sheet.createRow(rowNum++);
		colNum = 0;
		int k = 0;
		for(int i = 0; i < listLinha.size(); i++) {
			cell = row.createCell(colNum++);
			cell.setCellValue((String) listLinha.get(i));
			k++;
			if(k == listColuna.size()) {
				row = sheet.createRow(rowNum++);
				colNum = 0;
				k = 0;
			}
		}

		try {
			FileOutputStream outputStream = new FileOutputStream(LOGRADOURO_FILE);
			workbook.write(outputStream);
			workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Planilha Logradouro Criada!");
	}

}
