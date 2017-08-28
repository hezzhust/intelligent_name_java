package com.github.hezzhust.model.db;

import lombok.Data;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 * 评论表
 * Created by hezz on 2017/8/28.
 */
@Entity(value = "comment", noClassnameStored = true)
@Data
@ToString
public class Comment {
    public static final String Field_createTime = "CT";
    public static final String Field_modifyTime = "MT";
    public static final String Field_nickName = "NN";
    public static final String Field_status = "Ss";
    public static final String Field_content = "Ct";
    public static final String Field_creatorId = "CId";
    public static final String Field_beReplyId = "BRId";
    public static final String Field_topicId = "TId";
    public static final String Field_type = "Te";

    @Id
    private ObjectId id;

    @Property(Field_createTime)
    private long createTime;//创建时间

    @Property(Field_modifyTime)
    private long modifyTime;//更新时间

    @Property(Field_status)
    private int status;//0-停用，1启用，-1删除

    @Property(Field_nickName)
    private String nickName;//评论人昵称

    @Property(Field_content)
    private String content;//评论内容

    @Property(Field_creatorId)
    private String creatorId;//创建人id

    @Property(Field_beReplyId)
    private String beReplyId;//被回复人id

    @Property(Field_topicId)
    private String topicId;//主题id

    @Property(Field_type)
    private int type;//评论类型，0-主题评论，1-评论的评论

}
