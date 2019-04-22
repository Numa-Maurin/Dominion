package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Game;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Attack;

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
       p.incrementMoney(1);
        for (Player o : p.getGame().otherPlayers(p)) {
            for (int i = 0; i < 2; i++) {
                o.drawCard();
            }
        }

    }
}
