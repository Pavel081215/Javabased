package spring;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class IntegerTaskProvider  implements TaskProvider  <Task<Long>>  {

    private List<Task<Long>> task = new ArrayList<>();
@PostConstruct
    public void init(){

        Task<Long> longTask = new LongTask(-1);
        Task<Long> longTask2 = new LongTask(2);
        Task<Long> longTask3 = new LongTask(30);
        Task<Long> longTask4 = new LongTask(4);
        task.add(longTask);
        task.add(longTask2);
        task.add(longTask3);
        task.add(longTask4);

    }


    @Override
    public List<Task<Long>> getAllTasks() {
        return task;
    }
}
