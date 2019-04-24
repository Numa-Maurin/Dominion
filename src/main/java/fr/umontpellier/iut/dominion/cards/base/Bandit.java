package fr.umontpellier.iut.dominion.cards.base;


import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.common.Gold;
import fr.umontpellier.iut.dominion.cards.type.Attack;


import static fr.umontpellier.iut.dominion.CardType.Treasure;

/**
 * Carte Bandit
 *
 * Gagnez un Or.
 * Chaque joueur révèle les deux premières cartes de son deck, écarte un trésor autre que Cuivre et défausse le reste.
 */
public class Bandit extends Attack {
    public Bandit() {
        super("Bandit", 5);
    }

    @Override
    public void play(Player p) {
        p.gain(new Gold());
        for (Player o : p.getOtherPlayers()) {
            Card revealCard1 = o.drawCard();
            Card revealCard2 = o.drawCard();
            if ((revealCard1.getTypes().contains(Treasure) & revealCard2.getTypes().contains(Treasure)) && ((!revealCard1.getName().equals("Copper") &
                    !revealCard2.getName().equals("Copper")) && !revealCard1.getName().equals(revealCard2.getName()))) {
                ListOfCards choice = new ListOfCards();
                choice.add(revealCard1);
                choice.add(revealCard2);
                if (o.chooseCard("Choisissez la carte à écarter", choice, false).equals(revealCard1.getName())) {
                    o.getGame().getTrashedCards().add(revealCard1);
                    o.discardCard(revealCard2);
                } else {
                    o.getGame().getTrashedCards().add(revealCard2);
                    o.discardCard(revealCard1);
                }
            }
            else if (revealCard1.getTypes().contains(Treasure) && !revealCard1.getName().equals("Copper")) {
                o.getGame().getTrashedCards().add(revealCard1);
                o.discardCard(revealCard2);
            }
            else if (revealCard2.getTypes().contains(Treasure) && !revealCard2.getName().equals("Copper")) {
                o.getGame().getTrashedCards().add(revealCard2);
                o.discardCard(revealCard1);
            }
            else {
                o.discardCard(revealCard1);
                o.discardCard(revealCard2);
            }
        }

    }
}
