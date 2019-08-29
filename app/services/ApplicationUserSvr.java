package services;

import java.sql.Timestamp;
import java.util.*;
import org.jooq.DSLContext;
import com.google.inject.Inject;
import schemas.public_.tables.daos.ApplicationUserDao;
import schemas.public_.tables.pojos.ApplicationUser;

public class ApplicationUserSvr extends ApplicationUserDao {
	@Inject
	DSLContext sqlContext;
	
	@Inject
	public ApplicationUserSvr (DSLContext sqlContext) {
		// TODO Auto-generated constructor stub
		super();
		this.setConfiguration(sqlContext.configuration());
	}
	
	public void save (ApplicationUser applicationUser) {
		Date date = new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		if (!fetchById(applicationUser.getId()).isEmpty()) {
			super.update(applicationUser);
		} else {
			applicationUser.setIsAdmin(false);
			applicationUser.setIsActive(true);
			applicationUser.setLastUpdate(ts);
			super.insert(applicationUser);
		}
	}

}
