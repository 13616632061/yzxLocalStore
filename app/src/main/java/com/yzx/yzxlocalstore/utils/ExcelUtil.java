package com.yzx.yzxlocalstore.utils;

import android.content.Context;
import android.os.Environment;
import android.system.ErrnoException;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.apkfuns.logutils.LogUtils;
import com.google.gson.Gson;
import com.yzx.lib.util.ArithUtil;
import com.yzx.yzxlocalstore.entity.GoodsInfo;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.WorkbookSettings;
import jxl.format.Colour;
import jxl.write.Label;
import jxl.write.WritableCell;
import jxl.write.WritableCellFormat;
import jxl.write.WritableFont;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;


/**
 * Created by Administrator on 2019/7/19.
 */

public class ExcelUtil {
    private static WritableFont arial14font = null;

    private static WritableCellFormat arial14format = null;
    private static WritableFont arial10font = null;
    private static WritableCellFormat arial10format = null;
    private static WritableFont arial12font = null;
    private static WritableCellFormat arial12format = null;
    private final static String UTF8_ENCODING = "UTF-8";
    private String mfileName = Environment.getExternalStorageDirectory() + "/yzxData/";


    private volatile static ExcelUtil mInstance;

    private ExcelUtil() {
        format();
    }

    public static ExcelUtil getInstance() {
        if (mInstance == null) {
            synchronized (ExcelUtil.class) {
                if (mInstance == null) {
                    mInstance = new ExcelUtil();
                }
            }
        }
        return mInstance;
    }

    /**
     * 单元格的格式设置 字体大小 颜色 对齐方式、背景颜色等...
     */
    private static void format() {
        try {
            arial14font = new WritableFont(WritableFont.ARIAL, 14, WritableFont.BOLD);
            arial14font.setColour(jxl.format.Colour.LIGHT_BLUE);
            arial14format = new WritableCellFormat(arial14font);
            arial14format.setAlignment(jxl.format.Alignment.CENTRE);
            arial14format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            arial14format.setBackground(jxl.format.Colour.VERY_LIGHT_YELLOW);

            arial10font = new WritableFont(WritableFont.ARIAL, 10, WritableFont.BOLD);
            arial10format = new WritableCellFormat(arial10font);
            arial10format.setAlignment(jxl.format.Alignment.CENTRE);
            arial10format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);
            arial10format.setBackground(Colour.GRAY_25);

            arial12font = new WritableFont(WritableFont.ARIAL, 10);
            arial12format = new WritableCellFormat(arial12font);
            //对齐格式
            arial10format.setAlignment(jxl.format.Alignment.CENTRE);
            //设置边框
            arial12format.setBorder(jxl.format.Border.ALL, jxl.format.BorderLineStyle.THIN);

        } catch (WriteException e) {
            e.printStackTrace();
        }
    }

    /**
     * 初始化Excel
     * <p>
     * fileName 导出excel存放的地址（目录）
     *
     * @param colName excel中包含的列名（可以有多个）
     */
    public void initExcel(String excelName, String[] colName) {
//        format();
        String fileName = mfileName;
        WritableWorkbook workbook = null;
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            LogUtils.e("excel: " + "fileName: " + fileName);
            workbook = Workbook.createWorkbook(file);
            //设置表格的名字
            WritableSheet sheet = workbook.createSheet(excelName, 0);
            //创建标题栏
            sheet.addCell((WritableCell) new Label(0, 0, fileName, arial14format));
            for (int col = 0; col < colName.length; col++) {
                sheet.addCell(new Label(col, 0, colName[col], arial10format));
            }
            //设置行高
            sheet.setRowView(0, 340);
            workbook.write();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (workbook != null) {
                try {
                    workbook.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @SuppressWarnings("unchecked")
    public <T> void writeObjListToExcel(List<T> objList, String excelName) {
        if (objList != null && objList.size() > 0) {
            WritableWorkbook writebook = null;
            InputStream in = null;
            try {
                String fileName = mfileName + excelName + ".xls";
                WorkbookSettings setEncode = new WorkbookSettings();
                setEncode.setEncoding(UTF8_ENCODING);
                in = new FileInputStream(new File(fileName));
                Workbook workbook = Workbook.getWorkbook(in);
                writebook = Workbook.createWorkbook(new File(fileName), workbook);
                WritableSheet sheet = writebook.getSheet(0);

                for (int j = 0; j < objList.size(); j++) {
                    List<String> list = setGoodsInfoData(objList, j);
                    for (int i = 0; i < list.size(); i++) {
                        sheet.addCell(new Label(i, j + 1, list.get(i), arial12format));
                        if (list.get(i).length() <= 4) {
                            //设置列宽
                            sheet.setColumnView(i, list.get(i).length() + 8);
                        } else {
                            //设置列宽
                            sheet.setColumnView(i, list.get(i).length() + 5);
                        }
                    }
                    //设置行高
                    sheet.setRowView(j + 1, 350);
                }

                writebook.write();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (writebook != null) {
                    try {
                        writebook.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }

        }
    }

    public static <T> String ImportExcelData(String fileName) {
        List<T> datas = new ArrayList<>();
        Workbook workbook = null;
        try {
            workbook = Workbook.getWorkbook(new File(fileName));
            Sheet sheet = workbook.getSheet(0);
            int rows = sheet.getRows();
            int columns = sheet.getColumns();
            //遍历excel文件的每行每列
            for (int i = 0; i < rows; i++) {
                //遍历行
                List<String> li = new ArrayList<>();
                for (int j = 0; j < columns; j++) {
                    Cell cell = sheet.getCell(j, i);
                    String result = cell.getContents();
                    LogUtils.e("ImportExcel: result: " + result);
                    if (i != 0) {
                        li.add(result);
                    }
                }
                if (li.size() > 0) {
                    readExcleToObject(datas, li);
                }
            }
            Gson gson = new Gson();
            LogUtils.e("ImportExcel: gson: " + gson.toJson(datas));
            return gson.toJson(datas);
        } catch (Exception e) {
            e.printStackTrace();
            LogUtils.e("ImportExcel: Exception: " + e.toString());
        }
        return "error";
    }

    private static <T> void readExcleToObject(List<T> datas, List<String> li) {
        if (datas == null || li == null) return;
        try {
        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoodName(li.get(0));
        goodsInfo.setGoodPrice(parseDouble(li.get(1)));
        goodsInfo.setGoodOriginalPrice(parseDouble(li.get(2)));
        goodsInfo.setGoodStore(parseDouble(li.get(3)));
        goodsInfo.setGoodStoreWarningNum(parseDouble(li.get(4)));
        goodsInfo.setGoodProfit(parseDouble(getGoodProfit(li.get(1),li.get(2))));
        goodsInfo.setGoodStatus(parseBoolean(li.get(5)));
        goodsInfo.setGoodCode(li.get(6));
        goodsInfo.setGoodPinyinCode(li.get(7));
        goodsInfo.setGoodLoaction(parseInteger(li.get(8)));
        goodsInfo.setTypeName(li.get(9));
        goodsInfo.setSort(parseInteger(li.get(10)));
        datas.add((T) goodsInfo);
        }catch (Exception e){
            LogUtils.e("ImportExcel: gson: " + "导入数据有问题，请检查数据格式: "+e.toString());
        }
    }
    public static String getGoodProfit(String price, String originalPrice) {
        String profit = 0 + "";
        if (!TextUtils.isEmpty(originalPrice) && !TextUtils.isEmpty(price)) {
            //计算利润 （销售价-成本价）/成本价
            profit = ArithUtil.roundByScale(ArithUtil.div(ArithUtil.sub(price.trim(), originalPrice.trim()) + "", originalPrice.trim()) + "", "#0.00");
        }
        return profit;
    }
    private static double parseDouble(String str) {
        double strD = 0;
        if (!TextUtils.isEmpty(str)) {
            strD = Double.parseDouble(str.trim());
        }
        return strD;
    }
    private static int parseInteger(String str) {
        int strD = -1;
        if (!TextUtils.isEmpty(str)) {
            strD = Integer.parseInt(str.trim());
        }
        return strD;
    }

    private static boolean parseBoolean(String str) {
        boolean strB = false;
        if (!TextUtils.isEmpty(str.trim())) {
            strB = true;
        }
        return strB;
    }

    private <T> List<String> setGoodsInfoData(List<T> objList, int position) {

        GoodsInfo goodsInfoBean = (GoodsInfo) objList.get(position);
        List<String> list = new ArrayList<>();
        list.add(goodsInfoBean.getGoodName());
        list.add(goodsInfoBean.getGoodPrice() + "");
        list.add(goodsInfoBean.getGoodOriginalPrice() + "");
        list.add(goodsInfoBean.getGoodStore() + "");
        list.add(goodsInfoBean.getGoodStoreWarningNum() + "");
        list.add(goodsInfoBean.getGoodProfit() + "");
        list.add(goodsInfoBean.getGoodStatus() + "");
        list.add(goodsInfoBean.getGoodCode());
        list.add(goodsInfoBean.getGoodPinyinCode());

        return list;
    }
}
