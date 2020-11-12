package com.yulecha.utils.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 异常枚举
 */
@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum ExceptionEnum {

    DSC_EXCEPTION_00000("00000", "参数校验"),

    // mxx
    DSC_EXCEPTION_000100("000100", "活动编号不可为空"),
    DSC_EXCEPTION_000101("000101", "营销中心活动试算折扣结果未返回"),

























    // 待使用





























    // 待使用
    ;

    /**
     * 编码
     */
    private String code;

    /**
     * 信息
     */
    private String msg;
}
