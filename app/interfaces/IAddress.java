package interfaces;

import java.util.List;

import models.AddressDetail;
import play.data.Form;

public interface IAddress {
	
public String save(Form<AddressDetail> form, AddressDetail addressDetail);
	
	public String update(AddressDetail AddressDetail);
	
	public String delete(AddressDetail AddressDetail);
	
	public List<AddressDetail> findList();
	
	public AddressDetail findById(Long id);

}
