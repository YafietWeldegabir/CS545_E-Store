package waa.finalproject.service.user;

import waa.finalproject.domain.User;
import waa.finalproject.dto.UserAvailabilityRequestDto;
import waa.finalproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User getUserByUsername(String username) {
        return userRepository.findByUsername(username).get();
    }

    @Override
    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);

    }

    @Override
    public User isUsernameAvailable(UserAvailabilityRequestDto userAvailabilityRequestDto) {
        return userRepository.findByUsername(userAvailabilityRequestDto.getUsername()).get();
    }
}
