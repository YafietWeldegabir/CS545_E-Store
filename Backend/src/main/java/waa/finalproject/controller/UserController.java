package waa.finalproject.controller;

import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import waa.finalproject.domain.User;
import waa.finalproject.dto.UserAvailabilityRequestDto;
import waa.finalproject.service.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;

@CrossOrigin("http://localhost:3000")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/users")
    public Iterable<User> loadAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/users")
    public ResponseEntity<?> addUser(@RequestBody @Valid User user, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            Map<String,String> result=new HashMap<>();
            bindingResult.getAllErrors().forEach(objectError ->
            {
                result.put(((FieldError)objectError).getField(),objectError.getDefaultMessage());
            });
            return ResponseEntity.badRequest().body(result);
        }
        return  ResponseEntity.ok(userService.addUser(user));
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable long id){
          userService.deleteUser(id);
    }

    @GetMapping("/users/isUsernameAvailable")
    public User isUsernameAvailable(@RequestBody UserAvailabilityRequestDto userAvailabilityRequestDto){
        return userService.isUsernameAvailable(userAvailabilityRequestDto);
    }


}
