Bonjour et bienvenue à l'équipe Gilded Rose.
-----

Comme vous le savez, nous sommes une petite auberge, avec un emplacement de premier choix, dans une ville importante,
tenu par un ami aubergiste nommé Allison. De plus, nous achetons et vendons uniquement les meilleurs produits.

Malheureusement, nos produits se dégradent continuellement en qualité au fur et à mesure qu'il approche de leurs dates
de vente.

Nous avons un système en place qui mets à jour notre inventaire.
Il a été développer par un type lunatique nommé Leeroy, qui est parti pour de nouvelles aventures.

Votre tache est d'ajouter une nouvelle fonctionnalité à notre système pour faire en sorte que nous puissions ventre
une nouvelle catégorie d'objet.

Tout d'abord, une introduction à notre système :
----

- Tous les objets ont un champ de date de vente nommé `SellIn` qui représente le nombre de jours que nous ayons pour vendre l'objet.
- Tous les objets ont un champ qualité nommé `Quality` qui représente la valeur de l'objet.
- A la fin de chaque jour, notre système baisse les valeurs de ces derniers champs pour chaque objet

Plutôt simple, non ? Et bien, c'est là que ça devient intéressant :

- Une fois que la date de vente est passé, la qualité se dégrade deux fois plus vite
- La qualité d'un objet ne pourra jamais être négatif
- "Aged Brie" possède la particularité d'augmenter sa qualité au fil de l'age
- La qualité d'un objet ne dépasse jamais 50
- "Sulfuras", le légendaire objet, ne pourra jamais être vendu ou voir sa qualité diminuer
- "Backstage passes", comme "Aged Brie", augmente en qualité au fur et à mesure que sa date de vente approche.
La qualié augmente de 2 quand il reste moins de 10 jours (inclu), et par 3 quand il reste moins de 5 jours (inclu)
mais la qualité chute à 0 après le concert

Nous avons dernièrement signé avec un fournisseur d'objets conjurés. Cela nécessite une mise à jour de notre système.

- Les objets "Conjurés" perdent leurs qualités deux fois plus vite que les objets normaux.

Vous êtes libre de faire n'importe quelle modification sur la méthode `UpdateQuality` et
d'ajouter n'importe quel nouveau code, tant que l'ensemble marche correctement.

Cependant, ne modifiez pas la class `Item` ou le champ `Items` sachant que ceux ci appartiennent
 au goblin du coin qui entrera dans une rage instantaté et vous tuera, étant donné qu'il ne crois pas
 au shared code ownership. (Vous pouvez rendre la méthode `UpdateQuality` et le champ `Items` static si vous le souhaitez,
 on assumera pour vous).

 Votre travail se devra d'être fini pour très bien bientôt.

 Uniquement pour clarrifier les choses, un objet ne pourra avoir une qualité supérieur à 50, cependant,
 "Sulfuras" est un objet légendaire, c'est pourquoi sa qualité est de 80 et ne pourra jamais être altéré.



```java
public class GildedRose {

	private static List<Item> items = null;

	/**
	 * @param args
	 */
	public static void main(String[] args) {

        System.out.println("OMGHAI!");

        items = new ArrayList<Item>();
        items.add(new Item("+5 Dexterity Vest", 10, 20));
        items.add(new Item("Aged Brie", 2, 0));
        items.add(new Item("Elixir of the Mongoose", 5, 7));
        items.add(new Item("Sulfuras, Hand of Ragnaros", 0, 80));
        items.add(new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20));
        items.add(new Item("Conjured Mana Cake", 3, 6));

        updateQuality();
}



    public static void updateQuality()
    {
        for (int i = 0; i < items.size(); i++)
        {
            if (items.get(i).getName() != "Aged Brie" && items.get(i).getName() != "Backstage passes to a TAFKAL80ETC concert")
            {
                if (items.get(i).getQuality() > 0)
                {
                    if (items.get(i).getName() != "Sulfuras, Hand of Ragnaros")
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - 1);
                    }
                }
            }
            else
            {
                if (items.get(i).getQuality() < 50)
                {
                    items.get(i).setQuality(items.get(i).getQuality() + 1);

                    if (items.get(i).getName() == "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (items.get(i).getSellIn() < 11)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }

                        if (items.get(i).getSellIn() < 6)
                        {
                            if (items.get(i).getQuality() < 50)
                            {
                                items.get(i).setQuality(items.get(i).getQuality() + 1);
                            }
                        }
                    }
                }
            }

            if (items.get(i).getName() != "Sulfuras, Hand of Ragnaros")
            {
                items.get(i).setSellIn(items.get(i).getSellIn() - 1);
            }

            if (items.get(i).getSellIn() < 0)
            {
                if (items.get(i).getName() != "Aged Brie")
                {
                    if (items.get(i).getName() != "Backstage passes to a TAFKAL80ETC concert")
                    {
                        if (items.get(i).getQuality() > 0)
                        {
                            if (items.get(i).getName() != "Sulfuras, Hand of Ragnaros")
                            {
                                items.get(i).setQuality(items.get(i).getQuality() - 1);
                            }
                        }
                    }
                    else
                    {
                        items.get(i).setQuality(items.get(i).getQuality() - items.get(i).getQuality());
                    }
                }
                else
                {
                    if (items.get(i).getQuality() < 50)
                    {
                        items.get(i).setQuality(items.get(i).getQuality() + 1);
                    }
                }
            }
        }
    }

}
```