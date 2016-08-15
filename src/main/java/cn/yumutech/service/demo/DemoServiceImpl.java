/**
 * 
 */
package cn.yumutech.service.demo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.yumutech.dao.demo.StudentMapper;
import cn.yumutech.util.BOConstants;
import cn.yumutech.vo.demo.Demo;
import cn.yumutech.vo.demo.Student;
import cn.yumutech.dao.demo.DemoMapper;

/**
 * @author zhaowei
 *
 */
@Service
public class DemoServiceImpl implements DemoService {

	private static Logger logger = Logger.getLogger(DemoServiceImpl.class);

	@Resource
	private StudentMapper studentMapper;
	@Resource
	private DemoMapper demoMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yumutech.service.demo.DemoService#selectStudentList(cn.yumutech.vo
	 * .demo.Student)
	 */
	@Override
	public Map<String, Object> selectStudentList(Student student) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(student);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put(BOConstants.ROW_COUNT, studentMapper.selectStudentListCount(student));
			result.put(BOConstants.VALUE_LIST, studentMapper.selectStudentList(student));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yumutech.service.demo.DemoService#insertStudent(cn.yumutech.vo.demo
	 * .Student)
	 */
	@Override
	@Transactional
	public int insertStudent(Student student) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(student);
		}
		int result = 0;
		try {
			result = studentMapper.insertStudent(student);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yumutech.service.demo.DemoService#updateStudent(cn.yumutech.vo.demo
	 * .Student)
	 */
	@Override
	@Transactional
	public int updateStudent(Student student) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(student);
		}
		int result = 0;
		try {
			result = studentMapper.updateStudent(student);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yumutech.service.demo.DemoService#deleteStudent(java.lang.Integer)
	 */
	@Override
	@Transactional
	public int deleteStudent(Integer id) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(id);
		}
		int result = 0;
		try {
			result = studentMapper.deleteStudent(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * cn.yumutech.service.demo.DemoService#selectStudentById(java.lang.Integer)
	 */
	@Override
	public Student selectStudentById(Integer id) throws Exception {
		Student result = new Student();
		try {
			result = studentMapper.selectStudentById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see cn.yumutech.service.demo.DemoService#selectDemoList(cn.yumutech.vo.demo.Demo)
	 */
	@Override
	public Map<String, Object> selectDemoList(Demo demo) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(demo);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put(BOConstants.ROW_COUNT, demoMapper.selectDemoListCount(demo));
			result.put(BOConstants.VALUE_LIST, demoMapper.selectDemoList(demo));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see cn.yumutech.service.demo.DemoService#insertDemo(cn.yumutech.vo.demo.Demo)
	 */
	@Override
	@Transactional
	public int insertDemo(Demo demo) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(demo);
		}
		int result = 0;
		try {
			result = demoMapper.insertDemo(demo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see cn.yumutech.service.demo.DemoService#updateDemo(cn.yumutech.vo.demo.Demo)
	 */
	@Override
	@Transactional
	public int updateDemo(Demo demo) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(demo);
		}
		int result = 0;
		try {
			result = demoMapper.updateDemo(demo);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see cn.yumutech.service.demo.DemoService#deleteDemo(java.lang.Integer)
	 */
	@Override
	@Transactional
	public int deleteDemo(Integer id) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(id);
		}
		int result = 0;
		try {
			result = demoMapper.deleteDemo(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	/* (non-Javadoc)
	 * @see cn.yumutech.service.demo.DemoService#selectDemoById(java.lang.Integer)
	 */
	@Override
	public Demo selectDemoById(Integer id) throws Exception {
		Demo result = new Demo();
		try {
			result = demoMapper.selectDemoById(id);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

}
