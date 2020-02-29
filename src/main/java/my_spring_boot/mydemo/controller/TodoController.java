package my_spring_boot.mydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import my_spring_boot.mydemo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired //Autowiredを用いることで以下に宣言したmodelとつなぎ泡sる
    TodoService todoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(){
        todoService.list();
        return "list";
    }

    @GetMapping("/check/{id}") //requrestmappingははgetとpostを含んだもの
    public String check(@PathVariable("id") String id){ //parthvariableをつけた
        todoService.check(id);
        return "sample";
    }

    @PostMapping("/add")
    public String add(@RequestBody String body){//user=scott&password=tiger
        todoService.add(body);
        return "sample";
    }

    @GetMapping("/search")
    public String search(@RequestParam("title") String title){
        todoService.search(title);
        return "sample";
    }
}
    //getは情報を取得する時に使用
    //post情報を変更する時
