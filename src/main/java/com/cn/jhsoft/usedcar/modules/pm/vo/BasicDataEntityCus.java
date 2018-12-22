package com.cn.jhsoft.usedcar.modules.pm.vo;

import com.cn.jhsoft.usedcar.modules.pm.entity.BasicDataEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chenyi9 on 2017/9/11.
 */
public class BasicDataEntityCus extends BasicDataEntity {


    /**
     * 子节点，显示数据时用
     */
    private List<BasicDataEntityCus> childLists = new ArrayList<>();

    /**
     * 导航栏 的这些都不是库里的字段，都是为了前端显示
     * 导航栏链接地址，导航这数据特有
     */
    private String linkUrl;

    /**
     * 导航栏链接打开方式，导航这数据特有
     */
    private String linkTarget;

    /**
     * 导航栏链接的主图
     */
    private String mainImage;

    /**
     * 总题数
     */
    private Integer allQuestionSum;

    /**
     * 未答数
     */
    private Integer allUnAnswerSum;



    public List<BasicDataEntityCus> getChildLists() {
        return childLists;
    }

    public void setChildLists(List<BasicDataEntityCus> childLists) {
        this.childLists = childLists;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }



    public String getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(String linkTarget) {
        this.linkTarget = linkTarget;
    }

    public String getMainImage() {
        return mainImage;
    }

    public void setMainImage(String mainImage) {
        this.mainImage = mainImage;
    }

    public Integer getAllQuestionSum() {
        return allQuestionSum;
    }

    public void setAllQuestionSum(Integer allQuestionSum) {
        this.allQuestionSum = allQuestionSum;
    }

    public Integer getAllUnAnswerSum() {
        return allUnAnswerSum;
    }

    public void setAllUnAnswerSum(Integer allUnAnswerSum) {
        this.allUnAnswerSum = allUnAnswerSum;
    }
}
