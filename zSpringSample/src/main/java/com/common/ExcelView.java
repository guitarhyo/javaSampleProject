package com.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import net.sf.jxls.transformer.XLSTransformer;

public class ExcelView extends AbstractXlsxStreamingView {

	private static final String sample = "/excel/sample.xlsx";// 클래스패스에 있는 Resource 경로 
	

	@Override
	protected void buildExcelDocument(final Map<String, Object> model, final Workbook workbook, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		OutputStream os = null;
		InputStream is = null;

		try {
			String fileName = "excelTest";
		
			is = new ClassPathResource(sample).getInputStream();
			
			response.setHeader("Content-Type", "application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");

			os = response.getOutputStream();

			XLSTransformer transformer = new XLSTransformer();

			Workbook excel = transformer.transformXLS(is, model);
			excel.write(os);
			os.flush();

		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e.getMessage());
		} finally {
			if (os != null) {
				try {
					os.close();
				} catch (IOException e) {
				}
			}
			if (is != null) {
				try {
					is.close();
				} catch (IOException e) {
				}
			}
		}

	}

}
