package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Reaction;

import java.util.Arrays;
import java.util.List;

/**
 * Carte Douves (Moat)
 *
 * +2 Cartes.
 * Lorsqu’un adversaire joue une carte Attaque, vous pouvez dévoiler cette carte de votre main. Dans ce
 * cas, l’Attaque n’a pas d’effet sur vous.
 */
public class Moat extends Reaction {
    public Moat() {
        super("Moat", 2);
    }

    @Override
    public void play(Player p) {
        p.drawToHand();
        p.drawToHand();
    }

    @Override
    public boolean react(Player p) {
        List<String> choices = Arrays.asList("y", "n");
        if (p.chooseOption("Do you want to use Moat ?", choices, false).equals("n")) {
            return false;
        }
        return true;
    }
}
