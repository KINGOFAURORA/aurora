package com.aurora.prototype;

public class ProtoTypeEntity implements Cloneable{
    private Integer p1;

    private String p2;

    private ProtoTypeParam p3;

    public Integer getP1() {
        return p1;
    }

    public void setP1(Integer p1) {
        this.p1 = p1;
    }

    public String getP2() {
        return p2;
    }

    public void setP2(String p2) {
        this.p2 = p2;
    }

    public ProtoTypeParam getP3() {
        return p3;
    }

    public void setP3(ProtoTypeParam p3) {
        this.p3 = p3;
    }

    public ProtoTypeEntity clone() throws CloneNotSupportedException {
        ProtoTypeEntity protoTypeEntity = (ProtoTypeEntity) super.clone();
        protoTypeEntity.setP3(this.p3.clone());
        return protoTypeEntity;
    }

    @Override
    public String toString() {
        return "ProtoTypeEntity{" +
                "p1=" + p1 +
                ", p2='" + p2 + '\'' +
                ", p3=" + p3 +
                '}';
    }
}
