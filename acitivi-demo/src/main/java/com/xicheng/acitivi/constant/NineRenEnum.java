package com.xicheng.acitivi.constant;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum NineRenEnum {
    DA_AN("大安", WuXingEnum.MU, "", "长期缓慢稳定", 1),
    LIU_LIAN("留连", WuXingEnum.MU, "文昌", "停止反复复杂", 2),
    SU_XI("速喜", WuXingEnum.HUO, "雷祖", "惊喜快速突然", 3),
    CHI_KOU("赤口", WuXingEnum.JIN, "", "争斗凶恶伤害", 4),

    XIAO_JI("小吉", WuXingEnum.SHUI, "真武", "起步不多尚可", 5),

    KONG_WANG("空亡", WuXingEnum.TU, "玉皇", "失去虚伪空想", 6),

    PING_FU("病符", WuXingEnum.JIN, "后土", "病态异常治疗", 7),

    TAO_HUA("桃花", WuXingEnum.TU, "城隍", "欲望牵绊异性", 8),

    TIAN_DE("天德", WuXingEnum.JIN, "紫微", "贵人上司高远", 9);


    public String name;
    public WuXingEnum wuXingEnum;
    public String owner;
    public String desc;
    public int index;
}
