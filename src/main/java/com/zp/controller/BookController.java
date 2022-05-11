package com.zp.controller;

import com.zp.entity.Book;
import com.zp.service.BookService;
import com.zp.service.BookTypeService;
import com.zp.vo.PageVO;
import com.zp.entity.Books;
import com.zp.util.FileUploadUtil;
import com.zp.vo.ResultVO;
import com.zp.service.FBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private BookTypeService bookTypeService;
    @Autowired
    private FBookService fBookService;

    @RequestMapping("/admin/book_edit_show")
    public String book_edit_show(Integer bid,
                                 HttpServletRequest request) {
        request.setAttribute("g", bookService.byId(bid));
        return "admin/book_edit";
    }


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
                    }
                }
            }
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

    @RequestMapping("/admin/book_list")
    public String book_list(Integer pageNumber,
                            Integer rtype,
                            HttpServletRequest request) {
        if (pageNumber <= 0)
            pageNumber = 1;
        PageVO p = bookService.queryBook(pageNumber, rtype);
        if (p.getTotalPage() == 0) {
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
            }

        } else {
            System.out.println("文件不存在");
        }
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
    }
}
