package com.saline.naton.entity;

import com.saline.naton.enumerator.PackageTypeEnum;
import jakarta.persistence.*;


@Entity
@Table(name = "PRODUCT", schema = "productowner")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private PackageTypeEnum packageType;
    private Long company;
    @Transient
    private String companyName;

    public Product() {
    }

    public Product(Long id, String name, PackageTypeEnum packageType, Long company, String companyName) {
        this.id = id;
        this.name = name;
        this.packageType = packageType;
        this.company = company;
        this.companyName = companyName;
    }

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
        return packageType;
    }

    public void setPackageType(PackageTypeEnum packageType) {
        this.packageType = packageType;
    }

    public Long getCompany() {
        return company;
    }

    public void setCompany(Long company) {
        this.company = company;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
