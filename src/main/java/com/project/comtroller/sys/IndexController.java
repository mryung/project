package com.project.comtroller.sys;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.comtroller.BasicController;
import com.project.entity.Node;

@Controller
@RequestMapping(value="hello")
public class IndexController extends BasicController{
	
	@ResponseBody
	@RequestMapping(value="index",method=RequestMethod.POST)
	public Node index(){
		List<Node> nodes = new LinkedList<Node>();
		
		nodes.add(new Node(1,0, "节点1"));
		nodes.add(new Node(2,0, "节点2"));
		nodes.add(new Node(3,0, "节点3"));
		
		nodes.add(new Node(4,1, "2节点1"));
		nodes.add(new Node(5,1, "2节点1"));
		nodes.add(new Node(6,1, "2节点1"));
		
		nodes.add(new Node(10,4, "2节点1"));
		nodes.add(new Node(11,4, "2节点1"));
		
		nodes.add(new Node(7,5, "2节点1"));
		nodes.add(new Node(8,5, "2节点1"));
		nodes.add(new Node(9,5, "2节点1"));
		
		Node tree = new Node(-1, -1, "根节点");
		makeTree(tree, 0, nodes);
		return tree;
		
	}
	
	@RequestMapping(value="/index",method=RequestMethod.GET)
	public String index(Map<String, Object> map){
		return html("/index", map);
	}
	
	@RequestMapping(value="/test",method=RequestMethod.GET)
	public String test(Map<String, Object> map){
		return html("/test", map);
	}
	
	public static void makeTree(Node tree,int parentid,List<Node> nodes){
		for(int i = 0; i < nodes.size();i++) {
			Node node = nodes.get(i);
			if(node.parentid == parentid){
				tree.addChildren(node);
				nodes.remove(i);
				i--;
				makeTree(node, node.id, nodes);
			}
		}
	}
}
