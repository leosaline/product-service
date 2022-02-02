package com.saline.naton.exception;

public class PackageTypeNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 5685193332359051171L;

	public PackageTypeNotFoundException(Integer id) {
		super("Package Type not found: " + id);
	}

}
