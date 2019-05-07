package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Attack;


/**
 * Carte Milice (Militia)
 *
 * 2 Pièces.
 * Tous vos adversaires défaussent leurs cartes de façon à n'avoir que 3 cartes en main.
 */
public class Militia extends Attack {
    public Militia() {
        super("Militia", 4);
    }

    @Override
    public void play(Player p) {

        p.incrementMoney(2);

        for (Player o : p.getOtherPlayers()) {
            if (!o.getReaction()) {
                while (o.getCardsInHand().size() > 3) {
                    String answer = o.chooseCard("Choisissez une carte dans votre main à défausser", o.getCardsInHand(), false);
                    o.discardCard(o.removeFromHand(answer));
                }
            }
        }
    }
}
