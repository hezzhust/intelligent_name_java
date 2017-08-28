package com.github.hezzhust.model.db;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * 标签表
 * Created by hezz on 2017/8/28.
 */
@Entity(value = "tag", noClassnameStored = true)
@Data
@ToString
public class Tag {
    public static final String Field_createTime = "CT";
    public static final String Field_modifyTime = "MT";
    public static final String Field_name = "Ne";
    public static final String Field_status = "Ss";

    @Id
    private ObjectId id;

    @Property(Field_createTime)
    private long createTime;//创建时间

    @Property(Field_modifyTime)
    private long modifyTime;//更新时间

    @Property(Field_name)
    private String name;//标签名称

    @Property(Field_status)
    private int status;//0-停用，1启用，-1删除
}
