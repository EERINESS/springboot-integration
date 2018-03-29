package com.zzq.mapper;

import java.util.List;

import com.zzq.entity.SysUser;
import org.springframework.stereotype.Repository;

@Repository
public interface SysUserMapperCustom {
	List<SysUser> queryUserSimplyInfoById(String id);
}