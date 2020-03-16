package com.java.focus.awt;

import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 条形码工具类
 *
 * @author hugh
 * @createDate 2017年12月6日
 */
public class BarcodeUtil {

    private static final String generate = "generate.png";
    private static final String title = "title.png";

    /**
     * 判断属性
     *
     * @param msg
     *            条码信息
     * @param titlemsg
     *            title信息
     * @param generateFont
     *            条码字体
     * @param titleFont
     *            title字体
     * @param height
     *            条码高度 100-200
     * @param width
     *            条码宽度 600-1500
     * @return File file
     * @throws FileNotFoundException
     *             FileNotFoundException
     */

    public static File getGenerate(String msg, String titlemsg, String path, Font generateFont, Font titleFont,
                                   double height, double width) throws FileNotFoundException {
        File f1 = generateFile(msg, generateFont, height * 0.066761, width / 6, path);
        int widthh = getWidth(f1);
        File f2 = mergeImagee(titlemsg, widthh, (int) (height * 0.2), titleFont, path);
		/*
		 * try { System.out.println("f1 width :" + ImageIO.read(f1).getWidth()); System.out.println("f1 hength :" + ImageIO.read(f1).getHeight());
		 * System.out.println("f2 width :" + ImageIO.read(f2).getWidth()); System.out.println("f2 hength :" + ImageIO.read(f2).getHeight()); } catch
		 * (IOException e) { e.printStackTrace(); }
		 */
        return stitching(f2, f1, msg, path);
    }

    private static int getWidth(File f1) {
        try {
            return ImageIO.read(f1).getWidth();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * 生成条码基础图片
     *
     * @param msg
     *            条码信息
     * @param generateFont
     *            字体
     * @param height
     *            条码高度
     * @param width
     *            条码分辨率，要求大于50，分辨率越高，条码越宽
     * @return File
     * @throws FileNotFoundException
     *             FileNotFoundException
     */
    private static File generateFile(String msg, Font generateFont, double height, double width, String path)
            throws FileNotFoundException {
        File generateFile = new File(path + generate);
        FileOutputStream out = new FileOutputStream(generateFile);

        // Code39Bean bean = new Code39Bean();
        Code128Bean bean = new Code128Bean();
        // PDF417Bean bean =new PDF417Bean();

        // module宽度
        final double moduleWidth = UnitConv.in2mm(1.0f / width);
        // 配置对象
        bean.setModuleWidth(moduleWidth);
        // bean.setWideFactor(3);
        bean.setFontName(generateFont.getFontName());
        bean.setFontSize(generateFont.getSize());
        bean.setBarHeight(height);
        bean.doQuietZone(false);
        String format = "image/png";
        try {
            // 输出到流
            BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, format, (int) width,
                    BufferedImage.TYPE_BYTE_BINARY, false, 0);
            // 生成条形码
            bean.generateBarcode(canvas, msg);

            // 结束绘制
            canvas.finish();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                //TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return generateFile;
    }

    /**
     * title生成器
     *
     * @param titlemsg
     *            title
     * @param width
     *            width
     * @param titleFont
     *            fontsize
     * @throws Exception
     *             Exception
     */
    public static File mergeImagee(String titlemsg, int width, int height, Font titleFont, String fpath) {

        File titleFile = new File(fpath + title);

        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2 = (Graphics2D) bi.getGraphics();
        g2.setBackground(Color.WHITE);
        g2.clearRect(0, 0, width, height);
        g2.setPaint(Color.BLACK);

        FontRenderContext context = g2.getFontRenderContext();
        Rectangle2D bounds = titleFont.getStringBounds(titlemsg, context);
        double x = (width - bounds.getWidth()) / 15;
        double y = (height - bounds.getHeight()) / 1.5;
        double ascent = -bounds.getY();
        double baseY = y + ascent * 3;

        g2.drawString(titlemsg, (int) x, (int) baseY);

        try {
            ImageIO.write(bi, "png", titleFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return titleFile;
    }

    /**
     * 合成图片
     *
     * @param f1
     * @param f2
     * @param outfile
     * @return
     */
    public static File stitching(File f1, File f2, String outfile, String path) {
        BufferedImage bi_0 = null;
        BufferedImage bi_1 = null;
        // 读取文件
        try {
            bi_0 = ImageIO.read(f1);
            bi_1 = ImageIO.read(f2);
        } catch (IOException ex) {
            System.out.println("文件合并出错");
        }

        // 假设图片0 和图片1 宽度相同，上下合成
        // new 一个新的图像
        int w = bi_0 != null ? bi_0.getWidth() : 0;
        int h_0 = bi_0 != null ? bi_0.getHeight() : 0;
        int h_1 = bi_1 != null ? bi_1.getHeight() : 0;
        int h = h_0 + h_1;
        BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        // 像素一个一个复制过来
        for (int y = 0; y < h_0; y++) {
            for (int x = 0; x < w; x++) {
                bi.setRGB(x, y, bi_0.getRGB(x, y));
            }
        }
        for (int y = 0; y < h_1; y++) {
            for (int x = 0; x < w; x++) {
                bi.setRGB(x, h_0 + y, bi_1.getRGB(x, y));
            }
        }

        // 输出文件
        File file = new File(path + outfile + ".png");
        try {
            ImageIO.write(bi, "png", file);
        } catch (IOException ignored) {
        }

        return file;
    }

    public static void main(String[] args) throws FileNotFoundException {

        String msg = "1234567.8912A";
        String file = "barcode";
        String titlemsg = "ds4AD351384";
        long l = System.currentTimeMillis();
        Font gfont = new Font("宋体", Font.PLAIN, 3);
        Font tfont = new Font("宋体", Font.BOLD, 3);
        int x = 90;
        File f1 = getGenerate(msg, titlemsg, "./", gfont, tfont, 200, x);
        System.out.println(f1.getAbsolutePath());
        l = System.currentTimeMillis() - l;
        System.out.println("time : " + l);
        // System.out.println(f1.getPath());

    }

}