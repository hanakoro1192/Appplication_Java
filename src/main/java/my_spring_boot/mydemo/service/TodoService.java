package my_spring_boot.mydemo.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import my_spring_boot.mydemo.repository.Todoripositoty;

@Service
public class TodoService {
    // tbl_todo

    // mysql> describe tbl_todo;
    // +---------+------------+------+-----+---------+----------------+
    // | Field | Type | Null | Key | Default | Extra |
    // +---------+------------+------+-----+---------+----------------+
    // | id | int(11) | NO | PRI | NULL | auto_increment |
    // | title | text | YES | | NULL | |
    // | expire | timestamp | YES | | NULL | |
    // | checked | tinyint(1) | YES | | 0 | |
    // +---------+------------+------+-----+---------+----------------+
    // 4 rows in set (0.01 sec)

    @Autowired
    Todoripositoty todoripositoty;

    public String list() {
        return null;
    }

    public String check(String id) {
        return null;
    }

    // タイトルを呼び出して、
    public String add(String body) {
        // title=scott&expire=tiger

        String[] parametars = body.split("&");
        // 0:title=scott
        // 1:expire=tiger
        String[] title = parametars[0].split("=");
        // 0:title
        // 1:scott

        String[] expire = parametars[1].split("=");
        // 0:expire
        // 1:tiger

        Timestamp until;
        try {
            until = new Timestamp(new SimpleDateFormat("yyyyMMdd").parse(expire[1]).getTime());
            todoripositoty.updateadd(title[1], until);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //return parametar[0];// id;
        return "{id:0,expire:'"+expire[1]+"',title:'"+title[1]+"'}";// id;[]で中の文字を取得
    }

    public String search(String title){
        return null;
    }

}