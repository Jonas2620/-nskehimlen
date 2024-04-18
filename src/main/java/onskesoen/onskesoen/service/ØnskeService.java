package onskesoen.onskesoen.service;

import onskesoen.onskesoen.model.Ønske;
import onskesoen.onskesoen.repository.ØnskeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ØnskeService {

    @Autowired
    private ØnskeRepository ønskeRepository;

    public void tilføjØnske(Ønske ønske) {
        ønskeRepository.tilføjØnske(ønske);
    }

    public List<Ønske> findØnskerTilWishlist(int wishlistId) {
        return ønskeRepository.findØnskerTilWishlist(wishlistId);
    }

    public boolean sletØnske(int ønskeId) {
        return ønskeRepository.sletØnske(ønskeId);
    }

    public void opdaterØnske(Ønske ønske) {
        ønskeRepository.opdaterØnske(ønske);
    }
}
