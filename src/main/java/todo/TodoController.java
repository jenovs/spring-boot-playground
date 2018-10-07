package todo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

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
    Todo newTodo = new Todo(newTodoText);

    todos.add(newTodo);
    return todos;
  }
}