package web.index_calender.vo;

import java.io.Serializable;
import java.sql.Timestamp;

public class Index_calender implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer exhibitionID;
    private String exhibitionName;
    private Timestamp exhibitionStartDate;
    private Timestamp exhibitionEndDate;
    private Integer exhibitionStatus;
    private Integer businessstatus;
    
    public Index_calender() {
	}

	public Index_calender(Integer exhibitionID, String exhibitionName, Timestamp exhibitionStartDate,
			Timestamp exhibitionEndDate, Integer exhibitionStatus, Integer businessstatus) {
		super();
		this.exhibitionID = exhibitionID;
		this.exhibitionName = exhibitionName;
		this.exhibitionStartDate = exhibitionStartDate;
		this.exhibitionEndDate = exhibitionEndDate;
		this.exhibitionStatus = exhibitionStatus;
		this.businessstatus = businessstatus;
	}

	public Integer getExhibitionID() {
		return exhibitionID;
	}

	public void setExhibitionID(Integer exhibitionID) {
		this.exhibitionID = exhibitionID;
	}

	public String getExhibitionName() {
		return exhibitionName;
	}

	public void setExhibitionName(String exhibitionName) {
		this.exhibitionName = exhibitionName;
	}

	public Timestamp getExhibitionStartDate() {
		return exhibitionStartDate;
	}

	public void setExhibitionStartDate(Timestamp exhibitionStartDate) {
		this.exhibitionStartDate = exhibitionStartDate;
	}

	public Timestamp getExhibitionEndDate() {
		return exhibitionEndDate;
	}

	public void setExhibitionEndDate(Timestamp exhibitionEndDate) {
		this.exhibitionEndDate = exhibitionEndDate;
	}

	public Integer getExhibitionStatus() {
		return exhibitionStatus;
	}

	public void setExhibitionStatus(Integer exhibitionStatus) {
		this.exhibitionStatus = exhibitionStatus;
	}

	public Integer getBusinessstatus() {
		return businessstatus;
	}

	public void setBusinessstatus(Integer businessstatus) {
		this.businessstatus = businessstatus;
	}
    
}
