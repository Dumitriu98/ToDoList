package controler;

import ro.gr8.jsp.data.repository.ToDoItem;
import ro.gr8.jsp.data.repository.TodoItemRepository;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TodoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String actionName = req.getParameter("actionName");
        if (actionName != null && !actionName.trim().isEmpty()) {
            TodoItemRepository.getInstance().addToDoItem(ToDoItem
                    .newToDoItem()
                    .name(actionName)
                    .isCompleted(false)
                    .build());
        }
        resp.sendRedirect("/");
    }
}
