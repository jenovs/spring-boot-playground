package todo;

class Todo {
  public long id;
  public String text;
  public boolean completed = false;

  public Todo(String text, long id) {
    this.text = text;
    this.id = id;
  }
}