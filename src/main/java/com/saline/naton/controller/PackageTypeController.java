package com.saline.naton.controller;

import com.saline.naton.enumerator.PackageTypeEnum;
import com.saline.naton.exception.PackageTypeNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.Collection;

@RestController()
public class PackageTypeController {

    @GetMapping(value = "/packagetype/{id}", produces = "application/json")
    public ResponseEntity<PackageTypeEnum> getPackageTypeEnumById(@PathVariable Integer id) {
        PackageTypeEnum packTypeEnum = Arrays.stream(PackageTypeEnum.values())
                .filter(v -> v.getId().equals(id))
                .findAny().orElseThrow(() -> new PackageTypeNotFoundException(id));
        return ResponseEntity.ok(packTypeEnum);
    }

    @GetMapping(value = "/packagetype", produces = "application/json")
    public ResponseEntity<Collection<PackageTypeEnum>> findAllPackageType() {
        Collection<PackageTypeEnum> packageTypeEnums = Arrays.asList(PackageTypeEnum.values());
        return ResponseEntity.ok(packageTypeEnums);
    }
}
