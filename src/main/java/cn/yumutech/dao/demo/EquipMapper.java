package cn.yumutech.dao.demo;

/**
 * 管理设备的接口
 */
import java.util.List;

import cn.yumutech.vo.demo.Equip;

public interface EquipMapper {

	/**
	 * 显示所有设备
	 * @return
	 * 所有用户所在的list
	 */
	List<Equip> selectAllEquipment(Equip equip);
	
	/**
	 * 设备数量
	 * @return
	 * 整数
	 */
	int selectEquipmentCount(Equip equip);

	/**
	 * 增加一个
	 * @param equip
	 * @return
	 */
	int insertEquip(Equip equip);

	/**
	 * 通过ID来查找
	 * @param indx
	 * @return Equip
	 */
	Equip selectselectEquipById(Integer indx);
	/**
	 * 修改equip
	 * @param equip
	 * @return int
	 */
	int updateEquip(Equip equip);

	void deleteEquip(Integer indx);

}
