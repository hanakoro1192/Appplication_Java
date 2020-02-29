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
import org.springframework.web.bind.annotation.ResponseBody;

import my_spring_boot.mydemo.service.TodoService;

@Controller
@RequestMapping("/todo")
public class TodoController {

    @Autowired //Autowiredを用いることで以下に宣言したmodelとつなぎ泡sる
    TodoService todoService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public String list(){
        todoService.list();
        return "{list:[]}"; //服薄のデータを管理する
    }

    @GetMapping("/check/{id}") //requrestmappingははgetとpostを含んだもの
    @ResponseBody
    public String check(@PathVariable("id") String id){ //parthvariableをつけた
        todoService.check(id);
        return "{}";
    }

    @PostMapping("/add")
    @ResponseBody
    public String add(@RequestBody String body){//title=scott&expire=tiger
        return todoService.add(body);//"{id:0,expire:'2020/02/29',title:'打ち合わせ'}";// id
    }

    @GetMapping("/search")
    @ResponseBody
    public String search(@RequestParam("title") String title){
        todoService.search(title);
        return "{list:[]}"; //中の値を全て返す 
    }
}
    //getは情報を取得する時に使用
    //post情報を変更する時
