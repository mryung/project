package project;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Test1 {

	
	public static void main(String[] args) throws JsonProcessingException {
		Entity2 entity2 = new Entity2();
		
//		ObjectMapper mapper = new ObjectMapper();
		ObjectMapper mapper = new ObjectMapper();
		String string = mapper.writeValueAsString(entity2);
		
		System.out.println(string);
		
		Date date = new Date(1488098369780L);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(dateFormat.format(date));
	}
}

class Entity1{
	int id = 1;
	String name = "hello1";
	Date date = new Date();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}

class Entity2{
	int id = 2;
	String name = "hello2";
	Date date = new Date();
	Entity1 entity1 = new Entity1();
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Entity1 getEntity1() {
		return entity1;
	}
	public void setEntity1(Entity1 entity1) {
		this.entity1 = entity1;
	}
	
}
