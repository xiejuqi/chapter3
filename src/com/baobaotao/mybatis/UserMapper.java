package com.baobaotao.mybatis;

import com.baobaotao.domain.User;

/**
 * 
 * @Filename UserMapper.java
 * 
 * @Description	MyBatis的Mapper接口
 * 
 * @Version 1.0
 * 
 * @Author xpangxie
 * 
 * @Email xpangxie@yiji.com
 * 
 * @History Author: xpangxie
 * 
 * @Date: 2016年6月4日 上午10:01:21
 * 
 * @Version: 1.0
 * 
 * @Content: create
 * 
 */
public interface UserMapper {
	User getUserById(Integer id);
}

