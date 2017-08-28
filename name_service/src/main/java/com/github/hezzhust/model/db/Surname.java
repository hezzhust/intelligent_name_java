package com.github.hezzhust.model.db;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.List;

/**
 * 姓氏
 * Created by hezz on 2017/8/28.
 */
@Entity(value = "surname", noClassnameStored = true)
@Data
@ToString
public class Surname {
    public static final String Field_createTime = "CT";
    public static final String Field_modifyTime = "MT";
    public static final String Field_name = "Ne";
    public static final String Field_status = "Ss";
    public static final String Field_type = "Te";
    public static final String Field_tagIds = "TIds";
    public static final String Field_articleIds = "AIds";


    @Id
    private ObjectId id;

    @Property(Field_createTime)
    private long createTime;//创建时间

    @Property(Field_modifyTime)
    private long modifyTime;//更新时间

    @Property(Field_status)
    private int status;//0-停用，1启用，-1删除

    @Property(Field_name)
    private String name;//名字

    @Property(Field_type)
    private int type;//0-姓，1-氏

    @Property(Field_tagIds)
    private List<String> tagIds;//标签id列表

    @Property(Field_articleIds)
    private List<String> articleIds;//来源id列表
}
