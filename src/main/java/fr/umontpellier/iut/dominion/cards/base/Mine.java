package fr.umontpellier.iut.dominion.cards.base;

import fr.umontpellier.iut.dominion.CardType;
import fr.umontpellier.iut.dominion.ListOfCards;
import fr.umontpellier.iut.dominion.Player;
import fr.umontpellier.iut.dominion.cards.type.Action;
import fr.umontpellier.iut.dominion.cards.Card;


/**
 * Carte Mine
 *
 * Écartez une carte Trésor de votre main. Recevez une carte Trésor coûtant jusqu'à 3 Pièces de plus ;
 * ajoutez cette carte à votre main.
 */
public class Mine extends Action {
    public Mine() {
        super("Mine", 5);
    }

    public void play(Player p){
        ListOfCards treasurefromhands = new ListOfCards();
        ListOfCards treasurecards = new ListOfCards();
        for(Card c: p.getCardsInHand()){
            if(c.getTypes().contains(CardType.Treasure)){
                treasurefromhands.add(c);
            }
        }
        String cardName = p.chooseCard("Choisissez une carte trésor à écarter", treasurefromhands, false);
        Card carte = p.removeFromHand(cardName);
        int cost = carte.getCost()+3;
        p.getGame().trash(carte);

        for(Card c1 : p.getGame().availableSupplyCards()) {
            if(c1.getTypes().contains(CardType.Treasure) && c1.getCost()<=cost){
                treasurecards.add(c1);
            }
        }

        String cardchoose = p.chooseCard("Choisissez une carte Trésor coûtant jusqu'à 3 pièce de plus que la carte écartée", treasurecards,false);
        p.addToHand(p.getGame().getFromSupply(cardchoose));
    }
}