package com.yjf.datajpa.dao;

import com.yjf.datajpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author 余俊锋
 * @date 2020/11/11 16:18
 * @Description
 */
@Repository
public interface UserDao extends JpaRepository<User,Integer> {

    @Query(value = "From User where User.name=:name")
    List<User> selectByName(String name);

    //支持原生sql
    @Query(value = "select name from my_user where name=?1",nativeQuery = true)
    List<User> selectByName2(String name);

    //自定义修改
    @Modifying
    @Query("update User set name=:name where id=:id")
    @Transactional
    int updateUser(String name,Integer id);
}
