package com.vn.vo;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	@Length(min = 5, max = 50, message = "Phai co tu 5 - 50 ky tu")
	private String name;

}
