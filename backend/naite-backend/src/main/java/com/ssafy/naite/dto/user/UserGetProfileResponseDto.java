package com.ssafy.naite.dto.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class UserGetProfileResponseDto {
    private String userName;
    private String userNick;
    private int userScore;
    private int boardCnt;
    private int commentCnt;
    private int dealCnt;

    @Builder
    public UserGetProfileResponseDto(String userName, String userNick, int userScore, int boardCnt, int commentCnt, int dealCnt) {
        this.userName = userName;
        this.userNick = userNick;
        this.userScore = userScore;
        this.boardCnt = boardCnt;
        this.commentCnt = commentCnt;
        this.dealCnt = dealCnt;
    }
}
