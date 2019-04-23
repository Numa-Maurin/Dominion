package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Village
 *
 * +1 Carte.
 * +2 Actions.
 */
public class Village extends Action {
    public Village() {
        super("Village", 3);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(2);
    }
}