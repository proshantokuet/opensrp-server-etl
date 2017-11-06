/**
 * 
 */
package org.opensrp.etl.data.converter;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import org.json.JSONObject;
import org.springframework.stereotype.Service;

/**
 * @author proshanto
 */
@Service
public class DataConverter {
	
	public DataConverter() {
		
	}
	
	@SuppressWarnings("unchecked")
	public <Any> Any convert(JSONObject doc, Class<?> className, Object ob) {
		try {
			BeanInfo beaninfo = Introspector.getBeanInfo(className);
			PropertyDescriptor pds[] = beaninfo.getPropertyDescriptors();
			Method setterMethod = null;
			for (PropertyDescriptor pd : pds) {
				try {
					setterMethod = pd.getWriteMethod();
					if (setterMethod == null)
						continue;
					else
						setterMethod.invoke(ob, doc.getString(pd.getDisplayName()));
				}
				catch (Exception e) {
					
				}
			}
		}
		catch (Exception e) {}
		return (Any) ob;
	}
}
