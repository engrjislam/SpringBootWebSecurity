package com.maxpro.model;

import com.maxpro.support.model.FaqStatus;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;


@Entity
public class Faq {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(nullable = false, columnDefinition = "TEXT")
    private String question;
    @Lob
    @Column
    private String answer;
    @Column(columnDefinition = "BIGINT default 0")
    private long likeCount;
    // or simply
    // private long likeCount=0;
    @Column(columnDefinition = "BIGINT default 0")
    private long dislikeCount;
    @Enumerated(EnumType.STRING)
    @Column(columnDefinition = "VARCHAR(8) default 'PENDING'")
    private FaqStatus status = FaqStatus.PENDING;
    @Basic(optional = false)
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    private Date created;
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(insertable = false)
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
