package todo;

class Todo {
  private static long nextId = 0;
  private long id;
  private String text;
  private boolean completed = false;

  public Todo(String text) {
    this.text = text;
    this.id = Todo.nextId++;
  }

  public long getId() {
    return this.id;
  }

  public String getText() {
    return this.text;
  }

  public boolean getCompleted() {
    return this.completed;
  }

  public void toggleCompleted() {
    this.completed = !this.completed;
  }
}