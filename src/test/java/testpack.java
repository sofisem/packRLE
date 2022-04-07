import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;

public class testpack {
    @Test
    public void test1() throws IOException {
        File expected = new File("expected.txt");
        expected.createNewFile();
        try (PrintWriter pw = new PrintWriter(expected)) {
            pw.println("ffftpp");
            pw.println("nnterg");
            pw.println("bjjxt");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File input = new File("input.txt");
        input.createNewFile();
        try (PrintWriter pw = new PrintWriter(input)) {
            pw.println("f3tp2");
            pw.println("n2terg");
            pw.println("bj2xt");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File out = new File("out.txt");
        out.createNewFile();

        Main.main("input.txt -u -out out.txt".trim().split(" "));

        BufferedReader br = null;
        BufferedReader bt = null;
        br = new BufferedReader(new FileReader("expected.txt"));
        bt = new BufferedReader(new FileReader("out.txt"));
        String line1;
        String line2;
        while ((line1 = bt.readLine()) != null){
            line2=br.readLine();
            Assertions.assertEquals(line1,line2);
        }
    }

    @Test
    public void test2() throws IOException {
        File expected = new File("expected.txt");
        expected.createNewFile();
        try (PrintWriter pw = new PrintWriter(expected)) {
            pw.println("f3tp2");
            pw.println("n2terg");
            pw.println("bj2xt");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File input = new File("input.txt");
        input.createNewFile();
        try (PrintWriter pw = new PrintWriter(input)) {
            pw.println("ffftpp");
            pw.println("nnterg");
            pw.println("bjjxt");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File out = new File("out.txt");
        out.createNewFile();

        Main.main("input.txt -z -out out.txt".trim().split(" "));

        BufferedReader br = null;
        BufferedReader bt = null;
        br = new BufferedReader(new FileReader("expected.txt"));
        bt = new BufferedReader(new FileReader("out.txt"));
        String line1;
        String line2;
        while ((line1 = bt.readLine()) != null){
            line2=br.readLine();
            Assertions.assertEquals(line1,line2);
        }
    }

    @Test
    public void test3() throws IOException {
        File expected = new File("expected.txt");
        expected.createNewFile();
        try (PrintWriter pw = new PrintWriter(expected)) {
            pw.println("ggggtfffll");
            pw.println("lophhhhh");
            pw.println("bbbbhjkkkk");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File input = new File("input.txt");
        input.createNewFile();
        try (PrintWriter pw = new PrintWriter(input)) {
            pw.println("g4tf3l2");
            pw.println("loph5");
            pw.println("b4hjk4");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File out = new File("out.txt");
        out.createNewFile();

        Main.main("input.txt -u -out out.txt".trim().split(" "));

        BufferedReader br = null;
        BufferedReader bt = null;
        br = new BufferedReader(new FileReader("expected.txt"));
        bt = new BufferedReader(new FileReader("out.txt"));
        String line1;
        String line2;
        while ((line1 = bt.readLine()) != null){
            line2=br.readLine();
            Assertions.assertEquals(line1,line2);
        }
    }
    @Test
    public void test4() throws IOException {
        File expected = new File("expected.txt");
        expected.createNewFile();
        try (PrintWriter pw = new PrintWriter(expected)) {
            pw.println("g4tf3l2");
            pw.println("loph5");
            pw.println("b4hjk4");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File input = new File("input.txt");
        input.createNewFile();
        try (PrintWriter pw = new PrintWriter(input)) {
            pw.println("ggggtfffll");
            pw.println("lophhhhh");
            pw.println("bbbbhjkkkk");
        } catch (IOException e) {
            System.out.println("ERROR " + e);
        }
        File out = new File("out.txt");
        out.createNewFile();

        Main.main("input.txt -z -out out.txt".trim().split(" "));

        BufferedReader br = null;
        BufferedReader bt = null;
        br = new BufferedReader(new FileReader("expected.txt"));
        bt = new BufferedReader(new FileReader("out.txt"));
        String line1;
        String line2;
        while ((line1 = bt.readLine()) != null){
            line2=br.readLine();
            Assertions.assertEquals(line1,line2);
        }
    }
}

