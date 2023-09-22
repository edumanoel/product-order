package br.com.mbds.productorder.entities;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import br.com.mbds.productorder.entities.pk.OrderItemPK;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Getter(value = AccessLevel.NONE)
	@Setter(value = AccessLevel.NONE)
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK();

	@EqualsAndHashCode.Exclude
	private Integer quantity;

	@EqualsAndHashCode.Exclude
	private Double price;

	public OrderItem(Order order, Product product, Integer quantity, Double price) {
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

}
