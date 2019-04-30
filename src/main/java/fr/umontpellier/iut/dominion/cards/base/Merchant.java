package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Marchand (Merchant)
         *
         * +1 Carte.
         * +1 Action.
         * La première fois que vous jouez un argent pendant ce tour, +1 Pièce.
 * Bien qu’elle ne demande aucune intervention de la part du joueur,
 * cette carte est compliquée à implémenter correctement car elle modifie le fonctionnement
 * de la carte Argent lorsqu’elle est jouée pour la première fois.
         */
public class Merchant extends Action {
    public Merchant() {
        super("Merchant", 3);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.incrementActions(1);
        ListOfCards carteEnMain=p.getCardsInHand();
        for (Card c:carteEnMain) {
            if (c.getName().equals("silver")){

            }
        }
    }
}
