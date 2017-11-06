package org.opensrp.etl.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "household")
public class HouseholdEntity {
	
	public HouseholdEntity() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "household_id_seq")
	@SequenceGenerator(name = "household_id_seq", sequenceName = "household_id_seq", allocationSize = 1)
	private int id;
	
	private String caseId;
	
	private String INSTANCEID;
	
	private String PROVIDERID;
	
	private String existing_location;
	
	private String existing_Country;
	
	private String existing_Division;
	
	private String existing_District;
	
	private String existing_Upazilla;
	
	private String existing_Union;
	
	private String existing_Ward;
	
	private Date Start;
	
	private Date Today;
	
	@Temporal(TemporalType.DATE)
	private Date Reg_Date;
	
	private String Village_Name;
	
	private String GoB_HHID;
	
	public int getId() {
		return id;
	}
	
	public String getCaseId() {
		return caseId;
	}
	
	public void setCaseId(String caseId) {
		this.caseId = caseId;
		
	}
	
	public String getINSTANCEID() {
		return INSTANCEID;
	}
	
	public void setINSTANCEID(String iNSTANCEID) {
		INSTANCEID = iNSTANCEID;
	}
	
	public String getPROVIDERID() {
		return PROVIDERID;
	}
	
	public void setPROVIDERID(String pROVIDERID) {
		PROVIDERID = pROVIDERID;
	}
	
	public String getExisting_location() {
		return existing_location;
	}
	
	public void setExisting_location(String existing_location) {
		this.existing_location = existing_location;
	}
	
	public String getExisting_Country() {
		return existing_Country;
	}
	
	public void setExisting_Country(String existing_Country) {
		this.existing_Country = existing_Country;
	}
	
	public String getExisting_Division() {
		return existing_Division;
	}
	
	public void setExisting_Division(String existing_Division) {
		this.existing_Division = existing_Division;
	}
	
	public String getExisting_District() {
		return existing_District;
	}
	
	public void setExisting_District(String existing_District) {
		this.existing_District = existing_District;
	}
	
	public String getExisting_Upazilla() {
		return existing_Upazilla;
	}
	
	public void setExisting_Upazilla(String existing_Upazilla) {
		this.existing_Upazilla = existing_Upazilla;
	}
	
	public String getExisting_Union() {
		return existing_Union;
	}
	
	public void setExisting_Union(String existing_Union) {
		this.existing_Union = existing_Union;
	}
	
	public String getExisting_Ward() {
		return existing_Ward;
	}
	
	public void setExisting_Ward(String existing_Ward) {
		this.existing_Ward = existing_Ward;
	}
	
	public Date getStart() {
		return Start;
	}
	
	public void setStart(Date start) {
		Start = start;
	}
	
	public Date getToday() {
		return Today;
	}
	
	public void setToday(Date today) {
		Today = today;
	}
	
	public Date getReg_Date() {
		return Reg_Date;
	}
	
	public void setReg_Date(Date reg_Date) {
		Reg_Date = reg_Date;
	}
	
	public String getVillage_Name() {
		return Village_Name;
	}
	
	public void setVillage_Name(String village_Name) {
		Village_Name = village_Name;
	}
	
	public String getGoB_HHID() {
		return GoB_HHID;
	}
	
	public void setGoB_HHID(String goB_HHID) {
		GoB_HHID = goB_HHID;
	}
	
}
