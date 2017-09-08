package org.utils.file;

import com.alibaba.fastjson.JSONArray;

import java.io.*;

/**
 * Created by flysLi on 2017/8/28.
 */
public class FileUtil {

    /**
     * 可能创建一个文件
     *
     * @param path
     */
    public static void maybeNewFile(String path) {
        File file = new File(path);
        file.mkdir();
    }

    /**
     * 下载文件
     *
     * @param path
     * @param content
     */
    public static void initData(String path, String content) {

    }

    /**
     * 必须创建一个文件
     *
     * @param path
     */
    public static void mustNewFile(String path) {
        File file = new File(path);
        if (file.exists()) {
            file.mkdir();
        }
    }

    /**
     * 写出文件到服务器
     *
     * @param path 路径
     * @param data 要输出的数据
     */
    public static int writer(String path, String data) {

        //判断路径是否存在
        File file = new File(path.substring(0, path.lastIndexOf(File.separatorChar)));
        if (!file.isDirectory() && !file.isFile()) {
            file.mkdirs();
        }

        if (data == null) {
            return 0;
        }

        File f = new File(path);
        OutputStream out = null;

        try {
            out = new FileOutputStream(f);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //将字符串转换成字节数组
        byte[] b = data.getBytes();

        try {
            out.write(b);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return b.length;
    }


    public static void main(String[] args) {
        String str = "[\n" +
                "    {\n" +
                "        \"id\": \"\",\n" +
                "        \"name\": \"build.gradle\",\n" +
                "        \"lastUpdateTime\": null,\n" +
                "        \"path\": \"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\build.gradle\",\n" +
                "        \"parentPath\": null,\n" +
                "        \"type\": \"file\",\n" +
                "        \"version\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"\",\n" +
                "        \"name\": \"src\",\n" +
                "        \"lastUpdateTime\": null,\n" +
                "        \"path\": \"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\",\n" +
                "        \"parentPath\": null,\n" +
                "        \"type\": \"folder\",\n" +
                "        \"version\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"\",\n" +
                "        \"name\": \"main\",\n" +
                "        \"lastUpdateTime\": null,\n" +
                "        \"path\": \"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\main\",\n" +
                "        \"parentPath\": null,\n" +
                "        \"type\": \"folder\",\n" +
                "        \"version\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"\",\n" +
                "        \"name\": \"java\",\n" +
                "        \"lastUpdateTime\": null,\n" +
                "        \"path\": \"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\main\\\\java\",\n" +
                "        \"parentPath\": null,\n" +
                "        \"type\": \"folder\",\n" +
                "        \"version\": 0\n" +
                "    },\n" +
                "    {\n" +
                "        \"id\": \"\",\n" +
                "        \"name\": \"demo.java\",\n" +
                "        \"lastUpdateTime\": null,\n" +
                "        \"path\": \"D:\\\\学习\\\\org\\\\lifeifeixz@sina.cn\\\\user\\\\src\\\\main\\\\java\\\\demo.java\",\n" +
                "        \"parentPath\": null,\n" +
                "        \"type\": \"file\",\n" +
                "        \"version\": 0\n" +
                "    }\n" +
                "]";
        JSONArray jsonArray = JSONArray.parseArray(str);
        System.out.println(jsonArray.size());
    }
}
