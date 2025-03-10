package hashmap;

import java.util.HashMap;

public class IsIsoMorphic {

    public boolean isIsomorphic(String s, String t){
      if(s == null || t == null || s.length() != t.length()){
          return false;
      }

        HashMap<Character,Character> mapST = new HashMap<>();
        HashMap<Character,Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++){
           char fromS = s.charAt(i);
            System.out.println("fromS:" + fromS);
           char fromT = t.charAt(i);
            System.out.println("fromT:" + fromT);

            if(mapST.containsKey(fromS)){
                 if (mapST.get(fromS) != fromT){
                     return false;
                 }
            } else if (mapTS.containsKey(fromT)) {
                if (mapTS.get(fromT) != fromS){
                    return false;
                }
            } else {
                mapST.put(fromS,fromT);
                mapTS.put(fromT,fromS);
            }

        }

   return true;


    }


    public static void main(String[] args) {
        IsIsoMorphic IsIsoMorphic = new IsIsoMorphic();
        System.out.println(IsIsoMorphic.isIsomorphic("egg","add"));
       // System.out.println(IsIsoMorphic.isIsomorphic("foo","bar"));
    }

}
