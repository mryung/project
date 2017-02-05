package com.project.entity;

import java.util.LinkedList;
import java.util.List;

public class Node{
	public int id;
	public int parentid;
	public String node;
	
	public List<Node> children;

	public Node(int id,int parentid, String node) {
		this.id = id;
		this.parentid = parentid;
		this.node = node;
	}
	
	public void addChildren(Node node){
		if(children == null){
			children = new LinkedList<Node>();
		}
		children.add(node);
	}
}