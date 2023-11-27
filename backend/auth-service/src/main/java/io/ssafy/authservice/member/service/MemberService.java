package io.ssafy.authservice.member.service;


import io.ssafy.authservice.auth.dto.request.MemberJoinReqDto;
import io.ssafy.authservice.auth.dto.request.MemberLoginReqDto;
import io.ssafy.authservice.global.response.Response;

public interface MemberService {

    Response<?> joinMember (MemberJoinReqDto memberJoinReqDto);
    Response<?> loginMember (MemberLoginReqDto memberLoginReqDto);

    Response<?> validateNickname (String nickname);
    Response<?> validateEmail (String email);

}
