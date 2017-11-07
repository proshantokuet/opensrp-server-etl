/**
 * 
 */
package org.opensrp.etl.data.converter;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;

import javax.persistence.Temporal;

import org.json.JSONObject;
import org.opensrp.etl.util.DateUtil;

/**
 * @author proshanto
 */

public class DataConverter {
	
	public DataConverter() {
	}
	
	@SuppressWarnings("unchecked")
	public <Any> Any convert(JSONObject JsonDocument, Class<?> className, Object object) {
		try {
			BeanInfo beaninfo = Introspector.getBeanInfo(className);
			PropertyDescriptor pds[] = beaninfo.getPropertyDescriptors();
			Method setterMethod = null;
			for (PropertyDescriptor pd : pds) {
				try {
					setterMethod = pd.getWriteMethod();
					String dataTypeClass = pd.getPropertyType().getName();
					if (setterMethod == null)
						continue;
					else if ("java.util.Date".equalsIgnoreCase(dataTypeClass)) {
						Method readMethod = pd.getReadMethod();
						Class<Temporal> c = (Class<Temporal>) Class.forName("javax.persistence.Temporal");
						if (readMethod.isAnnotationPresent(c)) {
							setterMethod.invoke(object, DateUtil.getDateFromString(JsonDocument, pd.getDisplayName()));
						} else {
							setterMethod.invoke(object, DateUtil.getDateTimeFromString(JsonDocument, pd.getDisplayName()));
						}
						
					} else {
						setterMethod.invoke(object, JsonDocument.getString(pd.getDisplayName()));
					}
				}
				catch (Exception e) {}
			}
		}
		catch (Exception e) {}
		return (Any) object;
	}
	
}
