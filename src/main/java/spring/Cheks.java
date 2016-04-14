package spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Cheks {


    private TaskProvider<Task<Long>> taskProvider;
@Autowired
    public void setTaskProvider(TaskProvider<Task<Long>> taskProvider) {
        this.taskProvider = taskProvider;
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-Context2.xml");
        Cheks cheks = applicationContext.getBean("cheks", Cheks.class);
        cheks.execute();

    }


    private void execute() throws Exception {
        List<Task<Long>> intTasks = taskProvider.getAllTasks();

        Executor<Number> numberExecutor = new ExecutorImpl<>();

        for (Task<Long> intTask : intTasks) {
            numberExecutor.addTask(intTask);
        }
        numberExecutor.addTask(new LongTask(-1000L), new NumberValidator());

        numberExecutor.execute();

        System.out.println("Valid results:");
        for (Number number : numberExecutor.getValidResults()) {
            System.out.println(number);
        }
        System.out.println("Invalid results:");
        for (Number number : numberExecutor.getInvalidResults()) {
            System.out.println(number);
        }
    }


}

