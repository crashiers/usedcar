package com.cn.jhsoft.usedcar.common.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.cn.jhsoft.usedcar.common.inter.TableCells;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.hssf.util.HSSFColor;


public abstract class ExcelUtilsExport<T> implements TableCells<T> {
    private String[] excelHeaders = new String[] {};// excel表头
    private String excelName = new String(); // execl表名
    private String filePath = new String(); // 存储到本地的实际路径
    private String fileName = new String(); // 导出的文件的名字
    private HttpServletResponse response = null; //HttpResponse

    public String[] getExcelHeaders() {
        return excelHeaders;
    }

    public void setExcelHeaders(String[] excelHeaders) {
        this.excelHeaders = excelHeaders;
    }

    public String getExcelName() {
        return excelName;
    }

    public void setExcelName(String excelName) {
        this.excelName = excelName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    private HttpServletResponse getResponse() {
        return response;
    }

    private void setResponse(HttpServletResponse response) {
        this.response = response;
    }

    @Override
    public abstract void selectedTableCells(HSSFRow tableRow, T t, HSSFCellStyle cellStyle);

    @SuppressWarnings("deprecation")
    private void exportExcel(List<T> results){
        exportExcel(results, null);
    }

    @SuppressWarnings("deprecation")
    private void exportExcel(List<T> results, int[] widths){
        // 0.创建工作本
        HSSFWorkbook excelWorkBook = new HSSFWorkbook();
        // 1.创建表
        HSSFSheet excelSheet = null;
        if (this.excelName == null) {
            this.excelName = new String();
        }
        excelSheet = excelWorkBook.createSheet(this.excelName);

        // 创建单元格样式
        HSSFCellStyle titleCellStyle = excelWorkBook.createCellStyle();
        // 指定单元格居中对齐，边框为细
        titleCellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        titleCellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        titleCellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        titleCellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置填充色
        titleCellStyle.setFillForegroundColor(HSSFColor.SKY_BLUE.index);
        titleCellStyle.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
        // 指定当单元格内容显示不下时自动换行
        titleCellStyle.setWrapText(true);
        // 设置单元格字体
        HSSFFont titleFont = excelWorkBook.createFont();
        titleFont.setFontHeightInPoints((short) 12);
        titleFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        titleCellStyle.setFont(titleFont);

        // 2.创建表头: 创建一行
        HSSFRow headerRow = excelSheet.createRow(0);
        headerRow.setHeightInPoints(20);
        for (int i = 0; i < this.excelHeaders.length; i++) {
            // 创建一个单元格
            HSSFCell headerCell = headerRow.createCell((short) i);
            // headerCell.setEncoding(HSSFCell.ENCODING_UTF_16);
            // CellStyle cs = new CellStyle();
            // 设置cell的值
            headerCell.setCellValue(excelHeaders[i]);

            headerCell.setCellStyle(titleCellStyle);
            excelSheet.setColumnWidth(i, (30 * 160));

            // 有设置宽度
            if (widths != null && widths.length >= i+1){
                excelSheet.setColumnWidth(i, (widths[i] * 160));
            }
        }



        // ------------------------------------------------------------------
        // 创建单元格样式
        HSSFCellStyle cellStyle = excelWorkBook.createCellStyle();
        // 指定单元格居中对齐，边框为细
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        cellStyle.setVerticalAlignment(HSSFCellStyle.VERTICAL_CENTER);
        cellStyle.setBorderTop(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderRight(HSSFCellStyle.BORDER_THIN);
        cellStyle.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        // 设置单元格字体
        HSSFFont font = excelWorkBook.createFont();
        titleFont.setFontHeightInPoints((short) 12);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_NORMAL);
        cellStyle.setFont(font);


        // 3.根据查询出来的结果集results，填写excel表格
        if (results != null) {
            T objectT = null;
            for (int index = 0; index < results.size(); index++) {
                // 4.创建一行
                HSSFRow tableRow = excelSheet.createRow((short) index + 1); // 创建行，因为第一行是表头,
                tableRow.setHeight((short) (25 * 20));
                // 即row(0)
                objectT = results.get(index);

                this.selectedTableCells(tableRow, objectT, cellStyle);
            }
        }

        // 4.将excel导出到文件中
        // 如果没有名字则文件名为data时间+excelName
        if (this.fileName.equals(new String()) || this.fileName==null) {
            SimpleDateFormat tmp = new SimpleDateFormat("yyyyMMddHHmmssSSS");
            String dateStr = tmp.format(new Date());
            this.setFileName(dateStr + this.getExcelName());
        }

        //判断是下载到指定路径，还是网络下载，
        //本地下载，创建本地文件流，
        //否则，利用repsonse的文件流
        if(this.getResponse() == null){
            OutputStream ioFileStream = null;
            try {
                File dir = new File(this.filePath);
                if (!dir.exists()){
                    dir.mkdirs();
                }

                File file = new File(this.filePath + this.fileName +".xls");
                if (file.exists()){
                    file.delete();
                }
                ioFileStream = new FileOutputStream(file);
                excelWorkBook.write(ioFileStream);
                ioFileStream.flush();
                ioFileStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        else{
            this.response.setContentType("application/vnd.ms-excel");
            this.response.setHeader("Cache-Control", "no-store");
            SimpleDateFormat createDayConvert = new SimpleDateFormat("yyyyMMddHHmmssSSS");      //日期转换器
            String fileString = createDayConvert.format(new Date())+this.excelName + ".xls";
            //解决中文乱码问题
            try {
                response.setHeader("Content-Disposition", "attachment; filename="
                        + new String( fileString.getBytes("utf-8"), "ISO8859-1" ));
            } catch (UnsupportedEncodingException e1) {
                e1.printStackTrace();
            }
            OutputStream ioWebStream = null;
            try {
                ioWebStream = response.getOutputStream();
                excelWorkBook.write(ioWebStream);
                ioWebStream.flush();
                ioWebStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * @note 从页面上下载excel表格
     * @param results  查询出来的结果集
     * @param headers  表格的头
     * @param excelName excel表名
     * @param fileName 导出的excel文件名
     * @param response HttpServletResponse
     */
    public void exportExcel(List<T> results, String[] headers, String excelName, String fileName, HttpServletResponse response) {
        this.setExcelHeaders(headers);
        this.setExcelName(excelName);
        this.setFileName(fileName);
        this.setResponse(response);
        this.exportExcel(results);
    }

    /**
     * @note 导出excel报表到本地的指定路径
     * @param results  查询出来的结果集
     * @param headers  表格的头
     * @param excelName excel表名
     * @param filePath 本地的存储路径
     * @param fileName 导出的excel文件名
     */
    public void exportExcel(List<T> results, String[] headers,
                            String excelName, String filePath, String fileName) {
        exportExcel(results, headers, excelName, filePath, fileName, null);
    }

    /**
     * @note 导出excel报表到本地的指定路径
     * @param results  查询出来的结果集
     * @param headers  表格的头
     * @param excelName excel表名
     * @param filePath 本地的存储路径
     * @param fileName 导出的excel文件名
     * @param widths 每一列的宽度
     */
    public void exportExcel(List<T> results, String[] headers,
                            String excelName, String filePath, String fileName, int[] widths) {
        this.setExcelHeaders(headers);
        this.setExcelName(excelName);
        this.setFilePath(filePath);
        this.setFileName(fileName);
        this.exportExcel(results, widths);
    }

}