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

import com.common.ExcelView;

@Controller
public class ExcelController {


	//http://jxls.sourceforge.net/getting_started.html
	//http://greatkim91.tistory.com/72
	//http://syaku.tistory.com/301
	@RequestMapping(value = "/api/excel")
	public View reportExcelDownload2(final HttpServletResponse response,
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

	
}
