package com.ydb.enums;

public enum SysDataEnum implements BaseEnum {
    type1(2, "患教标签"),
    ;

    SysDataEnum(int value, String description){
        this.value = value;
        this.description = description;
    }
    private int value;
    private String description;

    @Override
    public int getValue() {
        return this.value;
    }
    public String getDescription(){
        return this.description;
    }
}
