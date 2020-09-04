package com.jingang.springinterfacetest.model;

import com.jingang.springinterfacetest.utils.JGString;
import com.jingang.springinterfacetest.utils.JGTime;
import com.jingang.springinterfacetest.utils.JGYamlUntil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

/**
 * @program: jg-api-autotest
 * @description: 创建项目接口入参bean
 * @author: LiuGang
 * @create: 2020-09-05 00:25
 **/
@Slf4j
@Data
public class ProjectAddParamDemo {

    private String projectName;
    private String specCode;
    private Integer openFlag;
    private String projectDesc;
    private String projectId;
    private List<Admins> admins;
    private String specName;

    @Data
    @AllArgsConstructor
    public static class Admins {
        private String memberId;
        private String memberName;
    }

    public ProjectAddParamDemo(Integer openFlag, String specCode, String specName, List<Admins> admins) {
        this.projectName = "自动化创建项目" + JGString.onlyMark();
        this.projectDesc = "自动化项目的描述信息" + JGTime.getTimeFormatAsDay(null, 0);
        this.projectId = "jingang-auto-" + JGString.onlyMark();
        this.openFlag = openFlag;
        this.specCode = specCode;
        this.specName = specName;
        this.admins = admins;

    }


}

