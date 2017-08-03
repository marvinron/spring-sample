package cn.birdstudio.order.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import cn.birdstudio.transaction.service.TransactionService;
import cn.birdstudio.user.service.UserService;

@Component("orderService")
public class OrderServiceImpl implements OrderService {
	@Resource
	private UserService userService;

	@Resource
	private TransactionService transactionService;

	@Override
	public void sold(int seller_id, int buyer_id, int amount) {
		transactionService.sold(seller_id, buyer_id, amount);
		userService.sold(seller_id, buyer_id, amount);
	}
}
