package maven_01_环境搭建;


import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.shsxt.vo.User;
import com.sun.corba.se.spi.orbutil.fsm.Input;

public class TestMybatis01 {

	@Test
	public void test() throws IOException {
		/**
		 * 1.资源文件加载
		 * 2.获取会话工厂（获取回话对象前提 单例）
		 * 3.获取会话
		 * 4.调用api 执行访问操作
		 * 5.输出输出
		 * 6.关闭会话
		 */
		InputStream is= Resources.getResourceAsStream("mybatis.xml");
		SqlSessionFactory factory=new SqlSessionFactoryBuilder().build(is);
		SqlSession session=factory.openSession();
		User user= session.selectOne("com.shsxt.mapper.UserMapper.queryUserById",12);
		System.out.println(user);
		session.close();
	}

}
