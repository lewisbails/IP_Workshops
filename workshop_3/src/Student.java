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
        ArrayList<Integer> myGrades = new ArrayList<>();
        if (this.gradesMap.get(myClass)==null){
            myGrades.add(grade);

        }
        else{
            myGrades = this.gradesMap.get(myClass);
            myGrades.add(grade);
        }
        this.gradesMap.put(myClass,myGrades);
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Integer> getGrades(String myClass){
        return gradesMap.getOrDefault(myClass,null);
    }

    public Set<String> getClasses(){
        return gradesMap.keySet();
    }

    public int getMedianGrade(String myClass){
        return Median.grade(this,myClass);
    }

    public int getAverageGrade(String myClass){
        return Average.grade(this, myClass);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
