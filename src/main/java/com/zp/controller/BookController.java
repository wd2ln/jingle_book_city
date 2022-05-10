package com.zp.controller;

import com.zp.dao.BookMapper;
import com.zp.entity.Book;
import com.zp.entity.Booktype;
import com.zp.service.BookService;
import com.zp.service.BookTypeService;
//<<<<<<< HEAD
//<<<<<<< HEAD
////<<<<<<< HEAD
//import com.zp.vo.PageVO;
//=======
import com.zp.vo.PageVO;
//=======
import com.zp.entity.Books;
import com.zp.service.BookService;
import com.zp.util.FileUploadUtil;
import com.zp.vo.PageVO;
import com.zp.vo.ResultVO;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//>>>>>>> b33d465a0fad53ce5f46954ff41799045ff1cac1
//>>>>>>> yu
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
//=======
//<<<<<<< HEAD
//=======
import com.zp.service.FBookService;
import com.zp.vo.PageInfoVO;
//>>>>>>> zsj
import com.zp.vo.PageVo;
//=======
////import com.zp.vo.PageVo;
//>>>>>>> yu
//>>>>>>> zsj
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
//<<<<<<< HEAD
import org.springframework.web.servlet.ModelAndView;
//<<<<<<< HEAD
//=======
import org.springframework.web.multipart.MultipartFile;
//>>>>>>> yu

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

//<<<<<<< HEAD
//=======

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
//>>>>>>> yu
@Controller
//<<<<<<< HEAD
@RequestMapping("admin")
//<<<<<<< HEAD
//=======
//import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;
//import javax.servlet.http.HttpServletRequest;
//import java.util.List;
//
//@RestController
//>>>>>>> zsj
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private FBookService fBookService;
//<<<<<<< HEAD
//    @RequestMapping("book_edit_show")
//    public String book_edit_show (Integer bid,
//                                  HttpServletRequest request){
//=======
//@RestController
//=======
//@RequestMapping("admin")
//>>>>>>> b33d465a0fad53ce5f46954ff41799045ff1cac1
//public class BookController {
//    @Autowired
//    private BookService bookService;
////<<<<<<< HEAD
//    @Autowired
//    private BookTypeService bookTypeService;
//    @RequestMapping("book_edit_show")
//    public String book_edit_show (Integer bid,
//                                  HttpServletRequest request){
//=======

    @RequestMapping("/admin/book_edit_show")
    public String book_edit_show(Integer bid,
                                 HttpServletRequest request) {
//>>>>>>> b33d465a0fad53ce5f46954ff41799045ff1cac1
//>>>>>>> yu
        request.setAttribute("g", bookService.byId(bid));
//=======
//
//>>>>>>> zsj

        return "admin/book_edit";
    }

//<<<<<<< HEAD
//    @RequestMapping("book_add")
//    public String book_add (HttpServletRequest request) throws Exception {
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        try {
//            List<FileItem> list = upload.parseRequest(request);
//            Book b = new Book();
//
//            for (FileItem item : list) {
//                if (item.isFormField()) {
//                    switch (item.getFieldName()) {
//                        case "bname":
//                            b.setBtName(item.getString("utf-8"));
////                            System.out.println(b.getBtName());
//                            break;
//                        case "bIsbn":
//                            b.setbIsbn(item.getString("utf-8"));
//                            break;
//                        case "bauthor":
//                            b.setbAuthor(item.getString("utf_8"));
//                            break;
//                        case "bpublisher":
//                            b.setbPublisher(item.getString("utf-8"));
//                        case "bprice":
//                            b.setbPrice(Float.parseFloat(item.getString("utf-8")));
//                            break;
//                        case "btid":
//                            b.setBtId(Integer.parseInt(item.getString("utf-8")));
//                            break;
//                        case "bstock":
//                            b.setbStock(Integer.parseInt(item.getString("utf-8")));
//                        case "bmark":
//                            b.setbMark(item.getString("utf-8"));
//                            break;
//                    }
//                } else {
//                    if (item.getInputStream().available() <= 0) continue;
//                    String fileName = item.getName();
//                    fileName = fileName.substring(fileName.lastIndexOf("."));
//                    fileName = "/" + new Date().getTime() + fileName;
//                    String path = request.getServletContext().getRealPath("/images") + fileName;
//                    InputStream in = item.getInputStream();
//                    FileOutputStream out = new FileOutputStream(path);
//                    byte[] buffer = new byte[1024];
//                    int len = 0;
//                    while ((len = in.read(buffer)) > 0) {
//                        out.write(buffer);
//                    }
//                    in.close();
//                    out.close();
//                    item.delete();
//                    switch (item.getFieldName()) {
//                        case "bcover":
//                            b.setbCover("images" + fileName);
//                            break;
//                        case "bimage1":
//                            b.setbImage1("images" + fileName);
//                            break;
//                        case "bimage2":
//                            b.setbImage2("images" + fileName);
//                            break;
//=======
//<<<<<<< HEAD
//    @RequestMapping("book_add")
//    public String book_add (HttpServletRequest request) throws Exception {
//        DiskFileItemFactory factory = new DiskFileItemFactory();
//        ServletFileUpload upload = new ServletFileUpload(factory);
//        try {
//            List<FileItem> list = upload.parseRequest(request);
//            Book b = new Book();
//
//            for (FileItem item : list) {
//                System.out.println(item.getName());
//                if (item.isFormField()) {
//                    switch (item.getFieldName()) {
//                        case "bname":
//                            b.setBtName(item.getString("utf-8"));
////                            System.out.println(b.getBtName());
//                            break;
//                        case "bisbn":
//                            b.setbIsbn(item.getString("utf-8"));
//                            break;
//                        case "bauthor":
//                            b.setbAuthor(item.getString("utf_8"));
//                            break;
//                        case "bpublisher":
//                            b.setbPublisher(item.getString("utf-8"));
//                        case "bprice":
//                            b.setbPrice(Float.parseFloat(item.getString("utf-8")));
//                            break;
//                        case "btid":
//                            b.setBtId(Integer.parseInt(item.getString("utf-8")));
//                            break;
//                        case "bstock":
//                            b.setbStock(Integer.parseInt(item.getString("utf-8")));
//                        case "bmark":
//                            b.setbMark(item.getString("utf-8"));
//                            break;
//                    }
//                } else {
//                    if (item.getInputStream().available() <= 0) continue;
//                    String fileName = item.getName();
//                    fileName = fileName.substring(fileName.lastIndexOf("."));
//                    fileName = "/" + new Date().getTime() + fileName;
//                    String path = request.getServletContext().getRealPath("/images") + fileName;
//                    InputStream in = item.getInputStream();
//                    FileOutputStream out = new FileOutputStream(path);
//                    byte[] buffer = new byte[1024];
//                    int len = 0;
//                    while ((len = in.read(buffer)) > 0) {
//                        out.write(buffer);
//                    }
//                    in.close();
//                    out.close();
//                    item.delete();
//                    switch (item.getFieldName()) {
//                        case "bcover":
//                            b.setbCover("images" + fileName);
//                            break;
//                        case "bimage1":
//                            b.setbImage1("images" + fileName);
//                            break;
//                        case "bimage2":
//                            b.setbImage2("images" + fileName);
//                            break;
//                    }
//                }
//            }
//            System.out.println(b);
//            bookService.addBook(b);
//        } catch (FileUploadException e) {
//            System.out.println(e.getMessage());
//=======
    @RequestMapping("/admin/book_add")
    public String addBook(Books books,
                          @RequestPart("bCover") MultipartFile bCover,
                          @RequestPart("bImage1") MultipartFile bImage1,
                          @RequestPart("bImage2") MultipartFile bImage2) {
        String s2 = null;
        String s1 = null;
        String s = null;
        System.out.println(books);
        String filename1 = bCover.getOriginalFilename();
        String filename2 = bImage1.getOriginalFilename();
        String filename3 = bImage2.getOriginalFilename();
        System.out.println(filename1);
        System.out.println(filename2);
        System.out.println(filename3);
        System.out.println(bCover.isEmpty());
        if (!(bCover.isEmpty() && bImage1.isEmpty() && bImage2.isEmpty())) {
            System.out.println("文件不为空");
            s = FileUploadUtil.fileUpload(bCover);
            if (s != null) {
                System.out.println("文件一上传那个成功");
                s1 = FileUploadUtil.fileUpload(bImage1);
                if (s1 != null) {
                    System.out.println("文件2上传那个成功");
                    s2 = FileUploadUtil.fileUpload(bImage2);
                    if (s2 != null) {
                        System.out.println("文件3上传那个成功");
//>>>>>>> yu
                    }
                }
            }
//>>>>>>> b33d465a0fad53ce5f46954ff41799045ff1cac1
        }
        if (s2 != null) {
            System.out.println("开始插入数据");
            ResultVO vo = bookService.addBook(new Book(0, books.getBIsbn(), books.getBName(), books.getBAuthor(), books.getBPublisher(), s, s1, s2, books.getBPrice(), books.getBtId(), books.getBStock(), books.getBMark(), false, false, false));
            if (vo != null) {
                System.out.println("添加成功");
            }
        }
        return "redirect:book_list?pageNumber=1&rtype=1";
    }
//<<<<<<< HEAD

//<<<<<<< HEAD
//    @RequestMapping("book_list")
//    public String book_list (Integer pageNumber,
//                             Integer rtype,
//                             HttpServletRequest request) {
//=======
//<<<<<<< HEAD
//    @RequestMapping("book_list")
//    public String book_list (Integer pageNumber,
//                             Integer rtype,
//                             HttpServletRequest request) {
//=======
    @RequestMapping("/admin/book_list")
    public String book_list(Integer pageNumber,
                            Integer rtype,
                            HttpServletRequest request) {
//>>>>>>> b33d465a0fad53ce5f46954ff41799045ff1cac1
//>>>>>>> yu
        if (pageNumber <= 0)
            pageNumber = 1;
        PageVO p = bookService.queryBook(pageNumber, rtype);
        if (p.getTotalPage() == 0) {
//<<<<<<< HEAD
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        } else {
//            if (pageNumber >= p.getTotalPage() + 1) {
//                p = bookService.queryBook(rtype, p.getTotalPage());
//            }
//        }
//        request.setAttribute("p", p);
//        request.setAttribute("rtype", rtype);
//
//        List<Booktype> booktypes = bookTypeService.select();
//
//        request.getServletContext().setAttribute("bookTypes", booktypes);
//
//
//        return "/admin/book_list";
//    }
//    @RequestMapping("recommend_books")
//    public ModelAndView recommend(Integer rType,int pageNumber,HttpServletRequest request){
//        if (pageNumber<=0){
//            pageNumber=1;
//        }
//        PageVo p=bookService.recommendBook(rType,pageNumber);
//        if (p.getTotalPage()==0){
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        }else {
//            if(pageNumber>=p.getTotalPage()+1)
//            {
//                p = bookService.recommendBook(rType,p.getTotalPage());
//=======
//<<<<<<< HEAD
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        } else {
//            if (pageNumber >= p.getTotalPage() + 1) {
//                p = bookService.queryBook(rtype, p.getTotalPage());
//            }
//        }
//        request.setAttribute("p", p);
//        request.setAttribute("rtype", rtype);
//
//        //List<Booktype> booktypes = bookTypeService.select();
//
//        //request.getServletContext().setAttribute("bookTypes", booktypes);
//
//
//        return "/admin/book_list";
//    }
//    /*@RequestMapping("book_detail")
//    public ModelAndView findBook(int bId,HttpServletRequest request){
//            Book f = bookService.find(bId);
//            request.setAttribute("f",f);
//            return new ModelAndView("forward:book_detail.jsp");
//    }*/
//   /* @RequestMapping("search_books")
//    public ModelAndView searchBook(int pageNumber,String keyword,HttpServletRequest request){
//        if (pageNumber<=0){
//                pageNumber=1;
//        }
//        PageVo p=bookService.searchBook(pageNumber,keyword);
//        if (p.getTotalPage()==0){
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        }else {
//            if (pageNumber>=p.getTotalPage()+1){
//                p=bookService.searchBook(p.getTotalPage(),keyword);
//            }
//        }
//        request.setAttribute("p",p);
//        request.setAttribute("keyword",keyword);
//        return new ModelAndView("forward:book_search.jsp");
//    }*/
//=======
            p.setTotalPage(1);
            p.setPageNumber(1);
        } else {
            if (pageNumber >= p.getTotalPage() + 1) {
                p = bookService.queryBook(rtype, p.getTotalPage());
            }
        }
        request.setAttribute("p", p);
        request.setAttribute("rtype", rtype);

        return "/admin/book_list";
    }

    @RequestMapping("/admin/book_change")
    public String book_change(Integer bid,
                              Integer rtype,
                              String method,
                              Integer page) {
        if (method.equals("add")) {
            bookService.addRecommendBook(bid, rtype);
        } else {
            bookService.delRecommendBook(bid, rtype);
        }

        return "redirect:book_list?pageNumber=1&rtype=" + page;
    }

    @RequestMapping("/admin/book_delete")
    public String book_delete(Integer bid,
                              Integer rtype) {
        Book book = (Book) bookService.byId(bid);
        String path = "D:/DingBook/jingle_book_city/src/main/webapp/";

        String s3 = path + book.getbCover();
        System.out.println(s3);
        String s1 = path + book.getbImage1();
        String s2 = path + book.getbImage2();
        File file = new File(s1);
        File file1 = new File(s2);
        File file2 = new File(s3);
        if (file.exists() && file1.exists() && file2.exists()) {
            System.out.println("文件存在");
            if (file.delete() && file1.delete() && file2.delete()) {
                System.out.println("文件删除成功");
//>>>>>>> yu
            }

        } else {
            System.out.println("文件不存在");
        }
//<<<<<<< HEAD
//        request.setAttribute("p",p);
//        request.setAttribute("t",rType);
//        return new ModelAndView("forward:booktypes_list.jsp");
//    }
//    @RequestMapping("booktypes_list")
//    public ModelAndView BookType(int pageNumber,Integer btId,HttpServletRequest request){
//        System.out.println(btId+"ppp"+pageNumber);
//        String btname=null;
//        if (btId!=0){
//            btname= fBookService.findBookTypeById(btId);
//        }
//        request.setAttribute("btname",btname);
//        if (pageNumber<=0){
//            pageNumber=1;
//        }
//        PageInfoVO p=fBookService.findBookTypeId(btId,pageNumber);
//        System.out.println(p.getList().size());
//        if (p.getTotalPage()==0){
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        }else {
//            if(pageNumber>=p.getTotalPage()+1) {
//                p=fBookService.findBookTypeId(btId,p.getTotalPage());
//                System.out.println(p.getList().size());
//
//            }
//        }
//        request.setAttribute("p",p);
//        request.setAttribute("btId",btId);
//        request.setAttribute("t",btname);
//        return new ModelAndView("forward:book_detail.jsp");
//    }
//    @RequestMapping("book_detail")
//    public ModelAndView findBook(int bId, HttpServletRequest request){
//            Book f = bookService.find(bId);
//            request.setAttribute("f",f);
//            return new ModelAndView("forward:book_detail.jsp");
//    }
//    @RequestMapping("search_books")
//    public ModelAndView searchBook(int pageNumber,String keyword,HttpServletRequest request){
//        if (pageNumber<=0){
//                pageNumber=1;
//        }
//        PageVo p=bookService.searchBook(pageNumber,keyword);
//        if (p.getTotalPage()==0){
//            p.setTotalPage(1);
//            p.setPageNumber(1);
//        }else {
//            if (pageNumber>=p.getTotalPage()+1){
//                p=bookService.searchBook(p.getTotalPage(),keyword);
//            }
//        }
//        request.setAttribute("p",p);
//        request.setAttribute("keyword",keyword);
//        return new ModelAndView("forward:book_search.jsp");
//=======


        bookService.delBook(bid);

        return "redirect:book_list?pageNumber=1&rtype=" + rtype;
    }

    @RequestMapping("/admin/book_update")
    public String book_update(Books books,
                              Integer bid,
                              @RequestPart("bCover") MultipartFile bCover,
                              @RequestPart("bImage1") MultipartFile bImage1,
                              @RequestPart("bImage2") MultipartFile bImage2) {
        String s2 = null;
        String s1 = null;
        String s = null;
        System.out.println(books);
        String filename1 = bCover.getOriginalFilename();
        String filename2 = bImage1.getOriginalFilename();
        String filename3 = bImage2.getOriginalFilename();
        System.out.println(filename1);
        System.out.println(filename2);
        System.out.println(filename3);
        System.out.println(bCover.isEmpty());
        if (!(bCover.isEmpty() && bImage1.isEmpty() && bImage2.isEmpty())) {
            System.out.println("文件不为空");
            s = FileUploadUtil.fileUpload(bCover);
            if (s != null) {
                System.out.println("文件1上传成功");
                s1 = FileUploadUtil.fileUpload(bImage1);
                if (s1 != null) {
                    System.out.println("文件2上传成功");
                    s2 = FileUploadUtil.fileUpload(bImage2);
                    if (s2 != null) {
                        System.out.println("文件3上传成功");
                    }
                }
            }
        }
        if (s2 != null) {
            System.out.println("开始修改数据");
            ResultVO vo = bookService.updateBook(new Book(books.getBId(), books.getBIsbn(), books.getBName(), books.getBAuthor(), books.getBPublisher(), s, s1, s2, books.getBPrice(), books.getBtId(), books.getBStock(), books.getBMark(), false, false, false));
            if (vo != null) {
                System.out.println("修改成功");
            }
        }

        return "redirect:book_list?pageNumber=1&rtype=0";
//>>>>>>> yu
    }
//>>>>>>> b33d465a0fad53ce5f46954ff41799045ff1cac1
//=======
//
//>>>>>>> zsj
}
