package org.store.operations.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.store.operations.model.Cart;
import org.store.operations.model.DiscountResponse;
import org.store.operations.service.CustomerBillService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@Api(tags = {"Bill Services"})
public class BillingController {

	@Autowired
	private CustomerBillService customerBillService;
	
	@ApiOperation(value = "Get Net Amount", notes = "Getting net amount from provided Bill")
	@ApiResponses(value = {
	@ApiResponse(code = 200, message = "JSON Response"),
	@ApiResponse(code = 500, message = "Internal Server Error")})
	@PostMapping("/calculateDiscount")
	public DiscountResponse bill(@RequestBody Cart cart)
	{
		return customerBillService.calculateDiscount(cart);
	}
}

