package com.saline.naton.enumerator;

import com.fasterxml.jackson.annotation.JsonFormat;

@JsonFormat(shape = JsonFormat.Shape.OBJECT)
public enum PackageTypeEnum {
    BOTTLE("Bottle", 1),
    BOX("Box", 2),
    CAN("Can", 3),
    BAR("Bar", 4);

    private final Integer id;
    private final String packageTypeName;

    PackageTypeEnum(String value, Integer id) {
        this.packageTypeName = value;
        this.id = id;
    }

    public String getPackageTypeName() {
        return packageTypeName;
    }

    public Integer getId() {
        return id;
    }

    public String getPackageType() {
        return this.packageTypeName.toUpperCase();
    }
}
