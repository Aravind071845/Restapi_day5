package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Book;
import com.example.demo.service.ApiService;

@RestController
public class ApiController {
    @Autowired
    ApiService ai;
    
    @PostMapping("addingBook")
    public Book add(@RequestBody Book ss)
	{
		return ai.saveinfo(ss);
	}
    
    @GetMapping("showingdetails")
    public List<Book> show()
    {
   	 return ai.showinfo();
    }
    @GetMapping("showingid/{id}")
    public Optional<Book> showid(@PathVariable int id)
    {
   	 return ai.showinfobyid(id);
    }
    
    @PutMapping("updatebyid/{id}")
    public String modifybyid(@PathVariable int id,@RequestBody Book b)
    {
    	return ai.changeinfobyid(id, b);
    }
    
    @DeleteMapping("deleteid/{id}")
    public void deleting(@PathVariable int id)
    {
   	 ai.deleteinfobyid(id);
    }
}
