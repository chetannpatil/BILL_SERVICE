package io.chetan.bill.controller;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.chetan.bill.model.Bill;
import io.chetan.bill.service.BillService;

@RestController
@RequestMapping(value = "/bill")
public class BillController 
{

	@Autowired
	private BillService billService;
	
	private static final Logger LOGGER = Logger.getLogger(BillController.class.getName());
	
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
