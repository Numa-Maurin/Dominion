package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.type.Action;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Rénovation (Remodel)
 *
 * Écartez une carte de votre main.
 * Recevez une carte coûtant jusqu'à 2 Pièces de plus que la carte écartée.
 */
public class Remodel extends Action {
    public Remodel() {
        super("Remodel", 4);
    }

    public void play(Player p) {
        ListOfCards choices = new ListOfCards();
        for(Card c: p.getCardsInHand()) {
            choices.add(c);
        }
        String carteEcartee = p.chooseCard("Choisissez une carte à écarter", choices, false);
        p.getGame().trash(p.removeFromHand(carteEcartee));

        int prixecartee= p.getGame().getFromSupply(carteEcartee).getCost()+2;
        boolean pasvalide = true;

        while (pasvalide ) {

            String answer= p.chooseCard("Choisissez une carte coutant jusqu'à 2 pièces de plus que la carte écartée", p.getGame().availableSupplyCards(), false);
            if(p.getGame().getFromSupply(answer).getCost()>prixecartee) {
                pasvalide=true;
            }
            else {
                p.discardCard(p.getGame().getFromSupply(answer));
                p.getGame().removeFromSupply(answer);
                pasvalide=false;
            }

        }
    }

}