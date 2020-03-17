package com.saline.naton.controller;

import java.util.Arrays;
import java.util.Collection;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.saline.naton.enumerator.PackageTypeEnum;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
public class PackageTypeController {

	@ApiResponses(value = { @ApiResponse(code = 200, message = "Return list of products") })
	@RequestMapping(value = "/packagetypes", method = RequestMethod.GET, produces = "application/json")
	@CrossOrigin(origins = {"http://localhost:8080", " http://natonfrontend:8080"})
	@ResponseBody
	public ResponseEntity<Collection<PackageTypeEnum>> listPackageType() {
		return ResponseEntity.ok(Arrays.asList(PackageTypeEnum.values()));
	}
}
