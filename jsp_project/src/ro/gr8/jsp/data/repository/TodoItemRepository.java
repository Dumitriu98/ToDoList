package ro.gr8.jsp.data.repository;

import java.util.*;

public class TodoItemRepository {
    private static TodoItemRepository todoItemRepository = new TodoItemRepository();
    private Set<ToDoItem> toDoItems = new LinkedHashSet<>();

    public static TodoItemRepository getInstance() { return todoItemRepository; }

    public Collection<ToDoItem> getToDoItems(){
        return Collections.unmodifiableCollection(toDoItems);
    }

    public void addToDoItem(ToDoItem item) {
        toDoItems.add(item);
    }

    public Optional<ToDoItem> findToDoItem(String action) {
        return toDoItems.stream()
                .filter(item -> item.getName().equalsIgnoreCase(action))
                .findFirst();
    }

    private TodoItemRepository(){
        toDoItems.add(ToDoItem.newToDoItem().name("Wash the car").isCompleted(true).build());
        toDoItems.add(ToDoItem.newToDoItem().name("Clean the house").isCompleted(true).build());
        toDoItems.add(ToDoItem.newToDoItem().name("Buy the food for tomorrow").isCompleted(true).build());
        toDoItems.add(ToDoItem.newToDoItem().name("Read the book").isCompleted(true).build());

    }


}
