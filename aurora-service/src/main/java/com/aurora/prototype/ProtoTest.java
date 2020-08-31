package com.aurora.prototype;

public class ProtoTest {
    public static void main(String[] args) throws CloneNotSupportedException {
        ProtoTypeEntity entity = new ProtoTypeEntity();
        entity.setP1(1);
        entity.setP2("aaa");
        ProtoTypeParam protoTypeParam = new ProtoTypeParam();
        protoTypeParam.setProp(9);
        entity.setP3(protoTypeParam);
        ProtoTypeEntity entity1 = entity.clone();
        System.out.println(entity == entity1);
        entity1.setP1(2);
        System.out.println(entity.getP1());
        entity1.getP3().setProp(8);
        System.out.println(entity.getP3().getProp());
    }
}
