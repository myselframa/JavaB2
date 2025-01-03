package com.forgemycode.example2.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties("my.prod")
@Component
public class UsingApplicationProperties implements CommandLineRunner {
    private int id;
	private String code;
	private boolean type;
	private char model;
	private List<String> prjnm;
	private Map<String,String> mdata;
	
	
	public UsingApplicationProperties() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getCode() {
		return code;
	}


	public void setCode(String code) {
		this.code = code;
	}


	public boolean isType() {
		return type;
	}


	public void setType(boolean type) {
		this.type = type;
	}


	public char getModel() {
		return model;
	}


	public void setModel(char model) {
		this.model = model;
	}


	public List<String> getPrjnm() {
		return prjnm;
	}


	public void setPrjnm(List<String> prjnm) {
		this.prjnm = prjnm;
	}


	public Map<String, String> getMdata() {
		return mdata;
	}


	public void setMdata(Map<String, String> mdata) {
		this.mdata = mdata;
	}

	

	@Override
	public String toString() {
		return "UsingApplicationProperties [id=" + id + ", code=" + code + ", type=" + type + ", model=" + model
				+ ", prjnm=" + prjnm + ", mdata=" + mdata + "]";
	}


	@Override
	public void run(String... args) throws Exception {
            System.out.println(this.toString());		
	}
}

