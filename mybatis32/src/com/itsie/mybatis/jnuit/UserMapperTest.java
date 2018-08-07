package com.itsie.mybatis.jnuit;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import javax.naming.InitialContext;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.itsie.mybatis.mapper.UserMapper;
import com.itsie.mybatis.pojo.User;

public class UserMapperTest {
	SqlSessionFactory sqlSessionFactory = null;
	@Before
	public void Init() throws Exception{
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		this.sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
	}
	//�����û�ID��ѯ�û���Ϣ
	@Test
	public void testUserById() throws Exception {
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = userMapper.queryUserById(1);
		System.out.println(user);
		sqlSession.close();
	}
	//�����û�����ĳ������ģ����ѯ�û���Ϣ
	@Test
	public void testfindUserByUsername() throws Exception{
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		List<User> user = userMapper.queryUserByUsername("��");
		System.out.println(user);
		sqlSession.close();
	}
	//�����û�ID�������û���Ϣ
	@Test
	public void testUpdateUser() throws Exception{
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setId(26);
		user.setUsername("�����");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("������ʯ");
		userMapper.updateUserById(user);
		sqlSession.commit();
		sqlSession.close();
	}
	
	//����û�
	@Test
	public void testAddUser() throws Exception{
		SqlSession sqlSession = this.sqlSessionFactory.openSession();
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		User user = new User();
		user.setUsername("�����");
		user.setBirthday(new Date());
		user.setSex("��");
		user.setAddress("�����人");
		userMapper.insertUser(user);
		sqlSession.commit();
		sqlSession.close();
		
	}
	
	

}
