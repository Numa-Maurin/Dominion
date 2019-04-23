package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Chambre du conseil (Council Room)
 *
 * +4 Cartes.
 * +1 Achat.
 * Tous vos adversaires piochent 1 carte.
 */
public class CouncilRoom extends Action {
    public CouncilRoom() {
        super("Council Room", 5);
    }

    public void play(Player p) {
        for (int i = 0; i < 4; i++) {
            p.drawToHand();
        }
        p.incrementBuys(1);

        for (Player o : p.getOtherPlayers()) {
            o.drawToHand();
        }
    }
}