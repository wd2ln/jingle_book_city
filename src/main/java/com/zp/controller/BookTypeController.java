package com.zp.controller;

import com.zp.entity.Booktype;
import com.zp.service.BookTypeService;
import com.zp.vo.ResultVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
public class BookTypeController {
    @Autowired
    private BookTypeService booktypeService;

    @RequestMapping("type_list")
    public ModelAndView typeList(ModelAndView mv,
                                 HttpServletRequest request) {
        ResultVO vo = booktypeService.typeList();

        request.setAttribute("list", vo.getData());

        mv.setViewName("forward:/admin/type_list.jsp");
        return mv;
    }

    @PostMapping("type_add")
    public ModelAndView type_add(@RequestPart String btname,
                                 ModelAndView mv,
                                 HttpServletRequest request) {
        ResultVO vo=booktypeService.typeAdd(btname);

        request.setAttribute("bookTypes",vo.getData());

        UpdateBookType(request);

        mv.setViewName("redirect:type_list");
        return mv;
    }

    @GetMapping("type_delete")
    public ModelAndView type_delete(@RequestParam Integer btid,
                                    ModelAndView mv,
                                    HttpServletRequest request){
        ResultVO vo=booktypeService.typeDel(btid);

        request.setAttribute("bookTypes",vo.getData());

        UpdateBookType(request);

        mv.setViewName("redirect:type_list");
        return mv;
    }

    @RequestMapping("type_update")
    public ModelAndView type_update(Integer btId,
                                     String btName,
                                    ModelAndView mv,
                                    HttpServletRequest request){
        ResultVO vo=booktypeService.typeUpdate(btId,btName);

        request.setAttribute("bookTypes",vo.getData());

        UpdateBookType(request);

        mv.setViewName("redirect:type_list");
        return mv;
    }

    private void UpdateBookType(HttpServletRequest request) {
        //如果context域中没有数据，再次获取
        if (request.getServletContext().getAttribute("bookTypes")==null){
            request.getServletContext().setAttribute("bookTypes",booktypeService.typeList());
        }else {
            //如果context域中有数据则删除重新获取
            request.getServletContext().removeAttribute("bookTypes");
            request.getServletContext().setAttribute("bookTypes",booktypeService.typeList());
        }
    }

}
