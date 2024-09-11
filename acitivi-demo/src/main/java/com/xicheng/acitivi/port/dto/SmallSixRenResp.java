package com.xicheng.acitivi.port.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Accessors(chain = true)
public class SmallSixRenResp {
    String qian;
    String zhong;
    String hou;
}
