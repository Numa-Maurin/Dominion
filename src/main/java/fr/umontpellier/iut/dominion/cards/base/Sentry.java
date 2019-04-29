package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Sentinelle (Sentry)
 *
 * +1 Carte.
 * +1 Action.
 * Regardez les 2 premières cartes de votre deck. Écartez et/ou défaussez celles que vous voulez.
 * Replacez les autres sur votre deck dans l'ordre de votre choix.
 * Le joueur entre d’abord les noms des cartes qu’il souhaite écarter, et
 * entre la chaîne vide pour passer à la suite. Il entre ensuite les noms des cartes
 * qu’il souhaite défausser et passe avec la chaîne vide. Enfin, il entre les noms des
 * cartes à replacer sur la pioche, la dernière étant replacée au-dessus.
 */
public class Sentry extends Action {
    public Sentry() {
        super("Sentry", 5);
    }

    @Override
    public void play(Player p) {
        p.incrementActions(1);
        p.drawToHand();
        Card cartepioche1 = p.drawCard();
        Card cartepioche2 = p.drawCard();

        System.out.println("les deux premieres cartes de la pioches sont :"+cartepioche1.getName().toString()+cartepioche2.getName().toString());

    }
}
