package com.biz;

import java.math.BigDecimal;

import com.entity.Usertable;

public interface Userlogin {
	/**
	 * 用户登陆的业务
	 */
	public boolean UserLogin(Usertable user);
	/**
	 * 用户注册的业务
	 */
	public boolean UserRigster(Usertable user);
	/**
	 * 判断是否为管理员的方法
	 */
	public boolean manage(Usertable user);
	/**
	 * 判断注册是否有此用户
	 */
	public boolean havepeople(Usertable user);
	/**
	 * 管理员判断用户的数量
	 */
	public BigDecimal columnuser();
	/**
	 * 管理员判断消息的数量
	 */
	public BigDecimal columnnews();
	/**
	 * 管理员判断三个问题的平均数
	 * 
	 */
	public BigDecimal getque1();
	public BigDecimal getque2();
	public BigDecimal getque3();

}
