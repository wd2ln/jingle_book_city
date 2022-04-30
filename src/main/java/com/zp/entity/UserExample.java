package com.zp.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserExample() {
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

        public Criteria andUNameIsNull() {
            addCriterion("u_name is null");
            return (Criteria) this;
        }

        public Criteria andUNameIsNotNull() {
            addCriterion("u_name is not null");
            return (Criteria) this;
        }

        public Criteria andUNameEqualTo(String value) {
            addCriterion("u_name =", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotEqualTo(String value) {
            addCriterion("u_name <>", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThan(String value) {
            addCriterion("u_name >", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameGreaterThanOrEqualTo(String value) {
            addCriterion("u_name >=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThan(String value) {
            addCriterion("u_name <", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLessThanOrEqualTo(String value) {
            addCriterion("u_name <=", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameLike(String value) {
            addCriterion("u_name like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotLike(String value) {
            addCriterion("u_name not like", value, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameIn(List<String> values) {
            addCriterion("u_name in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotIn(List<String> values) {
            addCriterion("u_name not in", values, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameBetween(String value1, String value2) {
            addCriterion("u_name between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUNameNotBetween(String value1, String value2) {
            addCriterion("u_name not between", value1, value2, "uName");
            return (Criteria) this;
        }

        public Criteria andUPwdIsNull() {
            addCriterion("u_pwd is null");
            return (Criteria) this;
        }

        public Criteria andUPwdIsNotNull() {
            addCriterion("u_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andUPwdEqualTo(String value) {
            addCriterion("u_pwd =", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotEqualTo(String value) {
            addCriterion("u_pwd <>", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdGreaterThan(String value) {
            addCriterion("u_pwd >", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdGreaterThanOrEqualTo(String value) {
            addCriterion("u_pwd >=", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdLessThan(String value) {
            addCriterion("u_pwd <", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdLessThanOrEqualTo(String value) {
            addCriterion("u_pwd <=", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdLike(String value) {
            addCriterion("u_pwd like", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotLike(String value) {
            addCriterion("u_pwd not like", value, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdIn(List<String> values) {
            addCriterion("u_pwd in", values, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotIn(List<String> values) {
            addCriterion("u_pwd not in", values, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdBetween(String value1, String value2) {
            addCriterion("u_pwd between", value1, value2, "uPwd");
            return (Criteria) this;
        }

        public Criteria andUPwdNotBetween(String value1, String value2) {
            addCriterion("u_pwd not between", value1, value2, "uPwd");
            return (Criteria) this;
        }

        public Criteria andURealnameIsNull() {
            addCriterion("u_realname is null");
            return (Criteria) this;
        }

        public Criteria andURealnameIsNotNull() {
            addCriterion("u_realname is not null");
            return (Criteria) this;
        }

        public Criteria andURealnameEqualTo(String value) {
            addCriterion("u_realname =", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotEqualTo(String value) {
            addCriterion("u_realname <>", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameGreaterThan(String value) {
            addCriterion("u_realname >", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameGreaterThanOrEqualTo(String value) {
            addCriterion("u_realname >=", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLessThan(String value) {
            addCriterion("u_realname <", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLessThanOrEqualTo(String value) {
            addCriterion("u_realname <=", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameLike(String value) {
            addCriterion("u_realname like", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotLike(String value) {
            addCriterion("u_realname not like", value, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameIn(List<String> values) {
            addCriterion("u_realname in", values, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotIn(List<String> values) {
            addCriterion("u_realname not in", values, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameBetween(String value1, String value2) {
            addCriterion("u_realname between", value1, value2, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURealnameNotBetween(String value1, String value2) {
            addCriterion("u_realname not between", value1, value2, "uRealname");
            return (Criteria) this;
        }

        public Criteria andURedgtIsNull() {
            addCriterion("u_redgt is null");
            return (Criteria) this;
        }

        public Criteria andURedgtIsNotNull() {
            addCriterion("u_redgt is not null");
            return (Criteria) this;
        }

        public Criteria andURedgtEqualTo(Date value) {
            addCriterion("u_redgt =", value, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtNotEqualTo(Date value) {
            addCriterion("u_redgt <>", value, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtGreaterThan(Date value) {
            addCriterion("u_redgt >", value, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtGreaterThanOrEqualTo(Date value) {
            addCriterion("u_redgt >=", value, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtLessThan(Date value) {
            addCriterion("u_redgt <", value, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtLessThanOrEqualTo(Date value) {
            addCriterion("u_redgt <=", value, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtIn(List<Date> values) {
            addCriterion("u_redgt in", values, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtNotIn(List<Date> values) {
            addCriterion("u_redgt not in", values, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtBetween(Date value1, Date value2) {
            addCriterion("u_redgt between", value1, value2, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURedgtNotBetween(Date value1, Date value2) {
            addCriterion("u_redgt not between", value1, value2, "uRedgt");
            return (Criteria) this;
        }

        public Criteria andURoleIsNull() {
            addCriterion("u_role is null");
            return (Criteria) this;
        }

        public Criteria andURoleIsNotNull() {
            addCriterion("u_role is not null");
            return (Criteria) this;
        }

        public Criteria andURoleEqualTo(Integer value) {
            addCriterion("u_role =", value, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleNotEqualTo(Integer value) {
            addCriterion("u_role <>", value, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleGreaterThan(Integer value) {
            addCriterion("u_role >", value, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleGreaterThanOrEqualTo(Integer value) {
            addCriterion("u_role >=", value, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleLessThan(Integer value) {
            addCriterion("u_role <", value, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleLessThanOrEqualTo(Integer value) {
            addCriterion("u_role <=", value, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleIn(List<Integer> values) {
            addCriterion("u_role in", values, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleNotIn(List<Integer> values) {
            addCriterion("u_role not in", values, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleBetween(Integer value1, Integer value2) {
            addCriterion("u_role between", value1, value2, "uRole");
            return (Criteria) this;
        }

        public Criteria andURoleNotBetween(Integer value1, Integer value2) {
            addCriterion("u_role not between", value1, value2, "uRole");
            return (Criteria) this;
        }

        public Criteria andUMarkIsNull() {
            addCriterion("u_mark is null");
            return (Criteria) this;
        }

        public Criteria andUMarkIsNotNull() {
            addCriterion("u_mark is not null");
            return (Criteria) this;
        }

        public Criteria andUMarkEqualTo(String value) {
            addCriterion("u_mark =", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkNotEqualTo(String value) {
            addCriterion("u_mark <>", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkGreaterThan(String value) {
            addCriterion("u_mark >", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkGreaterThanOrEqualTo(String value) {
            addCriterion("u_mark >=", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkLessThan(String value) {
            addCriterion("u_mark <", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkLessThanOrEqualTo(String value) {
            addCriterion("u_mark <=", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkLike(String value) {
            addCriterion("u_mark like", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkNotLike(String value) {
            addCriterion("u_mark not like", value, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkIn(List<String> values) {
            addCriterion("u_mark in", values, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkNotIn(List<String> values) {
            addCriterion("u_mark not in", values, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkBetween(String value1, String value2) {
            addCriterion("u_mark between", value1, value2, "uMark");
            return (Criteria) this;
        }

        public Criteria andUMarkNotBetween(String value1, String value2) {
            addCriterion("u_mark not between", value1, value2, "uMark");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNull() {
            addCriterion("u_phone is null");
            return (Criteria) this;
        }

        public Criteria andUPhoneIsNotNull() {
            addCriterion("u_phone is not null");
            return (Criteria) this;
        }

        public Criteria andUPhoneEqualTo(String value) {
            addCriterion("u_phone =", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotEqualTo(String value) {
            addCriterion("u_phone <>", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThan(String value) {
            addCriterion("u_phone >", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneGreaterThanOrEqualTo(String value) {
            addCriterion("u_phone >=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThan(String value) {
            addCriterion("u_phone <", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLessThanOrEqualTo(String value) {
            addCriterion("u_phone <=", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneLike(String value) {
            addCriterion("u_phone like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotLike(String value) {
            addCriterion("u_phone not like", value, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneIn(List<String> values) {
            addCriterion("u_phone in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotIn(List<String> values) {
            addCriterion("u_phone not in", values, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneBetween(String value1, String value2) {
            addCriterion("u_phone between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUPhoneNotBetween(String value1, String value2) {
            addCriterion("u_phone not between", value1, value2, "uPhone");
            return (Criteria) this;
        }

        public Criteria andUAddressIsNull() {
            addCriterion("u_address is null");
            return (Criteria) this;
        }

        public Criteria andUAddressIsNotNull() {
            addCriterion("u_address is not null");
            return (Criteria) this;
        }

        public Criteria andUAddressEqualTo(String value) {
            addCriterion("u_address =", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotEqualTo(String value) {
            addCriterion("u_address <>", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressGreaterThan(String value) {
            addCriterion("u_address >", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressGreaterThanOrEqualTo(String value) {
            addCriterion("u_address >=", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLessThan(String value) {
            addCriterion("u_address <", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLessThanOrEqualTo(String value) {
            addCriterion("u_address <=", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressLike(String value) {
            addCriterion("u_address like", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotLike(String value) {
            addCriterion("u_address not like", value, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressIn(List<String> values) {
            addCriterion("u_address in", values, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotIn(List<String> values) {
            addCriterion("u_address not in", values, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressBetween(String value1, String value2) {
            addCriterion("u_address between", value1, value2, "uAddress");
            return (Criteria) this;
        }

        public Criteria andUAddressNotBetween(String value1, String value2) {
            addCriterion("u_address not between", value1, value2, "uAddress");
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