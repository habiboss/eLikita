package interfaces;

import java.util.List;

import models.Contact;

public interface IContact {
	
	public String save(Contact contact);
	
	public String delete(Contact contact);
	
	public String update(Contact contact);
	
	public List<Contact> findList();
	
	public Contact findById(Long id);
}
