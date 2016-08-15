package cn.yumutech.service.demo;

import java.util.Map;

import cn.yumutech.vo.demo.Equip;

public interface EquipService{

	Map<String, Object> selectEquipList(Equip equip) throws Exception;
	int insertEquip(Equip equip) throws Exception;
	Equip selectEquipById(Integer indx);
	int updateEquip(Equip equip);
	void deleteEquip(Integer indx);
}
