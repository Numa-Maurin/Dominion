package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Forgeron (Smithy)
 *
 * +3 Cartes.
 */
public class Smithy extends Action {
    public Smithy() {
        super("Smithy", 4);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
        p.drawToHand();
    }
}