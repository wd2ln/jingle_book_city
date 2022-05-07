package com.zp.controller;

import com.zp.entity.Book;
import com.zp.entity.Books;
import com.zp.service.BookService;
import com.zp.util.FileUploadUtil;
import com.zp.vo.PageVO;
import com.zp.vo.ResultVO;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.List;


@Controller
@RequestMapping("admin")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("book_edit_show")
    public String book_edit_show(Integer bid,
                                 HttpServletRequest request) {
        request.setAttribute("g", bookService.byId(bid));

        return "admin/book_edit";
    }

    //    @RequestMapping("book_add")
//    public String book_add(HttpServletRequest request) throws Exception {
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
//            bookService.addBook(b);
//        } catch (FileUploadException e) {
//            System.out.println(e.getMessage());
//        }
//
//        return "redirect:book_list?pageNumber=1&rtype=1";
//    }
    @RequestMapping("book_add")
    public String addBook(Books books,
                          @RequestPart("bCover") MultipartFile bCover,
                          @RequestPart("bImage1") MultipartFile bImage1,
                          @RequestPart("bImage2") MultipartFile bImage2) {
        String aBoolean=null;
        String s1=null;
        String s=null;
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
            if (s!=null){
                System.out.println("文件一上传那个成功");
                 s1 = FileUploadUtil.fileUpload(bImage1);
                if ( s1!=null){
                    System.out.println("文件2上传那个成功");
                     aBoolean = FileUploadUtil.fileUpload(bImage2);
                     if (aBoolean!=null){
                         System.out.println("文件3上传那个成功");
                     }
                }
            }
        }
if (aBoolean!=null){
    System.out.println("开始插入数据");
    ResultVO vo = bookService.addBook(new Book(0, books.getBIsbn(), books.getBName(), books.getBAuthor(), books.getBPublisher(), s, s1, aBoolean, books.getBPrice(), books.getBtId(), books.getBStock(), books.getBMark(), false, false, false));
    if (vo!=null){
        System.out.println("添加成功");
    }
}
        return "redirect:book_list?pageNumber=1&rtype=1";
    }

    @RequestMapping("book_list")
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

    @RequestMapping("book_change")
    public String book_change(Integer bid,
                              Integer rtype,
                              String method,
                              Integer page){
        if (method.equals("add")){
            bookService.addRecommendBook(bid,rtype);
        }else {
            bookService.delRecommendBook(bid,rtype);
        }

        return "redirect:book_list?pageNumber=1&rtype="+page;
    }
    @RequestMapping("book_delete")
    public String book_delete(Integer bid,
                              Integer rtype){
        bookService.delBook(bid);

        return "redirect:book_list?pageNumber=1&rtype="+rtype;
    }
}
