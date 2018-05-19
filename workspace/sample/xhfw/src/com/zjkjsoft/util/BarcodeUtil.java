package com.zjkjsoft.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.imageio.ImageIO;

import org.krysalis.barcode4j.impl.code39.Code39Bean;
import org.krysalis.barcode4j.impl.pdf417.PDF417Bean;
import org.apache.poi.ss.formula.functions.T;
import org.krysalis.barcode4j.impl.code128.Code128Bean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.UnitConv;

/**
 * 条形码工具类
 *
 * @author hugh
 * @createDate 2017年12月6日
 */
public class BarcodeUtil {

	// private static String path = "WebRoot/tmgl/barcode/imag/";
	// private static String path = "Java/data/image/";

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
	 * @throws IOException
	 * @throws FileNotFoundException
	 *             FileNotFoundException
	 */

	public static File getGenerate(String msg, String titlemsg, String path, Font generateFont, Font titleFont,
			double height, double width) throws IOException {
		File f1 = generateFile(msg, generateFont, height * 0.066761, width / 6, path);
		int widthh = getWidth(f1);
		File f2 = mergeImagee(titlemsg, widthh, (int) (height * 0.2), titleFont, path);
		/*
		 * try { System.out.println("f1 width :" + ImageIO.read(f1).getWidth()); System.out.println("f1 hength :" + ImageIO.read(f1).getHeight()); System.out.println("f2 width :" + ImageIO.read(f2).getWidth()); System.out.println("f2 hength :" + ImageIO.read(f2).getHeight()); } catch (IOException e) { e.printStackTrace(); }
		 */
		return stitching(f2, f1, msg, path);

	}

	private static int getWidth(File f1) throws IOException {
		return ImageIO.read(f1).getWidth();

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
	 * @throws IOException
	 */
	private static File generateFile(String msg, Font generateFont, double height, double width, String path)
			throws IOException {
		File generate = new File(path, "generate.png");
		FileOutputStream out = new FileOutputStream(generate);
		// Code39Bean bean = new Code39Bean();
		Code128Bean bean = new Code128Bean();

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
		// 输出到流
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(out, format, (int) width, BufferedImage.TYPE_BYTE_BINARY,
				false, 0);
		// 生成条形码
		System.out.println("条码明文 "+msg);
		bean.generateBarcode(canvas, msg);

		// 结束绘制
		canvas.finish();
		return generate;

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
	 * @throws IOException
	 * @throws Exception
	 *             Exception
	 */
	public static File mergeImagee(String titlemsg, int width, int height, Font titleFont, String fpath)
			throws IOException {

		File titleFile = new File(fpath + "title" + ".png");

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
		ImageIO.write(bi, "png", titleFile);
		return titleFile;
	}

	/**
	 * 合成图片
	 *
	 * @param f1
	 * @param f2
	 * @param outfile
	 * @return
	 * @throws IOException
	 */
	public static File stitching(File f1, File f2, String outfile, String path) throws IOException {
		BufferedImage bi_0 = null;
		BufferedImage bi_1 = null;
		// 读取文件

		bi_0 = ImageIO.read(f1);
		bi_1 = ImageIO.read(f2);

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
		ImageIO.write(bi, "png", file);
		return file;
	}
	
	public static String display1(List<String> list) {
		String ids="";
		for (String s : list) {
			ids+=",'"+s+"'";
		}
		return new String(ids.substring(1));
		
	}
	public static String display2(String[] list) {
		return display1(Arrays.asList(list));		
	}
	/**
	 * 序列码
	 * 
	 * @return
	 */
	public static String getXlm(int len, int tail) {
		return String.format("%0" + len + "d", tail);
	}


	public static void main(String[] args) throws FileNotFoundException {
		String msg = "1234·567.8912A";
		String file = "barcode";
		String titlemsg = "ds4AD351384";
		long l = System.currentTimeMillis();
		Font gfont = new Font("宋体", Font.PLAIN, 3);
		Font tfont = new Font("宋体", Font.BOLD, 3);
		int x = 90;
		File f1 = null;
		try {
			f1 = getGenerate(msg, titlemsg, "./", gfont, tfont, 200, x);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(f1.getAbsolutePath());
		l = System.currentTimeMillis() - l;
		System.out.println("time : " + l);
		// System.out.println(f1.getPath());
	}

}