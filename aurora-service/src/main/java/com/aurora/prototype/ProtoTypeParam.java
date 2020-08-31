package com.aurora.prototype;

public class ProtoTypeParam implements Cloneable {
    private Integer prop;

    public Integer getProp() {
        return prop;
    }

    public void setProp(Integer prop) {
        this.prop = prop;
    }

    public ProtoTypeParam clone() throws CloneNotSupportedException {
        return (ProtoTypeParam) super.clone();
    }

    @Override
    public String toString() {
        return "ProtoTypeParam{" +
                "prop=" + prop +
                '}';
    }
}
