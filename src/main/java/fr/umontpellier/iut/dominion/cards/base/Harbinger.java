package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;
import java.util.List;

/**
 * Carte Avant-coureur (Harbinger)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez dans votre défausse, vous pouvez prendre une carte et la mettre sur votre deck.
 */
public class Harbinger extends Action {
    public Harbinger() {
        super("Harbinger", 3);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.drawToHand();
        List<String> choices = new ArrayList<>();
        for (Card c : p.getDiscard()) {
            choices.add(c.getName());
        }
        String scan = p.chooseOption("Quelle carte voulez-vous rajouter sur votre deck ?", choices, true);
        if (scan.equals(""));
        else {
            p.addToDraw(p.getDiscard().getCard(scan));
            p.getDiscard().remove(scan);
        }



    }
}
