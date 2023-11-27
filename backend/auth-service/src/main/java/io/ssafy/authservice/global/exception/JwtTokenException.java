package io.ssafy.authservice.global.exception;

public class JwtTokenException extends RuntimeException{
    public JwtTokenException(String message){
        super(message);
    }
}
