<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!-- Product section-->
        <section class="py-5">
            <div class="container px-4 px-lg-5 my-5">
                <div class="row gx-4 gx-lg-5 align-items-center">
                    <div class="col-md-6"><img class="card-img-top mb-5 mb-md-0" src="/images/${ list.image }" alt="..." /></div>
                    <div class="col-md-6">
                        <h3 class="small mb-1">Danh Mục : ${list.category.name }</h3>
                        <h1 class="display-5 fw-bolder">${list.name }</h1>
                        <div class="fs-5 mb-5">
                            <span>Giá : ${list.price } VNĐ</span>
                        </div>
                        <p class="lead">Lorem ipsum dolor sit amet consectetur adipisicing elit. Praesentium at dolorem quidem modi. Nam sequi consequatur obcaecati excepturi alias magni, accusamus eius blanditiis delectus ipsam minima ea iste laborum vero?</p>
                        <div class="d-flex">
                            <input class="form-control text-center me-3" id="inputQuantity" disabled="disabled" value="1" style="max-width: 3rem" />
                            <div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="/shoppingcart/add/${list.id}">Buy Now</a>
							</div>
                        </div>
                    </div>
                </div>
            </div>
        </section>