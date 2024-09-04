package com.raj.entity;

import org.springframework.stereotype.Component;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
public class product {

	@Id
	@GeneratedValue
	private Integer ID;

	@NotBlank(message = "name is mandatory")
	@Size(min = 3, max = 15, message = "name should 3 to 15 character")
	private String name;

	@NotNull(message = "price is mandatory")
	@Positive(message = "price should be positive")
	private Double price;

	@NotNull(message = "qty is mandatory")
	private Integer qty;
}
