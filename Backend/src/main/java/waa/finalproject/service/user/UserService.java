package waa.finalproject.service.user;

import waa.finalproject.domain.User;
import waa.finalproject.dto.UserAvailabilityRequestDto;


public interface UserService {

    User getUserByUsername(String username);

    Iterable<User> getAllUsers();

    User getUserById(long id);

    User addUser(User user);

    void deleteUser(long id);

    User isUsernameAvailable(UserAvailabilityRequestDto userAvailabilityRequestDto);

}
