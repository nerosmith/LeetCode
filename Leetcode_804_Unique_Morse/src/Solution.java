import java.util.TreeSet;

public class Solution {

    public int uniqueMorseRepresentations(String[] words) {

        String[] codes = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
        TreeSet<String> set = new TreeSet<>();
        for(String word: words){
            StringBuilder res = new StringBuilder();
            for(int i = 0 ; i < word.length() ; i ++)
                res.append(codes[word.charAt(i) - 'a']);
            set.add(res.toString());
        }
        System.out.println(set.size());
        return set.size();
    }
    public static void main(String[] args){
        Solution solution = new Solution();
        String[] words = {"gin","zen","gig","msg"};
        solution.uniqueMorseRepresentations(words);
    }

}







