package fr.umontpellier.iut.dominion.cards.base;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.cards.Card;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Artisan
 *
 * Gagnez une carte coûtant jusqu'à 5 Pièces dans votre main.
 * Mettez une carte de votre main sur votre deck.
 * Le joueur entre d’abord le nom de la carte à gagner en main, puis le
 * nom de la carte qu’il veut replacer sur son deck.
 */
public class Artisan extends Action {
    public Artisan() {
        super("Artisan", 6);
    }

    @Override
    public void play(Player p){

        ListOfCards wincards = new ListOfCards();

        for(Card c : p.getGame().availableSupplyCards()) {
            if (c.getCost() <= 5) {
                wincards.add(c);
            }
        }
        String card1 = p.chooseCard("Choisissez la carte que vous désirez gagner coûtant jusqu'à 5 pièces", wincards, false);
        p.addToHand(p.getGame().getFromSupply(card1));
        String card2 = p.chooseCard("Choisisez la carte que vous voulez replacer sur le deck", p.getCardsInHand(), false);
        p.addToDraw(p.removeFromHand(card2));
    }
}
