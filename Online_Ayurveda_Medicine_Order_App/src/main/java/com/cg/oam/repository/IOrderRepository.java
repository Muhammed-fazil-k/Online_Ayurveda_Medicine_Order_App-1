package com.cg.oam.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cg.oam.dto.CustomerDTO;
import com.cg.oam.dto.OrderDTO;
import com.cg.oam.entity.Order;

public interface IOrderRepository extends CrudRepository<Order, Integer>{

}
