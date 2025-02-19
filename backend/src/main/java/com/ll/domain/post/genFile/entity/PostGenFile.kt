package com.ll.domain.post.genFile.entity;

import com.ll.domain.base.genFile.genFile.entity.GenFile
import com.ll.domain.post.post.entity.Post
import jakarta.persistence.*

@Entity
class PostGenFile : GenFile {
    enum class TypeCode {
        attachment,
        thumbnail
    }

    @ManyToOne(fetch = FetchType.LAZY)
    lateinit var post: Post;

    @Enumerated(EnumType.STRING)
    lateinit var typeCode: TypeCode;

    constructor(post: Post, typeCode: TypeCode, fileNo: Int): super(fileNo) {
        this.post = post;
        this.typeCode = typeCode;
    }

    override fun getOwnerModelId(): Long {
        return post.id
    }

    override fun getTypeCodeAsStr(): String {
        return typeCode.toString();
    }
}
