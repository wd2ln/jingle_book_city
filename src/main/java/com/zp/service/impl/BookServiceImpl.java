package com.zp.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zp.dao.*;
import com.zp.entity.*;
import com.zp.dao.BookMapper;
import com.zp.dao.RecommendMapper;
import com.zp.entity.Book;
import com.zp.entity.BookExample;
import com.zp.service.BookService;
import com.zp.vo.PageVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
   @Autowired
   private BookMapper bookDao;
   @Autowired
   private OrderitemMapper orderitemMapper;
   @Autowired
   private BookMapper bookMapper;
   @Autowired
   private OrderMapper orderMapper;
   @Autowired
   private UserMapper userMapper;
    @Override
    public List<Book> sel(int rtype, Integer pageNumber, Integer pageSize) {

        PageHelper.startPage(pageNumber,pageSize);


        BookExample example = new BookExample();

        BookExample.Criteria criteria = example.createCriteria();
=======
   private RecommendMapper recommendDao;

   @Override
   public Object byId(Integer bId) {
      Book g = bookDao.selectByPrimaryKey(bId);
>>>>>>> yu

      return g;
   }

<<<<<<< HEAD
        List<Book> books = bookDao.selectByExample(example);
        // String bid = books.get(0).getBid();
        //System.out.printf();
        PageInfo<Book> info = new PageInfo<>(books);

        return info.getList();
    }

    @Override
    public User getUserInfo(Integer user) {
        User user1 = userMapper.selectByKey(user);
        if (user1!=null){
            return user1;
        }
        return null;
    }

    @Override
    public Book selBookId(Integer bId, Order order) {
        OrderitemExample orderitemExample = new OrderitemExample();
        orderitemExample.createCriteria()
                .andBIdEqualTo(bId);
        List<Orderitem> orderitems = orderitemMapper.selectByExample(orderitemExample);
        //验证是否有订单
        if (orderitems.size()<1){
            //没有创建
            Orderitem orderitem = new Orderitem();
            //获取单价
            BookExample bookExample = new BookExample();
            bookExample.createCriteria()
                    .andBIdEqualTo(bId);
            List<Book> books = bookMapper.selectByExample(bookExample);
            //生成新订单
            orderitem.setOiAmount(1);
            orderitem.setbId(bId);
            orderitem.setOiPrice(books.get(0).getbPrice());
            orderitem.setoId(order.getoId());
            //生成订单号
            orderitem.setoId(new SimpleDateFormat("YYYYMMDDHHmmss").format(new Date()));
            int insert = orderitemMapper.insert(orderitem);
            //更新order
            //增加数量
            //orderitem的数量
            Integer oiAmount = orderitem.getOiAmount();
            //order的数量
            Integer amount = order.getoAmount();

            //价格变化
            //orderitem的价格
            Float oiPrice = orderitem.getOiPrice();
            //order的价格
            Float oiPrice1 = order.getOiPrice();
//执行更改order操作
            Order order1 = new Order();
            order1.setoAmount(++oiAmount);
            order1.setoTotal(oiPrice1+oiPrice);
            OrderExample orderExample = new OrderExample();
            orderExample.createCriteria()
                    .andOIdEqualTo(orderitem.getoId());
            orderMapper.updateByExampleSelective(order1,orderExample);
        }else {
            //遍历查到的订单
            for (int i = 0; i < orderitems.size(); i++) {
                //增加数量
                //orderitem的数量
                Integer oiAmount = orderitems.get(i).getOiAmount();
                //order的数量
                Integer amount = order.getoAmount();

                //价格变化
                //orderitem的价格
                Float oiPrice = orderitems.get(i).getOiPrice();
                //order的价格
                Float oiPrice1 = order.getOiPrice();

                //执行更改orderitem操作
                OrderitemExample orderitemExample1 = new OrderitemExample();
                orderitemExample1.createCriteria()
                        .andOIdEqualTo(orderitems.get(i).getoId());
                Orderitem orderitem = new Orderitem();
                orderitem.setOiAmount(++oiAmount);
                orderitemMapper.updateByExampleSelective(orderitem,orderitemExample1);
                //执行更改order操作
                Order order1 = new Order();
                order1.setoAmount(++oiAmount);
                order1.setoTotal(oiPrice1+oiPrice);
                OrderExample orderExample = new OrderExample();
                orderExample.createCriteria()
                        .andOIdEqualTo(orderitems.get(i).getoId());
                orderMapper.updateByExampleSelective(order1,orderExample);
            }
        }
        return null;
    }
=======
   @Override
   public Boolean addBook(Book b) {
      try {
         bookDao.insert(b);
         return true;
      }catch (Exception e){
         System.out.println(e.getMessage());
         return false;
      }
   }

   @Override
   public PageVO queryBook(Integer pageNumber, Integer rtype) {
      PageVO p =new PageVO();
      p.setPageNumber(pageNumber);
      int totalCount=0;
      try {
         if (rtype==0)
            totalCount =bookDao.queryCountOfBooks();
         else
            totalCount=recommendDao.queryRecommendCountOfBooksByTypeID(rtype);
      }catch (Exception e){
         System.out.println(e.getMessage());
      }
      p.SetPageSizeAndTotalCount(8, totalCount);
      List<Book> list = null;
      try {
         if (rtype==0)
            list = bookDao.queryBooks((pageNumber-1)*8,8);
         else
            list = recommendDao.queryBookByRecommendType(rtype,(pageNumber-1)*8,8);
         for(int i=0;i< list.size();i++){
            Book book=list.get(i);
            book.setScroll(recommendDao.queryBookByRtypeAndBid(1,book.getbId()) >= 1);
            book.setHot(recommendDao.queryBookByRtypeAndBid(2,book.getbId())>=1);
            book.setNew(recommendDao.queryBookByRtypeAndBid(3,book.getbId())>=1);
         }
      }catch (Exception e){
         System.out.println(e.getMessage());
      }
      p.setList((List)list);
      return p;
   }
>>>>>>> yu
}
