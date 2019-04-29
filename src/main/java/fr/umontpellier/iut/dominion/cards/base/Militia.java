package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Attack;
import fr.umontpellier.iut.dominion.cards.Card;


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

    public void play(Player p) {
        p.incrementMoney(2);

        for (Player o : p.getOtherPlayers()) {

            while (o.getCardsInHand().size() > 3) {
                String cardchoose = p.chooseCard("Choisissez une carte dans votre main à défaussez", p.getCardsInHand(), false);
                Card c = p.getCardsInHand().getCard(cardchoose);
                p.discardCard(c);
                    }
                }
        }
    }
}