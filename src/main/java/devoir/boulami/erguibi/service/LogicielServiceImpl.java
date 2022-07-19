package devoir.boulami.erguibi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import devoir.boulami.erguibi.models.Logiciel;
import devoir.boulami.erguibi.repositories.LogicielRepository;

@Service
public class LogicielServiceImpl implements LogicielService{

	@Autowired
	private LogicielRepository logRepo;
	
	@Override
	public void ajouter(Logiciel log) {
		logRepo.save(log);
	}

}
