package cn.edu.nwafu.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author Huang Z.Y.
 */
@Component
@ConfigurationProperties(prefix = "file.custom")
public class BaseFileCustomConfig {
    public String fileDispose;
    private String fileSave;

    public String getFileSave() {
        return fileSave;
    }

    public void setFileSave(String fileSave) {
        this.fileSave = fileSave;
    }

    public String getFileDispose() {
        return fileDispose;
    }

    public void setFileDispose(String fileDispose) {
        this.fileDispose = fileDispose;
    }
}
    