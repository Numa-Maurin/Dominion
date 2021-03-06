package fr.umontpellier.iut.dominion.cards;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.base.*;
import fr.umontpellier.iut.dominion.cards.common.*;

import java.util.HashMap;

/**
 * Classe de fabrication de listes de cartes
 */

public final class FactoryListOfCards {

    /**
     * dictionnaire de cartes
     */
    private static final HashMap<String, Class<? extends Card>> dicoCards = new HashMap<>();

    static {
        dicoCards.put("Copper", Copper.class);
        dicoCards.put("Silver", Silver.class);
        dicoCards.put("Gold", Gold.class);
        dicoCards.put("Estate", Estate.class);
        dicoCards.put("Duchy", Duchy.class);
        dicoCards.put("Province", Province.class);
        dicoCards.put("Curse", Curse.class);
        dicoCards.put("Cellar", Cellar.class);
        dicoCards.put("Chapel", Chapel.class);
        dicoCards.put("Moat", Moat.class);
        dicoCards.put("Harbinger", Harbinger.class);
        dicoCards.put("Merchant", Merchant.class);
        dicoCards.put("Vassal", Vassal.class);
        dicoCards.put("Village", Village.class);
        dicoCards.put("Workshop", Workshop.class);
        dicoCards.put("Bureaucrat", Bureaucrat.class);
        dicoCards.put("Gardens", Gardens.class);
        dicoCards.put("Militia", Militia.class);
        dicoCards.put("Moneylender", Moneylender.class);
        dicoCards.put("Poacher", Poacher.class);
        dicoCards.put("Remodel", Remodel.class);
        dicoCards.put("Smithy", Smithy.class);
        dicoCards.put("ThroneRoom", ThroneRoom.class);
        dicoCards.put("Bandit", Bandit.class);
        dicoCards.put("CouncilRoom", CouncilRoom.class);
        dicoCards.put("Festival", Festival.class);
        dicoCards.put("Laboratory", Laboratory.class);
        dicoCards.put("Library", Library.class);
        dicoCards.put("Market", Market.class);
        dicoCards.put("Mine", Mine.class);
        dicoCards.put("Sentry", Sentry.class);
        dicoCards.put("Witch", Witch.class);
        dicoCards.put("Artisan", Artisan.class);
    }

    /**
     * Renvoie une liste de cartes
     *
     * @param number : le nombre de cartes de la liste
     * @param nameOfCardClass: le nom de la classe à instancier
     * @return une liste de cartes de même type
     */
    public static ListOfCards createCardList(int number, String nameOfCardClass) {
        ListOfCards stack = new ListOfCards();
        for (int i = 0; i < number; i++) {
            try {
                stack.add(dicoCards.get(nameOfCardClass).newInstance());
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return stack;
    }
}
