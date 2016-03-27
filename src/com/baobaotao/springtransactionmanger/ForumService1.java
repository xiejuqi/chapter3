package com.baobaotao.springtransactionmanger;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.baobaotao.anno.UserDao;
import com.baobaotao.dao.LoginLogDao;
import com.baobaotao.domain.LoginLog;
import com.baobaotao.domain.User;

/**
 * 
 * @Filename ForumService1.java
 * 
 * @Description
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年3月27日 下午1:39:49
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public class ForumService1 {
	/**这里应该通过IoC注入*/
	private TransactionTemplate transactionTemplate;
	
	private LoginLogDao loginLogDao;
	
	public void addForum(final LoginLog loginLog){
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus status) {
				loginLogDao.insertLoginLog(loginLog);
			}
		});
	}
}

