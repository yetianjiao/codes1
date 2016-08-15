package cn.yumutech.service.demo;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import cn.yumutech.dao.demo.EquipMapper;
import cn.yumutech.util.BOConstants;
import cn.yumutech.vo.demo.Equip;
import cn.yumutech.vo.demo.Student;

@Service
public class EquipServiceImpl implements EquipService {

	private static Logger logger = Logger.getLogger(EquipServiceImpl.class);
	
	@Resource
	private EquipMapper equipMapper;
	
	@Override
	public Map<String, Object> selectEquipList(Equip equip) throws Exception{
		
		System.out.println("==========service=========");
		if (logger.isInfoEnabled()) {
			logger.info(equip);
		}
		Map<String, Object> result = new HashMap<String, Object>();
		try {
			result.put(BOConstants.ROW_COUNT, equipMapper.selectEquipmentCount(equip));
			System.out.println("===========total equipments:" +equipMapper.selectEquipmentCount(equip));
			result.put(BOConstants.VALUE_LIST, equipMapper.selectAllEquipment(equip));
			
			//System.out.println(equipMapper.selectAllEquipment(equip));
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}

		return result;
	}

	@Override
	public int insertEquip(Equip equip) throws Exception {
		if (logger.isInfoEnabled()) {
			logger.info(equip);
		}
		int result = 0;
		try {
			result = equipMapper.insertEquip(equip);
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw e;
		}
		return result;
	}

	@Override
	public Equip selectEquipById(Integer indx) {
		return equipMapper.selectselectEquipById(indx);
	}

	@Override
	public int updateEquip(Equip equip) {
		return equipMapper.updateEquip(equip);
	}

	@Override
	public void deleteEquip(Integer indx) {
		equipMapper.deleteEquip(indx);
	}
	
	
}
