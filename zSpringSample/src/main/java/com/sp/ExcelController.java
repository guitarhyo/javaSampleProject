package com.sp;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;

import com.common.ExcelMultiSheetView;
import com.common.ExcelView;

@Controller
public class ExcelController {


	//http://jxls.sourceforge.net/getting_started.html
	//http://greatkim91.tistory.com/72
	//http://syaku.tistory.com/301
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
	
}
