package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Cave (Cellar)
 *
 * +1 Action.
 * Défaussez autant de cartes que vous voulez.
 * +1 Carte par carte défaussée.
 */
public class Cellar extends Action {
    public Cellar() {
        super("Cellar", 2);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        String cardName = p.chooseCard("Choose an Action cards to discard.",p.getCardsInHand(), true);
        int nbCartesDefausses = 0;
        while (cardName != "") {
            if (p.getCardsInHand().getCard(cardName) != null) {
                p.discardHandCard(p.getCardsInHand().getCard(cardName));
                nbCartesDefausses++;
            }
            cardName = p.chooseCard("Choose an Action cards to discard.", p.getCardsInHand(), true);
        }
        for (int i=0; i<nbCartesDefausses; ++i) {
            p.drawToHand();
        }
    }
}