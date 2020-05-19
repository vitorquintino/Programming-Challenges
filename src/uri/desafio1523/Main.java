package uri.desafio1523;

import java.util.*;

/*
    Integrantes do grupo:

    Hugo Bechtolt Curi - 10284198
    Guilherme Estevam Ferreira Putzeys - 10424972
    Vitor Santos Quintino - 10258880
*/

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> ins = new HashMap<>();
        HashMap<Integer, Integer> outs = new HashMap<>();

        while(true){
            int drivers = sc.nextInt();
            int capacity = sc.nextInt();

            if(drivers == 0 && capacity == 0) break;

            ins.clear();
            outs.clear();

            for(int i = 1; i <= drivers; i++){
                int entryTime = sc.nextInt();
                int departureTime = sc.nextInt();

                ins.put(entryTime, i);
                outs.put(departureTime, i);
            }

            Map<Integer, Integer> sortedIns = new TreeMap<>(ins);
            Map<Integer, Integer> sortedOuts = new TreeMap<>(outs);

            Queue queue = new Queue();

            boolean stop = false;
            while(true){
                if(stop) break;

                Move nextMove = findNextMove(sortedIns, sortedOuts, queue);

                if(Objects.isNull(nextMove)){
                    System.out.println("Sim");
                    break;
                }

                switch(nextMove.operation){
                    case 'I':
                        if(!queue.put(nextMove.car, capacity)){
                            System.out.println("Nao");
                            stop = true;
                        }
                        break;
                    case 'O':
                        if(!queue.pop(nextMove.car)){
                            System.out.println("Nao");
                            stop = true;
                        }
                        break;
                }
            }
        }
    }

    private static Move findNextMove(Map<Integer, Integer> ins, Map<Integer, Integer> outs, Queue queue) {
        if (ins.size() == 0 && outs.size() == 0) return null;

        Integer insFirstOp = 999999, insFirstCar = 0, outsFirstOp = 999999, outsFirstCar = 0;

        if (ins.size() > 0){
            Iterator it = ins.entrySet().iterator();
            Map.Entry pair = (Map.Entry) it.next();

            insFirstOp = (Integer) pair.getKey();
            insFirstCar = (Integer) pair.getValue();
        }

        if(outs.size() > 0) {
            Iterator it = outs.entrySet().iterator();
            Map.Entry pair = (Map.Entry) it.next();

            outsFirstOp = (Integer) pair.getKey();
            outsFirstCar = (Integer) pair.getValue();
        }

        Move nextMove = new Move();

        if(insFirstOp < outsFirstOp){
            nextMove.setOperation('I');
            nextMove.setCar(insFirstCar);

            ins.remove(insFirstOp);
        }
        else if(insFirstOp > outsFirstOp){
            nextMove.setOperation('O');
            nextMove.setCar(outsFirstCar);

            outs.remove(outsFirstOp);
        }
        else{
            if(queue.queue.get(queue.queue.size() - 1).equals(outsFirstCar)){
                nextMove.setOperation('O');
                nextMove.setCar(outsFirstCar);

                outs.remove(outsFirstOp);
            }
            else{
                nextMove.setOperation('I');
                nextMove.setCar(insFirstCar);

                ins.remove(insFirstOp);
            }
        }

        return nextMove;
    }

    public static class Queue{
        ArrayList<Integer> queue = new ArrayList<>();

        public Queue(){

        }

        public boolean put(Integer car, Integer capacity){
            int numberOfCars = queue.size();

            if((numberOfCars + 1) > capacity) {
                return false;
            }

            queue.add(car);

            return true;
        }

        public boolean pop(Integer car){
            if(queue.size() == 0) return false;

            Integer carToBeRemoved = queue.get(queue.size() - 1);

            if(!carToBeRemoved.equals(car)) return false;

            queue.remove(queue.size() - 1);

            return true;
        }
    }

    public static class Move{
        char operation;
        Integer car;

        public void setOperation(char operation){
            this.operation = operation;
        }

        public void setCar(Integer car){
            this.car = car;
        }
    }
}

/*
3 2
1 10
2 5
6 9
3 2
1 10
2 5
6 12
0 0

3 2
1 2
2 3
3 4

 */