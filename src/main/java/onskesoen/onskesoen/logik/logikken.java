package onskesoen.onskesoen.logik;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import onskesoen.onskesoen.model.User;
import onskesoen.onskesoen.model.Ønskeliste;
import onskesoen.onskesoen.service.ønskelisteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class logikken extends User {
    @Autowired
    ønskelisteService ønskelisteService;
    public int findNextAvailableId() {


        int highestExistingId = ønskelisteService.fetchAll().stream()
                .mapToInt(Ønskeliste::getWishlist_id)
                .max()
                .orElse(0);

        List<Integer> allIds = IntStream.rangeClosed(1, highestExistingId).boxed().collect(Collectors.toList());

        List<Integer> usedIds = ønskelisteService.fetchAll().stream()
                .map(Ønskeliste::getWishlist_id)
                .collect(Collectors.toList());

        Optional<Integer> nextAvailableId = allIds.stream()
                .filter(id -> !usedIds.contains(id))
                .findFirst();

        return nextAvailableId.orElse(highestExistingId + 1);
    }

}
