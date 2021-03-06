package com.ts.kaikei.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ts.kaikei.vo.UserListVO;
import com.ts.kaikei.vo.UserVO;

@Mapper
public interface UserDAO {
	/*
	 * ========================
	 * 			Common
	 * ========================
	 */
	public UserVO getUser(UserVO userVO);
	public void insertUser(UserVO userVO);
	public int checkId(String id);
	
	/*
	 * ========================
	 * 			Setting
	 * ========================
	 */
	public UserVO getUserById(String id);
	public void updateUser(UserVO userVO);
	
	public List<UserVO> getAcceptedUserList(String company_cd);
	public List<UserVO> getWaitingUserList(String company_cd);
	public void acceptUser(String id);
	public void deleteUser(String id);
	
	/*
	 * ========================
	 * 			Manage
	 * ========================
	 */
	public void userDeletecmp(String id);
	public List<UserListVO> selectUser(Map<String, Object> Params);
	public UserListVO infoUsers(String id);
	public void infoUpdateUser(UserListVO vo);
	public void userDelete(String code);
	public String getCompanyCode();

	public void companyCodeCh_us(Map<String, Object> Params);	//manage - company code change

}
 