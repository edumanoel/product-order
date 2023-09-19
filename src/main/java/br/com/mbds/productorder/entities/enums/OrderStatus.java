package br.com.mbds.productorder.entities.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum OrderStatus {
	WAITING_PAYMENT(1), PAID(2), SHIPPED(3), DELIVERED(4), CANCELED(5);

	private int id;

	public static OrderStatus valueOf(int id) {
		for (OrderStatus value : OrderStatus.values()) {
			if (value.getId() == id) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus id");
	}

}
