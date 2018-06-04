package com.maxpro.model;

import com.maxpro.support.model.FaqStatus;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String question;
    private String answer;
    @Column(columnDefinition = "bigint default 0")
    private long likeCount;
    // or simply
    // private long likeCount=0;
    @Column(columnDefinition = "bigint default 0")
    private long dislikeCount;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "varchar(8) default 'PENDING'")
    private FaqStatus status = FaqStatus.PENDING;
    @CreatedDate
    private Date created;
    @LastModifiedBy
    private Date updated;

    public Faq() {
    }

    public Faq(String question, String answer) {
        this.question = question;
        this.answer = answer;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }

    public long getDislikeCount() {
        return dislikeCount;
    }

    public void setDislikeCount(long dislikeCount) {
        this.dislikeCount = dislikeCount;
    }

    public FaqStatus getStatus() {
        return status;
    }

    public void setStatus(FaqStatus status) {
        this.status = status;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Faq{" +
                "id=" + id +
                ", question='" + question + '\'' +
                ", answer='" + answer + '\'' +
                ", likeCount=" + likeCount +
                ", dislikeCount=" + dislikeCount +
                ", status='" + status + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }

}
