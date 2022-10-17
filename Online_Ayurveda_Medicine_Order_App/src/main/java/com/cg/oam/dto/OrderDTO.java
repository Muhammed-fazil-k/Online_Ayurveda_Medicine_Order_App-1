package com.cg.oam.dto;

import java.time.LocalDate;
import java.util.Objects;

public class OrderDTO {
	
	private Integer orderId;
	private LocalDate orderDate;
	private LocalDate dispatchDate;
	private Float totalCost;
	private OrderStatus orderStatus;
	public OrderDTO() {
		super();
	}
	public OrderDTO(Integer orderId, LocalDate orderDate, LocalDate dispatchDate, Float totalCost,OrderStatus orderStatus) {
		super();
		this.orderId = orderId;
		this.orderDate = orderDate;
		this.dispatchDate = dispatchDate;
		this.totalCost = totalCost;
		this.orderStatus = orderStatus;
	}
	public Integer getOrderId() {
		return orderId;
	}
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	public LocalDate getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDate orderDate) {
		this.orderDate = orderDate;
	}
	public LocalDate getDispatchDate() {
		return dispatchDate;
	}
	public void setDispatchDate(LocalDate dispatchDate) {
		this.dispatchDate = dispatchDate;
	}
	public Float getTotalCost() {
		return totalCost;
	}
	public void setTotalCost(Float totalCost) {
		this.totalCost = totalCost;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	@Override
	public String toString() {
		return "OrderDTO [orderId=" + orderId + ", orderDate=" + orderDate + ", dispatchDate=" + dispatchDate
				+ ", totalCost=" + totalCost + ", orderStatus=" + orderStatus + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(orderId);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderDTO other = (OrderDTO) obj;
		return Objects.equals(orderId, other.orderId);
	}
	

}
