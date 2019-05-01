package fr.umontpellier.iut.dominion.cards.common;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.base.Merchant;
import fr.umontpellier.iut.dominion.cards.type.Treasure;

/**
 * Carte Argent (Silver)
 *
 * 2 Pièces
 * 3 Pieces si cest le premier argent joué apres un Marchant
 */
public class Silver extends Treasure {
    public Silver() {
        super("Silver", 3);
    }

    public void play(Player p) {
        boolean merchantPresent=false;
        int nbrDeSilver=0;
        for (Card c : p.getCardsInPlay()) {
            if (c.getName().equals("Merchant")){
                merchantPresent =true;
            }
            else if (c.getName().equals("Silver")){
                nbrDeSilver=nbrDeSilver+1;
            }
        }
        if(merchantPresent&&nbrDeSilver==1){
            p.incrementMoney(3);
        }
        else{ p.incrementMoney(2); }
    }
}
