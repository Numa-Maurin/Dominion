package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

/**
 * Carte Or (Gold)
 *
 * 3 Pièces
 */
public class Gold extends Treasure {
    public Gold() {
        super("Gold", 6);
    }

    public void play(Player p) {
        p.incrementMoney(3);
    }
}
