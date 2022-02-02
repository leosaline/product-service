package com.saline.naton.dto;

import com.saline.naton.enumerator.PackageTypeEnum;

public class ProductDTO {
    private Long id;
    private String name;
    private PackageTypeEnum packageType;
    private Long company;
    private String companyName;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public PackageTypeEnum getPackageType() {
        return packageType;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Long getCompany() {
        return company;
    }

    private ProductDTO(ProductDTOBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.packageType = builder.packageType;
        this.companyName = builder.companyName;
        this.company = builder.company;
    }

    public static class ProductDTOBuilder {
        private Long id;
        private String name;
        private PackageTypeEnum packageType;
        private Long company;
        private String companyName;

        public ProductDTOBuilder(Long id, String name) {
            this.id = id;
            this.name = name;
        }

        public ProductDTOBuilder withPackageTypeEnum(PackageTypeEnum packageType) {
            this.packageType = packageType;
            return this;
        }

        public ProductDTOBuilder withCompanyName(String companyName) {
            this.companyName = companyName;
            return this;
        }

        public ProductDTOBuilder withCompany(Long company) {
            this.company = company;
            return this;
        }

        public ProductDTO build() {
            return new ProductDTO(this);
        }
    }
}
