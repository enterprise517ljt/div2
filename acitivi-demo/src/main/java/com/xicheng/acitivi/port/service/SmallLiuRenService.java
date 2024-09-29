package com.xicheng.acitivi.port.service;

import com.nlf.calendar.Lunar;
import com.nlf.calendar.Solar;
import com.xicheng.acitivi.constant.NineRenEnum;
import com.xicheng.acitivi.port.dto.SmallSixRenReq;
import com.xicheng.acitivi.port.dto.SmallSixRenResp;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class SmallLiuRenService {

    public SmallSixRenResp getSmallRes(SmallSixRenReq smallSixRenReq) {
        int num1 = Integer.valueOf(smallSixRenReq.getNum1());
        int num2 = Integer.valueOf(smallSixRenReq.getNum2());
        int num3 = Integer.valueOf(smallSixRenReq.getNum3());
        String isTime = smallSixRenReq.getNum4();

        int year = LocalDateTime.now().getYear();
        int time = isTime(num1, num2, num3);
        int x, y, z;
        if (!isTime.equals("T") && !isTime.equals("t")) {
            time = 2;
        }

        if (time == 0) {
            System.out.print("查询年月日...");
            Solar solar = new Solar(num1, num2, num3);
            Lunar lunar = solar.getLunar();
            x = lunar.getYear();
            y = lunar.getMonth();
            z = lunar.getDay();
            System.out.println(lunar.getYearInGanZhi() + "年" + lunar.getMonthInChinese() + "月" + lunar.getDayInChinese() + "日" + lunar.getTimeZhi() + "时");
        } else if (time == 1) {
            System.out.print("查询月日时...");
            Solar solar = new Solar(year, num1, num2, num3, 0, 0);
            Lunar lunar = solar.getLunar();
            x = lunar.getMonth();
            y = lunar.getDay();
            z = lunar.getHour();
            System.out.println(lunar.getYearInGanZhi() + "年" + lunar.getMonthInChinese() + "月" + lunar.getDayInChinese() + "日" + lunar.getTimeZhi() + "时");
        } else {
            x = num1;
            y = num2;
            z = num3;
        }

        List<NineRenEnum> nineRenEnum = getNineRenEnum(x, y, z);

        String res1 =
                "[前期]" + nineRenEnum.get(0).name + "(" + nineRenEnum.get(0).wuXingEnum.name + ") ：" + nineRenEnum.get(0).desc + "/";
        String zhong = null;
        if (nineRenEnum.get(1).wuXingEnum.ke == nineRenEnum.get(0).wuXingEnum.name) {
            zhong = "克";

        }
        if (nineRenEnum.get(1).wuXingEnum.sheng == nineRenEnum.get(0).wuXingEnum.name) {
            zhong = "生";

        }
        String res2 =
                "[中期]" + nineRenEnum.get(1).name + "(" + nineRenEnum.get(1).wuXingEnum.name + ") ：" + nineRenEnum.get(1).desc + "/" + (zhong != null ? zhong + "[前]" : "");
        String hou = null;
        if (nineRenEnum.get(2).wuXingEnum.ke == nineRenEnum.get(1).wuXingEnum.name) {
            hou = "克";

        }
        if (nineRenEnum.get(2).wuXingEnum.sheng == nineRenEnum.get(1).wuXingEnum.name) {
            hou = "生";

        }
        String res3 =
                "[后期]" + nineRenEnum.get(2).name + "(" + nineRenEnum.get(2).wuXingEnum.name + ") ：" + nineRenEnum.get(2).desc + "/" + (hou != null ? hou + "[中]" : "");
        SmallSixRenResp smallSixRenResp = new SmallSixRenResp();
        smallSixRenResp.setQian(res1).setZhong(res2).setHou(res3);
        return smallSixRenResp;
    }

    private List<NineRenEnum> getNineRenEnum(int num1, int num2, int num3) {
        List<NineRenEnum> res = new ArrayList<NineRenEnum>();
        int x = num1 % 9 == 0 ? 9 : num1 % 9;
        int y = (num1 + num2 - 1) % 9 == 0 ? 9 : (num1 + num2 - 1) % 9;
        int z = (num1 + num2 + num3 - 2) % 9 == 0 ? 9 : (num1 + num2 + num3 - 2) % 9;
        res.add(getBynumber(x));
        res.add(getBynumber(y));
        res.add(getBynumber(z));
        return res;
    }

    private NineRenEnum getBynumber(int numm) {
        for (NineRenEnum nineRenEnum : NineRenEnum.values()) {
            if (nineRenEnum.index == numm) {
                return nineRenEnum;
            }
        }
        return null;
    }

    public int isTime(int num1, int num2, int num3) {
        if (num1 >= 1900 && num1 <= 2050 && num2 >= 1 && num2 <= 12 && num3 >= 1 && num3 <= 31) {
            return 0;
        }
        if (num1 >= 1 && num1 <= 12 && num2 >= 1 && num2 <= 31 && num3 >= 0 && num3 <= 24) {
            return 1;
        }
        return 2;
    }

}
