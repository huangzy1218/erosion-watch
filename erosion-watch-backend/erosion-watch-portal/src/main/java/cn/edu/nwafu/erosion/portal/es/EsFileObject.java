package cn.edu.nwafu.erosion.portal.es;

/**
 * @author Huang Z.Y.
 */
public class EsFileObject {
    /**
     * 用于存储文件id
     */
    String id;
    /**
     * 文件名
     */
    String name;
    /**
     * 文件的type，pdf，word，or txt
     */
    String type;
    /**
     * 文件转化成base64编码后所有的内容
     */
    String content;

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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
    