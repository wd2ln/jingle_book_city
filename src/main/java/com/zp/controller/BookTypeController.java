package com.zp.controller;

import com.zp.entity.Booktype;
import com.zp.service.BookTypeService;
import com.zp.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class BookTypeController {
    @Autowired
    private BookTypeService booktypeService;

    @RequestMapping("type_list")
    public ModelAndView typeList(ModelAndView mv,
                                 HttpServletRequest request){
        ResultVO vo = booktypeService.typeList();

        request.setAttribute("list",vo.getData());

        mv.setViewName("forward:/admin/type_list.jsp");
        return mv;
    }
}
