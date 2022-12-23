package jpaApp;


import dao.EmployeeDAO;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import model.Address;
import model.AddressId;
import model.Department;
import model.Employee;
import model.Group;

public class App 
{
    public static void main( String[] args )
    {
        
        Department department=new Department("Software");
        AddressId addressId = new AddressId(14, "tom", "London", "UK");
        Address address=new Address(addressId);
        Set<Address> addresses=new HashSet<>();
        addresses.add(address);
        Group group = new Group("Geeks");
        List<Group> groups=new ArrayList<>();
        groups.add(group);
        Employee employee1=new Employee("Mohammed",department,addresses,groups);
        EmployeeDAO employeedao=new EmployeeDAO();
        employeedao.updateEmployee(30,employee1);
    }
}

