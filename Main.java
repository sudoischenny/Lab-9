import java.io.*;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    String name;
    int age;
    String color;
    ArrayList<Person> people;
    people = new ArrayList<Person> ();
    people.add(new Person("Andy", 24, "blue"));
    people.add(new Person("A", 87, "pink"));
    people.add(new Person("B", 13, "yellow"));
    people.add(new Person("C", 55, "black"));
    people.add(new Person("D", 4, "green"));

    try{
      FileWriter writer = new FileWriter("data.txt");
      BufferedWriter output = new BufferedWriter(writer);
      for (Person person: people){
        output.write(person.getName());
        output.newLine();
        output.write(Integer.toString(person.getAge()));
        output.newLine();
        output.write(person.getColor());
        output.newLine();
      }
      output.flush();
      output.close();
    }
    catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
    }

    try{
      FileReader myFile;
      myFile = new FileReader("data.txt");
      BufferedReader reader = new BufferedReader(myFile);
      people.clear();

      while (reader.ready()){
        name = reader.readLine();
        age = Integer.parseInt(reader.readLine());
        color = reader.readLine();
        people.add(new Person(name, age, color));
      }
      for (Person person: people){
        System.out.printf("%-10s %n", person.getName()+", "+person.getAge()+", "+person.getColor());
      }
      reader.close();
    }
    // catch (IOException excpt){
    //   excpt.printStackTrace();
    // }
    catch (IOException exception) {
      System.out.println("An error occurred: " + exception);
    }    
  }
}