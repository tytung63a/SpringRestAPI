package com.vn.vo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductVO implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;

	private int available;

	@Temporal(TemporalType.DATE)
	private Date createDate;

	private MultipartFile image;
	
	private String imagetext;

	@NotBlank(message = "Không được bỏ trống")
	private String name;

	private double price;

	private Integer category_id;
}
