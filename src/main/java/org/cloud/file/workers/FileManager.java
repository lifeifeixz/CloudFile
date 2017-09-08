package org.cloud.file.workers;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.cloud.file.config.FileConfig;
import org.cloud.file.entity.FileEntity;
import org.utils.file.FileUtil;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by flysLi on 2017/8/28.
 */
@Component
public class FileManager {

    /**
     * 获取文件列表
     *
     * @return
     */
    public List<FileEntity> files(String userName, String projectName) {

        return ergdoic(new File(account(userName, projectName)), new ArrayList<FileEntity>());
    }

    /**
     * 得到项目路径
     *
     * @param userName
     * @param projectName
     * @return
     */
    public static String account(String userName, String projectName) {
        return FileConfig.root + File.separatorChar + userName + File.separatorChar + projectName + File.separatorChar;
    }

    /**
     * 读取硬盘结构数据
     *
     * @param file
     * @param resultFileName
     * @return
     */
    public static List<FileEntity> ergdoic(File file, List<FileEntity> resultFileName) {
        if (file.isDirectory()) {
            resultFileName.add(new FileEntity().getInstance("", file.getName(), file.getPath(), FileEntity.FOLDER));
        }
        File[] files = file.listFiles();
        if (files == null) {
            return resultFileName;
        }
        for (File f : files) {
            if (!f.isDirectory()) {//如果不是文件夹
                //读取文件内容
                resultFileName.add(new FileEntity().getInstance("", f.getName(), f.getPath(), FileEntity.FILE, FileReader.readerString(f.getPath(), "UTF-8")));
            } else {
                ergdoic(f, resultFileName);//如果是文件夹进行递归
            }
        }
        return resultFileName;//返回文件名的集合
    }

    /**
     * 更新文件到服务中
     *
     * @param userName
     * @param project
     * @param data
     * @return
     */
    public static String downloadFile(String userName, String project, String data) {
        JSONArray jsonArray = JSONArray.parseArray(data);
        String dir = FileConfig.root + File.separator + userName + File.separator;
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = (JSONObject) jsonArray.get(i);
            String relativePath = jsonObject.getString("relativePath");
            String type = jsonObject.getString("type");
            String content = jsonObject.getString("content");
            if (type.equals(FileEntity.FOLDER)) {
                File file = new File(dir + relativePath);
                if (!file.exists()) {
                    file.mkdirs();
                }
            } else if (type.equals(FileEntity.FILE)) {
                FileUtil.writer(dir + relativePath, content);
            }
        }
        return "over";
    }
}
