package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Braconnier (Poacher)
 *
 * +1 Action.
 * +1 Carte.
 * +1 Pièce.
 * Défaussez une carte de votre main par pile de réserve épuisée.
 */
public class Poacher extends Action {
    public Poacher() {
        super("Poacher", 4);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.drawToHand();
        p.incrementMoney(1);
        int nbrCartesADefausser = p.getGame().nonAvailableSupplyCards().size();
        for (int i = 0; i < nbrCartesADefausser; i++) {
            String answer = p.chooseCard("Choisissez une carte a defausser", p.getCardsInHand(), false);
            p.discardCard(p.removeFromHand(answer));
        }
    }
}
