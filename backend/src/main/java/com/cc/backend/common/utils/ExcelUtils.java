package com.cc.backend.common.utils;

import cn.hutool.core.img.ImgUtil;
import cn.hutool.core.util.StrUtil;

import com.cc.backend.dao.vo.ExcelColorVo;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFColor;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import java.io.BufferedInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.security.*;
import java.util.*;

@Component
public class ExcelUtils {


    /**
     * 根据指定的颜色读取excel单元格内容和坐标
     * @param color
     * @param readerPath
     * @return
     * @throws FileNotFoundException
     * @throws FileNotFoundException
     */
    public ExcelColorVo readExcelByColor(String color, String readerPath) throws FileNotFoundException, FileNotFoundException {

        color = color.toUpperCase();

        if (StrUtil.isEmpty(color)) {
            throw new RuntimeException("没有指定的颜色");
        }

//        InputStream inputStream = new FileInputStream(readerPath);

        InputStream inputStream = null;
        try {
//            URL urls = new URL(readerPath);
//            URLConnection connection = urls.openConnection();
//            inputStream = connection.getInputStream();
            URL urls = new URL(readerPath);
            HttpsURLConnection connection = (HttpsURLConnection) urls.openConnection();
            SSLContext sslContext = SSLContext.getInstance("TLS");
            // 创建TrustManagerFactory对象，用于SSL初始化
            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            // 初始化TrustManagerFactory
            trustManagerFactory.init((KeyStore) null);
            // 获取TrustManager数组
            TrustManager[] trustManagers = trustManagerFactory.getTrustManagers();

            sslContext.init(null, trustManagers, new SecureRandom());
            connection.setSSLSocketFactory(sslContext.getSocketFactory());
            inputStream = connection.getInputStream();
        } catch (IOException e) {
            throw new RuntimeException("没有读取到远程文件！");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        } catch (KeyManagementException e) {
            throw new RuntimeException(e);
        } catch (KeyStoreException e) {
            throw new RuntimeException(e);
        }
        String extension = getFileExtension(readerPath);
        Workbook workbook = null;
        try {
            // 判断后缀

            if(extension.equalsIgnoreCase("xls")){
                workbook = new HSSFWorkbook(new BufferedInputStream(inputStream));
            }else{
                workbook = new XSSFWorkbook(new BufferedInputStream(inputStream));
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Sheet sheetAt = workbook.getSheetAt(0);

        int firstRowNum = sheetAt.getFirstRowNum();

        int lastRowNum = sheetAt.getLastRowNum();

        ArrayList<Object> valueList = new ArrayList<>();

        ArrayList<Object> addressList = new ArrayList<>();

        HashMap<String, String> map = new HashMap<>();

        for (int num = firstRowNum; num <= lastRowNum; num++) {

            Row row = sheetAt.getRow(num);

            if (row == null) {
                continue;
            }

            Iterator<Cell> cellIterator = row.cellIterator();

            if (cellIterator == null) {
                continue;
            }

            while (cellIterator.hasNext()) {

                Cell next = cellIterator.next();

                String address = next.getAddress().toString();
                byte[] rgb ;
                if(extension.equalsIgnoreCase("xls")){
                    HSSFColor fillForegroundColorColor =   (HSSFColor) next.getCellStyle().getFillForegroundColorColor();
                    if (fillForegroundColorColor == null) continue;
                    short[] triplet = fillForegroundColorColor.getTriplet();
                    rgb = convertShortArrayToByteArray(triplet);
                }else{
                    XSSFColor fillForegroundColorColor = (XSSFColor) next.getCellStyle().getFillForegroundColorColor();
                    if (fillForegroundColorColor == null) continue;
                    rgb = fillForegroundColorColor.getRGB();
                }


//                byte[] rgb = fillForegroundColorColor.getRGB();
                int[] rgbInt = new int[rgb.length];
                for (int i = 0; i < rgb.length; i++) {
                    rgbInt[i] = Byte.toUnsignedInt(rgb[i]);
                }
                String s = ImgUtil.toHex(rgbInt[0], rgbInt[1], rgbInt[2]);

//                cellIterator.next().setCellType(CellType.STRING);

                if (!s.equals(color)) {

                    continue;
                }

                CellType cachedFormulaResultType = next.getCellType();

                Object value = null;

                switch (cachedFormulaResultType) {
                    case NUMERIC:
                        value = next.getNumericCellValue();
                        break;
                    case STRING:
                        value = next.getStringCellValue();
                        break;
                    default:
                        value = "";
                        break;

                }

                valueList.add(value);

                addressList.add(address);
                map.put(address, String.valueOf(value));

            }

        }
        ExcelColorVo excelColorVo = new ExcelColorVo();
        excelColorVo.setValueList(valueList);
        excelColorVo.setAddressList(addressList);
        excelColorVo.setDataMap(map);
        return excelColorVo;

    }

    /**
     * excel单元格排序
     * @param addressList
     * @return
     */
    public List<String> sort(ArrayList<Object> addressList) {
        ArrayList<String> coordinateList = new ArrayList<>();
        addressList.stream()
                .map(Object::toString) // 将每个元素转换为字符串
                .forEach(coordinateList::add); // 将转换后的字符串添加到新的ArrayList<String>中
        Collections.sort(coordinateList, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 先按字母进行排序
                int result = s1.substring(0, 1).compareTo(s2.substring(0, 1));
                if (result == 0) {
                    // 如果字母相同，按数字进行排序
                    String num1 = s1.substring(1);
                    String num2 = s2.substring(1);
                    return Integer.compare(Integer.parseInt(num1), Integer.parseInt(num2));
                }
                return result;
            }
        });
        return coordinateList;
    }


    public String getFileExtension(String filename){
        if (filename != null && !filename.isEmpty()) {
            int dot = filename.lastIndexOf('.');
            if (dot > 0 && dot < filename.length() - 1) {
                return filename.substring(dot + 1);
            }
        }
        return "";
    }

    public static byte[] convertShortArrayToByteArray(short[] shortArray) {
        byte[] byteArray = new byte[shortArray.length * 2];
        for (int i = 0; i < shortArray.length; i++) {
            byteArray[i * 2] = (byte) (shortArray[i] >> 8); // 高8位
            byteArray[i * 2 + 1] = (byte) shortArray[i]; // 低8位
        }
        return byteArray;
    }
}
