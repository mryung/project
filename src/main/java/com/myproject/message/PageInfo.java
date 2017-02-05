package com.myproject.message;

import java.util.LinkedList;
import java.util.List;

public class PageInfo<E>implements java.io.Serializable {
	private static final long serialVersionUID = 7246950441990196313L;
	private int total=0;
	private List<E>rows;
	
	public PageInfo(){
	}
	public PageInfo(List<E>rows){
		if(!rows.isEmpty())
			this.total=rows.size();
		this.rows=rows;
	}
	public PageInfo(int total, List<E>rows){
		this.total=total;
		this.rows=rows;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public List<E> getRows() {
		return rows;
	}
	public void setRows(List<E> rows) {
		this.rows = rows;
	}
	public void pustRow(E row){
		if(this.rows == null){
			rows = new LinkedList<E>();
		}
		rows.add(row);
		total++;
	}
}