package com.saline.naton.dto;

import com.saline.naton.enumerator.PackageTypeEnum;

public record ProductDTO(Long id,
                         String name,
                         PackageTypeEnum packageType,
                         Long company,
                         String companyName) {
}
