package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
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
        boolean pasvalide = true;

        while (pasvalide ) {

            String answer= p.chooseCard("Choisissez une carte coutant jusqu'� 4 pi�ces", p.getGame().availableSupplyCards(), false);
            if(p.getGame().getFromSupply(answer).getCost()>4) {
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