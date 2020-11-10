package io.chetan.bill.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.chetan.bill.model.Bill;
import io.chetan.bill.model.Complaint;
import io.chetan.bill.service.BillService;

@RestController
@RequestMapping(value = "/bill")
public class BillController 
{

	@Autowired
	private BillService billService;
	
	//private static final Logger LOGGER = Logger.getLogger(BillController.class.getName());
	
	private static Logger LOGGER = LogManager.getLogger(BillController.class);
	
	private static final String OWNER_SERVICE_URI = "http://OwnerService/mypg/";
	
	@Autowired
	private LoadBalancerClient loadBalancer;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@GetMapping(value = "/get2")
	public String getString()
	{
		//System.out.println("\n BillController - get  with header = \n"+header);
		
		LOGGER.info("\n BillController - get  with  = \n");
		
		
		
		return "from BillController - get  with";
	}
	
	
	
	
	@GetMapping(value = "/readComplaint")
	public Complaint get_temp_for_Logger()
	{
		System.out.println("\n BillController - getPg_temp_for_Logger(    = \n");
		
		LOGGER.info("\n BillController - getPg_temp_for_Logger(    = \n");
		
	
		
		
		Complaint complaint = restTemplate.getForObject(OWNER_SERVICE_URI+"readComplaint", 
				Complaint.class);
				
		
		return complaint;
	}
	
	
	@GetMapping(value = "/getOwner")
	public Iterable get_temp_for_ribbon()
	{
		System.out.println("\n BillController - get_temp_for_ribbon    = \n");
		
		LOGGER.info("\n BillController - get_temp_for_ribbon    = \n");
		
		
		
		ServiceInstance serviceInstance = loadBalancer.choose("OwnerService");
		
		LOGGER.info("\n BillController - get_temp_for_ribbon - serviceInstance  = \n"+serviceInstance);
		
		System.out.println(serviceInstance.getUri());
		
		LOGGER.info("\n BillController - get_temp_for_ribbon - serviceInstance.getUri  = \n"+serviceInstance.getUri());
		
		
		Iterable iterable = restTemplate.getForObject(OWNER_SERVICE_URI+"readOwner", 
				Iterable.class);
				
//		Bill bill = new Bill();
//		bill.setAmount(3.231);
//		bill.setRoomNumber(12);
		
		LOGGER.info("\n BillController - get_temp_for_ribbon - iterable.  = \n"+iterable);
		
		return iterable;
	}
	
	
	//loading all bills of an inmate
	//                    findAll/{inMateId}
//	@GetMapping(value = "/findAll/{inMateId}")
//	public List<Bill> getAllBillsOfInMate(@PathVariable long inMateId)
//	{
//		System.out.println("\n BillController - getAllBillsOfInMate with inammteid = \n"+inMateId);
//		
//		LOGGER.info("\n BillController - getAllBillsOfInMate with inammteid = \n"+inMateId);
//		
//		return billService.getAllBillsOfInMate(inMateId);
//	}
	
	//
	@GetMapping(value = "/read")
	public Bill get_temp_for_customFilter()
	{
		System.out.println("\n BillController - get_temp_for_customFilter    = \n");
		
		LOGGER.info("\n BillController - get_temp_for_customFilter    = \n");
		
		Bill bill = new Bill();
		bill.setAmount(3.231);
		bill.setRoomNumber(12);
		return bill;
	}
	
	@GetMapping(value = "/get")
	public Bill get_temp(@RequestHeader("first-request") String header)
	{
		System.out.println("\n BillController - get  with header = \n"+header);
		
		LOGGER.info("\n BillController - get  with header = \n"+header);
		
		Bill bill = new Bill();
		bill.setAmount(2312.231);
		
		return bill;
	}
	
	
	@GetMapping(value = "/findAll/{myInMate}")
	public List<Bill> getAllBillsOfInMate(@PathVariable long myInMate)
	{
		System.out.println("\n BillController - getAllBillsOfInMate with inammteid = \n"+myInMate);
		
		LOGGER.info("\n BillController - getAllBillsOfInMate with inammteid = \n"+myInMate);
		
		return billService.getAllBillsOfInMate(myInMate);
	}
	
	
//	@GetMapping(value = "/findAll/{pgId}")
//	public List<InMate> findAllInMatesOfAPg(@PathVariable long pgId)
//	{
//		System.out.println("\n InMateController findInMatesOfAPg()\n");
//		
//		return inMateService.findInMatesOfAPg(pgId);
//
//	}
	@GetMapping(value = "/find/{billId}")
	public Bill finBillById(@PathVariable long billId)
	{
		System.out.println("\n BillController - finBill with billId = \n"+billId);
		
		LOGGER.info("\n BillController - finBill with billId = \n"+billId);
		
		return billService.finBillById(billId);
	}
	
	@GetMapping(value = "/")
	public Object temp()
	{
		LOGGER.info("\n BillController - temp- \n ");
		
		return new Object();
	}
			
}
