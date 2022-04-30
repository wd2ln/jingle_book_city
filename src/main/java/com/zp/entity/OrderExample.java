package com.zp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderExample() {
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

        public Criteria andOIdIsNull() {
            addCriterion("o_id is null");
            return (Criteria) this;
        }

        public Criteria andOIdIsNotNull() {
            addCriterion("o_id is not null");
            return (Criteria) this;
        }

        public Criteria andOIdEqualTo(String value) {
            addCriterion("o_id =", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotEqualTo(String value) {
            addCriterion("o_id <>", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThan(String value) {
            addCriterion("o_id >", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdGreaterThanOrEqualTo(String value) {
            addCriterion("o_id >=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThan(String value) {
            addCriterion("o_id <", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLessThanOrEqualTo(String value) {
            addCriterion("o_id <=", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdLike(String value) {
            addCriterion("o_id like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotLike(String value) {
            addCriterion("o_id not like", value, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdIn(List<String> values) {
            addCriterion("o_id in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotIn(List<String> values) {
            addCriterion("o_id not in", values, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdBetween(String value1, String value2) {
            addCriterion("o_id between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOIdNotBetween(String value1, String value2) {
            addCriterion("o_id not between", value1, value2, "oId");
            return (Criteria) this;
        }

        public Criteria andOTotalIsNull() {
            addCriterion("o_total is null");
            return (Criteria) this;
        }

        public Criteria andOTotalIsNotNull() {
            addCriterion("o_total is not null");
            return (Criteria) this;
        }

        public Criteria andOTotalEqualTo(Float value) {
            addCriterion("o_total =", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalNotEqualTo(Float value) {
            addCriterion("o_total <>", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalGreaterThan(Float value) {
            addCriterion("o_total >", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalGreaterThanOrEqualTo(Float value) {
            addCriterion("o_total >=", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalLessThan(Float value) {
            addCriterion("o_total <", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalLessThanOrEqualTo(Float value) {
            addCriterion("o_total <=", value, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalIn(List<Float> values) {
            addCriterion("o_total in", values, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalNotIn(List<Float> values) {
            addCriterion("o_total not in", values, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalBetween(Float value1, Float value2) {
            addCriterion("o_total between", value1, value2, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOTotalNotBetween(Float value1, Float value2) {
            addCriterion("o_total not between", value1, value2, "oTotal");
            return (Criteria) this;
        }

        public Criteria andOAmountIsNull() {
            addCriterion("o_amount is null");
            return (Criteria) this;
        }

        public Criteria andOAmountIsNotNull() {
            addCriterion("o_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOAmountEqualTo(Integer value) {
            addCriterion("o_amount =", value, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountNotEqualTo(Integer value) {
            addCriterion("o_amount <>", value, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountGreaterThan(Integer value) {
            addCriterion("o_amount >", value, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_amount >=", value, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountLessThan(Integer value) {
            addCriterion("o_amount <", value, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountLessThanOrEqualTo(Integer value) {
            addCriterion("o_amount <=", value, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountIn(List<Integer> values) {
            addCriterion("o_amount in", values, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountNotIn(List<Integer> values) {
            addCriterion("o_amount not in", values, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountBetween(Integer value1, Integer value2) {
            addCriterion("o_amount between", value1, value2, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("o_amount not between", value1, value2, "oAmount");
            return (Criteria) this;
        }

        public Criteria andOStatusIsNull() {
            addCriterion("o_status is null");
            return (Criteria) this;
        }

        public Criteria andOStatusIsNotNull() {
            addCriterion("o_status is not null");
            return (Criteria) this;
        }

        public Criteria andOStatusEqualTo(Integer value) {
            addCriterion("o_status =", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusNotEqualTo(Integer value) {
            addCriterion("o_status <>", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusGreaterThan(Integer value) {
            addCriterion("o_status >", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_status >=", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusLessThan(Integer value) {
            addCriterion("o_status <", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusLessThanOrEqualTo(Integer value) {
            addCriterion("o_status <=", value, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusIn(List<Integer> values) {
            addCriterion("o_status in", values, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusNotIn(List<Integer> values) {
            addCriterion("o_status not in", values, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusBetween(Integer value1, Integer value2) {
            addCriterion("o_status between", value1, value2, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("o_status not between", value1, value2, "oStatus");
            return (Criteria) this;
        }

        public Criteria andOPaytypeIsNull() {
            addCriterion("o_paytype is null");
            return (Criteria) this;
        }

        public Criteria andOPaytypeIsNotNull() {
            addCriterion("o_paytype is not null");
            return (Criteria) this;
        }

        public Criteria andOPaytypeEqualTo(Integer value) {
            addCriterion("o_paytype =", value, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeNotEqualTo(Integer value) {
            addCriterion("o_paytype <>", value, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeGreaterThan(Integer value) {
            addCriterion("o_paytype >", value, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("o_paytype >=", value, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeLessThan(Integer value) {
            addCriterion("o_paytype <", value, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeLessThanOrEqualTo(Integer value) {
            addCriterion("o_paytype <=", value, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeIn(List<Integer> values) {
            addCriterion("o_paytype in", values, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeNotIn(List<Integer> values) {
            addCriterion("o_paytype not in", values, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeBetween(Integer value1, Integer value2) {
            addCriterion("o_paytype between", value1, value2, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andOPaytypeNotBetween(Integer value1, Integer value2) {
            addCriterion("o_paytype not between", value1, value2, "oPaytype");
            return (Criteria) this;
        }

        public Criteria andUIdIsNull() {
            addCriterion("u_id is null");
            return (Criteria) this;
        }

        public Criteria andUIdIsNotNull() {
            addCriterion("u_id is not null");
            return (Criteria) this;
        }

        public Criteria andUIdEqualTo(Integer value) {
            addCriterion("u_id =", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotEqualTo(Integer value) {
            addCriterion("u_id <>", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThan(Integer value) {
            addCriterion("u_id >", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_id >=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThan(Integer value) {
            addCriterion("u_id <", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdLessThanOrEqualTo(Integer value) {
            addCriterion("u_id <=", value, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdIn(List<Integer> values) {
            addCriterion("u_id in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotIn(List<Integer> values) {
            addCriterion("u_id not in", values, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdBetween(Integer value1, Integer value2) {
            addCriterion("u_id between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andUIdNotBetween(Integer value1, Integer value2) {
            addCriterion("u_id not between", value1, value2, "uId");
            return (Criteria) this;
        }

        public Criteria andODatetimeIsNull() {
            addCriterion("o_datetime is null");
            return (Criteria) this;
        }

        public Criteria andODatetimeIsNotNull() {
            addCriterion("o_datetime is not null");
            return (Criteria) this;
        }

        public Criteria andODatetimeEqualTo(Date value) {
            addCriterion("o_datetime =", value, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeNotEqualTo(Date value) {
            addCriterion("o_datetime <>", value, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeGreaterThan(Date value) {
            addCriterion("o_datetime >", value, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("o_datetime >=", value, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeLessThan(Date value) {
            addCriterion("o_datetime <", value, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeLessThanOrEqualTo(Date value) {
            addCriterion("o_datetime <=", value, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeIn(List<Date> values) {
            addCriterion("o_datetime in", values, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeNotIn(List<Date> values) {
            addCriterion("o_datetime not in", values, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeBetween(Date value1, Date value2) {
            addCriterion("o_datetime between", value1, value2, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andODatetimeNotBetween(Date value1, Date value2) {
            addCriterion("o_datetime not between", value1, value2, "oDatetime");
            return (Criteria) this;
        }

        public Criteria andORealnameIsNull() {
            addCriterion("o_realname is null");
            return (Criteria) this;
        }

        public Criteria andORealnameIsNotNull() {
            addCriterion("o_realname is not null");
            return (Criteria) this;
        }

        public Criteria andORealnameEqualTo(String value) {
            addCriterion("o_realname =", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameNotEqualTo(String value) {
            addCriterion("o_realname <>", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameGreaterThan(String value) {
            addCriterion("o_realname >", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameGreaterThanOrEqualTo(String value) {
            addCriterion("o_realname >=", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameLessThan(String value) {
            addCriterion("o_realname <", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameLessThanOrEqualTo(String value) {
            addCriterion("o_realname <=", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameLike(String value) {
            addCriterion("o_realname like", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameNotLike(String value) {
            addCriterion("o_realname not like", value, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameIn(List<String> values) {
            addCriterion("o_realname in", values, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameNotIn(List<String> values) {
            addCriterion("o_realname not in", values, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameBetween(String value1, String value2) {
            addCriterion("o_realname between", value1, value2, "oRealname");
            return (Criteria) this;
        }

        public Criteria andORealnameNotBetween(String value1, String value2) {
            addCriterion("o_realname not between", value1, value2, "oRealname");
            return (Criteria) this;
        }

        public Criteria andOPhoneIsNull() {
            addCriterion("o_phone is null");
            return (Criteria) this;
        }

        public Criteria andOPhoneIsNotNull() {
            addCriterion("o_phone is not null");
            return (Criteria) this;
        }

        public Criteria andOPhoneEqualTo(String value) {
            addCriterion("o_phone =", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotEqualTo(String value) {
            addCriterion("o_phone <>", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneGreaterThan(String value) {
            addCriterion("o_phone >", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("o_phone >=", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneLessThan(String value) {
            addCriterion("o_phone <", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneLessThanOrEqualTo(String value) {
            addCriterion("o_phone <=", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneLike(String value) {
            addCriterion("o_phone like", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotLike(String value) {
            addCriterion("o_phone not like", value, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneIn(List<String> values) {
            addCriterion("o_phone in", values, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotIn(List<String> values) {
            addCriterion("o_phone not in", values, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneBetween(String value1, String value2) {
            addCriterion("o_phone between", value1, value2, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOPhoneNotBetween(String value1, String value2) {
            addCriterion("o_phone not between", value1, value2, "oPhone");
            return (Criteria) this;
        }

        public Criteria andOAddressIsNull() {
            addCriterion("o_address is null");
            return (Criteria) this;
        }

        public Criteria andOAddressIsNotNull() {
            addCriterion("o_address is not null");
            return (Criteria) this;
        }

        public Criteria andOAddressEqualTo(String value) {
            addCriterion("o_address =", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressNotEqualTo(String value) {
            addCriterion("o_address <>", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressGreaterThan(String value) {
            addCriterion("o_address >", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressGreaterThanOrEqualTo(String value) {
            addCriterion("o_address >=", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressLessThan(String value) {
            addCriterion("o_address <", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressLessThanOrEqualTo(String value) {
            addCriterion("o_address <=", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressLike(String value) {
            addCriterion("o_address like", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressNotLike(String value) {
            addCriterion("o_address not like", value, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressIn(List<String> values) {
            addCriterion("o_address in", values, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressNotIn(List<String> values) {
            addCriterion("o_address not in", values, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressBetween(String value1, String value2) {
            addCriterion("o_address between", value1, value2, "oAddress");
            return (Criteria) this;
        }

        public Criteria andOAddressNotBetween(String value1, String value2) {
            addCriterion("o_address not between", value1, value2, "oAddress");
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