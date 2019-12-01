package com.getanoutfit.salesAndInventory.User;

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
@RequestMapping("api/v1/user")
@RequiredArgsConstructor
@Slf4j
public class UserAPI {
    @Autowired
    private UserService userService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> findAll() {
        Map response = new HashMap();
        List<UserDTO> users = userService.findAll().stream().map(user -> MapperBuilder.INSTANCE.userToUserDTO(user)).collect(Collectors.toList());
        response.put("data", users);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> save(@Valid @RequestBody UserDTO userDTO) {
        Map response = new HashMap();
        User user = MapperBuilder.INSTANCE.userDTOToUser(userDTO);
        userService.save(user);
        response.put("data", userDTO);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteById(@PathVariable Integer id) {
        Map response = new HashMap();
        if (!userService.findById(id).isPresent()) {
            response.put("status", HttpServletResponse.SC_NOT_FOUND);
            response.put("message", "data not found against this id");
            return ResponseEntity.ok(response);
        }
        userService.deleteById(id);
        response.put("status", HttpServletResponse.SC_OK);
        response.put("message", "data deleted successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@PathVariable Integer id, @Valid @RequestBody UserDTO userDTO){
        Map response = new HashMap();
        Optional<User> user = userService.findById(id);
        if(!user.isPresent()){
            response.put("status", HttpServletResponse.SC_NOT_MODIFIED);
            response.put("message", "no data found against this id");
            return ResponseEntity.ok(response);
        }
        User data = MapperBuilder.INSTANCE.userDTOToUser(userDTO);
        userService.save(data);
        response.put("data", userDTO);
        response.put("status", HttpServletResponse.SC_OK);
        return ResponseEntity.ok(response);
    }
}
