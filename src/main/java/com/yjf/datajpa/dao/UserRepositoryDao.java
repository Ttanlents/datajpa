package com.yjf.datajpa.dao;

import com.yjf.datajpa.entity.User;
import org.springframework.data.repository.Repository;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/11 15:12
 * @Description
 */

//继承该接口就用命名查询的功能，可以通过方法命名的方式由SpringDataJpa自动生成sql
@org.springframework.stereotype.Repository
public interface UserRepositoryDao extends Repository<User,Integer> {
  List<User> findByName(String name);
  User findById(Integer id);

}
