package com.example.demo.tutorial.dao.tuto0005;

import java.io.Serializable;
import java.util.List;

//データアクセスをコントローラーではなく専用のオブジェクトにもたせる
public interface UserDAO <T> extends Serializable {
	
	public List<T> getAll();

}
