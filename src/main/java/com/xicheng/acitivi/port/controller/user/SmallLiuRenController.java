package com.xicheng.acitivi.port.controller.user;

import com.xicheng.acitivi.port.dto.LoginReq;
import com.xicheng.acitivi.port.dto.SmallSixRenReq;
import com.xicheng.acitivi.port.dto.SmallSixRenResp;
import com.xicheng.acitivi.port.service.SmallLiuRenService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


@RestController
@AllArgsConstructor
@RequestMapping
@Slf4j
public class SmallLiuRenController {
    private final SmallLiuRenService smallLiuRenService;


    @CrossOrigin(origins = "*")
    @PostMapping("/api/user/small-liu-ren-test")
    public SmallSixRenResp findAllPublic(@RequestBody @Validated SmallSixRenReq smallSixRenReq) {
        return smallLiuRenService.getSmallRes(smallSixRenReq);
    }


    @CrossOrigin(origins = "*")
    @PostMapping("/api/login")
    public Boolean login(@RequestBody @Validated LoginReq loginReq) {
        log.info("登录请求" + loginReq);
        return loginReq.getUsername().equals(loginReq.getPassword());
    }

}
