package spring;

import java.util.List;


public interface TaskProvider <T> {
   List <T> getAllTasks();
}
