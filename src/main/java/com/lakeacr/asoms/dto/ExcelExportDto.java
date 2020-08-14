/**
 * 
 */
package com.lakeacr.asoms.dto;

import java.util.List;

/**
 * @author SURAJ CHANDEL
 *
 */
public class ExcelExportDto {
	String fileName;
	String sheetName;
	String heading;
	List<String> header;
	List<List<Object>> data;

	public ExcelExportDto() {
    }

	public ExcelExportDto(ExcelExportDto exportCommand) {
        this.fileName = exportCommand.getFileName();
        this.sheetName = exportCommand.getSheetName();
        this.header = exportCommand.getHeader();
        this.data = exportCommand.getData();
    }

	public ExcelExportDto(String fileName, String sheetName, List<String> header, List<List<Object>> data) {
        this.fileName = fileName;
        this.sheetName = sheetName;
        this.header = header;
        this.data = data;
    }

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getSheetName() {
		return sheetName;
	}

	public void setSheetName(String sheetName) {
		this.sheetName = sheetName;
	}

	public String getHeading() {
		return heading;
	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public List<String> getHeader() {
		return header;
	}

	public void setHeader(List<String> header) {
		this.header = header;
	}

	public List<List<Object>> getData() {
		return data;
	}

	public void setData(List<List<Object>> data) {
		this.data = data;
	}
}
