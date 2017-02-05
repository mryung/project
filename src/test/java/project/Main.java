package project;

import java.sql.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		List<Node> nodes = new LinkedList<Node>();
		
		nodes.add(new Node(1,0, "节点1"));
		nodes.add(new Node(2,0, "节点2"));
		nodes.add(new Node(3,0, "节点3"));
		
		nodes.add(new Node(4,1, "2节点1"));
		nodes.add(new Node(5,1, "2节点1"));
		nodes.add(new Node(6,1, "2节点1"));
		
//		nodes.add(new Node(7,5, "2节点1"));
//		nodes.add(new Node(8,5, "2节点1"));
//		nodes.add(new Node(9,5, "2节点1"));
		
//		List<Node> tree = new LinkedList<Node>();
//		makeTree(tree, 0, nodes);
		Node tree = new Node(-1, -1, "根节点");
		makeTree(tree, 0, nodes);
		System.out.println(tree.children.size());
		
	}
	
//	public static void makeTree(List<Node> tree,int parentid,List<Node> nodes){
//		Iterator<Node> iterator = nodes.iterator();
//		while(iterator.hasNext()) {
//			Node node = iterator.next();
//			if(node.parentid == parentid){
//				if(tree == null){
//					tree = new LinkedList<Node>();
//				}
//				tree.add(node);
////				nodes.remove(node);
//				makeTree(node.children, node.id, nodes);
//			}
//		}
//	}
	
	public static void makeTree(Node tree,int parentid,List<Node> nodes){
//		Iterator<Node> iterator = nodes.iterator();
//		while(iterator.hasNext()) {
//			Node node = iterator.next();
//			if(node.parentid == parentid){
//				tree.addChildren(node);
////				iterator.remove();
//				makeTree(node, node.id, nodes);
//			}
//		}
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

class Node{
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