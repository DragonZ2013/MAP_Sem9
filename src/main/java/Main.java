import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        Auto daciaTest1 = new Auto("Dacia", "Logan", 2004);
        Auto daciaTest2 = new Auto("Dacia", "None", 2004);
        Auto daciaTest3 = new Auto("Dacia", "Sandero", 1998);
        Auto daciaTest4 = new Auto("Dacia", "1310", 1998);

        List<Auto> autosList = new ArrayList<>();
        autosList.add(daciaTest1);
        autosList.add(daciaTest2);
        autosList.add(daciaTest3);
        autosList.add(daciaTest4);
        Map<Integer, List<Auto>> modelMap = autosList.stream().collect(Collectors.groupingBy(Auto::getYear));
        System.out.println(modelMap);
        //for(Map.Entry entry: modelMap.entrySet()){
        //    System.out.println(entry.getValue());
        //}
        autosList.stream().map(Auto::getModel).filter(x-> !Objects.equals(x,"None")).forEach(System.out::println);
        String string = "Ana are Mere si nu are Pere";
        Arrays.stream(string.split(" ")).filter(x->x.charAt(0)>='A'&&x.charAt(0)<='Z').forEach(x->System.out.print(x+" "));

        BufferedReader bufferedReader = new BufferedReader(new FileReader("text.txt"));
        List<String> list = new ArrayList<>();
        for(int i=0;i<9;i++){
            list.add(bufferedReader.readLine().trim());
        }
        System.out.println();
        list.stream().filter(x->x.contains("ete")||x.contains("ar")).map(x->x.toUpperCase()+"!").sorted().forEach(x->System.out.print(x+" "));

        String string1 = "Ana are mere si nu are pere";
        System.out.println();
        Arrays.stream(string1.split(" ")).filter(x->x.length()<4).map(String::toUpperCase).filter(x->x.contains("E")).forEach(x->System.out.print(x+" "));
        System.out.println();
        //System.out.println(Arrays.stream(string1.split(" ")).map(String::toUpperCase).reduce("",(x,y)->x+"\t\n"+y));
        System.out.println(Arrays.stream(string1.split(" ")).map(String::toUpperCase).collect(Collectors.joining("\t","Start: ","End: ")));
    }


}