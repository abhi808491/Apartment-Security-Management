package com.cg.aps.service;

import java.util.List;

import com.cg.aps.entity.GardsTranningEntity;

public interface GardsTranningServiceInt {
	public long add(GardsTranningEntity bean);

	public void update(GardsTranningEntity bean);

	public void delete(GardsTranningEntity bean);

	public GardsTranningEntity getByName(String name);

	public GardsTranningEntity findByPk(long id);

	public List<GardsTranningEntity> search(GardsTranningEntity bean, long pageNo, int pageSize);

	public List<GardsTranningEntity> search(GardsTranningEntity bean);

}
