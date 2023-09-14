package br.com.mbds.productorder.entities;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	private  Long id;
	private String name;
	private String email;
	private String phone;
	private String password;
	
}
