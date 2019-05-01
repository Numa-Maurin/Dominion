package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.Card;
import fr.umontpellier.iut.dominion.cards.type.Action;

import java.util.ArrayList;

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
        Card carte1 = p.drawCard();
        Card carte2 = p.drawCard();
        ArrayList<String> cartepioche = new ArrayList<>();
        String cardName1 = "";
        String cardName2 = "";
        if (carte1 != null) {
            cardName1 = carte1.getName();
            cartepioche.add(cardName1);
        }
        if (carte2 != null) {
            cardName2 = carte2.getName();
            cartepioche.add(cardName2);
        }
        for (int i = 0; i < 2; i++) {
            String carteAEcarter = p.chooseOption("Choisissez une carte a ecarter",cartepioche, true);
            if (carteAEcarter.equals(cardName1)) {
                p.getGame().trash(carte1);
                cartepioche.remove(cardName1);
            }
            else if (carteAEcarter.equals(cardName2)){
                p.getGame().trash(carte2);
                cartepioche.remove(cardName2);
            }
        }
        for (int i = 0; i < 2; i++) {
            String carteADefausser = p.chooseOption("Choisissez une carte a defausser",cartepioche, true);
            if (carteADefausser.equals(cardName1)) {
                p.discardCard(carte1);
                cartepioche.remove(cardName1);
            }
            else if (carteADefausser.equals(cardName2)){
                p.discardCard(carte2);
                cartepioche.remove(cardName2);
            }
            else if (carteADefausser.equals("")){
                break;
            }
        }
        if (!cartepioche.isEmpty()) {
            String carteAReplacer = p.chooseOption("Choisissez la carte a remettre en premier dans la pioche, la deuxieme sera mise automatiquement", cartepioche, false);
            if (carteAReplacer.equals(cardName1)) {
                p.addToDraw(carte1);
                p.addToDraw(carte2);
            } else if (carteAReplacer.equals(cardName2)) {
                p.addToDraw(carte2);
                p.addToDraw(carte1);
            }
        }
    }
}
