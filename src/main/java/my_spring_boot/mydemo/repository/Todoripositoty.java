package my_spring_boot.mydemo.repository;

import org.springframework.stereotype.Repository;

import ch.qos.logback.core.joran.action.TimestampAction;
import my_spring_boot.mydemo.entity.Todo;

import java.sql.Timestamp;
import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Repository
@Mapper
public interface Todoripositoty{

    //tbl_todo

// mysql> describe tbl_todo;
// +---------+------------+------+-----+---------+----------------+
// | Field   | Type       | Null | Key | Default | Extra          |
// +---------+------------+------+-----+---------+----------------+
// | id      | int(11)    | NO   | PRI | NULL    | auto_increment |
// | title   | text       | YES  |     | NULL    |                |
// | expire  | timestamp  | YES  |     | NULL    |                |
// | checked | tinyint(1) | YES  |     | 0       |                |
// +---------+------------+------+-----+---------+----------------+
// 4 rows in set (0.01 sec)


    List<Todo> selectlist(); //todo型のリスト型 selectはLISt型

    @Update("update tbl_todo set checked = 1") /*1はtrue*/
    int updatecheck(); //checkと依存関係　updateはint型

    @Insert("insert tbl_todo ('title','expire') valuse(#{title}, #{expire}) ") //NSERT  INTO  テーブル名  VALUES ( ‘値1′ [ , ‘値2’ ]・・・);
    int updateadd(@Param("title") String title,@Param("expire") Timestamp expire); //addと依存関係

    @Select("select * from tbl_todo where title like '%{#keyword}%'") //SELECT col_name1 [, col_name2 ...] FROM table_name
    List<Todo> selectsearch(@Param("keyword") String keyword);
}