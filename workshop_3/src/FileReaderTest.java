import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;

import java.util.HashSet;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class FileReaderTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(FileReader.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @org.junit.Test
    public void readInput() {
        HashSet<Student> students = FileReader.readInput("test.txt");
        assertEquals(1,students.size());
        for (Student student : students) {
            //only 1 student in students
            assertEquals(2, student.getClasses().size());
        }
    }

    @org.junit.Test
    public void main() {
    }
}
