package com.saline.naton.enumerator;

public enum PackageTypeEnum {
	BOTTLE("Bottle"),
	BOX("Box"),
	CAN("Can"),
	BAR("Bar");
	
	public String packageTypeName;
	
	PackageTypeEnum(String value){
		this.packageTypeName = value;
	}

	public String getPackageTypeName() {
		return packageTypeName;
	}
}
