package todo;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoController {

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

  @PatchMapping("/todo/{id}")
  ArrayList<Todo> editTodo(@PathVariable long id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        todo.toggleCompleted();
      }
    }

    return todos;
  }

  @DeleteMapping("/todo/{id}")
  ArrayList<Todo> deleteTodo(@PathVariable long id) {
    for (Todo todo : todos) {
      if (todo.getId() == id) {
        todos.remove(todo);
      }
    }

    return todos;
  }
}