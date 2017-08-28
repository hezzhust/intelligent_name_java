package com.github.hezzhust.model.db;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.List;

/**
 * 原始 文章
 * 诗
 * 词
 * 曲
 * 经典文言文，诸如论语，道德经等
 * Created by hezz on 2017/8/28.
 */
@Entity(value = "article", noClassnameStored = true)
@Data
@ToString
public class Article {
    public static final String Field_createTime = "CT";
    public static final String Field_modifyTime = "MT";
    public static final String Field_content = "Ct";
    public static final String Field_authorIds = "AIds";
    public static final String Field_tagIds = "TIds";
    public static final String Field_status = "Ss";

    @Id
    private ObjectId id;

    @Property(Field_createTime)
    private long createTime;//创建时间

    @Property(Field_modifyTime)
    private long modifyTime;//更新时间

    @Property(Field_content)
    private String content;//文本内容

    @Property(Field_authorIds)
    private List<String> authorIds;//作者id列表

    @Property(Field_tagIds)
    private List<String> tagIds;//标签id列表

    @Property(Field_status)
    private int status;//0-停用，1启用，-1删除
}
