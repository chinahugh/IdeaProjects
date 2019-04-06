package com.tools.file;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HUGH
 * @Date 2019/3/29 21:19
 * @Description ChangeJarClassUtils 替换jar包中的文件 TODO 后续实现
 */
public class ReplaceJarClassUtils {
    private static Logger logger = LoggerFactory.getLogger(ReplaceJarClassUtils.class);
    private static final String bat = "./maven/bat/rjar.bat";
    private static List<Inner> list = new ArrayList<>();
    private static Runtime runtime = Runtime.getRuntime();

    /*请在静态块中加入要转换的文件信息，例如:put("d:/a.jar", "com.hello.class");*/
    static {
        put("d:/", "", "");
    }

    public static void main(String[] args) {
        File file = new File(bat);
        System.out.println(file.exists());
        start();
    }

    public static void start() {
        logger.info("Start Replace!!!");
        Inner inner = list.get(0);
        String path = "cmd " + inner.jarPath;
        String exec = "cmd dir ";
        try {
            Process pathe = runtime.exec(path);
            Process exec1 = runtime.exec("cmd /c "+bat, null, new File(inner.classPath));
            InputStream inputStream = exec1.getInputStream();
            System.out.println(inputStream.read(new byte[inputStream.available()]));
            System.out.println(inputStream.available());
        } catch (IOException e) {
            logger.error("exec '" + exec + "' error !!! ", e);
        }
    }

    /**
     * @param jarPath   jar文件绝对路径
     * @param className 替换文件相对路径
     */
    public static void put(String jarPath, String className, String classPath) {
        Inner inner = new Inner(jarPath, className, classPath);
        list.add(inner);
        logger.info("put Inner{} to list.", inner);
    }

    static class Inner {
        /**
         * jar文件绝对路径
         */
        private String jarPath;
        /**
         * 替换文件相对路径
         */
        private String className;
        /**
         * 替换文件项目地址
         */
        public String classPath;

        public Inner(String jarPath, String className, String classPath) {
            this.jarPath = jarPath;
            this.className = className;
            this.classPath = classPath;
        }

        public String getExec() {
            return null;
        }

        @Override
        public String toString() {
            return "Inner{" +
                    "jarPath='" + jarPath + '\'' +
                    ", className='" + className + '\'' +
                    ", classPath='" + classPath + '\'' +
                    '}';
        }
    }
}
