package io.ssafy.userservice.user.member.enums;

import lombok.Getter;

@Getter
public enum RankingChange {
    UP("상승"),
    DOWN("하락"),
    KEEP("유지");

    private final String description;

    RankingChange(String description) {
        this.description=description;
    }
}
