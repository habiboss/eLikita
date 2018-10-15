package models.dto;

public class InvoiceDetailDTO {
	
	private String student_name;
	private Long student_id;
	private String invoide_id;
	private Long amount;
	private String status;
	
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public Long getStudent_id() {
		return student_id;
	}
	public void setStudent_id(Long student_id) {
		this.student_id = student_id;
	}
	public String getInvoide_id() {
		return invoide_id;
	}
	public void setInvoide_id(String invoide_id) {
		this.invoide_id = invoide_id;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
}
