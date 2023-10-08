package com.example.demo.tutorial.dao.tuto0005;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.example.demo.tutorial.entity.tuto0005.User;

@Repository
public class UserDAOUserImpl implements UserDAO<User>  {

	private static final long serialVersionUID = 1L;
	
	//エンティティを操作するための機能がそろっている
	@PersistenceContext //EntityManagerのBeanを取得してフィールドに設定するためのもの
	private EntityManager entityManger;
	
	public UserDAOUserImpl() {
		super();
	}
	
	@Override
	public List<User> getAll() {
		
		//引数にJPQLによるクエリ文を指定し、実行するためのQueryインスタンスが生成される
		Query query = entityManger.createQuery("from User");
		
		@SuppressWarnings("unchecked")
		List<User> list = query.getResultList();
		
		entityManger.close();
		
		return list;
	}

}
