package org.cloud.file.action;

import com.netflix.governator.annotations.binding.Response;
import io.swagger.annotations.ApiParam;
import org.cloud.file.entity.FileEntity;
import org.cloud.file.workers.FileManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by flysLi on 2017/8/28.
 */
@SuppressWarnings("All")
@RestController
@RequestMapping(value = "/file")
public class FileAction {

    @Autowired
    private FileManager fileManager;

    /**
     * pull
     *
     * @return
     */
    @RequestMapping(value = "/pull", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public List<FileEntity> pull(@ApiParam(name = "userName", value = "用户名,例:lifeifeixz@sina.cn") @RequestParam(required = true) String userName,
                                 @ApiParam(name = "projectName", value = "项目名,例:demo") @RequestParam(required = true) String projectName) {

        return fileManager.files(userName, projectName);
    }

    /**
     * push
     *
     * @param userName
     * @param projectName 由于需要提交的文件内容比较大。所以只提供POST方式的提交。
     *                    1.后期将考虑压缩包方式的上传。
     * @return
     */
    @RequestMapping(value = "/push", method = RequestMethod.POST)
    @ResponseBody
    public Object push(@ApiParam(name = "userName", value = "用户名,例:lifeifeixz@sina.cn") @RequestParam(required = true) String userName,
                       @ApiParam(name = "projectName", value = "项目名,例:demo") @RequestParam(required = true) String projectName,
                       @ApiParam(name = "data", value = "项目文件结构") @RequestParam(required = true) String data) {

        FileManager.downloadFile(userName, projectName, data);
        return "over";
    }
}
