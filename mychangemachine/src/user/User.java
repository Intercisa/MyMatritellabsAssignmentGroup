package user;

import data.Data;
import writer.CMWritable;
import writer.Writer;

public class User implements CMWritable {
	
	private String name;
	private Data data;

	
	public static User getUserInstance(String name) {
		return new User(name);
	}
	
	private User(String name) {this.name = name;}
	
	public String getName() {return name;}
	public Data getData() {return data;}
	public void setData(Data data) {this.data = data;}
	
	


	@Override
	public String getFileName() {return this.getName();}
	
	@Override
	public String getWritableInformation() {
		System.out.println(this.name + data.getInfo());
		return this.name +" "+ data.getInfo();
		

	}

	@Override
	public void persist() {
		if(Writer.persisitUser(this) == 1) 
			System.out.println("User saved!");
		else
			System.out.println("Something went wrong");
				
	}	

}
