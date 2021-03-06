package com.ly.base.service.provideImpl.sys;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.ly.base.core.model.sys.SysAccount;
import com.ly.base.service.provideImpl.BaseServiceImpl;
import com.ly.base.core.provide.sys.SysAccountService;
import com.ly.base.dao.sys.SysAccountMapper;

/**
 * 业务处理,数据缓存
 * @author LeiYong
 * @date 2016年10月02日
 */
@Service
public class SysAccountServiceImpl extends BaseServiceImpl<SysAccount> implements SysAccountService {

	@Autowired
	public void setBaseMapper(SysAccountMapper baseMapper) {
		super.setBaseMapper(baseMapper);
	}
	public SysAccountMapper getBaseMapper() {
		return (SysAccountMapper) super.getBaseMapper();
	}
	/**
	 * 通过主键查询
	 * 
	 * @param pk
	 * @return
	 */ 
	@Override
	public SysAccount selectByPrimaryKey(Integer pk){
		return getBaseMapper().selectByPrimaryKey(pk);
	}
	/**
	 * 通过主键删除
	 * 
	 * @param pk
	 * @return
	 */ 
	@Override
	public int deleteByPrimaryKey(Integer pk){
		return getBaseMapper().deleteByPrimaryKey(pk);
	}
	/**
	 * 通过主键批量删除
	 * 
	 * @param pks
	 * @return
	 */ 
	@Override
	public int deleteByBatch(Integer[] pks){
		return getBaseMapper().deleteByBatch(pks);
	}
	/**
	 * 通过主键启用
	 * 
	 * @param pk
	 * @return
	 */ 
	@Override
	public int enable(String updateBy,Integer pk){
		return getBaseMapper().updateState(updateBy,"enable","1",pk);
	}
	/**
	 * 通过主键禁用
	 * 
	 * @param pk
	 * @return
	 */ 
	@Override
	public int disable(String updateBy,Integer pk){
		return getBaseMapper().updateState(updateBy,"enable","0",pk);
	}
	/**
	 * 通过主键批量启用
	 * 
	 * @param pks
	 * @return
	 */ 
	@Override
	public int enables(String updateBy,Integer... pks){
		return getBaseMapper().updateStates(updateBy,"enable","1",pks);
	}
	/**
	 * 通过主键批量禁用
	 * 
	 * @param pks
	 * @return
	 */ 
	@Override
	public int disables(String updateBy,Integer... pks){
		return getBaseMapper().updateStates(updateBy,"enable","0",pks);
	}
}