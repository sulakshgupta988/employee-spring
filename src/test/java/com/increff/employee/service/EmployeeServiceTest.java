package com.increff.employee.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import com.increff.employee.pojo.EmployeePojo;

@Transactional
public class EmployeeServiceTest extends AbstractUnitTest {
	
	@Autowired
	private EmployeeService service;
	
	@Test
	public void testAdd() {
		EmployeePojo p = new EmployeePojo();
		p.setName(" Sulaksh Gupta ");
		service.add(p);
	}
	
	@Test
	public void testNormalize() {
		EmployeePojo p = new EmployeePojo();
		p.setName(" Sulaksh Gupta ");
		EmployeeService.normalize(p);
		assertEquals("sulaksh gupta", p.getName());
	}
}
