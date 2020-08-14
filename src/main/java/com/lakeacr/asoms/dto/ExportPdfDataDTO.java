package com.lakeacr.asoms.dto;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public class ExportPdfDataDTO {
	
	private String heading;
	private String fileName;
	private List<String> tableHeading = new ArrayList<String>();
	private ArrayList<ArrayList<Object>> data = new ArrayList<ArrayList<Object>>();

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<String> getTableHeading() {
		return tableHeading;
	}

	public void setTableHeading(List<String> tableHeading) {
		this.tableHeading = tableHeading;
	}

	public ArrayList<ArrayList<Object>> getData() {
		return data;
	}

	public void setData(ArrayList<ArrayList<Object>> data) {
		this.data = data;
	}
}