package com.saline.naton.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.saline.naton.enumerator.PackageTypeEnum;

@Entity
@Table(name="PRODUCT")
public class Product {
	
	@Id
	private Long id;
	private String name;
	private PackageTypeEnum PackageType;
	private Long company;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public PackageTypeEnum getPackageType() {
		return PackageType;
	}
	public void setPackageType(PackageTypeEnum packageType) {
		PackageType = packageType;
	}
	public Long getCompany() {
		return company;
	}
	public void setCompany(Long company) {
		this.company = company;
	}
}
