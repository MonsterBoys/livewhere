package com.xu.hasee.livewhere.home.small_strategy;

/**
 * Created by Administrator on 2016/5/19 0019.
 */
public class SmallStrategyEntitys {
    private String name;
    private String pic;
    private String subname;
    private String kid;

    public SmallStrategyEntitys(String name, String pic, String subname, String kid) {
        this.name = name;
        this.pic = pic;
        this.subname = subname;
        this.kid = kid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    public String getSubname() {
        return subname;
    }

    public void setSubname(String subname) {
        this.subname = subname;
    }

    public String getKid() {
        return kid;
    }

    public void setKid(String kid) {
        this.kid = kid;
    }
}
