package io.chetan.bill.dao;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.data.repository.CrudRepository;

import io.chetan.bill.controller.BillController;
import io.chetan.bill.model.Bill;

public interface BillDao extends CrudRepository<Bill, Long>
{

	
	List<Bill> findByMyInMate(long myInMate);
	
	

}
