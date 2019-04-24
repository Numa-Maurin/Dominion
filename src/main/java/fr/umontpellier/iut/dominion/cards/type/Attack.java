package fr.umontpellier.iut.dominion.cards.type;

import fr.umontpellier.iut.dominion.CardType;

import java.util.List;

public class Attack extends Action {

    public Attack(String name, int cost) {
        super(name, cost);
    }

    public List<CardType> getTypes() {
        List<CardType> type = super.getTypes();
        type.add(CardType.Attack);
        return type;
    }
}
