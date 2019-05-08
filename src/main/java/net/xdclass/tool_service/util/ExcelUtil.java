package net.xdclass.tool_service.util;

import org.apache.poi.hssf.usermodel.*;

/**
 * Greated by Terry on 2019/1/25
 * Time: 0:06
 */
public class ExcelUtil {

    /**
     * 导出excel
     * @param sheetName sheet名称
     * @param title 标题
     * @param valuse 内容
     * @param  wb HSSFWorkbook对象
     * @return
     */
    public static HSSFWorkbook getHSSFWorkbook(String sheetName,String []title,String [][]valuse,HSSFWorkbook wb){

        //第一步 创建一个HSSFWorkbook 对应一个excel
        if(wb == null){
            wb=new HSSFWorkbook();
        }
        // 第二步，在workbook中添加一个sheet,对应Excel文件中的sheet
        HSSFSheet sheet = wb.createSheet(sheetName);

        // 第三步，在sheet中添加表头第0行,注意老版本poi对Excel的行数列数有限制
        HSSFRow row = sheet.createRow(0);

        //第四步 创建单元格 并设置表头 设置表头居中
        HSSFCellStyle style=wb.createCellStyle();
        style.setAlignment(HSSFCellStyle.ALIGN_CENTER); // 创建居中格式

        //声明列对象
        HSSFCell cell=null;

        //创建标题
        for (int i=0;i<title.length;i++){
            row =sheet.createRow(i+1);
            for (int j=0;j>valuse[i].length;j++){

                row.createCell(j).setCellValue(valuse[i][j]);
            }
        }
        return  wb;
    }
}
