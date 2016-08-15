package cn.yumutech.dao.demo;

import java.util.List;

import cn.yumutech.vo.demo.Demo;

/**
 * demomapper
 * 
 * @author zhaowei
 * 
 */
public interface DemoMapper {

	/**
	 * 获取demo记录
	 * 
	 * @param user
	 * @return
	 */
	List<Demo> selectDemoList(Demo demo);

	/**
	 * 获取demo记录数
	 * 
	 * @param user
	 * @return
	 */
	int selectDemoListCount(Demo demo);

	/**
	 * 插入demo
	 * 
	 * @param user
	 * @return
	 */
	int insertDemo(Demo demo);

	/**
	 * 更新demo
	 * 
	 * @param user
	 * @return
	 */
	int updateDemo(Demo demo);

	/**
	 * 删除demo
	 * 
	 * @param user
	 * @return
	 */
	int deleteDemo(Integer id);

	/**
	 * 通过demoid取得demo数据
	 * 
	 * @param id
	 * @return
	 */
	Demo selectDemoById(Integer id);

}
