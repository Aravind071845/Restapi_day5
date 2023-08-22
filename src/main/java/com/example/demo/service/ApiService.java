package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Book;
import com.example.demo.repository.BookRepo;

@Service
public class ApiService {
    @Autowired
    BookRepo br;
    
    public Book saveinfo(Book b)
    {
    	return br.save(b);
    }
    
    public Optional<Book> showinfobyid(int id)
    {
    	return br.findById(id);
    }
    public List<Book> showinfo()
    {
    	return br.findAll();
    }
    
    public String changeinfobyid(int id,Book s)
    {
    	br.saveAndFlush(s);
    	if(br.existsById(id))
    	{
    		return "updated";
    	}
		return "enter valid id";
    }
    
    public void deleteinfobyid(int id)
    {
    	br.deleteById(id);
    }
    
}
