package hello;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

class Todo {
  public long id;
  public String text;

  public Todo(String text, long id) {
    this.text = text;
    this.id = id;
  }
}

@RestController
public class GreetingController {

  private static final String template = "Hello, %s!";
  private final AtomicLong id = new AtomicLong();
  private ArrayList<Todo> todos = new ArrayList<Todo>();

  @GetMapping("/")
  String home() {
    return "Welcome home!";
  }

  @GetMapping("/todos")
  ArrayList<Todo> getTodos() {
    return todos;
  }

  @PostMapping("/todo")
  ArrayList<Todo> addTodo(@RequestBody String newTodoText) {
    Todo newTodo = new Todo(newTodoText, id.incrementAndGet());

    todos.add(newTodo);
    return todos;
  }

  @RequestMapping("/greeting")
  public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}