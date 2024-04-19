package onskesoen.onskesoen.logik;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import onskesoen.onskesoen.model.User;
import onskesoen.onskesoen.model.Ønskeliste;
import onskesoen.onskesoen.repository.ØnskelistRepository;
import onskesoen.onskesoen.service.ønskelisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class logikken extends User {
    @Autowired
    ønskelisteService ønskelisteService;
    public int findNextAvailableId() {
        // Hent det højeste eksisterende ID


        int highestExistingId = ønskelisteService.fetchAll().stream()
                .mapToInt(Ønskeliste::getWishlist_id)
                .max()
                .orElse(0);

        // Lav en liste over alle tal fra 1 til det højeste eksisterende ID
        List<Integer> allIds = IntStream.rangeClosed(1, highestExistingId).boxed().collect(Collectors.toList());

        // Lav en liste over alle de IDs, der allerede er i brug
        List<Integer> usedIds = ønskelisteService.fetchAll().stream()
                .map(Ønskeliste::getWishlist_id)
                .collect(Collectors.toList());

        // Find det første ledige ID
        Optional<Integer> nextAvailableId = allIds.stream()
                .filter(id -> !usedIds.contains(id))
                .findFirst();

        // Returner det næste ledige ID, eller højeste eksisterende ID + 1, hvis der ikke er nogen ledige
        return nextAvailableId.orElse(highestExistingId + 1);
    }

}
