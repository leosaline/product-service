package com.saline.naton.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.saline.exception.PackageTypeNotFoundException;
import com.saline.naton.assembler.PackageTypeEnumAssembler;
import com.saline.naton.enumerator.PackageTypeEnum;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PackageTypeController {
	private final PackageTypeEnumAssembler assembler;

	public PackageTypeController(PackageTypeEnumAssembler pteAssembler) {
		assembler = pteAssembler;
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return one package type by id") })
	@GetMapping(value = "/packagetype/{id}", produces = "application/json")
	public EntityModel<PackageTypeEnum> getPackageTypeEnumById(@PathVariable Integer id) {
		PackageTypeEnum packTypeEnum = Arrays.stream(PackageTypeEnum.values()).filter(v -> v.getId().equals(id))
				.findAny().orElseThrow(() -> new PackageTypeNotFoundException(id));
		return assembler.toModel(packTypeEnum);
	}

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of package types") })
	@GetMapping(value = "/packagetypes", produces = "application/json")
	public CollectionModel<EntityModel<PackageTypeEnum>> findAll() {
		List<EntityModel<PackageTypeEnum>> packageTypeEnums = Arrays.stream(PackageTypeEnum.values())
				.map(assembler::toModel).collect(Collectors.toList());

		return CollectionModel.of(packageTypeEnums,
				linkTo(methodOn(PackageTypeController.class).findAll()).withSelfRel());
	}
}
