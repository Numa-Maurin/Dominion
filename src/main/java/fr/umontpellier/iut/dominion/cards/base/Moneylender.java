package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Copper;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.Arrays;
import java.util.List;

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
        boolean firstCopper = true;
        ListOfCards choices = new ListOfCards();
        for (Card c:p.getCardsInHand()){
            if (c.getName().equals("Copper")){
                if (firstCopper) {
                    choices.add(new Copper());
                    if (p.chooseCard("Do you want to use Moneylender ?", choices, true).equals("Copper")) {
                        p.getGame().trash(p.removeFromHand("Copper"));
                        p.incrementMoney(3);
                    }
                }
                firstCopper = false;
            }
        }
    }
}