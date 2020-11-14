package com.yjf.datajpa.dao;

import com.yjf.datajpa.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author 余俊锋
 * @date 2020/11/11 15:54
 * @Description
 */
public interface UserPageAndSortRepository extends PagingAndSortingRepository<User,Integer> {
    Page<User> findByNameContaining(String name, PageRequest pageRequest);
}
