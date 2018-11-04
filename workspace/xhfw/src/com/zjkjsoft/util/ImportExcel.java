package com.zjkjsoft.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ImportExcel {

	/*
	 * *导入EXCEL方法
	 */
	public static List<Map<Integer,Object>> importExce(String path,String excel) throws FileNotFoundException, IOException{

		return importExce( path, excel,1,0);
	}
	/*
	 * *导入EXCEL方法
	 */
	public static List<Map<Integer,Object>> importExce(String path,String excel,int x,int y) throws FileNotFoundException, IOException{
		List<Map<Integer,Object>> list = new ArrayList<Map<Integer,Object>>();
		if ("xls".equals(excel)) {
			HSSFWorkbook hwb = new HSSFWorkbook(new FileInputStream(new File(path)));
			HSSFSheet sheet = hwb.getSheetAt(0); // 获取到第一个sheet中数据
			for(int i = x;i<sheet.getLastRowNum() + 1; i++) {// 第二行开始取值，第一行为标题行
				HSSFRow row = sheet.getRow(i);// 获取到第i列的行数据(表格行)
				if (row!=null&&row.getCell(0).getCellType()!=HSSFCell.CELL_TYPE_BLANK) {
					Map<Integer, Object> map = new HashMap<Integer, Object>();
					for(int j=y;j<row.getLastCellNum(); j++) {
						HSSFCell cell = row.getCell(j);// 获取到第j行的数据(单元格)
						map.put(j, getDate(cell));
					}
					list.add(map);
				}
			}
		}else{
			XSSFWorkbook xwb = new XSSFWorkbook(new FileInputStream(new File(path)));
			XSSFSheet sheet = xwb.getSheetAt(0); // 获取到第一个sheet中数据
			for(int i = 1;i<sheet.getLastRowNum() + 1; i++) {// 第二行开始取值，第一行为标题行
				XSSFRow row = sheet.getRow(i);// 获取到第i列的行数据(表格行)
				if (row!=null&&row.getCell(0).getCellType()!=XSSFCell.CELL_TYPE_BLANK) {
					Map<Integer, Object> map = new HashMap<Integer, Object>();
					for(int j=0;j<row.getLastCellNum(); j++) {
						XSSFCell cell = row.getCell(j);// 获取到第j行的数据(单元格)
						map.put(j, getDate(cell));
					}
					list.add(map);
				}
			}
		}
		return list;
	}
	//格式化单元格中的值HSSF
	private static String getDate(HSSFCell hssfCell){
        DecimalFormat df = new DecimalFormat("#");
        if(hssfCell == null){
            return "";
        }
        switch (hssfCell.getCellType()){
        case HSSFCell.CELL_TYPE_NUMERIC:
            if(HSSFDateUtil.isCellDateFormatted(hssfCell)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                return sdf.format(HSSFDateUtil.getJavaDate(hssfCell.getNumericCellValue()));
            }

                return df.format(hssfCell.getNumericCellValue());
        case HSSFCell.CELL_TYPE_STRING:
            return hssfCell.getStringCellValue().trim();
        case HSSFCell.CELL_TYPE_FORMULA:
            return hssfCell.getCellFormula();
        case HSSFCell.CELL_TYPE_BLANK:
            return "";
        }
       return "";
    }
	
	//格式化单元格中的值XSSF
	private static String getDate(XSSFCell xssfCell){
        DecimalFormat df = new DecimalFormat("#");
        if(xssfCell == null){
            return "";
        }
        switch (xssfCell.getCellType()){
        case XSSFCell.CELL_TYPE_NUMERIC:
            if(XSSFDateUtil.isCellDateFormatted(xssfCell)){
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

                return sdf.format(XSSFDateUtil.getJavaDate(xssfCell.getNumericCellValue()));
            }

                return df.format(xssfCell.getNumericCellValue());
        case XSSFCell.CELL_TYPE_STRING:
            return xssfCell.getStringCellValue();
        case XSSFCell.CELL_TYPE_FORMULA:
            return xssfCell.getCellFormula();
        case XSSFCell.CELL_TYPE_BLANK:
            return "";
        }
       return "";
    }
}
