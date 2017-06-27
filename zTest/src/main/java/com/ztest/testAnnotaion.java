package com.ztest;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)//클래스 파일에 저장 JVM적용@testAnnotaion을 쓸수있다.
public @interface testAnnotaion {

}
