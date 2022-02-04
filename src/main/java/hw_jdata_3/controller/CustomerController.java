package hw_jdata_3.controller;

import hw_jdata_3.service.CustomersService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomersService customersService;

    public CustomerController(CustomersService customersService) {
        this.customersService = customersService;
    }

    @GetMapping("/products/fetch-product")
    public List<String> getProductName(@RequestParam("name") String name) {
        return customersService.getProductName(name);
    };

    @ExceptionHandler
    ResponseEntity<String> handlerUnauthorizedUser(RuntimeException exp) {
        exp.printStackTrace();
        return new ResponseEntity<>("Ошибка обработки запроса", HttpStatus.SERVICE_UNAVAILABLE);
    }


}
