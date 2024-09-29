package com.xicheng.acitivi.port.controller.user;

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


    @CrossOrigin(origins = "http://127.0.0.1:8080")
    @PostMapping("/api/user/small-liu-ren-test")
    public SmallSixRenResp findAllPublic(@RequestBody @Validated SmallSixRenReq smallSixRenReq) {
        log.info("进入后端接口");
        return smallLiuRenService.getSmallRes(smallSixRenReq);
    }

}
