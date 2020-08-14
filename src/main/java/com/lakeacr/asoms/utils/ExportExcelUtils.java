/**
 * 
 */
package com.lakeacr.asoms.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;

import com.lakeacr.asoms.dto.ExcelExportDto;

/**
 * @author SURAJ CHANDEL
 *
 */
public class ExportExcelUtils {

	public static void downloadExcelFile(HttpServletRequest request, HttpServletResponse response, ExcelExportDto excelList) {
        HSSFWorkbook workbook = new HSSFWorkbook();

        //Create workbook style map
        Map<String, CellStyle> styles = createStyles(workbook);

        // Create a new worksheet in the workbook and name the worksheet "sheet"
        HSSFSheet sheet = workbook.createSheet(excelList.getSheetName());
        sheet.setAutobreaks(true);
        sheet.setDisplayGridlines(false);
        sheet.setPrintGridlines(false);
        sheet.setFitToPage(true);

        // Set title in excel sheet
        HSSFRow titleRow = sheet.createRow((short) 0);
        titleRow.setHeightInPoints(50);
        HSSFCell titleCell = titleRow.createCell((short) 0);
        // sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$N$1"));
        sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, excelList.getHeader().size()));
        titleCell.setCellValue(excelList.getHeading()!= null ? excelList.getHeading() : excelList.getSheetName());

        // Set title style
        titleCell.setCellStyle(styles.get("title"));

        // Create header row
        HSSFRow headerRow = sheet.createRow((short) 1);
        headerRow.setHeightInPoints(20);
        HSSFCell srNoCell = headerRow.createCell((short) 0);
        srNoCell.setCellValue("Sr. No.");
        srNoCell.setCellStyle(styles.get("header"));
        for (int i = 0; i < excelList.getHeader().size(); i++) {
            HSSFCell cell = headerRow.createCell((short) (i + 1));
            cell.setCellValue(excelList.getHeader().get(i)+"");
            cell.setCellStyle(styles.get("header"));
        }

        int j = 2;
        for (List<Object> data : excelList.getData()) {
            HSSFRow dataRow = sheet.createRow((short) j);
            dataRow.setHeightInPoints(16);
            HSSFCell srNoRow = dataRow.createCell((short) 0);
            srNoRow.setCellStyle(styles.get("srNoRow" + (j % 2 + 1)));
            srNoRow.setCellValue(j - 1);
            for (int i = 0; i < data.size(); i++) {
                HSSFCell cell = dataRow.createCell((short) (i + 1));
                if (data.get(i) != null && !data.get(i).equals("")) {
                    if (data.get(i).getClass().getName().equals("java.lang.Integer")) {
                        cell.setCellValue(new Integer((Integer) data.get(i)));
                    } else if (data.get(i).getClass().getName().equals("java.lang.Double")) {
                        cell.setCellValue(new Double((Double) data.get(i)));
                    } else if (data.get(i).getClass().getName().equals("java.lang.Long")) {
                        cell.setCellValue(new Long((Long) data.get(i)));
                    } else {
                        String value = data.get(i).toString();
                        if (checkNumber(value) == true) {
                            cell.setCellValue(Long.valueOf(value));
                        } else {
                            cell.setCellValue(value);
                        }
                    }
                } else {
                    cell.setCellValue("");
                }
                cell.setCellStyle(styles.get("row" + (j % 2 + 1)));
            }
            j++;
        }

        // Set footer in excel sheet
        HSSFRow footerRow = sheet.createRow((short) j);
        footerRow.setHeightInPoints(30);
        HSSFCell footerCell = footerRow.createCell((short) 0);
        // sheet.addMergedRegion(CellRangeAddress.valueOf("$A$1:$N$1"));
        sheet.addMergedRegion(new CellRangeAddress(j, j, 0, excelList.getHeader().size()));
        footerCell.setCellValue("Note : Total " + excelList.getData().size() + " records available in this file & exported on " + new java.util.Date());

        // Set title style
        footerCell.setCellStyle(styles.get("footer"));

//        sheet.autoSizeColumn(5);
        for (int i = 0; i <= excelList.getHeader().size(); i++) {
            sheet.autoSizeColumn(i);
        }

        // Put some content in the cell
        response.setContentType("application/vnd.ms-excel");

        response.setHeader("Content-Disposition", "attachment; filename=" + excelList.getFileName() + ".xls");
//FileOutputStream stream;

        try {
            OutputStream out = response.getOutputStream();
            workbook.write(out);
            out.flush();
            out.close();

        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    private static Map<String, CellStyle> createStyles(Workbook wb) {
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        short borderColor = IndexedColors.GREY_50_PERCENT.getIndex();
        CellStyle style;
        Font titleFont = wb.createFont();
        titleFont.setFontHeightInPoints((short) 30);
        titleFont.setColor(IndexedColors.DARK_BLUE.getIndex());
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(titleFont);
        styles.put("title", style);

        Font headerFont = wb.createFont();
      
        headerFont.setFontHeightInPoints((short) 12);
        headerFont.setColor(IndexedColors.WHITE.getIndex());
        headerFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setFont(headerFont);
        styles.put("header", style);

        Font footerFont = wb.createFont();
        footerFont.setFontHeightInPoints((short) 9);
        footerFont.setColor(IndexedColors.GREY_50_PERCENT.getIndex());
        footerFont.setItalic(true);
        style = wb.createCellStyle();
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFont(footerFont);
        styles.put("footer", style);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("row1", style);

        style = wb.createCellStyle();
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("srNoRow1", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("row2", style);

        style = wb.createCellStyle();
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setRightBorderColor(borderColor);
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(borderColor);
        styles.put("srNoRow2", style);

        return styles;
    }

    public static boolean checkNumber(String value) {
        if (!value.equals("")) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            //If we find a non-digit character we return false.
            if (!Character.isDigit(value.charAt(i))) {
                return false;
            }
        }

        return true;
    }
}
