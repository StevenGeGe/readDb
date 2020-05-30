package com.hy.readDb;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Created by IntelliJ IDEA.
 *
 * @Author: Yong
 * @Date: 2020/5/28 18:37
 * @Version 1.0
 * @PACKAGE_NAME : com.hy.readDb
 **/
public class Main {
    public static void main(String[] args) {
        DBUtil dbUtil = new DBUtil();
        Connection connection = dbUtil.getConnection();
        //String sqlStr = "select t1.FST, t1.TASK_FILE_NAME, t1.task_file_content  from icm_task_file t1 " +
        //        "where t1.FST>=to_date('2019-05-28', 'yyyy-mm-dd')";
        String sqlStr = "select to_char(t1.FST,'yyyy-mm-dd hh24:mi:ss'), t1.TASK_FILE_NAME, t1.task_file_content  from icm_task_file t1 " +
                "where t1.PROJECT_ID in (select t2.id from IPM_PROJECT t2 where t2.PROJECT_NAME in ('测试', 'shangxian20181122'))";
        XSSFWorkbook work = new XSSFWorkbook();
        XSSFSheet st = work.createSheet();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlStr);
            XSSFRow row = st.createRow(0);
            Cell cell1 = row.createCell(0);
            Cell cell2 = row.createCell(1);
            Cell cell3 = row.createCell(2);
            cell1.setCellValue("时间");
            cell2.setCellValue("任务名称");
            cell3.setCellValue("名单量");
            int i = 1;
            while (resultSet.next()) {
                try {
                    XSSFRow rw = st.createRow(i);
                    Cell rwCell1 = rw.createCell(0);
                    Cell rwCell2 = rw.createCell(1);
                    Cell rwCell3 = rw.createCell(2);
                    rwCell1.setCellValue(resultSet.getString(1));
                    rwCell2.setCellValue(resultSet.getString(2));
                    Blob blob = resultSet.getBlob(3);
                    InputStream ins = blob.getBinaryStream();
                    XSSFWorkbook wb = new XSSFWorkbook(ins);
                    XSSFSheet sheet = wb.getSheetAt(0);
                    rwCell3.setCellValue(sheet.getLastRowNum());
                    i++;
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println(resultSet.getString(2) + "文件为空");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            dbUtil.closeConnection(connection);
        }
        try {
            FileOutputStream output = new FileOutputStream("/home/ccrobot/data/workbook.xls");
            //FileOutputStream output = new FileOutputStream("F:\\data\\workspace_data\\haoyi_data");
            work.write(output);
            output.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("生成excle文件异常");
        }
    }

}
