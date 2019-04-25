package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Chapelle (Chapel)
 *
 * Écartez jusqu'à 4 cartes de votre main.
 */
public class Chapel extends Action {
    public Chapel() {
        super("Chapel", 2);
    }

    @Override
    public void play(Player p){
        int i = 0;
        boolean ecarter = true;
        while(i<4 || ecarter){
            String car = p.chooseCard("Quelle carte souhaitez vous détruire?", p.getCardsInHand(), true);
            if ( car != ""){
                p.getGame().getTrashedCards().add(p.getCardsInHand().getCard(car));
                p.discardCard(p.getCardsInHand().getCard(car));
                i++;
            } else {
                ecarter = false;
            }
        }
    }
}