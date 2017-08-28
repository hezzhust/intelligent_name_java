package com.github.hezzhust.model.db;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.List;

/**
 * 完整的姓名
 * Created by hezz on 2017/8/28.
 */
@Entity(value = "full_name", noClassnameStored = true)
@Data
@ToString
public class FullName {
    public static final String Field_createTime = "CT";
    public static final String Field_modifyTime = "MT";
    public static final String Field_name = "Ne";
    public static final String Field_status = "Ss";
    public static final String Field_fullName = "FN";
    public static final String Field_surnameId = "SId";
    public static final String Field_nameId = "NId";
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

    @Property(Field_fullName)
    private String fullName;//姓名

    @Property(Field_surnameId)
    private String surnameId;//姓氏id

    @Property(Field_nameId)
    private String nameId;//名字id

    @Property(Field_tagIds)
    private List<String> tagIds;//标签id列表

    @Property(Field_articleIds)
    private List<String> articleIds;//来源id列表
}
