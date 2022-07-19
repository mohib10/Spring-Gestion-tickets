package devoir.boulami.erguibi.service;

import java.util.List;

import devoir.boulami.erguibi.models.*;

public interface BugService {
	void ajouter(Bug bug);
	
	List<Urgence> getUrgences();
	List<Logiciel> getLogiciels();
}
