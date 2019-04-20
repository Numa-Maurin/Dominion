package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Victory;

/**
 * Carte Province
 *
 * 6 VP
 */
public class Province extends Victory {
    public Province() {
        super("Province", 8);
    }

    public int getVictoryValue(Player p) {
        return 6;
    }
}