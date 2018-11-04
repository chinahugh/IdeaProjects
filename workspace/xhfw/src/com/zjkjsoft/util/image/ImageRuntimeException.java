package com.zjkjsoft.util.image;

 
/**
 *图片缩略图生产超时异常
 */
@SuppressWarnings("serial")
public class ImageRuntimeException extends RuntimeException {
	/**
	 * 
	 * @param path
	 * @param proesstype
	 * 图片缩略图生产超时异常处理
	 */
	public ImageRuntimeException(String path,String proesstype){
		super("对图片"+path +"进行"  + proesstype +"出错" );
	}
}
