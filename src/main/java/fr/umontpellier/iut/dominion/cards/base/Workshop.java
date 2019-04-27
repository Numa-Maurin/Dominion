package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Atelier (Workshop)
 *
 * Recevez une carte coûtant jusqu'à 4 Pièces.
 */
public class Workshop extends Action {
    public Workshop() {
        super("Workshop", 3);
    }

    public void play(Player p) {
        ListOfCards cartesDeMoinsDeQuatre = p.getGame().availableSupplyCards();
        for (Card c : new ListOfCards(cartesDeMoinsDeQuatre)) {
            if (c.getCost()>4) {
                cartesDeMoinsDeQuatre.remove(c);
            }
        }
        boolean pasvalide = !cartesDeMoinsDeQuatre.isEmpty();

        while (pasvalide) {
            String answer = p.chooseCard("Choisissez une carte coutant jusqu'a 4 pieces", cartesDeMoinsDeQuatre, false);
            if(cartesDeMoinsDeQuatre.getCard(answer).getCost()<=4) {
                p.discardCard(p.getGame().removeFromSupply(answer));
                pasvalide=false;
            }
        }
    }
}