package com.saline.naton.controller;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saline.naton.exception.PackageTypeNotFoundException;
import com.saline.naton.enumerator.PackageTypeEnum;

@RestController
public class PackageTypeController {

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/packagetype/{id}", produces = "application/json")
	public ResponseEntity<PackageTypeEnum> getPackageTypeEnumById(@PathVariable Integer id) {
		PackageTypeEnum packTypeEnum = Arrays.stream(PackageTypeEnum.values())
				.filter(v -> v.getId().equals(id))
				.findAny().orElseThrow(() -> new PackageTypeNotFoundException(id));
		return ResponseEntity.ok(packTypeEnum);
	}

	@CrossOrigin(origins = "http://localhost:8080")
	@GetMapping(value = "/packagetypes", produces = "application/json")
	public ResponseEntity<Collection<PackageTypeEnum>> findAll() {
		Iterable<PackageTypeEnum> iterable = Arrays.asList(PackageTypeEnum.values());

		return ResponseEntity.ok((Collection<PackageTypeEnum>) iterable);
	}
}
