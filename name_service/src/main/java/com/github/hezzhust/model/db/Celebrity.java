package com.github.hezzhust.model.db;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

import java.util.List;

/**
 * 名人表
 * Created by hezz on 2017/8/28.
 */
@Entity(value = "celebrity", noClassnameStored = true)
@Data
@ToString
public class Celebrity {
    public static final String Field_createTime = "CT";
    public static final String Field_modifyTime = "MT";
    public static final String Field_status = "Ss";
    public static final String Field_fullName = "FN";
    public static final String Field_nickNames = "NNs";
    public static final String Field_surnameId = "SId";
    public static final String Field_nameId = "NId";
    public static final String Field_nationality = "ny";
    public static final String Field_dynasty = "dy";
    public static final String Field_birthDay = "BD";
    public static final String Field_deathDay = "DD";
    public static final String Field_lifeStory = "LS";
    public static final String Field_tagIds = "TIds";



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

    @Property(Field_nickNames)
    private List<String> nickNames;//字号

    @Property(Field_surnameId)
    private String surnameId;//姓氏id

    @Property(Field_nameId)
    private String nameId;//名字id

    @Property(Field_nationality)
    private String nationality;//国籍

    @Property(Field_dynasty)
    private String dynasty;//朝代

    @Property(Field_birthDay)
    private String birthDay;//生辰

    @Property(Field_deathDay)
    private String deathDay;//祭日

    @Property(Field_lifeStory)
    private String lifeStory;//生平事迹

    @Property(Field_tagIds)
    private List<String> tagIds;//标签id列表


}
