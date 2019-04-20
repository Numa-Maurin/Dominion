package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 */
public class Silver extends Treasure {
    public Silver() {
        super("Silver", 3);
    }

    public void play(Player p) {
        p.incrementMoney(2);
    }
}
