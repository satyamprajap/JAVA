//1. Using ArrayList

import java.util.ArrayList;

class Task {
  String name;

Task(String name){
  this.name = name;
}
}

public class TaskManager{
  public static void main(String[] args){
    ArrayList<Task> tasks = new ArrayList<>();

   task.add(new Task("complete Assignment"));
    task.add(new Task("study DSA));
    task.add(new Task("Attend Class"));
    System.out.println("Task List:");
    for(Task task : tasks){
      System.out.println(task.name);
    }
  }
}


2. Using LinkedList
import java.util.LinkedList;

class Task {
    String name;

    Task(String name) {
        this.name = name;
    }
}
// Output
// Task List:
// Complete Assignment
// Study DSA
// Attend Class

public class TaskManager {
    public static void main(String[] args) {
        LinkedList<Task> tasks = new LinkedList<>();

        tasks.add(new Task("Complete Assignment"));
        tasks.add(new Task("Study DSA"));
        tasks.add(new Task("Attend Class"));

        System.out.println("Task List:");
        for (Task task : tasks) {
            System.out.println(task.name);
        }
    }
}

//  Output
// Task List:
// Complete Assignment
// Study DSA
// Attend Class
