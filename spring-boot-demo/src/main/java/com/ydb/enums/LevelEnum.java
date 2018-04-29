package com.ydb.enums;

public enum LevelEnum implements BaseEnum{
    type1(5, "type1type1type1type1type1"),
    ;

    LevelEnum(int value, String description){
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
