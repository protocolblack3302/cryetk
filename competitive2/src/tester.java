import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class tester {

    static <T> void forEach(List<T> list, Consumer<T> c){
        for(T item: list){
            c.accept(item);
        }
    }

    static <T,R> List<R> map(List<T> list, Function<T,R> f){
        ArrayList<R> result=new ArrayList<>();
        for(T elem:list){
            result.add(f.apply(elem));
        }
        return result;
    }

    public static void main(String[] args){

    forEach(Arrays.asList(1,2,34,5), System.out::println);
    System.out.println(map(Arrays.asList("harsh","kk","wow"),(String s)->s.replace("h","m")));
    System.out.println(
            (ArrayList<String>)
                    Arrays.asList(1,2,3,4,4,5,67,7,8,9).
                            parallelStream().
                            filter(i->i>10).
                            map(String::valueOf).
                            collect(Collectors.toCollection(ArrayList::new)));



    }
}
