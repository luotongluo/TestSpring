package com.lt.commparent.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.InputStreamReader;
import java.util.HashSet;


/**
 * csv导入的时候用到的工具类
 *
 * @author LT
 * @date 3.14
 */
public class CsvUtill {

    private static final String UTF8 = "utf-8";
    private static final String GBK = "GBK";


    public static HashSet<String> importCsv(MultipartFile picFile) throws Exception {
        int a = 0;

        HashSet<String> objects = new HashSet<>();
        // 判断是否为空
        if (picFile.isEmpty()) {
            return null;
        }
//        csv文件默认编码为ANSI，这里出现乱码主要是编码不一致问题 参考博课
//        DataInputStream in = new DataInputStream(new FileInputStream(new File("d:\\*.csv")));
//        BufferedReader br= new BufferedReader(new InputStreamReader(in,"GBK"));

        DataInputStream dataInputStream = new DataInputStream(picFile.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(dataInputStream, UTF8));
//        InputStreamReader ins = new InputStreamReader(inputStream);
//        BufferedReader br = new BufferedReader(ins);

        String line = "";
        while ((line = br.readLine()) != null) {
            //将第一行的数据不进行导入
            if (a == 0) {
                a = a + 1;
            } else {
                //转成流文件后，就可以自己处理了
                objects.add(line);
            }
        }
        return objects;
    }


    /**
     * 积分兑换的导出接口  --
     * 参考代码
     *
     * @return
     */
//    @RequestMapping("/exportPoint")
//    public Map exportPoint(@RequestParam(name = "exchange_order_number") Integer groupId, HttpServletResponse httpServletResponse) {
//        RequestHead header = null;
//        try {
//            List<PointExchangeProductItem> csvExportInfo = productPointService.exportPoint(groupId);
//
//            //设置response
//            httpServletResponse.setContentType("application/x-download;charset=gbk");
//            //设置文件名
//            String fileName = "積分csv导出文件" + ".csv";
//            httpServletResponse.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "utf-8"));
//            //获得打印流
//            PrintWriter pw = httpServletResponse.getWriter();
//            pw.println("商品编号,商品名称,兑换积分数,加价格");
//            StringBuilder sb = new StringBuilder();
//            for (PointExchangeProductItem pointExchangeProductItem : csvExportInfo) {
//                String sku = pointExchangeProductItem.getSku();
//                String productName = pointExchangeProductItem.getProductName();
//                Integer point = pointExchangeProductItem.getPoint();
//                double addPrice = pointExchangeProductItem.getAddPrice();
//                sb.append(sku + "," + productName + "," + point + "," + addPrice);
//                sb.append("\r\n");
//            }
//
//            pw.print(sb);
//            pw.close();
//            return ResponseUtil.getRespMap(0, "導出成功", header, csvExportInfo);
//        } catch (Exception e) {
//            logger.info("com.leyou.apollo.promotion.controller.ProductPointController.exportPoint--> \n " + e);
//        }
//        return ResponseUtil.getRespMap(ResultCode.ERROR.getIndex(), ResultCode.ERROR.getName(), header, null);
//    }
}


