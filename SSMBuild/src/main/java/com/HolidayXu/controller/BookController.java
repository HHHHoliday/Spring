package com.HolidayXu.controller;

import com.HolidayXu.pojo.Books;
import com.HolidayXu.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("bookServiceImpl")
    private BookService bookService;

    //查询全部数据 并返回到展示页面
    @RequestMapping("/allBook")
    public String allBook(Model model) {
        List<Books> list = bookService.queryAllBook();
        model.addAttribute("list", list);
        return "allBook";
    }

    //跳转到增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPaper(){
        return "addBook";
    }

    //添加书籍的请求
    @RequestMapping("/addBook")
    public String addBook(Books books){
        System.out.println("addBook=>"+books);
        bookService.addBook(books);
        return "redirect:/book/allBook";
        //return "allBook";
    }

    //跳转到修改书籍页面
    @RequestMapping("/toUpdatePaper")
    public String toUpdatePaper(int id,Model model){
        Books book = bookService.queryBookById(id);
        model.addAttribute("QBook",book);
        return "updatePaper";
    }

    //修改书籍的请求
    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        System.out.println("updateBook=>"+books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    //删除书籍的请求
    @RequestMapping("/deleteBook/{bookId}")
    public String deleteBook(@PathVariable("bookId") int id){
        bookService.deleteBookById(id);
        return "redirect:/book/allBook";
    }

    //查询书籍的请求
    @RequestMapping("/queryBookName")
    public String queryBookName(String queryBookName,Model model){
        List<Books> list = bookService.queryBookName(queryBookName);
        if(list.isEmpty() || list.size()==0){
            model.addAttribute("error", "未查到相关书籍");
        }
        model.addAttribute("list", list);
        return "allBook";
    }
}