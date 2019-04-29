package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

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
        ListOfCards cartepioche= new ListOfCards();
        cartepioche.add(cartepioche1);
        cartepioche.add(cartepioche2);
        System.out.println("les deux premieres cartes de la pioches sont :"+cartepioche.toString());
        for (int i = 0; i < 2; i++) {
            String carteAEcarter = p.chooseCard("Choisissez une carte a ecarter",cartepioche, true);
            if (carteAEcarter==cartepioche1.toString()) {
                p.getGame().trash(cartepioche1);
                cartepioche.remove(cartepioche1);
            }
            else if (carteAEcarter==cartepioche2.toString()){
                p.getGame().trash(cartepioche2);
                cartepioche.remove(cartepioche2);
            }
        }
        for (int i = 0; i < 2; i++) {
            String carteADefauss = p.chooseCard("Choisissez une carte a defausser",cartepioche, true);
            if (carteADefauss==cartepioche1.toString()) {
                p.discardCard(cartepioche1);
                cartepioche.remove(cartepioche1);
            }
            else if (carteADefauss==cartepioche2.toString()){
                p.discardCard(cartepioche2);
                cartepioche.remove(cartepioche2);
            }
        }
        if (!cartepioche.isEmpty()) {
            String carteAReplacer = p.chooseCard("Choisissez la carte a remettre en premier dans la pioche, la deuxieme sera place automatiquement", cartepioche, false);
            if (carteAReplacer == cartepioche1.toString()) {
                p.addToDraw(cartepioche1);
                p.addToDraw(cartepioche2);
            } else if (carteAReplacer == cartepioche2.toString()) {
                p.addToDraw(cartepioche2);
                p.addToDraw(cartepioche1);
            }
        }
    }
}
