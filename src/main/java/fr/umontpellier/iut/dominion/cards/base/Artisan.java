package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;

/**
 * Carte Artisan
 *
 * Gagnez une carte coûtant jusqu'à 5 Pièces dans votre main.
 * Mettez une carte de votre main sur votre deck.
 * Le joueur entre d’abord le nom de la carte à gagner en main, puis le
 * nom de la carte qu’il veut replacer sur son deck.
 */
public class Artisan extends Action {
    public Artisan() {
        super("Artisan", 6);
    }

    @Override
    public void play(Player p){

    }
}
