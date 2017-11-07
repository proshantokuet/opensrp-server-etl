package org.opensrp.etl.data.converter;

import org.json.JSONException;
import org.json.JSONObject;
import org.opensrp.etl.entity.MemberEntity;
import org.opensrp.etl.interfaces.DataConverterService;
import org.opensrp.etl.service.ExceptionService;
import org.opensrp.etl.service.MemberService;
import org.opensrp.etl.util.DateUtil;
import org.opensrp.etl.util.Keys;
import org.springframework.beans.factory.annotation.Autowired;

public class MemberDataConverterService implements DataConverterService {
	
	@Autowired
	private MemberEntity memberEntity;
	
	@Autowired
	private MemberService memberService;
	
	@Autowired
	private PSRFDataConverterService psrfDataConverterService;
	
	@Autowired
	private ExceptionService exceptionService;
	
	@Autowired
	private DataConverter dataConverter;
	
	public MemberDataConverterService() {
		
	}
	
	@Override
	public void convertToEntityAndSave(JSONObject doc) throws JSONException {
		Class<MemberEntity> className = MemberEntity.class;
		Object object = memberEntity;
		memberEntity = (MemberEntity) dataConverter.convert(doc, className, object);
		try {
			JSONObject details = doc.getJSONObject("details");
			memberEntity.setStart(DateUtil.getDateTimeFromString(details, "start"));
			memberEntity.setEnd(DateUtil.getDateTimeFromString(details, "end"));
			memberEntity.setRelationalid(details.getString("womanrelationalid"));
			memberService.save(memberEntity);
			
		}
		catch (Exception e) {
			exceptionService.generatedEntityAndSave(doc, e.fillInStackTrace().toString(), Keys.MEMBER.name());
		}
		
	}
	
}
