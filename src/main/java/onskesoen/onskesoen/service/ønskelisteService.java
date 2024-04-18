package onskesoen.onskesoen.service;

import onskesoen.onskesoen.model.Ønskeliste;
import onskesoen.onskesoen.repository.ØnskelistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ønskelisteService {


        @Autowired
        ØnskelistRepository ønskelistRepository;
        public List<Ønskeliste> fetchAll(){
            return ønskelistRepository.fetchAll();
        }
        public void addØnskelist(Ønskeliste ø){ønskelistRepository.addØnskeliste(ø);
        }
        public Ønskeliste findØnskelisteId(int id){
            return ønskelistRepository.findØnskelistId(id);
        }
        public Boolean deleteØnskeliste(int id){
            return ønskelistRepository.deleteØnskeliste(id);
        }
        public void updateØnskeliste(int id, Ønskeliste ø){
            ønskelistRepository.updateØnskeliste(id,ø);


        }
    }


