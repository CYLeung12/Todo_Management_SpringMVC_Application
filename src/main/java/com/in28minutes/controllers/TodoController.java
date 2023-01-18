package com.in28minutes.controllers;

import com.in28minutes.exception.ExceptionController;
import com.in28minutes.models.Todo;
import com.in28minutes.services.TodoService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class TodoController {
    private Log logger = LogFactory.getLog(ExceptionController.class);


    @Autowired      //dependency injection
    TodoService todoService;

//    Use initBinder method to set a standard date format across the controller
    @InitBinder   //this method will run before any methods in this controller
    protected void initBinder(WebDataBinder binder){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
    }

    @RequestMapping(value = "/list-todos", method = RequestMethod.GET)
    public String listTodos(Model model){
        String user = getLoggedInUserName();
        model.addAttribute("todos", todoService.retrieveTodos(user));
        return "list-todos";
    }

    private String getLoggedInUserName(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails){
            return ((UserDetails) principal).getUsername();
        }
        return principal.toString();

    }


    //return to the todo.jsp when user click the Add To Do button
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodoPage(ModelMap model){
        //make an new Todo object so it is available for form binding, attribute name should match the commandName tag value defined on HTML form on jsp
        model.addAttribute("todo", new Todo(0,"test", "", new Date(), false));
        return "todo";

    }

    //handel the Post request when user submit a new todo through the form
    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @Valid Todo todo, BindingResult result){    //@Valid triggers the validation, use BindingResult access the result of validation
        if (result.hasErrors()){
            return "todo";
        }
        todoService.addTodo("test", todo.getDesc(), new Date(), false);
        return "redirect: list-todos";  //return to the list-todos.jsp cannot get the todos list as model is not set, we should redirect to the url so that the listTodos Get method can execute (set model attribute and redirect to list-todos.jsp)

    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String updateTodo(@RequestParam int id, ModelMap model){
        Todo todo = todoService.retrieveTodo(id);
        //and todo model binds on the HTML form with commandName "todo"
        model.addAttribute("todo", todo);
        return "todo";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result){
        if (result.hasErrors()){
            return "todo";
        }
        todo.setUser("test");
        todoService.updateTodo(todo);
        model.clear();      // to prevent request parameter "name" to be passed
        return "redirect: list-todos";
    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(@RequestParam int id){
        todoService.deleteTodo(id);
        return "redirect: list-todos";
    }

    @ExceptionHandler(value = ArrayIndexOutOfBoundsException.class)    //whenever there is an ArrayIndexOutOfBoundsException in this controller, this method is called.
    public String handleException(HttpServletRequest request, Exception ex) {
        logger.error("Request: " + request.getRequestURL() + " raised an exception: " + ex);
        return "error-specific";
    }

    


}
