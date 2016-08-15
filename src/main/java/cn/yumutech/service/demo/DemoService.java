/**
 * 
 */
package cn.yumutech.service.demo;

import java.util.Map;

import cn.yumutech.vo.demo.Student;
import cn.yumutech.vo.demo.Demo;

/**
 * demo业务逻辑
 * 
 * @author zhaowei
 *
 */
public interface DemoService {

	/**
	 * 获得学生数据
	 * 
	 * @param student
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selectStudentList(Student student) throws Exception;

	/**
	 * 插入学生
	 * 
	 * @param student
	 * @return
	 */
	int insertStudent(Student student) throws Exception;

	/**
	 * 更新学生
	 * 
	 * @param student
	 * @return
	 */
	int updateStudent(Student student) throws Exception;

	/**
	 * 删除学生
	 * 
	 * @param id
	 * @return
	 */
	int deleteStudent(Integer id) throws Exception;

	/**
	 * 通过学生id取得学生数据
	 * 
	 * @param id
	 * @return
	 */
	Student selectStudentById(Integer id) throws Exception;
	
	
	
	
	
	
	
	
	
	/**
	 * 获得学生数据
	 * 
	 * @param student
	 * @return
	 * @throws Exception
	 */
	Map<String, Object> selectDemoList(Demo demo) throws Exception;

	/**
	 * 插入学生
	 * 
	 * @param student
	 * @return
	 */
	int insertDemo(Demo demo) throws Exception;

	/**
	 * 更新学生
	 * 
	 * @param student
	 * @return
	 */
	int updateDemo(Demo demo) throws Exception;

	/**
	 * 删除学生
	 * 
	 * @param id
	 * @return
	 */
	int deleteDemo(Integer id) throws Exception;

	/**
	 * 通过学生id取得学生数据
	 * 
	 * @param id
	 * @return
	 */
	Demo selectDemoById(Integer id) throws Exception;
	

}
