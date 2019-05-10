package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Salle du trône (Throne Room)
 *
 * Choisissez 1 carte Action de votre main.
 * Jouez-la deux fois.
 */
public class ThroneRoom extends Action {
    public ThroneRoom() {
        super("Throne Room", 4);
    }

    @Override
    public void play(Player p) {
        String cardName = p.chooseCard("Choose an Action cards to play twice.",p.getCardsInHand(), true);
        if (cardName != "") {
            p.getCardsInHand().getCard(cardName).play(p);
            p.playCard(cardName);
        }
    }
}