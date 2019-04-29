package fr.umontpellier.iut.dominion.cards.base;
import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Attack;
import fr.umontpellier.iut.dominion.cards.Card;

/**
 * Carte Bureaucrate (Bureaucrat)
 *
 * Recevez une carte Argent; placez-la sur votre deck.
 * Tous vos adversaires dévoilent une carte Victoire et la placent sur leur deck (sinon ils dévoilent leur
 * main afin que vous puissiez voir qu'ils n'ont pas de cartes Victoire).
 */
public class Bureaucrat extends Attack {
    public Bureaucrat() {
        super("Bureaucrat", 4);
    }

    public void play(Player p) {
        ListOfCards silvercards = new ListOfCards();

        for (Card c : p.getGame().availableSupplyCards()) {
            if (c.equals("Silver")) {
                silvercards.add(c);
            }
        }
        String card = p.chooseCard("Choisissez une carte argent à recevoir", silvercards, false);
        p.addToDraw(p.getGame().getFromSupply(card));

        for (Player o : p.getOtherPlayers()) {
            String victorycards = p.chooseCard("Choisissez une carte victoire à poser sur votre deck", p.getCardsInHand(), false);
            Card victory = p.removeFromHand(victorycards);

            if (victory.getTypes().contains(CardType.Victory)) {
                o.addToDraw(victory);
            }
            else {
                o.getCardsInHand();
            }
        }
    }
}