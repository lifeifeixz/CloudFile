package org.cloud.file.workers;

import org.springframework.stereotype.Component;

import java.io.*;

/**
 * Created by flysLi on 2017/8/28.
 */
@Component
public class FileReader {


    public static void main(String[] args) {
//        FileReader fileReader = new FileReader();
//        List<FileEntity> fileEntities = new ArrayList<>();
//
//        fileEntities = FileReader.ergdoic(new File(FileConfig.root), fileEntities);
//        for (FileEntity fileEntity : fileEntities) {
//            System.out.println(fileEntity.toString());
//        }

        System.out.println(readerString("D:\\学习\\org\\lifeifeixz@sina.cn\\user\\build.gradle", "UTF-8"));
    }

    /**
     * 读取文件内容
     *
     * @param filePath
     * @return
     */
    public static String readerString(String filePath, String encoding) {
        File file = new File(filePath);
        String sb = "";
        if (file.isFile() && file.exists()) {// 判断文件是否存在
            InputStreamReader read = null;// 考虑到编码格式
            BufferedReader br = null;
            String lineTxt = null;
            try {
                read = new InputStreamReader(new FileInputStream(file), encoding);// 考虑到编码格式
                br = new BufferedReader(read);
                while ((lineTxt = br.readLine()) != null) {
                    sb += lineTxt;
                    sb += "\n";
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }

    /**
     * 写出文件到服务器
     *
     * @param path
     *            路径
     *
     * @param data
     *            要输出的数据
     */
    public static int writer(String path, String data) {

        if(data == null){
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
}
