package org.cloud.file.entity;

import org.cloud.file.config.FileConfig;

/**
 * Created by flysLi on 2017/8/28.
 */
@SuppressWarnings("all")
public class FileEntity {

    public static final String FILE = "file";

    public static final String FOLDER = "folder";

    private String id;

    private String name;

    private Long lastUpdateTime;

    private String path;

    private String relativePath;

    private String parentPath;

    private String content;

    private String type;

    private int version;

    public String getRelativePath() {
        return relativePath;
    }

    public void setRelativePath(String relativePath) {
        this.relativePath = relativePath;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public FileEntity() {
    }

    public FileEntity(String id, String name, Long lastUpdateTime, String path, String parentPath, String type) {
        this.id = id;
        this.name = name;
        this.lastUpdateTime = lastUpdateTime;
        this.path = path;
        this.parentPath = parentPath;
        this.type = type;
    }

    public FileEntity(String name, String path, String relativePath, String type) {
        this.name = name;
        this.path = path;
        this.setRelativePath(relativePath);
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public FileEntity getInstance(String id, String name, String path, String type, String content) {
        this.setId(id);
        this.setName(name);
        this.setPath(path);
        this.setType(type);
        this.setContent(content);
        this.setRelativePath(path.substring(FileConfig.root.length(), path.length()));//填写相对路径
        return this;
    }

    public FileEntity getInstance(String id, String name, String path, String type) {
        this.setId(id);
        this.setName(name);
        this.setPath(path);
        this.setType(type);
        this.setRelativePath(path.substring(FileConfig.root.length(), path.length()));//填写相对路径
        return this;
    }

    public String toString() {
        return "FileEntity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastUpdateTime=" + lastUpdateTime +
                ", path='" + path + '\'' +
                ", parentPath='" + parentPath + '\'' +
                ", type='" + type + '\'' +
                ", version=" + version +
                '}';
    }
}
