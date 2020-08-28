package com.aurora.builder.neo;

public class TestBuilder {

    public static void main(String[] args) {
        Entity entity = Entity.Builder.getInstance()
                .setProperty1(1)
                .setProperty2(false)
                .setProperty3("")
                .setProperty4(2L)
                .build();
        System.out.println(entity.toString());
    }
}
