package com.project.comtroller.sys;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.message.Message;
import com.project.comtroller.BasicController;
import com.project.service.MenuService;

@Controller
@RequestMapping(value="/sys/frame")
public class FrameController extends BasicController {
	
	@Autowired
	private MenuService menuService;
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String frame(Map<String,Object> map){
		
		return html("/sys/frame/index", map);
	}
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String hello(Map<String,Object> map){
		
		return html("hello", map);
	}
	
	@ResponseBody
	@RequestMapping(value="/menu",method=RequestMethod.POST)
	public Map<String,Object> menu(){
		Message message = Message.newMessage();
		message.put("tree", menuService.findMenu(1));
		return json(0, "", message);
	}
	@RequestMapping(value="/welcome",method=RequestMethod.GET)
	public String welcome(Map<String,Object> map){
		return html("welcome", map);
	}
}
