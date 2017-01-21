package com.gyf.graduate.domain;

/**
 * Created by GYF on 2017/1/20.
 */

import lombok.Getter;
import lombok.Setter;

/**
 * 主题分类
 * 1-IOS,2-Android,3-Windows,4-Linux
 */
@Getter@Setter
public class Type extends BaseDomain {
    private String name;    //分类名称
}
