package com.ssafy.naite.domain.comment;

import com.ssafy.naite.domain.board.Board;
import com.ssafy.naite.domain.user.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer commentNo;

    @ManyToOne
    @JoinColumn(name = "user_no")
    private User user;

    @ManyToOne
    @JoinColumn(name = "board_no")
    private Board board;

    @Column(length = 200)
    private String commentContent;

    private Timestamp commentCreatedAt;
    private Timestamp commentUpdatedAt;
    private Byte commentIsDeleted;
    private Integer commentReportCnt;
    private Integer commentParentId;

    @Builder
    public Comment(Integer commentNo, User user, Board board, String commentContent, Timestamp commentCreatedAt, Timestamp commentUpdatedAt, Byte commentIsDeleted, Integer commentReportCnt, Integer commentParentId) {
        this.commentNo = commentNo;
        this.board = board;
        this.user = user;
        this.commentContent = commentContent;
        this.commentCreatedAt = commentCreatedAt;
        this.commentUpdatedAt = commentUpdatedAt;
        this.commentIsDeleted = commentIsDeleted;
        this.commentReportCnt = commentReportCnt;
        this.commentParentId = commentParentId;
    }

    public void updateContent(String content) {
        this.commentContent = content;
    }

    public void updateDelete() {
        this.commentIsDeleted = 1;
    }

    public void updateTime() {
        this.commentUpdatedAt = new Timestamp(System.currentTimeMillis() + (1000 * 60 * 60 * 9));
    }

    @Override
    public String toString() {
        return "Comment{" +
                "commentNo=" + commentNo +
                ", user=" + user +
                ", board=" + board +
                ", commentContent='" + commentContent + '\'' +
                ", commentCreatedAt=" + commentCreatedAt +
                ", commentUpdatedAt=" + commentUpdatedAt +
                ", commentIsDeleted=" + commentIsDeleted +
                ", commentReportCnt=" + commentReportCnt +
                ", commentParentId=" + commentParentId +
                '}';
    }
}
