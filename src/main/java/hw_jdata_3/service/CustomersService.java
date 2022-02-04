package hw_jdata_3.service;

import hw_jdata_3.repository.CustomersRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomersService {
    private final CustomersRepository customersRepository;

    public CustomersService(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<String> getProductName(String name) {
        return customersRepository.getProductName(name);
    };
}
