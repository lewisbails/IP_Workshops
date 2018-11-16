import java.util.HashSet;
import java.util.Scanner;

public class Interface {

    public static void main(String[] args) {
        HashSet<Student> students = FileReader.readInput("grades.txt");

        System.out.println("Awaiting command...");
        Scanner scanner = new Scanner(System.in);

        String[] line = scanner.nextLine().split(" ");

        while(!line[0].equals("BYE")){

            switch (line[0]){
                case "STUDENTS":
                    students.forEach(System.out::println);
                    break;
                case "CLASSES":
                    HashSet<String> classes = new HashSet<>();
                    students.forEach(student -> classes.addAll(student.getClasses()));
                    classes.forEach(System.out::println);
                    break;
                case "MEDIAN":
                    try{
                        for (Student student : students){
                            if (student.getName().equals(line[1])){
                                System.out.println(student.getMedianGrade(line[2]));
                            }
                        }
                        break;
                    }
                    catch (Exception e){
                        System.out.println("Command \"MEDIAN\" error.");
                        break;
                    }
                case "AVERAGE":
                    try{
                        for (Student student : students){
                            if (student.getName().equals(line[1])){
                                System.out.println(student.getAverageGrade(line[2]));
                            }
                        }
                        break;
                    }
                    catch (Exception e){
                        System.out.println("Command \"AVERAGE\" error.");
                        break;
                    }
                case "BYE":

                default:
                    System.out.println("Unknown command.");
                    break;
            }

            System.out.println("Awaiting next command...");
            line = new Scanner(System.in).nextLine().split(" ");
        }
        System.out.println("Interface terminated.");




    }
}
