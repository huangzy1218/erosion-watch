package cn.edu.nwafu.erosion.portal.domain.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.data.elasticsearch.annotations.Setting;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Huang Z.Y.
 */
@Document(indexName = "erosion")
@Setting(shards = 1, replicas = 0)
public class EsReference implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    @Field(analyzer = "ik_max_word", type = FieldType.Keyword)
    private String label;
    @Field(analyzer = "ik_max_word", type = FieldType.)
    private String author;
    private Integer year;
    private String abstractText;
    private Date createTime;
}
    