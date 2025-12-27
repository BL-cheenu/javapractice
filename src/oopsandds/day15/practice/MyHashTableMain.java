package oopsandds.day15.practice;

public class MyHashTableMain {
    public static void main(String[] args) {
        String str = "To be or not to be";
        MyHashTable<String, Integer> map1 = new MyHashTable<>();
        String[] words = str.toLowerCase().split("");

        for (String word : words) {
            Integer value = map1.get(word);

            if (value == null){
                map1.put(word, 1);
            }else{
                map1.put(word, value+1);
            }
        }

        System.out.println("Word Frequency:");
        map1.display();
    }
}
