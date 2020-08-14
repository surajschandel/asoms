package com.lakeacr.asoms.utils;

import java.util.ArrayList;
import java.util.List;

import com.lakeacr.asoms.dto.ExcelExportDto;
import com.lakeacr.asoms.dto.ExportPdfDataDTO;

/**
 * 
 * @author SURAJ CHANDEL
 *
 */
public class ExportExcelDataHadlerUtil {

	public static ExcelExportDto prepareExcelExportCommand(ExportPdfDataDTO dataDTO) {
		ExcelExportDto exportCommand;
        //Create a workbook
        exportCommand = new ExcelExportDto();
        exportCommand.setHeading(dataDTO.getHeading());
        exportCommand.setHeader(dataDTO.getTableHeading());
        exportCommand.setSheetName(dataDTO.getFileName());
        exportCommand.setFileName(dataDTO.getFileName());
        List<List<Object>> dataList = new ArrayList<List<Object>>();
        for (ArrayList<Object> data : dataDTO.getData()) {
            dataList.add(data);
        }
        exportCommand.setData(dataList);
        return exportCommand;
    }
}
