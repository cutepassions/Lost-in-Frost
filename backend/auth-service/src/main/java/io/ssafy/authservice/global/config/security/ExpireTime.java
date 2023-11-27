package io.ssafy.authservice.global.config.security;

import org.springframework.beans.factory.annotation.Value;

public class ExpireTime {

    public static final Long ACCESS_TOKEN_EXPIRE_TIME = 21600000L; // 6시간
    // public static final long ACCESS_TOKEN_EXPIRE_TIME = 6 * 6 * 1000L; //36초
}
