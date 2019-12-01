package com.getanoutfit.salesAndInventory.Mapper;

import com.getanoutfit.salesAndInventory.Employee.Employee;
import com.getanoutfit.salesAndInventory.Employee.EmployeeDTO;
import com.getanoutfit.salesAndInventory.Product.ProductDto;
import com.getanoutfit.salesAndInventory.Product.Product;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategory;
import com.getanoutfit.salesAndInventory.ProductCategory.ProductCategoryDTO;
import com.getanoutfit.salesAndInventory.User.User;
import com.getanoutfit.salesAndInventory.User.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MapperBuilder {
    MapperBuilder INSTANCE = Mappers.getMapper(MapperBuilder.class);

    @Mapping(source = "prodDescription", target = "prodDesc")
    @Mapping(source = "productCategory.id", target = "prodCategory")
    @Mapping(source = "id",target = "prodId")
    ProductDto productToProductDto(Product product);

    @Mapping(source = "prodDesc", target = "prodDescription")
    @Mapping(source = "prodCategory", target = "productCategory.id")
    @Mapping(source = "prodId",target = "id")
    Product productDTOToProduct(ProductDto productDto);

    ProductCategoryDTO productCategoryToProductCategoryDto(ProductCategory productCategory);

    ProductCategory productCategoryDTOToProductCategory(ProductCategoryDTO productCategoryDTO);

    @Mapping(source = "fname", target = "fullName.fname")
    @Mapping(source = "lname", target = "fullName.lname")
    @Mapping(source = "permanentAddress", target = "address.permanentAddress")
    @Mapping(source = "residentialAddress", target = "address.residentialAddress")
    Employee employeeDTOToEmployee(EmployeeDTO employeeDTO);

    @Mapping(source = "fullName.fname", target = "fname")
    @Mapping(source = "fullName.lname", target = "lname")
    @Mapping(source = "address.permanentAddress", target = "permanentAddress")
    @Mapping(source = "address.residentialAddress", target = "residentialAddress")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);

    @Mapping(source = "employee.id", target = "empId")
    UserDTO userToUserDTO(User user);

    @Mapping(source = "empId", target = "employee.id")
    User userDTOToUser(UserDTO userDTO);

    User loginDTOToUser(UserDTO user);

}
