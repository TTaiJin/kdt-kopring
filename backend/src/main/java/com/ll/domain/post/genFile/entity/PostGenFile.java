package com.ll.domain.post.genFile.entity;

import com.ll.domain.base.genFile.genFile.entity.GenFile;
import com.ll.domain.post.post.entity.Post;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class PostGenFile extends GenFile {
    public PostGenFile(Post post, TypeCode typeCode, int fileNo) {
        super(fileNo);
        this.post = post;
        this.typeCode = typeCode;
    }

    public enum TypeCode {
        attachment,
        thumbnail
    }

    @ManyToOne(fetch = FetchType.LAZY)
    private Post post;
    @Enumerated(EnumType.STRING)
    private TypeCode typeCode;

    @Override
    protected long getOwnerModelId() {
        return post.getId();
    }

    @Override
    protected String getTypeCodeAsStr() {
        return typeCode.name();
    }
}
