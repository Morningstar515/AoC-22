
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

class Day5 {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Tyler\\OneDrive\\Desktop\\Advent.txt");
        BufferedReader input = new BufferedReader(new FileReader(file));

        // Constructing stacks
        String line = input.readLine();
        long stacks = (line.chars().count() + 1) / 4;
        int i = 0;
        ArrayList<LinkedList<String>> list = new ArrayList<>();
        while (list.size() < stacks) {
            list.add(new LinkedList<>());
        }

        //Deal with first line of input
        for (int j = 0; j < line.length(); j++) {
            if (line.charAt(j) != ' ' && line.charAt(j) != '[' && line.charAt(j) != ']') {
                list.get(j / 4).add(String.valueOf(line.charAt(j)));
            }
        }

        //Dealing with the rest of input
        while ((line = input.readLine()) != null && !line.isEmpty()) {
            for (int j = 0; j < line.length(); j++) {
                if (line.charAt(j) != ' ' && line.charAt(j) != '[' && line.charAt(j) != ']') {
                    list.get(j / 4).push(String.valueOf(line.charAt((j))));
                }
            }
        }

        reverse(list);

        //Dealing with loading instructions
        while((line = input.readLine()) != null){
            LinkedList<String> aux = new LinkedList<>();
            String Move = "";
            String fullMove = "";
            boolean isDouble = false;

            //First Number
            if(Character.isDigit(line.charAt(5)) && !Character.isDigit(line.charAt(6))){
                    Move = String.valueOf(line.charAt(5));

            }
            else if(Character.isDigit(line.charAt(5)) && Character.isDigit(line.charAt(6))){
                Move = String.valueOf(line.charAt(5));
                String sMove = String.valueOf(line.charAt(6));
                fullMove = Move.concat(sMove);
                isDouble = true;

            }
            //Second Number
            i = Integer.parseInt(Move);
            int k = Integer.parseInt(Move);
            if(!isDouble){
                String from = String.valueOf(line.charAt(12));
                String to = String.valueOf(line.charAt(17));
                aux = new LinkedList<>();
                while(i > 0){
                    aux.addFirst(list.get(Integer.parseInt(from) -1).removeFirst());
                    i--;
                }
                while( k > 0){
                    list.get(Integer.parseInt(to) -1).addFirst(aux.removeFirst());
                    k--;
                }
                System.out.println();
                System.out.println(list.get(0));
                System.out.println(list.get(1));
                System.out.println(list.get(2));
                System.out.println(list.get(3));
                System.out.println(list.get(4));
                System.out.println(list.get(5));
                System.out.println(list.get(6));
                System.out.println(list.get(7));
                System.out.println(list.get(8));
            }
            else{
                i = Integer.parseInt(fullMove);
                k = Integer.parseInt(fullMove);
                String from = String.valueOf(line.charAt(13));
                String to = String.valueOf(line.charAt(18));
                while(i > 0){

                    aux.addFirst(list.get(Integer.parseInt(from) -1).removeFirst());

                    i--;
                }
                while( k > 0){
                    list.get(Integer.parseInt(to) -1).addFirst(aux.removeFirst());
                    k--;
                }

            }
        }

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println(list.get(4));
        System.out.println(list.get(5));
        System.out.println(list.get(6));
        System.out.println(list.get(7));
        System.out.println(list.get(8));


    }

    public static void reverse(ArrayList<LinkedList<String>> list){
        LinkedList<String> link = new LinkedList<>();
        for (int i = 0; i < list.size(); i++) {
            list.get(i).removeFirst();
        }
        for (int i = 0; i < list.size();) {
            link.addFirst(list.get(i).removeFirst());
            if(list.get(i).isEmpty()){
                list.remove(i);
                list.add(i,link);
                i++;
                link = new LinkedList<>();


            }
        }
    }
}


