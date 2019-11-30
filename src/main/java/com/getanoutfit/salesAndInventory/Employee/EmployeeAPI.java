package com.getanoutfit.salesAndInventory.Employee;

import com.getanoutfit.salesAndInventory.Mapper.MapperBuilder;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/v1/employee")
@RequiredArgsConstructor
@Slf4j
public class EmployeeAPI {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        Map response = new HashMap<>();
        List<Employee> employeeList = employeeService.findAll();

        List<EmployeeDTO> dtoList = employeeList.stream().map(employee -> MapperBuilder.INSTANCE.employeeToEmployeeDTO(employee)).collect(Collectors.toList());

        response.put("data", dtoList);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findById(@PathVariable Integer id) {
        Map response = new HashMap();
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            response.put("status", HttpServletResponse.SC_NOT_FOUND);
            response.put("message", "data not found against this id");
            return ResponseEntity.ok(response);
        }
        EmployeeDTO employeeDTO = MapperBuilder.INSTANCE.employeeToEmployeeDTO(employee.get());
        response.put("data", employeeDTO);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody EmployeeDTO employeeDTO) {
        Map response = new HashMap();
        Employee employee = MapperBuilder.INSTANCE.employeeDTOToEmployee(employeeDTO);
        employeeService.save(employee);
        response.put("data", employeeDTO);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}" , consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody EmployeeDTO employeeDTO){
        Map response = new HashMap();
        Optional<Employee> employee = employeeService.findById(id);
        if(!employee.isPresent()){
            response.put("status", HttpServletResponse.SC_NOT_MODIFIED);
            response.put("message", "no data found against this id");
            return ResponseEntity.ok(response);
        }
        employeeService.save(MapperBuilder.INSTANCE.employeeDTOToEmployee(employeeDTO));
        response.put("data", employeeDTO);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);

    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> delete(@PathVariable Integer id) {
        Map response = new HashMap();
        Optional<Employee> employee = employeeService.findById(id);
        if (!employee.isPresent()) {
            response.put("status", HttpServletResponse.SC_NOT_FOUND);
            response.put("message", "data not found against this id");
            return ResponseEntity.ok(response);
        }
        employeeService.deleteById(id);
        response.put("status", HttpServletResponse.SC_OK);
        response.put("message", "data deleted successfully");
        return ResponseEntity.ok(response);
    }
}
