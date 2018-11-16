import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class Student {
    private String name;
    private HashMap<String,ArrayList<Integer>> gradesMap;

    public Student(String name){
        this.name = name;
        gradesMap = new HashMap<>();
    }

    public void addClass(String newClass){
        gradesMap.put(newClass,null);
    }

    public void addGrade(String myClass, int grade){
        ArrayList<Integer> myGrades = gradesMap.getOrDefault(myClass,null);
        myGrades.add(grade);
        gradesMap.put(myClass,myGrades);
    }

    public ArrayList<Integer> getGrades(String myClass){
        return gradesMap.getOrDefault(myClass,null);
    }

    public Set<String> getClasses(){
        return gradesMap.keySet();
    }
}
