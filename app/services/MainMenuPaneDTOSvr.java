package services;

import com.google.inject.Inject;
import controllers.JourneeCtrl;
import models.dto.MainMenuPaneDTO;

public class MainMenuPaneDTOSvr {
	
	@Inject
	JourneeCtrl journeeCtrl;
	@Inject
	AboutInstitutionSvr aboutInstitutionSvr;
	
	public MainMenuPaneDTO mainMenuPane() {
		MainMenuPaneDTO mainMenuPaneDTO = new MainMenuPaneDTO();
		try {
			mainMenuPaneDTO.setInstitutionName(aboutInstitutionSvr.x().getInstitutionName().toUpperCase());
			mainMenuPaneDTO.setJournee(journeeCtrl.getJournee());
			mainMenuPaneDTO.setUserConnected(journeeCtrl.getUserConnected());
			mainMenuPaneDTO.setUserType(journeeCtrl.getUserType());
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		
		return mainMenuPaneDTO;
	}

}
