package ro.gr8.jsp.data.repository;

import javafx.util.Builder;

import java.nio.channels.CompletionHandler;
import java.util.Date;
import java.util.Objects;

public class ToDoItem {

    private String name;
    private boolean isCompleted;

    private ToDoItem(Builder builder) {
        this.name = builder.name;
        this.isCompleted = builder.isCompleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if(!(o instanceof ToDoItem)) return false;
        ToDoItem item = (ToDoItem) o;
        return Objects.equals(name,item.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public ToDoItem(String name, boolean isCompleted) {
        this.name = name;
        this.isCompleted = isCompleted;
    }

    public static Builder newToDoItem(){
        return new Builder();
    }

    public static final class Builder {
        private String name;
        private boolean isCompleted;

        private Builder() {
        }

        public ToDoItem build() {
            return new ToDoItem(this);
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder isCompleted(boolean isCompleted) {
            this.isCompleted = isCompleted;
            return this;
        }

    }
}
