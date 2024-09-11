package com.xicheng.acitivi.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum WuXingEnum {
    JIN("金", "水", "木"),
    MU("木", "火", "土"),
    SHUI("水", "木", "火"),
    HUO("火", "土", "金"),
    TU("土", "金", "火");

    public String name;
    public String sheng;
    public String ke;
}
