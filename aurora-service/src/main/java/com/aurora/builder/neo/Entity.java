package com.aurora.builder.neo;

public class Entity {
    private Integer property1;
    private Boolean property2;
    private String property3;
    private Long property4;

    public Integer getProperty1() {
        return property1;
    }

    public Boolean getProperty2() {
        return property2;
    }

    public String getProperty3() {
        return property3;
    }

    public Long getProperty4() {
        return property4;
    }

    private Entity(Builder builder){
        property1 = builder.property1;
        property2 = builder.property2;
        property3 = builder.property3;
        property4 = builder.property4;
    }

    public static final class Builder{
        private Integer property1;
        private Boolean property2;
        private String property3;
        private Long property4;
        public Builder setProperty1(Integer property1){
            this.property1 = property1;
            return this;
        }

        public Builder setProperty2(Boolean property2){
            this.property2 = property2;
            return this;
        }

        public Builder setProperty3(String property3){
            this.property3 = property3;
            return this;
        }

        public Builder setProperty4(Long property4){
            this.property4 = property4;
            return this;
        }

        public Entity build(){
            return new Entity(this);
        }

        public static Builder getInstance(){
            return new Builder();
        }
    }

    @Override
    public String toString() {
        return "Entity{" +
                "property1=" + property1 +
                ", property2=" + property2 +
                ", property3='" + property3 + '\'' +
                ", property4=" + property4 +
                '}';
    }
}
