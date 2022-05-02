package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.UserMapper;
import com.zp.entity.User;
import com.zp.entity.UserExample;
import com.zp.service.AdminService;
import com.zp.util.JasyptUtil;
import com.zp.vo.PageVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.LocaleResolver;

import java.sql.SQLException;
import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public String addUser(User user) {
        //标记普通用户
        user.setuMark("普通用户");
        user.setuRole(1);
        //加密密码
        user.setuPwd(JasyptUtil.jia(user.getuPwd()));
        //插入
        int i;
        try {
            i = userMapper.insertSelective(user);
            if (i>0){
                System.out.println("添加成功");
                return "redirect:user_list.action?pageNumber=1";
            }else {
                return null;
            }
        }catch (Exception e){
            System.out.println("添加失败");
            return null;
        }
    }

    @Override
    public PageVo findAlls(Integer pageNumber) {
        Integer pageSize=8;
        PageVo pageVo = new PageVo();
        PageHelper.startPage(pageNumber,pageSize);
        List<User> users = userMapper.selectByExample(null);
        if (users!=null){
            PageInfo<User> userPageInfo = new PageInfo<>(users);
            Long total = userPageInfo.getTotal();
            int i1 = total.intValue();
            pageVo.setList(userPageInfo.getList());

            pageVo.setPageNumber(userPageInfo.getPageNum());
            pageVo.setPageSize(userPageInfo.getPageSize());
            //数据总量
            pageVo.setTotalCount(users.size());

           // System.out.println(i);
            System.out.println(userPageInfo.getTotal());
            System.out.println(total);
            System.out.println(i1);
            //总页数
           // if ()
            pageVo.setTotalPage(i1%pageSize==0?i1/pageSize:i1/pageSize+1);
        }
        return pageVo;
    }

    @Override
    public User updatePwd(Integer uId, String uPwd) {
        //设置更新所需条件
        UserExample userExample = new UserExample();
        userExample.createCriteria()
                .andUIdEqualTo(uId);
        //设置参数
        User user = new User();
        user.setuId(uId);
        user.setuPwd(uPwd);
        try {
            int i = userMapper.updateByExampleSelective(user, userExample);
            if(i>0){
                User user1 = userMapper.selectByKey(uId);
                return user1;
            }
        }catch ( Exception e){
            System.out.println("修改失败,请联系管理员");
        }

        return null;
    }
}
