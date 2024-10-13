package com.grizer.grizerorder.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "`order`")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Order {
	@Id
	private int id;
	private int ItemId;
	private Date OrderDate;
	private String amount;
}
