package org.opensrp.etl.data.converter;

import org.json.JSONObject;
import org.opensrp.etl.entity.HouseholdEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.HouseholdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseholdDataConverterService implements DataConverterService {
	
	public HouseholdDataConverterService() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private HouseholdService householdService;
	
	@Autowired
	private HouseholdEntity householdEntity;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) {
		Class<HouseholdEntity> c = HouseholdEntity.class;
		Object ob = householdEntity;
		
		householdEntity = (HouseholdEntity) dataConverter.convert(doc, c, ob);
		householdService.save(householdEntity);
	}
	
}
