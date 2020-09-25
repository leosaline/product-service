package com.saline.naton.assembler;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import com.saline.naton.controller.PackageTypeController;
import com.saline.naton.enumerator.PackageTypeEnum;

@Component
public class PackageTypeEnumAssembler
		implements RepresentationModelAssembler<PackageTypeEnum, EntityModel<PackageTypeEnum>> {

	@Override
	public EntityModel<PackageTypeEnum> toModel(PackageTypeEnum packageTypeEnum) {
		return EntityModel.of(packageTypeEnum,
				linkTo(methodOn(PackageTypeController.class).getPackageTypeEnumById(packageTypeEnum.getId()))
						.withSelfRel(),
				linkTo(methodOn(PackageTypeController.class).findAll()).withRel("packageTypeEnums"));
	}

}
