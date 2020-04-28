package uri.desafio1260;

import java.util.*;

/*
    Integrantes do grupo:

    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/


public class Main {

    static HashMap<String, Integer> trees = new HashMap<>();
    static int treesQuantity = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int caseTests = sc.nextInt();

        sc.nextLine();
        sc.nextLine();

        for (int i = 0; i < caseTests; i++) {
            while (sc.hasNext()) {
                String name = sc.nextLine();

                if (name.equals("")) {
                    Map<String, Integer> sortedTrees = new TreeMap<>(trees);

                    for (Map.Entry<String, Integer> entry : sortedTrees.entrySet()) {
                        Integer quantity = entry.getValue();

                        double percentage = ((double) quantity/treesQuantity) * 100.0;

                        String percentageString = String.format(Locale.US, "%.4f", percentage);

                        System.out.println(entry.getKey() + " " + percentageString);
                    }

                    if(!(i == (caseTests - 1)))
                        System.out.println();

                    trees.clear();
                    treesQuantity = 0;

                    break;
                } else {
                    treesQuantity++;

                    if (trees.containsKey(name))
                        trees.put(name, (trees.get(name)) + 1);
                    else
                        trees.put(name, 1);
                }
            }
        }
        Map<String, Integer> sortedTrees = new TreeMap<>(trees);

        for (Map.Entry<String, Integer> entry : sortedTrees.entrySet()) {
            Integer quantity = entry.getValue();

            double percentage = ((double) quantity/treesQuantity) * 100.0;

            String percentageString = String.format(Locale.US, "%.4f", percentage);

            System.out.println(entry.getKey() + " " + percentageString);
        }
    }
}


/*
2

Red Alder
Ash
Aspen
Basswood
Ash
Beech
Yellow Birch
Ash
Cherry
Cottonwood
Ash
Cypress
Red Elm
Gum
Hackberry
White Oak
Hickory
Pecan
Hard Maple
White Oak
Soft Maple
Red Oak
Red Oak
White Oak
Poplan
Sassafras
Sycamore
Black Walnut
Willow

Red Alder
Ash


 */