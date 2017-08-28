package com.github.hezzhust.model.db;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * 用户操作行为表
 * Created by hezz on 2017/8/28.
 */
@Entity(value = "activity", noClassnameStored = true)
@Data
@ToString
public class Activity {
    public static final String Field_createTime = "CT";

    @Id
    private ObjectId id;

    @Property(Field_createTime)
    private long createTime;//创建时间
}
