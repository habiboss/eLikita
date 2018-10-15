package models.dto;

public class AcademicYearDTO {
    private Long   id;
    private Long statusFk_id;
    private String statusFk;
    private Long endMonthFk_id;
    private String endMonthFk;
    private Long startMonthFk_id;
    private String startMonthFk;
    private Long endYearFk_id;
    private String endYearFk;
    private Long startYearFk_id;
    private String startYearFk;
	
    public Long getId() {
		return id;
	}

	public String getStatusFk() {
		return statusFk;
	}

	public void setStatusFk(String statusFk) {
		this.statusFk = statusFk;
	}

	public String getEndMonthFk() {
		return endMonthFk;
	}

	public void setEndMonthFk(String endMonthFk) {
		this.endMonthFk = endMonthFk;
	}

	public String getStartMonthFk() {
		return startMonthFk;
	}

	public void setStartMonthFk(String startMonthFk) {
		this.startMonthFk = startMonthFk;
	}

	public String getEndYearFk() {
		return endYearFk;
	}

	public void setEndYearFk(String endYearFk) {
		this.endYearFk = endYearFk;
	}

	public String getStartYearFk() {
		return startYearFk;
	}

	public void setStartYearFk(String startYearFk) {
		this.startYearFk = startYearFk;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getStatusFk_id() {
		return statusFk_id;
	}

	public void setStatusFk_id(Long statusFk_id) {
		this.statusFk_id = statusFk_id;
	}

	public Long getEndMonthFk_id() {
		return endMonthFk_id;
	}

	public void setEndMonthFk_id(Long endMonthFk_id) {
		this.endMonthFk_id = endMonthFk_id;
	}

	public Long getStartMonthFk_id() {
		return startMonthFk_id;
	}

	public void setStartMonthFk_id(Long startMonthFk_id) {
		this.startMonthFk_id = startMonthFk_id;
	}

	public Long getEndYearFk_id() {
		return endYearFk_id;
	}

	public void setEndYearFk_id(Long endYearFk_id) {
		this.endYearFk_id = endYearFk_id;
	}

	public Long getStartYearFk_id() {
		return startYearFk_id;
	}

	public void setStartYearFk_id(Long startYearFk_id) {
		this.startYearFk_id = startYearFk_id;
	}
	
}
