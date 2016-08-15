package cn.yumutech.dao.demo;

import java.util.List;

import cn.yumutech.vo.demo.Student;

/**
 * 学生mapper
 * 
 * @author zhaowei
 * 
 */
public interface StudentMapper {

	/**
	 * 获取学生记录
	 * 
	 * @param user
	 * @return
	 */
	List<Student> selectStudentList(Student student);

	/**
	 * 获取学生记录数
	 * 
	 * @param user
	 * @return
	 */
	int selectStudentListCount(Student student);

	/**
	 * 插入学生
	 * 
	 * @param user
	 * @return
	 */
	int insertStudent(Student student);

	/**
	 * 更新学生
	 * 
	 * @param user
	 * @return
	 */
	int updateStudent(Student student);

	/**
	 * 删除学生
	 * 
	 * @param user
	 * @return
	 */
	int deleteStudent(Integer id);

	/**
	 * 通过学生id取得学生数据
	 * 
	 * @param id
	 * @return
	 */
	Student selectStudentById(Integer id);

}
