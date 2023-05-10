package io.bootify.my_app.route;

import java.io.ByteArrayOutputStream;
import java.util.List;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

//@Component
public class CsvToExcelRoute extends RouteBuilder {

	@Value("${input.directory.path}")
	private String inputDirectoryPath;

	@Value("${output.directory.path}")
	private String outputDirectoryPath;
	
	
	private static final Logger LOGGER = LoggerFactory.getLogger(CsvToExcelRoute.class);


	@Override
	public void configure() throws Exception {
		from("file:" + inputDirectoryPath + "?fileName=example.csv&noop=true&move=.completed")
				.routeId("CsvToExcelRoute")
				.log("Starting CSV to Excel route")
				.unmarshal().csv()
				.process(new Processor() {
					@Override
					public void process(Exchange exchange) throws Exception {
						List<List<String>> rows = (List<List<String>>) exchange.getIn().getBody();
						XSSFWorkbook workbook = new XSSFWorkbook();
						XSSFSheet sheet = workbook.createSheet("Sheet1");
						int rowNum = 0;
						for (List<String> row : rows) {
							Row r = sheet.createRow(rowNum++);
							int colNum = 0;
							for (String cellValue : row) {
//								Cell c = r.createCell(colNum++);
//								c.setCellValue(cellValue);
								
								Cell c = r.createCell(colNum++);
						        try {
						            double numericValue = Double.parseDouble(cellValue);
						            c.setCellValue(numericValue);
						            // Imposta il formato della cella come numerico
						             XSSFCellStyle style = workbook.createCellStyle();
						            //style.setDataFormat(workbook.createDataFormat().getFormat("0.00"));
						             style.setDataFormat(workbook.createDataFormat().getFormat("0"));
						            c.setCellStyle(style);
						        } catch (NumberFormatException e) {
						            // Se il valore non è numerico, imposta il valore della cella come testo
						            c.setCellValue(cellValue);
						        }
								
							}
						}
						ByteArrayOutputStream bos = new ByteArrayOutputStream();
						workbook.write(bos);
						exchange.getIn().setBody(bos.toByteArray());
					}
				}).to("file:" + outputDirectoryPath + "?fileName=example.xlsx");
	}
}
