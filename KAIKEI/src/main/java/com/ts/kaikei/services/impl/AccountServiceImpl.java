package com.ts.kaikei.services.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ts.kaikei.dao.CustomerDAO;
import com.ts.kaikei.dao.StatementDAO;

import com.ts.kaikei.services.AccountService;
import com.ts.kaikei.vo.CustomerVO;
import com.ts.kaikei.vo.StatementListVO;


@Service("accountService")
public class AccountServiceImpl implements AccountService {
	
	@Autowired
	StatementDAO statementDAO;
	@Autowired
	CustomerDAO customerDAO;

	/*
	 * =====================================
	 *          STATEMEMT SERVICE
	 * =====================================
	 */
	
	@Override
	public List<StatementListVO> getStatements(String company_cd, String year, String month) {
		Map<String, String> searchParams = new HashMap<String, String>();
		
		searchParams.put("company_cd", company_cd);
		searchParams.put("year", year);
		searchParams.put("month", month);
		
		return statementDAO.getStatementList(company_cd);
	}
	
	public void addStatement(List<Map<String, String>> statementList, String userId, String company_cd) {
		Map<String, Object> statements = new HashMap<String, Object>();
		
		for(int i = 0; i < statementList.size(); i++) {
			statementList.get(i).put("ent_id", userId);
			statementList.get(i).put("mod_id", userId);
			statementList.get(i).put("company_cd", company_cd);
		}
		
		statements.put("statementList", statementList);
		
		statementDAO.saveStatement(statements);
	}


	/*
	 * =====================================
	 *           CUSTOMER SERVICE
	 * =====================================
	 */
	
	@Override
	public boolean addCustomer(String company_cd, CustomerVO customerVO, String userId) {
		 
		customerVO.setCompany_cd(company_cd);
		
		customerVO.setEnt_id(userId);
		customerVO.setMod_id(userId);
		
		customerDAO.addCustomer(customerVO);
		
		return true;
		
	}
	
	@Override
	public List<CustomerVO> getCustomerList(String company_cd, String searchParam, String pageNum, String size) {

		if(searchParam == null) {
			searchParam = "";
		}
		
		if(pageNum == null) {
			pageNum = "0";
		}
		
		Map<String, String> params = new HashMap<String, String>();
		
		params.put("company_cd", company_cd);
		params.put("searchParam", searchParam);
		params.put("pageNum", pageNum);
		params.put("size", size);
		
		return customerDAO.selectCustomerList(params);
	}
	
	@Override
	public CustomerVO getCustomerOf(String company_cd, String cus_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		return customerDAO.getCustomerDetail(param);
	}
	
	@Override
	public boolean updateCustomer(String company_cd, CustomerVO customerVO, String userId) {
		
		customerVO.setCompany_cd(company_cd);
		customerVO.setMod_id(userId);
		
		customerDAO.updateCustomer(customerVO);
		
		return true;
	}
	
	@Override
	public boolean deleteCustomer(String company_cd, String cus_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		customerDAO.deleteCustomer(param); 
		
		return true;
	}
	
	/*
	 *  AJAX
	 */
	
	@Override
	public int customerCodeCheck(String cus_cd, String company_cd) {
		
		Map<String, String>param = new HashMap<String, String>();
		param.put("company_cd", company_cd);
		param.put("cus_cd", cus_cd);
		
		return customerDAO.customerCodeCheck(param);
	}

}
