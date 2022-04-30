package com.zp.entity;

import java.util.ArrayList;
import java.util.List;

public class BookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BookExample() {
        oredCriteria = new ArrayList<>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBIdIsNull() {
            addCriterion("b_id is null");
            return (Criteria) this;
        }

        public Criteria andBIdIsNotNull() {
            addCriterion("b_id is not null");
            return (Criteria) this;
        }

        public Criteria andBIdEqualTo(Integer value) {
            addCriterion("b_id =", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotEqualTo(Integer value) {
            addCriterion("b_id <>", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThan(Integer value) {
            addCriterion("b_id >", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_id >=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThan(Integer value) {
            addCriterion("b_id <", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdLessThanOrEqualTo(Integer value) {
            addCriterion("b_id <=", value, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdIn(List<Integer> values) {
            addCriterion("b_id in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotIn(List<Integer> values) {
            addCriterion("b_id not in", values, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdBetween(Integer value1, Integer value2) {
            addCriterion("b_id between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBIdNotBetween(Integer value1, Integer value2) {
            addCriterion("b_id not between", value1, value2, "bId");
            return (Criteria) this;
        }

        public Criteria andBIsbnIsNull() {
            addCriterion("b_isbn is null");
            return (Criteria) this;
        }

        public Criteria andBIsbnIsNotNull() {
            addCriterion("b_isbn is not null");
            return (Criteria) this;
        }

        public Criteria andBIsbnEqualTo(String value) {
            addCriterion("b_isbn =", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnNotEqualTo(String value) {
            addCriterion("b_isbn <>", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnGreaterThan(String value) {
            addCriterion("b_isbn >", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnGreaterThanOrEqualTo(String value) {
            addCriterion("b_isbn >=", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnLessThan(String value) {
            addCriterion("b_isbn <", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnLessThanOrEqualTo(String value) {
            addCriterion("b_isbn <=", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnLike(String value) {
            addCriterion("b_isbn like", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnNotLike(String value) {
            addCriterion("b_isbn not like", value, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnIn(List<String> values) {
            addCriterion("b_isbn in", values, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnNotIn(List<String> values) {
            addCriterion("b_isbn not in", values, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnBetween(String value1, String value2) {
            addCriterion("b_isbn between", value1, value2, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBIsbnNotBetween(String value1, String value2) {
            addCriterion("b_isbn not between", value1, value2, "bIsbn");
            return (Criteria) this;
        }

        public Criteria andBNameIsNull() {
            addCriterion("b_name is null");
            return (Criteria) this;
        }

        public Criteria andBNameIsNotNull() {
            addCriterion("b_name is not null");
            return (Criteria) this;
        }

        public Criteria andBNameEqualTo(String value) {
            addCriterion("b_name =", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotEqualTo(String value) {
            addCriterion("b_name <>", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThan(String value) {
            addCriterion("b_name >", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameGreaterThanOrEqualTo(String value) {
            addCriterion("b_name >=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThan(String value) {
            addCriterion("b_name <", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLessThanOrEqualTo(String value) {
            addCriterion("b_name <=", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameLike(String value) {
            addCriterion("b_name like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotLike(String value) {
            addCriterion("b_name not like", value, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameIn(List<String> values) {
            addCriterion("b_name in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotIn(List<String> values) {
            addCriterion("b_name not in", values, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameBetween(String value1, String value2) {
            addCriterion("b_name between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBNameNotBetween(String value1, String value2) {
            addCriterion("b_name not between", value1, value2, "bName");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNull() {
            addCriterion("b_author is null");
            return (Criteria) this;
        }

        public Criteria andBAuthorIsNotNull() {
            addCriterion("b_author is not null");
            return (Criteria) this;
        }

        public Criteria andBAuthorEqualTo(String value) {
            addCriterion("b_author =", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotEqualTo(String value) {
            addCriterion("b_author <>", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThan(String value) {
            addCriterion("b_author >", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorGreaterThanOrEqualTo(String value) {
            addCriterion("b_author >=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThan(String value) {
            addCriterion("b_author <", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLessThanOrEqualTo(String value) {
            addCriterion("b_author <=", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorLike(String value) {
            addCriterion("b_author like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotLike(String value) {
            addCriterion("b_author not like", value, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorIn(List<String> values) {
            addCriterion("b_author in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotIn(List<String> values) {
            addCriterion("b_author not in", values, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorBetween(String value1, String value2) {
            addCriterion("b_author between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBAuthorNotBetween(String value1, String value2) {
            addCriterion("b_author not between", value1, value2, "bAuthor");
            return (Criteria) this;
        }

        public Criteria andBPublisherIsNull() {
            addCriterion("b_publisher is null");
            return (Criteria) this;
        }

        public Criteria andBPublisherIsNotNull() {
            addCriterion("b_publisher is not null");
            return (Criteria) this;
        }

        public Criteria andBPublisherEqualTo(String value) {
            addCriterion("b_publisher =", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherNotEqualTo(String value) {
            addCriterion("b_publisher <>", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherGreaterThan(String value) {
            addCriterion("b_publisher >", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherGreaterThanOrEqualTo(String value) {
            addCriterion("b_publisher >=", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherLessThan(String value) {
            addCriterion("b_publisher <", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherLessThanOrEqualTo(String value) {
            addCriterion("b_publisher <=", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherLike(String value) {
            addCriterion("b_publisher like", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherNotLike(String value) {
            addCriterion("b_publisher not like", value, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherIn(List<String> values) {
            addCriterion("b_publisher in", values, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherNotIn(List<String> values) {
            addCriterion("b_publisher not in", values, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherBetween(String value1, String value2) {
            addCriterion("b_publisher between", value1, value2, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBPublisherNotBetween(String value1, String value2) {
            addCriterion("b_publisher not between", value1, value2, "bPublisher");
            return (Criteria) this;
        }

        public Criteria andBCoverIsNull() {
            addCriterion("b_cover is null");
            return (Criteria) this;
        }

        public Criteria andBCoverIsNotNull() {
            addCriterion("b_cover is not null");
            return (Criteria) this;
        }

        public Criteria andBCoverEqualTo(String value) {
            addCriterion("b_cover =", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverNotEqualTo(String value) {
            addCriterion("b_cover <>", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverGreaterThan(String value) {
            addCriterion("b_cover >", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverGreaterThanOrEqualTo(String value) {
            addCriterion("b_cover >=", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverLessThan(String value) {
            addCriterion("b_cover <", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverLessThanOrEqualTo(String value) {
            addCriterion("b_cover <=", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverLike(String value) {
            addCriterion("b_cover like", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverNotLike(String value) {
            addCriterion("b_cover not like", value, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverIn(List<String> values) {
            addCriterion("b_cover in", values, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverNotIn(List<String> values) {
            addCriterion("b_cover not in", values, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverBetween(String value1, String value2) {
            addCriterion("b_cover between", value1, value2, "bCover");
            return (Criteria) this;
        }

        public Criteria andBCoverNotBetween(String value1, String value2) {
            addCriterion("b_cover not between", value1, value2, "bCover");
            return (Criteria) this;
        }

        public Criteria andBImage1IsNull() {
            addCriterion("b_image1 is null");
            return (Criteria) this;
        }

        public Criteria andBImage1IsNotNull() {
            addCriterion("b_image1 is not null");
            return (Criteria) this;
        }

        public Criteria andBImage1EqualTo(String value) {
            addCriterion("b_image1 =", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1NotEqualTo(String value) {
            addCriterion("b_image1 <>", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1GreaterThan(String value) {
            addCriterion("b_image1 >", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1GreaterThanOrEqualTo(String value) {
            addCriterion("b_image1 >=", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1LessThan(String value) {
            addCriterion("b_image1 <", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1LessThanOrEqualTo(String value) {
            addCriterion("b_image1 <=", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1Like(String value) {
            addCriterion("b_image1 like", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1NotLike(String value) {
            addCriterion("b_image1 not like", value, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1In(List<String> values) {
            addCriterion("b_image1 in", values, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1NotIn(List<String> values) {
            addCriterion("b_image1 not in", values, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1Between(String value1, String value2) {
            addCriterion("b_image1 between", value1, value2, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage1NotBetween(String value1, String value2) {
            addCriterion("b_image1 not between", value1, value2, "bImage1");
            return (Criteria) this;
        }

        public Criteria andBImage2IsNull() {
            addCriterion("b_image2 is null");
            return (Criteria) this;
        }

        public Criteria andBImage2IsNotNull() {
            addCriterion("b_image2 is not null");
            return (Criteria) this;
        }

        public Criteria andBImage2EqualTo(String value) {
            addCriterion("b_image2 =", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2NotEqualTo(String value) {
            addCriterion("b_image2 <>", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2GreaterThan(String value) {
            addCriterion("b_image2 >", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2GreaterThanOrEqualTo(String value) {
            addCriterion("b_image2 >=", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2LessThan(String value) {
            addCriterion("b_image2 <", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2LessThanOrEqualTo(String value) {
            addCriterion("b_image2 <=", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2Like(String value) {
            addCriterion("b_image2 like", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2NotLike(String value) {
            addCriterion("b_image2 not like", value, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2In(List<String> values) {
            addCriterion("b_image2 in", values, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2NotIn(List<String> values) {
            addCriterion("b_image2 not in", values, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2Between(String value1, String value2) {
            addCriterion("b_image2 between", value1, value2, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBImage2NotBetween(String value1, String value2) {
            addCriterion("b_image2 not between", value1, value2, "bImage2");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNull() {
            addCriterion("b_price is null");
            return (Criteria) this;
        }

        public Criteria andBPriceIsNotNull() {
            addCriterion("b_price is not null");
            return (Criteria) this;
        }

        public Criteria andBPriceEqualTo(Float value) {
            addCriterion("b_price =", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotEqualTo(Float value) {
            addCriterion("b_price <>", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThan(Float value) {
            addCriterion("b_price >", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("b_price >=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThan(Float value) {
            addCriterion("b_price <", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceLessThanOrEqualTo(Float value) {
            addCriterion("b_price <=", value, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceIn(List<Float> values) {
            addCriterion("b_price in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotIn(List<Float> values) {
            addCriterion("b_price not in", values, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceBetween(Float value1, Float value2) {
            addCriterion("b_price between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBPriceNotBetween(Float value1, Float value2) {
            addCriterion("b_price not between", value1, value2, "bPrice");
            return (Criteria) this;
        }

        public Criteria andBtIdIsNull() {
            addCriterion("bt_id is null");
            return (Criteria) this;
        }

        public Criteria andBtIdIsNotNull() {
            addCriterion("bt_id is not null");
            return (Criteria) this;
        }

        public Criteria andBtIdEqualTo(Integer value) {
            addCriterion("bt_id =", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotEqualTo(Integer value) {
            addCriterion("bt_id <>", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdGreaterThan(Integer value) {
            addCriterion("bt_id >", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("bt_id >=", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdLessThan(Integer value) {
            addCriterion("bt_id <", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdLessThanOrEqualTo(Integer value) {
            addCriterion("bt_id <=", value, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdIn(List<Integer> values) {
            addCriterion("bt_id in", values, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotIn(List<Integer> values) {
            addCriterion("bt_id not in", values, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdBetween(Integer value1, Integer value2) {
            addCriterion("bt_id between", value1, value2, "btId");
            return (Criteria) this;
        }

        public Criteria andBtIdNotBetween(Integer value1, Integer value2) {
            addCriterion("bt_id not between", value1, value2, "btId");
            return (Criteria) this;
        }

        public Criteria andBStockIsNull() {
            addCriterion("b_stock is null");
            return (Criteria) this;
        }

        public Criteria andBStockIsNotNull() {
            addCriterion("b_stock is not null");
            return (Criteria) this;
        }

        public Criteria andBStockEqualTo(Integer value) {
            addCriterion("b_stock =", value, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockNotEqualTo(Integer value) {
            addCriterion("b_stock <>", value, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockGreaterThan(Integer value) {
            addCriterion("b_stock >", value, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockGreaterThanOrEqualTo(Integer value) {
            addCriterion("b_stock >=", value, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockLessThan(Integer value) {
            addCriterion("b_stock <", value, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockLessThanOrEqualTo(Integer value) {
            addCriterion("b_stock <=", value, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockIn(List<Integer> values) {
            addCriterion("b_stock in", values, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockNotIn(List<Integer> values) {
            addCriterion("b_stock not in", values, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockBetween(Integer value1, Integer value2) {
            addCriterion("b_stock between", value1, value2, "bStock");
            return (Criteria) this;
        }

        public Criteria andBStockNotBetween(Integer value1, Integer value2) {
            addCriterion("b_stock not between", value1, value2, "bStock");
            return (Criteria) this;
        }

        public Criteria andBMarkIsNull() {
            addCriterion("b_mark is null");
            return (Criteria) this;
        }

        public Criteria andBMarkIsNotNull() {
            addCriterion("b_mark is not null");
            return (Criteria) this;
        }

        public Criteria andBMarkEqualTo(String value) {
            addCriterion("b_mark =", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkNotEqualTo(String value) {
            addCriterion("b_mark <>", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkGreaterThan(String value) {
            addCriterion("b_mark >", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkGreaterThanOrEqualTo(String value) {
            addCriterion("b_mark >=", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkLessThan(String value) {
            addCriterion("b_mark <", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkLessThanOrEqualTo(String value) {
            addCriterion("b_mark <=", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkLike(String value) {
            addCriterion("b_mark like", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkNotLike(String value) {
            addCriterion("b_mark not like", value, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkIn(List<String> values) {
            addCriterion("b_mark in", values, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkNotIn(List<String> values) {
            addCriterion("b_mark not in", values, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkBetween(String value1, String value2) {
            addCriterion("b_mark between", value1, value2, "bMark");
            return (Criteria) this;
        }

        public Criteria andBMarkNotBetween(String value1, String value2) {
            addCriterion("b_mark not between", value1, value2, "bMark");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {
        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}