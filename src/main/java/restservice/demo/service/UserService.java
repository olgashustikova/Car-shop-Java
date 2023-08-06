package restservice.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import restservice.demo.dto.UserDto;
import restservice.demo.entity.User;
import restservice.demo.repository.UserRepository;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserDto addUser(UserDto userDto) {
        User user = new User();
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setAddress(userDto.getAddress());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        User savedUser = userRepository.save(user);

        // Convert the saved entity back to the DTO
        return new UserDto(savedUser.getFirstName(), savedUser.getLastName(), savedUser.getAddress(), savedUser.getEmail());
    }

    public UserDto getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            return null;
        }
        return new UserDto(user.getFirstName(), user.getLastName(), user.getAddress(), user.getEmail(), user.getPassword());
    }
}
