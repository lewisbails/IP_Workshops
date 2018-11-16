import java.io.*;
import java.util.*;

public class FileReader 
{
    /*
    * Reads a text file containing students and their
    * grades in the courses they take.
    * Usage: SomeDataStructure a = FileReader.readInput(someFileNameHere);
    *
    * TODO: Replace void with data structure of choice.
    *
    * @param filename Name of the text file (Ex. "prices.txt").
    */
    public static HashSet<Student> readInput(String filename)
    {
        //TODO: Create data structure of choice
        //Ex. List<Something> someList = new ArrayList<>();
        HashSet<Student> students = new HashSet<>();

        //Try opening the file and making a scanner that goes through the file
        try (Scanner scanner = new Scanner(new File(filename))) 
        {
            //Iterate through all the lines in the text file
            Student newStudent = null;
            String newClass = "";

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                System.out.println(line);

                if (line.startsWith(">")) {
                    //This line is the name of a student
                    String studentName = line.substring(1);
                    System.out.println("New student: " + studentName);

                    //TODO: Some code here
                    newStudent = new Student(studentName);
                    students.add(newStudent);
                }
                else if (!line.matches("\\d+")) {
                    //This line is a new course
                    System.out.println("Course: " + line);

                    //TODO: Some code here
                    newClass = line;
                    newStudent.addClass(newClass);
                }
                else {
                    //This line is a grade
                    int grade = Integer.parseInt(line);

                    System.out.println("Grade: " + grade);

                    //TODO: Some code here
                    newStudent.addGrade(newClass,grade);
                }
            }

            //TODO: Return data structure of choice after while loop is done
            return students;
            //Ex. return someList;
        } 
        catch (IOException ex) 
        {
            //File was probably not found :(
            System.out.println(ex.getMessage());
            return null;
        }
    }

    public static void main(String[] args)
    {
        readInput("grades.txt");
    }
}