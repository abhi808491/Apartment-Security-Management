package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.UserEntity;

public interface UserServiceInt {

	public long add(UserEntity bean,long adminPk);

	public void update(UserEntity bean);

	public void delete(UserEntity bean);

	public UserEntity findByLogin(String login);

	public UserEntity findByPk(long id);

	public List<UserEntity> search(long pageNo, int pageSize);

	public List<UserEntity> search(UserEntity bean);

	public boolean changePassword(Long id, String oldPassword, String newPassword);
	
	public UserEntity authenticate(UserEntity bean);

	public boolean forgetPassword(String login);

	public UserEntity addGard(long userPk, long gardPk);

	public UserEntity addFlat(long userPk, long flatPk);

	public long registerAdmin(UserEntity bean);

}
