package stocksim.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import stocksim.demo.service.OrderService;

@RestController
public class OrderController {

    @Autowired
    OrderService orderService;
}
