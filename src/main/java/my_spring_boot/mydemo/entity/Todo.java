package my_spring_boot.mydemo.entity;

import java.sql.Timestamp;

public class Todo {
    //フィールドの設定
    int id;
    String title;
    Timestamp expire;
    String checked;

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Timestamp getExpire() {
		return this.expire;
	}

	public void setExpire(Timestamp expire) {
		this.expire = expire;
	}

	public String getChecked() {
		return this.checked;
	}

	public void setChecked(String checked) {
		this.checked = checked;
	}



}