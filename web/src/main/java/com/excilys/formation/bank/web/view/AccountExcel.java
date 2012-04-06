package com.excilys.formation.bank.web.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.excilys.formation.bank.bean.Compte;
import com.excilys.formation.bank.bean.Operation;
import com.excilys.formation.bank.bean.OperationType;

public class AccountExcel extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// creation de la feuille
		HSSFSheet sheet = workbook.createSheet(((Compte) model.get("compte"))
				.getCompteId());

		// creation style gras
		CellStyle cellStyleBold = workbook.createCellStyle();
		HSSFFont Boldfont = workbook.createFont();
		Boldfont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
		cellStyleBold.setFont(Boldfont);

		// creation style date
		CellStyle cellStyleDate = workbook.createCellStyle();
		CreationHelper createHelper = workbook.getCreationHelper();
		cellStyleDate.setDataFormat(createHelper.createDataFormat().getFormat(
				"dd/MM/yyyy"));

		// creation style euro
		CellStyle cellStyleEuro = workbook.createCellStyle();
		cellStyleEuro.setDataFormat(createHelper.createDataFormat().getFormat(
				"#0.00€;[Red]-#0.00€"));

		// Creation header
		HSSFRow header = sheet.createRow(0);
		header.createCell(0).setCellValue("Date");
		header.getCell(0).setCellStyle(cellStyleBold);
		header.createCell(1).setCellValue("Type");
		header.getCell(1).setCellStyle(cellStyleBold);
		header.createCell(2).setCellValue("Libelle");
		header.getCell(2).setCellStyle(cellStyleBold);
		header.createCell(3).setCellValue("Montant");
		header.getCell(3).setCellStyle(cellStyleBold);

		// ajout des operations
		List<Operation> operations = (List<Operation>) model.get("operations");
		int rowNumber = 1;
		for (Operation operation : operations) {
			HSSFRow row = sheet.createRow(rowNumber);
			row.createCell(0).setCellValue(
					operation.getTransaction().getDateValid().toDate());
			row.getCell(0).setCellStyle(cellStyleDate);
			row.createCell(1).setCellValue(
					operation.getTransaction().getTransactionCategorie()
							.toString());
			row.createCell(2).setCellValue(
					operation.getTransaction().getLibelle());
			row.createCell(3)
					.setCellValue(
							operation.getOperationType() == OperationType.CREDIT ? operation
									.getMontant() / 100.0 : -operation
									.getMontant() / 100.0);
			row.getCell(3).setCellStyle(cellStyleEuro);
			rowNumber++;
		}

		// largeur des colones
		sheet.setColumnWidth(0, 3000);
		sheet.setColumnWidth(1, 6000);
		sheet.setColumnWidth(2, 12000);
		sheet.setColumnWidth(3, 3000);
	}

}
