package com.getanoutfit.salesAndInventory.Employee;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }
    public Optional<Employee> findById(Integer id){
        return employeeRepository.findById(id);
    }
    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }
    public void deleteById(Integer id){
        employeeRepository.deleteById(id);
    }

}
