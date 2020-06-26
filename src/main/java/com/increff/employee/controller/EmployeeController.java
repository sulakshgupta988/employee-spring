package com.increff.employee.controller;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.increff.employee.model.EmployeeData;
import com.increff.employee.model.EmployeeForm;
import com.increff.employee.pojo.EmployeePojo;
import com.increff.employee.service.ApiException;
import com.increff.employee.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Api
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;

	@ApiOperation(value = "Adds an Employee")
	@RequestMapping(path = "/api", method = RequestMethod.POST)
	public void add(@RequestBody EmployeeForm userform) {
		EmployeePojo p = convert(userform);
		service.add(p);

	}

	@ApiOperation(value = "Deletes an employee")
	@RequestMapping(path = "/api/{id}", method = RequestMethod.DELETE)
	public void delete(@PathVariable int id) throws ApiException {
		service.delete(id);
	}

	@ApiOperation(value = "Gets an employee By id")
	@RequestMapping(path = "/api/{id}", method = RequestMethod.GET)
	public EmployeeData get(@PathVariable int id) throws ApiException {
		EmployeePojo p = service.get(id);
		return convert(p);
	}

	@ApiOperation(value = "Gets List of all Employees")
	@RequestMapping(path = "/api", method = RequestMethod.GET)
	public List<EmployeeData> getAll() {
		List<EmployeePojo> list = service.getAll();
		List<EmployeeData> list2 = new ArrayList<EmployeeData>();
		for (EmployeePojo p : list) {
			list2.add(convert(p));
		}

		return list2;
	}

	@ApiOperation(value = "Updates an employee")
	@RequestMapping(path = "/api/{id}", method = RequestMethod.PUT)
	public void update(@PathVariable int id, @RequestBody EmployeeForm f) throws ApiException {
		EmployeePojo p = convert(f);
		service.update(id, p);
	}

	private static EmployeeData convert(EmployeePojo p) {
		EmployeeData d = new EmployeeData();
		d.setAge(p.getAge());
		d.setName(p.getName());
		d.setId(p.getId());
		return d;

	}

	private static EmployeePojo convert(EmployeeForm userform) {
		EmployeePojo p = new EmployeePojo();
		p.setAge(userform.getAge());
		p.setName(userform.getName());
		return p;
	}
}
