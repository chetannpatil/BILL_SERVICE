package io.chetan.bill.service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.chetan.bill.controller.BillController;
import io.chetan.bill.dao.BillDao;
import io.chetan.bill.model.Bill;

@Service
public class BillService 
{

	@Autowired
	BillDao billDao ;

	private static final Logger LOGGER = Logger.getLogger(BillService.class.getName());
	
	public List<Bill> getAllBillsOfInMate(long myInMate) 
	{
		LOGGER.info("\n BillService - getAllBillsOfInMate - with inammteid = \n"+myInMate);
		
		return billDao.findByMyInMate(myInMate);
	}

	public Bill finBillById(long billId) 
	{
		LOGGER.info("\n BillService - finBillById - with billId = \n"+billId);
		
		Optional<Bill> optional = billDao.findById(billId);
		
		//Optional<Bill> findById = billDao.findById(billId);	
//		Optional<InMate> inMateOptional = inMateDao.findById(inMateId);
//		
//		return inMateOptional.get() ;
		if(optional == null || optional.isPresent() == false)
		{
			LOGGER.info("\n BillService - finBillById -optional = \n"+optional);
			return null ;
		}
		else
		{
			LOGGER.info("\n BillService - finBillById -optional is not null  = \n"+optional);
			return optional.get();
		}
		
		
	}
	
	//create
	
	//read
	
	//update
	
	//delete
	
	
	
}
