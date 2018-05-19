package com.zjkjsoft.controller;

import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.jfinal.core.Controller;
import com.jfinal.upload.UploadFile;
import com.zjkjsoft.util.FileTool;
//import com.zjkjsoft.util.image.JavaImageIOCreator;

public class FileController extends Controller {
	private static SimpleDateFormat sf = new SimpleDateFormat("yyyyMMddHHmmsss");
	private static String uploadroot = "/upload/";
	private static String zykimgeup = "/zygx/images/";
	private static String root;

	public void up() {
		String errmsg = "", savefilename = "";
		StringBuffer files = new StringBuffer();
		List<UploadFile> upfilelist = this.getFiles();
		boolean suc = false;
		if (upfilelist != null && upfilelist.isEmpty() == false) {
			if (root == null)
				root = this.getRequest().getContextPath();
			String realPath = this.getRequest().getRealPath("/");
			int fsize = upfilelist.size();
			int i = 1;
			for (UploadFile upfile : upfilelist) {
				File file = upfile.getFile();
				String filedataFileName = upfile.getOriginalFileName();
				savefilename = uploadroot
						+ sf.format(new Date())
						+ filedataFileName.substring(filedataFileName
								.lastIndexOf("."));
				if (file != null) {
					upfile.getFile()
							.renameTo(new File(realPath + savefilename));
					suc = true;
					files.append(root + savefilename);
					if (i < fsize)
						files.append(",");
				}
				i++;
			}
		} else {
			errmsg = "未上传文件";
		}
		this.renderText("{'err':'" + errmsg + "','msg':'" + files.toString()
				+ "','suc':" + suc + "}");
	}

	/** 文件下载 */
	public void down() {

	}

	/**
	 * 弹出对话框上传附件
	 */
	public void upAttachment() {
		String errmsg = "", savefilename = "", fileName = "";
		long attachmentSize = 0;
		StringBuffer files = new StringBuffer();
		List<UploadFile> upfilelist = this.getFiles();
		boolean suc = false;
		if (upfilelist != null && upfilelist.isEmpty() == false) {
			if (root == null)
				root = this.getRequest().getContextPath();
			String realPath = this.getRequest().getRealPath("/");
			int fsize = upfilelist.size();
			int i = 1;
			for (UploadFile upfile : upfilelist) {
				File file = upfile.getFile();
				attachmentSize = file.length();
				fileName = upfile.getOriginalFileName();
				savefilename = uploadroot + sf.format(new Date())
						+ fileName.substring(fileName.lastIndexOf("."));
				if (file != null) {
					upfile.getFile()
							.renameTo(new File(realPath + savefilename));
					suc = true;
					files.append(root + savefilename);
					if (i < fsize)
						files.append(",");
				}
				i++;
			}
		} else {
			errmsg = "未上传文件";
		}
		// {
		// "id":"1000",
		// "fileName":"测试文件.txt",
		// "attachmentPath":"/upload/测试文件.txt",
		// "attachmentSize":"1024"
		// }
		this.renderText("{\"fileName\":\"" + fileName
				+ "\",\"attachmentPath\":\"" + savefilename
				+ "\",\"attachmentSize\":\"" + FileTool.FormetFileSize(attachmentSize )
				+ "\"}");
	}
	/**
	 * 弹出对话框上传资源库图片
	 */
	public void upImage() {
		String errmsg = "", savefilename = "",imgfilename = "", fileName = "";
		long attachmentSize = 0;
		StringBuffer files = new StringBuffer();
		List<UploadFile> upfilelist = this.getFiles();
		boolean suc = false;
		String realPath = this.getRequest().getRealPath("/");
		if (upfilelist != null && upfilelist.isEmpty() == false) {
			if (root == null)
				root = this.getRequest().getContextPath();
			
			int fsize = upfilelist.size();
			int i = 1;
			for (UploadFile upfile : upfilelist) {
				File file = upfile.getFile();
				attachmentSize = file.length();
				fileName = upfile.getOriginalFileName();
				String imgbh=sf.format(new Date());
				savefilename = zykimgeup + imgbh
						+ fileName.substring(fileName.lastIndexOf("."));
				imgfilename=zykimgeup + "img/"+imgbh
				+ fileName.substring(fileName.lastIndexOf("."));
				if (file != null) {
					upfile.getFile()
							.renameTo(new File(realPath + savefilename));
					suc = true;
					files.append(root + savefilename);
					if (i < fsize)
						files.append(",");
				}
				i++;
			}
		} else {
			errmsg = "未上传图片";
		}
	//	JavaImageIOCreator creator = new JavaImageIOCreator(realPath + savefilename, realPath +imgfilename);
	//	creator.resize(200);
		// {
		// "id":"1000",
		// "fileName":"测试文件.txt",
		// "attachmentPath":"/upload/测试文件.txt",
		// "attachmentSize":"1024"
		// }
		this.renderText("{\"fileName\":\"" + fileName
				+ "\",\"attachmentPath\":\"" + savefilename
				+ "\",\"attachmentSize\":\"" + FileTool.FormetFileSize(attachmentSize )
				+ "\"}");
	}


}
