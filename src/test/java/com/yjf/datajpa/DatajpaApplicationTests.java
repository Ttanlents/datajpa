package com.yjf.datajpa;

import com.yjf.datajpa.dao.*;
import com.yjf.datajpa.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;

@SpringBootTest
class DatajpaApplicationTests {

    @Autowired
    UserRepositoryDao userRepositoryDao;
    @Autowired
    UserCrudRepositort userCrudRepositort;
    @Autowired
    UserPageAndSortRepository userPageAndSortRepository;

    @Autowired
    UserDao userDao;
    @Autowired
    UserSpecification userSpecification;

    @Test
    public void contextLoads() {
        List<User> tom = userRepositoryDao.findByName("tom");
        System.out.println(tom);
    }

    @Test
    public void contextLoads1() {
        List<User> users =(List<User> ) userCrudRepositort.findAll();
        userCrudRepositort.delete(new User());
        userCrudRepositort.save(new User());
    }

    @Test  //支持排序和分页
    public void contextLoads2() {
        Sort sort = Sort.by(Sort.Direction.DESC, "name");
        /*Iterable<User> all = userPageAndSortRepository.findAll(sort);
        for (User user : all) {
            System.out.println(user);
        }*/

        PageRequest pageRequest = PageRequest.of(1, 2, sort);
        /*Page<User> pageInfo = userPageAndSortRepository.findAll(pageRequest);
        List<User> content = pageInfo.getContent();
        content.forEach(n->{
            System.out.println(n);
        });*/

        //如果做定义的查询需要分页呢？
        Page<User> t = userPageAndSortRepository.findByNameContaining("t", pageRequest);
        for (User user : t) {
            System.out.println(user);
        }
    }

    @Test  //动态sql
    public void contextLoads3() {
        User user = new User();
        user.setName("tom");
        Example<User> example = Example.of(user);
        List<User> users = userDao.findAll(example);

    }


    @Test  //动态sql2 最后一接口
    public void contextLoads4() {
        //动态条件对象
        Specification specification = new Specification() {
          /*  @Override
            public Specification and(Specification other) {
                return null;
            }

            @Override
            public Specification or(Specification other) {
                return null;
            }*/
            /**
             *@Description TODO
             *@author 余俊锋
             *@date 2020/11/11 16:46
             *@params root :用于根据属性名转换  字段名
             * @param criteriaQuery ：语法查询对象  通过java构建拼接sql
             * @param criteriaBuilder  ：语法处理构建对象
             *@return javax.persistence.criteria.Predicate
             */


            @Override   //Predicate  语句对象
            public Predicate toPredicate(Root root, CriteriaQuery criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return null;
            }
        };

    }


}
