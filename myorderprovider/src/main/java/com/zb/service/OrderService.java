package com.zb.service;

import com.zb.entity.Order;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class OrderService {

    private static List<Order> list = new ArrayList<>();

    static{
        Order o1 = new Order();
        o1.setId(1);
        o1.setTitle("订单1");
        o1.setPrice(20.0);
        o1.setUid(1);
        Order o2 = new Order();
        o2.setId(2);
        o2.setTitle("订单2");
        o2.setPrice(30.0);
        o2.setUid(1);
        list.add(o1);
        list.add(o2);
    }

    @RequestMapping(value = "/orderbyuser/{uid}")
    @ResponseBody
    public List<Order> findOrderByUser(@PathVariable("uid") Integer uid) {
        return list;
    }

    @RequestMapping(value = "/saveorder",method = RequestMethod.POST)
    @ResponseBody
    public String saveOrder(@RequestBody Order order){
        list.add(order);
        return "ok";
    }

}
