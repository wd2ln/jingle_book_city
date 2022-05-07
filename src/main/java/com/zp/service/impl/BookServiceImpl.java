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
   private static Integer hh;
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
    public void insertOrder(Order order) {
        int i = orderMapper.insert(order);
    }

    @Override
    public Book sell(Integer bId) {

        return bookMapper.selectByPrimaryKey(bId);
    }

    @Override
    public User getUserInfo(Integer user) {
        User user1 = userMapper.selectByKey(user);
        if (user1!=null){
            return user1;
        }
        return null;
    }

    /**
     *
     * @param bId 书id
     * @param order 订单对象
     * @return
     */
    @Override
    public Book selBookId(Integer bId, Order order) {
        OrderitemExample orderitemExample = new OrderitemExample();
        orderitemExample.createCriteria()
                .andOIdEqualTo(order.getoId());
        //获取指定订单号的所有订单
        List<Orderitem> orderitems = orderitemMapper.selectByExample(orderitemExample);
        System.out.println("11111111111111111111111111111111111111111111111111111");
        System.out.println(orderitems.size());
        //验证是否有订单
        if (orderitems.size()<1){
            //没有创建
            Orderitem orderitem = new Orderitem();
            //获取单价
            BookExample bookExample = new BookExample();
            bookExample.createCriteria()
                    .andBIdEqualTo(bId);
            List<Book> books = bookMapper.selectByExample(bookExample);
            System.out.println("22222222222222222222222222222222222222222222222");

            //生成新订单
            orderitem.setOiAmount(1);
            orderitem.setbId(bId);
            orderitem.setOiPrice(books.get(0).getbPrice());
            orderitem.setoId(order.getoId());
            //生成订单号
            orderitem.setoId(order.getoId());
            int insert = orderitemMapper.insertSelective(orderitem);
            System.out.println("33333333333333333333333333333333333333333333333");

            //更新order
            //orderitem的数量
            Integer oiAmount = orderitem.getOiAmount();


            //价格变化
            //orderitem的价格
            Float oiPrice = orderitem.getOiPrice();
            Order order1 = new Order();
            order1.setoAmount(oiAmount);
            order1.setOiPrice(oiPrice);
            order1.setoTotal(oiPrice*oiAmount);
            OrderExample orderExample = new OrderExample();
            orderExample.createCriteria()
                    .andOIdEqualTo(order.getoId());
            orderMapper.updateByExampleSelective(order1,orderExample);
            System.out.println("4444444444444444444444444444444444");

        }else {
             //hh=0;
            Float oiPrice=null;
            Integer oiAmount=null;
            String oid=null;
            Integer bid=null;
            //同一个用户多个订单判断
            for (int i = 0; i < orderitems.size(); i++) {

                //获取订单的书名，订单号
                 bid = orderitems.get(i).getbId();
                 oid = orderitems.get(i).getoId();
//                System.out.println(bid);
//                System.out.println(bId);
//                System.out.println(bid==bId);
//                System.out.println("..............");
                int k=bid;
                int l=bId;
//                System.out.println(k);
//                System.out.println(l);
//                System.out.println(l==k);
                //同一订单，同一书名
                if (l==k){
                    System.out.println("找到了");
                    hh=1;
                    oiPrice = orderitems.get(i).getOiPrice();
                    oiAmount = orderitems.get(i).getOiAmount();
                    break;
                }else {
                    hh=0;
                }

            }
            System.out.println("hh=="+hh);
            if (hh==1){
                System.out.println(hh+"pppppppppppppppppp");
                //orderitem的价格
               // oiPrice = orderitems.get(i).getOiPrice();
                //order的价格
                Float oiPrice1 = order.getOiPrice();
                if (oiPrice1==null){
                    oiPrice1=0F;
                }
                if (oiPrice==null){
                    oiPrice=0F;
                }
                //oiAmount = orderitems.get(i).getOiAmount();
                //order的数量
                Integer amount = order.getoAmount();
                OrderitemExample orderitemExample1 = new OrderitemExample();
                orderitemExample1.createCriteria()
                        .andOIdEqualTo(oid)
                .andBIdEqualTo(bId);
                //通过循环得到每条记录的总价
                float totle=0F;
                for (Orderitem orderitem : orderitems) {
                    totle += orderitem.getOiAmount() * orderitem.getOiPrice();
                }
                //获取书的价格
                Book book = bookMapper.selectByPrimaryKey(bId);

                Orderitem orderitem = new Orderitem();
                orderitem.setOiAmount(++oiAmount);
                orderitemMapper.updateByExampleSelective(orderitem,orderitemExample1);
                Order order1 = new Order();
                order1.setoAmount(++oiAmount);
                order1.setoTotal(totle+book.getbPrice());
                OrderExample orderExample = new OrderExample();
                orderExample.createCriteria()
                        .andOIdEqualTo(oid);
                orderMapper.updateByExampleSelective(order1,orderExample);
            }else {
                //没有创建
                Orderitem orderitem = new Orderitem();
                //获取单价
                BookExample bookExample = new BookExample();
                bookExample.createCriteria()
                        .andBIdEqualTo(bId);
                List<Book> books = bookMapper.selectByExample(bookExample);
                System.out.println("5555555555555555555555555555555555555");

                //生成新订单
                orderitem.setOiAmount(1);
                orderitem.setbId(bId);
                orderitem.setOiPrice(books.get(0).getbPrice());
                orderitem.setoId(order.getoId());
                //生成订单号
//                    orderitem.setoId(order.getoId());
                int insert = orderitemMapper.insertSelective(orderitem);
                System.out.println("666666666666666666666666666666666666");
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
