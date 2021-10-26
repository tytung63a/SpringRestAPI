<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!-- Section-->
<style>
.thumb1 {
	width: 269px;
	height: 200px;
}
</style>
<div class="dropdown">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
    Sắp Xếp
  </button>
  <ul class="dropdown-menu" aria-labelledby="dropdownMenuButton1">
    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/homepage?field=price">Giá</a></li>
    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/homepage?field=name">Tên</a></li>
    <li><a class="dropdown-item" href="${pageContext.request.contextPath}/homepage?field=quantity">Số lượng</a></li>
  </ul>
</div>
<section class="py-5">
	<div class="container px-4 px-lg-5 mt-5">
		<div
			class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
			<c:forEach var="product" items="${list.content}">
				<div class="col mb-5">
					<div class="card h-100">
						<!-- Product image-->
						<img class="thumb1" src="/images/${product.image}" />
						<!-- Product details-->
						<div class="card-body p-4">
							<div class="text-center">
								<!-- Product name-->
								<h5 class="fw-bolder">${product.name}</h5>
								<!-- Product price-->
								${product.price} VNĐ
								<br>
									<c:if test="${product.quantity > 0}">
									Còn Hàng
									</c:if>
									<c:if test="${product.quantity < 1}">
									Cháy Hàng
							</c:if>
							</div>
						</div>
						<!-- Product actions-->
						<div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="/products/${product.id}">View
									options</a>
							</div>
							
							<div class="text-center">
								<a class="btn btn-outline-dark mt-auto" href="/shoppingcart/add/${product.id}">Buy Now</a>
							</div>
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
	</div>

</section>

<div class="d-flex justify-content-center">
	<nav aria-label="Page navigation example">
		<ul class="pagination">
			<c:if test="${list.number > 0}">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/homepage/?page=0">First</a></li>
			</c:if>


			<c:if test="${list.number > 0}">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/homepage/?page=${list.number - 1}">${list.number }</a></li>
			</c:if>


			<li class="page-item active" aria-current="page"><a
				class="page-link" href="#">${list.number + 1}<span
					class="visually-hidden">(current)</span></a></li>

			<c:if test="${list.number <list.totalPages -1}">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/homepage/?page=${list.number + 1}">${list.number +2}</a></li>
			</c:if>


			<c:if test="${list.number <list.totalPages -1}">
				<li class="page-item"><a class="page-link"
					href="${pageContext.request.contextPath}/homepage/?page=${list.totalPages -1}">Last</a></li>
			</c:if>

		</ul>
	</nav>
</div>


