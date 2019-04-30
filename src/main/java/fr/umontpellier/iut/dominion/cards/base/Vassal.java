package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Vassal
 *
 * +2 Pièces.
 * Défaussez la première carte de votre deck. Si c'est une carte Action, vous pouvez la jouer.
 * Si la carte à défausser est une carte Action on demande au joueur s’il
 * veut la jouer. S’il répond "y" la carte est jouée (et déplacée dans inPlay), sinon
 * ("n") rien ne se passe.
 */
public class Vassal extends Action {
    public Vassal() {
        super("Vassal", 3);
    }

    @Override
    public void play(Player p) {
    p.incrementMoney(2);
        Card cartepioche = p.drawCard();
        List<String> choices = Arrays.asList("y", "n");
        if (cartepioche.getTypes().contains(CardType.Action)){
            String answer=p.chooseOption("voulez vous jouer la carte "+cartepioche.getName()+"? (y/n)",choices,false);
            if (answer.equals("y")){
                p.addToHand(cartepioche);
                p.playCard(cartepioche.getName());
            }
            else if(answer.equals("n")){
                p.discardCard(cartepioche);
            }
        }
        else{
            p.discardCard(cartepioche);
        }
    }
}
