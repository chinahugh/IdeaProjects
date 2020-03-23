package com.tools.file;

import java.io.File;
import java.util.Objects;

/**
 * @author HUGH
 * @Date 2018/9/15
 * @Description MavenClean  maven仓库清理
 */
public class MavenCleanUtils {
    /**
     * 注意：MAVEN_REPO_PATH 的值需要替换成自己的maven本地仓库地址
     */
    private static final String MAVEN_REPO_PATH = "d:/repository/maven";
    /**
     * 删除文件类型
     */
    private static final String[] SUFFIX = {".lastUpdated", "jar-in-progress"};

    public static void main(String[] args) {
        File mavenRep = new File(MAVEN_REPO_PATH);
        long usableSpace1 = mavenRep.getUsableSpace();
        System.out.println(usableSpace1);
        if (!mavenRep.exists()) {
            System.out.println("Maven repos is not exist.");
            return;
        }
        File[] files = mavenRep.listFiles();
        checkAndDeleteFiles(Objects.requireNonNull(files));
        System.out.println("Clean lastUpdated files and in-progess jar finished.");
        long usableSpace2 = mavenRep.getUsableSpace();
        System.out.println(usableSpace2);
        System.out.println(usableSpace1 - usableSpace2);
    }

    private static boolean checkAndDeleteFiles(File[] files) {
        for (File file : files) {
            if (file.isDirectory()) {
                if (Objects.requireNonNull(file.listFiles()).length == 0) {
                    // 删除空文件夹
                    System.out.println("空文件夹删除："+file.getAbsolutePath());
                    file.delete();
                } else {
                    boolean flag = checkAndDeleteFiles(Objects.requireNonNull(file.listFiles()));
                    if (flag) {
                        // 删除文件夹中的文件
                        for (File childFile : Objects.requireNonNull(file.listFiles())) {
                            childFile.delete();
                        }
                        System.out.println(file.getAbsolutePath());
                        // 删除文件夹
                        file.delete();
                    }
                }
            } else {
                for (String aSUFFIX : SUFFIX) {
                    if (file.getName().contains(aSUFFIX)) {
                        System.out.println(file.getName());
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
