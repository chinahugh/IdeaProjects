package com.tools.file;

import org.junit.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Auther HUGH
 * @Date 2018/5/4
 * @Description ChangeFileNameUtils
 */
public class ChangeFileNameUtils {

    public static void changeFileName(File file, String newFileName){
        if (file == null) {
            throw new RuntimeException("传入文件为空");
        }
        if (!file.exists()) {
            throw new RuntimeException("文件不存在"+file);
        }
        String path = file.getParent();
        File newFile=new File(path,newFileName);
        file.renameTo(newFile);
    }

    /**
     * 批量修改文件名字
     * @param files
     * @param newFileNames
     */
    public static void changeFileNames(List<File> files,List<String> newFileNames){
        if (files == null||files.size()==0) {
           throw new RuntimeException("传入文件列表为空");

        }
        if (newFileNames == null||newFileNames.size()==0) {
            throw new RuntimeException("传入的新文件名列表为空");
        }
        if (files.size() != newFileNames.size()) {
            throw new RuntimeException("传入的文件列表与新文件名列表大小不同");
        }
        for (int i = 0; i < files.size(); i++) {
            changeFileName(files.get(i),newFileNames.get(i));
        }
    }
    @Test
    public void  test(){
        String path="E:/Videos/神盾局4";
        List<String> newFileNames= new ArrayList<>(16);
        File[] files = new File(path).listFiles();
        List<File> fileList= Arrays.asList(files);
        File remfile=null;
        for (File f:files){
            String name = f.getName();
            String[] split = name.split("[.]");
            if (split.length>11){
                newFileNames.add(split[0]+split[10]+"."+split[split.length-1]);
            }else {
                 remfile = f;
            }
        }
        fileList=new ArrayList<>(fileList);
        fileList.remove(remfile);
        System.out.println(fileList.size()+" "+newFileNames.size());
        for (int i=0;i<fileList.size();i++){
            System.out.println(fileList.get(i)+" "+newFileNames.get(i));
        }
        changeFileNames(fileList,newFileNames);
    }
}
