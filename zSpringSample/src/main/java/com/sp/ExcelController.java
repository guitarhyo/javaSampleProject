package com.sp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.common.ExcelMultiSheetView;
import com.common.ExcelView;

@Controller
public class ExcelController {

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;
	

	//http://jxls.sourceforge.net/getting_started.html
	//http://greatkim91.tistory.com/72
	//http://syaku.tistory.com/301
	
	/**
	 * @param response
	 * @param reqData
	 * @param model
	 * @return
	 * @throws Exception
	 * 
	 */
	@RequestMapping(value = "/api/excel")
	public View excel(final HttpServletResponse response,
			@RequestParam(value = "reqData", required = false, defaultValue = "") final String reqData, final Model model) throws Exception {

		try {
			//데이터 만들기
			List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
			
			HashMap<String, Object> obj = null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

			
			
			obj = new HashMap<String, Object>();
			obj.put("name", "홍길동");
			obj.put("age", "20");
			obj.put("address", "서울시");
			list.add(obj);
			
			obj = new HashMap<String, Object>();
			obj.put("name", "슈퍼맨");
			obj.put("age", "30");
			obj.put("address", "경기도");
			list.add(obj);
			
			obj = new HashMap<String, Object>();
			obj.put("name", "배트맨");
			obj.put("age", "40");
			obj.put("address", "인천");
			list.add(obj);
			
			model.addAttribute("list", list);
			model.addAttribute("count", list.size());
			model.addAttribute("DownloadDate", sdf.format(new Date()));
	

		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return new ExcelView();

	}

	
	@RequestMapping(value = "/api/excelMulti")
	public View excel2(final HttpServletResponse response,
			@RequestParam(value = "reqData", required = false, defaultValue = "") final String reqData, final Model model) throws Exception {

		try {
			//데이터 만들기
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
			
			List<HashMap<String, Object>> sheetMaps = new ArrayList<HashMap<String, Object>>();//시트리스트
			HashMap<String, Object> sheetMap = new HashMap<String, Object>();//각시트단위
			
			HashMap<String, Object> data = new HashMap<String, Object>();
			List<HashMap<String, Object>> dataList = new ArrayList<HashMap<String, Object>>();
			
			List<String> sheetNames = new ArrayList<String>();//시트 이름 리스트
			
			sheetNames.add("홍길동");
			data = new HashMap<String, Object>();
			data.put("name", "홍길동");
			data.put("age", "20");
			data.put("address", "서울시");
			dataList.add(data);
			
			data = new HashMap<String, Object>();
			data.put("name", "홍길동");
			data.put("age", "22");
			data.put("address", "경기도");
			dataList.add(data);
			
			sheetMap = new HashMap<String, Object>();
			sheetMap.put("dataList", dataList);
			sheetMap.put("count", dataList.size());
			sheetMap.put("DownloadDate", sdf.format(new Date()));
			sheetMaps.add(sheetMap);
			
			sheetNames.add("배트맨");
			data = new HashMap<String, Object>();
			dataList = new ArrayList<HashMap<String, Object>>();
			 
			data.put("name", "배트맨");
			data.put("age", "30");
			data.put("address", "경기도");
			dataList.add(data);
			sheetMap = new HashMap<String, Object>();
			sheetMap.put("dataList", dataList);
			sheetMap.put("count", dataList.size());
			sheetMap.put("DownloadDate", sdf.format(new Date()));
			sheetMaps.add(sheetMap);
			
			
			sheetNames.add("슈퍼맨");
			data = new HashMap<String, Object>();
			 dataList = new ArrayList<HashMap<String, Object>>();
			data.put("name", "슈퍼맨");
			data.put("age", "20");
			data.put("address", "부산");
			dataList.add(data);
			sheetMap = new HashMap<String, Object>();
			sheetMap.put("dataList", dataList);
			sheetMap.put("count", dataList.size());
			sheetMap.put("DownloadDate", sdf.format(new Date()));
			sheetMaps.add(sheetMap);
			
			model.addAttribute("sheetMaps",sheetMaps);
			model.addAttribute("sheetNames",sheetNames);
		} catch (Exception e) {
		e.printStackTrace();
		}
		
		return new ExcelMultiSheetView();

	}
	
	
	@RequestMapping(value = "/api/excelPoi")//apache poi
	public void excel3(final HttpServletResponse response,
			@RequestParam(value = "reqData", required = false, defaultValue = "") final String reqData, final Model model) throws Exception {
		
		//데이터 만들기
		List<HashMap<String, Object>> list = new ArrayList<HashMap<String, Object>>();
		
		HashMap<String, Object> obj = null;
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");

		
		
		obj = new HashMap<String, Object>();
		obj.put("name", "홍길동");
		obj.put("age", 20);
		obj.put("address", "서울시");
		list.add(obj);
		
		obj = new HashMap<String, Object>();
		obj.put("name", "슈퍼맨");
		obj.put("age", 30);
		obj.put("address", "경기도");
		list.add(obj);
		
		obj = new HashMap<String, Object>();
		obj.put("name", "배트맨");
		obj.put("age", 40);
		obj.put("address", "인천");
		list.add(obj);
		
	
		XSSFWorkbook swb = null;
		FileOutputStream fileOut = null;
		String sample = "/excel/sample3.xlsx";// 클래스패스에 있는 Resource 경로 
		
		//tamplate 가져오기
		ClassPathResource resource = new ClassPathResource(sample);
		File fromFile = resource.getFile();
		swb = new XSSFWorkbook(new FileInputStream(fromFile));
		
		try {
			//cell 스타일 적용
			XSSFCellStyle style = swb.createCellStyle();
//			XSSFDataFormat format = swb.createDataFormat();
			Font font = swb.createFont();
			font.setFontHeightInPoints((short) 11);
			font.setFontName("돋움");
			style.setAlignment(CellStyle.ALIGN_CENTER);
			style.setVerticalAlignment((CellStyle.VERTICAL_CENTER));
			style.setFont(font);
//			style.setDataFormat(format.getFormat("0.0"));
			
			XSSFRow orgRow = null;
			XSSFRow newRow = null;
			XSSFSheet sheet = null;
			
			//시트별 추출
			for (int i = 0; i < list.size(); i++) {
				// Sheet Copy
				swb.cloneSheet(0);
				swb.setSheetName(swb.getNumberOfSheets() - 1, "sheetcopy"+i);//복사 대상 시트 이름
				sheet = swb.getSheet("sheetcopy"+i); //대상 시트 가져오기
				
				
				//날짜와 총회수입력 부분 row 와 cell에 마추어 값을 넣는다.
				sheet.getRow(0).getCell(0).setCellValue("다운일시 : " +sdf.format(new Date())); 
				sheet.getRow(3).getCell(1).setCellValue(2+"개"); 
				
				
				//기존 row에 입력한다.
				orgRow = sheet.getRow(6); //데이터 입력할 부분 row 가져오기
				
				obj = new HashMap<String, Object>();
				obj = list.get(i);
				String name = (String) obj.get("name");
				int age = (int) obj.get("age");
				String address = (String) obj.get("address");
				
				orgRow.getCell(0).setCellValue(name);
				orgRow.getCell(1).setCellValue(age);
				orgRow.getCell(2).setCellValue(address);
				
				
				//새로운 row와 cell을 만든다.
				newRow = sheet.createRow(7);
				newRow.setHeight(orgRow.getHeight());
				for (int k = 0; k < orgRow.getLastCellNum(); k++) {
					newRow.createCell(k);
					newRow.getCell(k).setCellStyle(orgRow.getCell(k).getCellStyle());
				}
				//병합 해보기
				sheet.addMergedRegion(new CellRangeAddress(7, 7, 2, 3)); //시작 행번호,마지막 행번호,시작 열번호,마지막 열번호
				
				newRow.getCell(0).setCellValue(name);
				newRow.getCell(1).setCellValue(age);
				orgRow.getCell(2).setCellValue(address);
				
				//엑셀 함수넣보기
				sheet.getRow(8).getCell(1).setCellFormula("SUM(B7:B8)"); //합계넣보기
				
				sheet.setActiveCell("A1"); //커서 이동
			}
			
			swb.removeSheetAt(0);
			swb.setActiveSheet(0);//sample sheet 삭제
			
			
			
			this.response.setContentType("application/octet-stream; charset=UTF-8");
			this.response.setHeader("Content-Disposition", "attachment; filename=\"" + URLEncoder.encode("apache_poi_테스트.xlsx", "UTF-8").replace("+", "%20") + "\"");
			this.response.setHeader("Content-Transfer-Encoding", "binary");
			swb.write(response.getOutputStream());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (swb != null) {
					swb.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

			try {
				if (fileOut != null) {
					fileOut.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	
	}
}
