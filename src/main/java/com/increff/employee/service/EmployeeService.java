package com.increff.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.increff.employee.pojo.EmployeePojo;
import com.increff.empoyee.dao.EmployeeDao;

@Service
public class EmployeeService {
	
	@Autowired
	private EmployeeDao dao;

	public void add(EmployeePojo p) {
		normalize(p);
		dao.insert(p);
	}
	
	public void delete(int id) throws ApiException {
		getCheck(id);
		dao.delete(id);
	}
	
	
	public EmployeePojo get(int id) throws ApiException {
		EmployeePojo p = getCheck(id);
		return p;
	}
	
	public List<EmployeePojo> getAll() {
		return dao.selectAll();
	}
	
	public void update(int id, EmployeePojo p) throws ApiException {
		normalize(p);
		getCheck(id);
		dao.update(id, p);
	}
	public EmployeePojo getCheck(int id) throws ApiException  {
		EmployeePojo p = dao.select(id);
		if(p==null) {
			throw new ApiException("Employee with given id does not exists. id: "+ id);
		}
		return p;
		
	}
	
	private static void normalize(EmployeePojo p) {
		p.setName(p.getName().toLowerCase().trim());
		
	}
}
