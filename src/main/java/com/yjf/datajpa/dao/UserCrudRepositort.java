package com.yjf.datajpa.dao;

import com.yjf.datajpa.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/11 15:45
 * @Description
 */
//继承该接口就有的基本的crud 它是Repository的子类
public interface UserCrudRepositort extends CrudRepository<User,Integer> {
    List<User> findByName(String name);
}
