package io.ssafy.gameservice.config.security;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Map;

@Getter
@AllArgsConstructor
public abstract class OAuth2UserInfo {

    protected Map<String, Object> attributes;

    public abstract String getOAuth2Id();
    public abstract String getEmail();
    public abstract String getName();

    public abstract String getNickname();

    public abstract String profile_imgae();

    public abstract String getAge();

}
