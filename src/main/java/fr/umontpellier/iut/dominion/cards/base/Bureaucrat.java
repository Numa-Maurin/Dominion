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
        p.addToDraw(p.getGame().getFromSupply("Silver"));
        ListOfCards victorycards = new ListOfCards();

        for (Player o : p.getOtherPlayers()) {
            if (!o.getReaction()) {
                for (Card c : o.getCardsInHand()) {
                    if (c.getTypes().contains(CardType.Victory)) {
                        victorycards.add(c);
                    }
                }

                String victory = o.chooseCard("Choisissez une carte victoire à poser sur votre deck", victorycards, false);
                o.addToDraw(o.removeFromHand(victory));
            }
        }
    }
}