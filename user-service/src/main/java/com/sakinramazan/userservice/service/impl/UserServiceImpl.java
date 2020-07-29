package com.sakinramazan.userservice.service.impl;

import com.sakinramazan.userservice.dto.UserDTO;
import com.sakinramazan.userservice.entity.Address;
import com.sakinramazan.userservice.entity.User;
import com.sakinramazan.userservice.exception.UserNotFoundException;
import com.sakinramazan.userservice.model.ToDoModel;
import com.sakinramazan.userservice.repository.UserRepository;
import com.sakinramazan.userservice.service.AddressService;
import com.sakinramazan.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    private final AddressService addressService;

    private final RestTemplate restTemplate;

    private ModelMapper modelMapper;

    @Value("${todoservice.baseurl}")
    private String todoServiceBaseUrl;

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
    }

    @Cacheable(value = "users")
    @Override
    public List<UserDTO> getAll() {
        List<User> all = userRepository.findAll();
        return all.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getOne(Integer id) {
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(() -> new UserNotFoundException(id));
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
        User byEmail = userRepository.getByEmail(email);
        return modelMapper.map(byEmail, UserDTO.class);
    }

    //  @CachePut(value = "users", key = "#result.id", unless = "#result == null")
    @CacheEvict(value = "users", allEntries = true)
    @Override
    public UserDTO addOne(User user) {
        User save = userRepository.save(user);
        return modelMapper.map(save, UserDTO.class);
    }

    //  @CachePut(value = "users", key = "#result.id", unless = "#result == null")
    @CacheEvict(value = "users", allEntries = true)
    @Override
    public UserDTO updateOne(User user) {
        // we need to check dto id or put another validation
        // to prevent db null field exceptions
        // we can customize the exception to handle on
        // genericExpHandler specifically
        if (user.getId() == null)
            throw new RuntimeException("Id must not be null for update entity");
        // check whether there is a such user or not
        getOne(user.getId());
        User save = userRepository.save(user);
        return modelMapper.map(save, UserDTO.class);
    }

    @CacheEvict(value = "users", allEntries = true)
    @Override
    public Map<String, String> deleteOne(Integer id) {
        // check whether there is a such user or not
        Optional<User> byId = userRepository.findById(id);
        User user = byId.orElseThrow(() -> new UserNotFoundException(id));
        userRepository.delete(user);
        Map<String, String> response = new HashMap<>();
        response.put("Deleted", Boolean.TRUE.toString());
        return response;
    }

    public List<ToDoModel> getAllToDosViaRestTemplate() {
        final String uri = todoServiceBaseUrl + "/all";

        ResponseEntity<List<ToDoModel>> result = restTemplate.exchange(uri, HttpMethod.GET, getHeader(),
                new ParameterizedTypeReference<List<ToDoModel>>() {
                }
        );
        return result.getBody();
    }

    @Override
    public List<UserDTO> getUsersByAddress(Integer address_id) {
        Address one = addressService.getOne(address_id);
        List<User> allByAddress = userRepository.getAllByAddress(one);
        return allByAddress.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDTO> getUsersByAddressCityName(String city) {
        List<User> allByAddress_city = userRepository.getAllByAddress_City(city);
        return allByAddress_city.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }

    private HttpEntity<String> getHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        return new HttpEntity<>("parameters", headers);
    }

}
