package com.lynda.common.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import com.lynda.common.data.repository.CustomerRepository;
import com.lynda.common.data.repository.InventoryItemRepository;
import com.lynda.common.data.repository.SalesOrderRepository;
import com.lynda.common.service.InventoryService;
import com.lynda.common.service.OrderService;
import com.lynda.common.service.impl.InventoryServiceImpl;
import com.lynda.common.service.impl.OrderServiceImpl;

@Configuration
//@Import(DataConfig.class)   //not required since we have used appropriate @Component annotations at the right classes and then used component scan
@PropertySource("classpath:/application.properties")
@ComponentScan(basePackages = {"com.lynda.common"})
public class AppConfig {

//	@Bean	
//	public InventoryService inventoryService(InventoryItemRepository inventoryItemRepository) {
//		return new InventoryServiceImpl(inventoryItemRepository);
//	}
//	
//	@Bean
//	public OrderService orderService(InventoryService inventoryService, CustomerRepository customerRepository,
//			SalesOrderRepository salesOrderRepository) {
//		return new OrderServiceImpl(inventoryService, customerRepository, salesOrderRepository);
//	}

//********Testing environment and properties********
//	@Value("${greeting.text}")
//	private String greetingText;
//	
//	class Worker {
//		private String greeting;
//		Worker(String greetingText){
//			greeting = "hello " + greetingText;
//		}
//		public void execute() {
//			System.out.println(greeting);
//		}
//	}
//	
//	@Bean
//	public Worker createWorker() {
//		return new Worker(greetingText);
//	}
	
	public static void main(String [] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		OrderService orderService = context.getBean(OrderService.class);
		System.out.println(orderService==null?"Bowled!@#%!":"A OK!");
		
//		Worker worker = context.getBean(Worker.class);
//		worker.execute();
	}
}
