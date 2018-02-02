package com.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.servlet.view.document.AbstractXlsxStreamingView;

import net.sf.jxls.transformer.XLSTransformer;

public class ExcelMultiSheetView extends AbstractXlsxStreamingView {

	private static final String sample = "/excel/sample2.xlsx";// 클래스패스에 있는 Resource 경로 
	
	@Override
	protected void buildExcelDocument(final Map<String, Object> model, final Workbook workbook, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {

		OutputStream os = null;
		InputStream is = null;
		List<HashMap<String, Object>> sheetMaps = (List<HashMap<String, Object>>) model.get("sheetMaps");
		List<String> sheetNames =  (List<String>) model.get("sheetNames");

		try {
			String fileName = "엑셀_멀티_시트";
		
			is = new ClassPathResource(sample).getInputStream();
			
			response.setHeader("Content-Type", "application/octet-stream");
			response.setHeader("Content-Disposition", "attachment; filename=" +  URLEncoder.encode(fileName, "UTF-8") + ".xlsx");//한글은 인코딩 필요

			os = response.getOutputStream();

			XLSTransformer transformer = new XLSTransformer();

//			Workbook excel = transformer.transformXLS(is, model);
			Workbook excel = transformer.transformMultipleSheetsList(is, sheetMaps, sheetNames, "sheetMap", new HashMap(), 0);
			
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
