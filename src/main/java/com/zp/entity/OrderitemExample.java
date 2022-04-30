package com.zp.entity;

import java.util.ArrayList;
import java.util.List;

public class OrderitemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderitemExample() {
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

        public Criteria andOiIdIsNull() {
            addCriterion("oi_id is null");
            return (Criteria) this;
        }

        public Criteria andOiIdIsNotNull() {
            addCriterion("oi_id is not null");
            return (Criteria) this;
        }

        public Criteria andOiIdEqualTo(Integer value) {
            addCriterion("oi_id =", value, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdNotEqualTo(Integer value) {
            addCriterion("oi_id <>", value, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdGreaterThan(Integer value) {
            addCriterion("oi_id >", value, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("oi_id >=", value, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdLessThan(Integer value) {
            addCriterion("oi_id <", value, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdLessThanOrEqualTo(Integer value) {
            addCriterion("oi_id <=", value, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdIn(List<Integer> values) {
            addCriterion("oi_id in", values, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdNotIn(List<Integer> values) {
            addCriterion("oi_id not in", values, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdBetween(Integer value1, Integer value2) {
            addCriterion("oi_id between", value1, value2, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiIdNotBetween(Integer value1, Integer value2) {
            addCriterion("oi_id not between", value1, value2, "oiId");
            return (Criteria) this;
        }

        public Criteria andOiPriceIsNull() {
            addCriterion("oi_price is null");
            return (Criteria) this;
        }

        public Criteria andOiPriceIsNotNull() {
            addCriterion("oi_price is not null");
            return (Criteria) this;
        }

        public Criteria andOiPriceEqualTo(Float value) {
            addCriterion("oi_price =", value, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceNotEqualTo(Float value) {
            addCriterion("oi_price <>", value, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceGreaterThan(Float value) {
            addCriterion("oi_price >", value, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceGreaterThanOrEqualTo(Float value) {
            addCriterion("oi_price >=", value, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceLessThan(Float value) {
            addCriterion("oi_price <", value, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceLessThanOrEqualTo(Float value) {
            addCriterion("oi_price <=", value, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceIn(List<Float> values) {
            addCriterion("oi_price in", values, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceNotIn(List<Float> values) {
            addCriterion("oi_price not in", values, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceBetween(Float value1, Float value2) {
            addCriterion("oi_price between", value1, value2, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiPriceNotBetween(Float value1, Float value2) {
            addCriterion("oi_price not between", value1, value2, "oiPrice");
            return (Criteria) this;
        }

        public Criteria andOiAmountIsNull() {
            addCriterion("oi_amount is null");
            return (Criteria) this;
        }

        public Criteria andOiAmountIsNotNull() {
            addCriterion("oi_amount is not null");
            return (Criteria) this;
        }

        public Criteria andOiAmountEqualTo(Integer value) {
            addCriterion("oi_amount =", value, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountNotEqualTo(Integer value) {
            addCriterion("oi_amount <>", value, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountGreaterThan(Integer value) {
            addCriterion("oi_amount >", value, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountGreaterThanOrEqualTo(Integer value) {
            addCriterion("oi_amount >=", value, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountLessThan(Integer value) {
            addCriterion("oi_amount <", value, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountLessThanOrEqualTo(Integer value) {
            addCriterion("oi_amount <=", value, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountIn(List<Integer> values) {
            addCriterion("oi_amount in", values, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountNotIn(List<Integer> values) {
            addCriterion("oi_amount not in", values, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountBetween(Integer value1, Integer value2) {
            addCriterion("oi_amount between", value1, value2, "oiAmount");
            return (Criteria) this;
        }

        public Criteria andOiAmountNotBetween(Integer value1, Integer value2) {
            addCriterion("oi_amount not between", value1, value2, "oiAmount");
            return (Criteria) this;
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