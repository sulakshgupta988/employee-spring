package com.increff.employee.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.increff.employee.model.AboutApp;

import com.increff.employee.service.AboutAppService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;

@Api
@RestController
public class AboutAppController {

	@Autowired
	private AboutAppService service;

	@ApiOperation(value = "Gives application name and version")
	@RequestMapping(path = "/api/about", method = RequestMethod.GET)
	public AboutApp getDetails() {
		AboutApp d = new AboutApp();
		d.setName(service.getName());
		d.setVersion(service.getVersion());
		return d;

	}

}
