package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Prêteur sur gages (Moneylender)
 *
 * Écartez une carte Cuivre de votre main.
 * Dans ce cas, +3 Pièces.
 */
public class Moneylender extends Action {
    public Moneylender() {
        super("Moneylender", 4);
    }

    public void play(Player p){
        boolean actionFaite = false;
        for (Card c:p.getCardsInHand()){
            if (c.getName().equals("Copper") && !actionFaite){
                p.getGame().trash(p.removeFromHand(c.getName()));
                p.incrementMoney(3);
                actionFaite = true;
            }
        }
    }
}