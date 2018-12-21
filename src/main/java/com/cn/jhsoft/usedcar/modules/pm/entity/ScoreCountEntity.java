package com.cn.jhsoft.usedcar.modules.pm.entity;

/**
 * Created by liuyongdong on 2018/5/16.
 */
public class ScoreCountEntity {
    private int score;
    private int num;

    public ScoreCountEntity() {
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    @Override
    public String toString() {
        return "ScoreCountEntity{" +
                "score=" + score +
                ", num=" + num +
                '}';
    }
}
