package StringsQ;

public class CharConsecDiff {

    public static void fun(String s) {
        StringBuilder sb=new StringBuilder();

        int diff;

        for(int i=1;i<s.length() -1;i++){

            char c1=s.charAt(i);
            char c2=s.charAt(i-1);
            diff=c2-c1;

            sb.append(c2).append(diff);


        }

        System.out.println(sb.append(s.charAt(s.length()-1)));

    }

    public static void main(String[] args) {

        String s ="pepCODinG";
        fun(s);

    }

}
