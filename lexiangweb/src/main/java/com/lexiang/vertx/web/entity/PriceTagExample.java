package com.lexiang.vertx.web.entity;

import java.util.ArrayList;
import java.util.List;

public class PriceTagExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public PriceTagExample() {
        oredCriteria = new ArrayList<Criteria>();
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
            criteria = new ArrayList<Criterion>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNull() {
            addCriterion("tag_name is null");
            return (Criteria) this;
        }

        public Criteria andTagNameIsNotNull() {
            addCriterion("tag_name is not null");
            return (Criteria) this;
        }

        public Criteria andTagNameEqualTo(String value) {
            addCriterion("tag_name =", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotEqualTo(String value) {
            addCriterion("tag_name <>", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThan(String value) {
            addCriterion("tag_name >", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameGreaterThanOrEqualTo(String value) {
            addCriterion("tag_name >=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThan(String value) {
            addCriterion("tag_name <", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLessThanOrEqualTo(String value) {
            addCriterion("tag_name <=", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameLike(String value) {
            addCriterion("tag_name like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotLike(String value) {
            addCriterion("tag_name not like", value, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameIn(List<String> values) {
            addCriterion("tag_name in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotIn(List<String> values) {
            addCriterion("tag_name not in", values, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameBetween(String value1, String value2) {
            addCriterion("tag_name between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagNameNotBetween(String value1, String value2) {
            addCriterion("tag_name not between", value1, value2, "tagName");
            return (Criteria) this;
        }

        public Criteria andTagDescribeIsNull() {
            addCriterion("tag_describe is null");
            return (Criteria) this;
        }

        public Criteria andTagDescribeIsNotNull() {
            addCriterion("tag_describe is not null");
            return (Criteria) this;
        }

        public Criteria andTagDescribeEqualTo(String value) {
            addCriterion("tag_describe =", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeNotEqualTo(String value) {
            addCriterion("tag_describe <>", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeGreaterThan(String value) {
            addCriterion("tag_describe >", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeGreaterThanOrEqualTo(String value) {
            addCriterion("tag_describe >=", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeLessThan(String value) {
            addCriterion("tag_describe <", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeLessThanOrEqualTo(String value) {
            addCriterion("tag_describe <=", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeLike(String value) {
            addCriterion("tag_describe like", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeNotLike(String value) {
            addCriterion("tag_describe not like", value, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeIn(List<String> values) {
            addCriterion("tag_describe in", values, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeNotIn(List<String> values) {
            addCriterion("tag_describe not in", values, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeBetween(String value1, String value2) {
            addCriterion("tag_describe between", value1, value2, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagDescribeNotBetween(String value1, String value2) {
            addCriterion("tag_describe not between", value1, value2, "tagDescribe");
            return (Criteria) this;
        }

        public Criteria andTagPhotoIsNull() {
            addCriterion("tag_photo is null");
            return (Criteria) this;
        }

        public Criteria andTagPhotoIsNotNull() {
            addCriterion("tag_photo is not null");
            return (Criteria) this;
        }

        public Criteria andTagPhotoEqualTo(String value) {
            addCriterion("tag_photo =", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoNotEqualTo(String value) {
            addCriterion("tag_photo <>", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoGreaterThan(String value) {
            addCriterion("tag_photo >", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoGreaterThanOrEqualTo(String value) {
            addCriterion("tag_photo >=", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoLessThan(String value) {
            addCriterion("tag_photo <", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoLessThanOrEqualTo(String value) {
            addCriterion("tag_photo <=", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoLike(String value) {
            addCriterion("tag_photo like", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoNotLike(String value) {
            addCriterion("tag_photo not like", value, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoIn(List<String> values) {
            addCriterion("tag_photo in", values, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoNotIn(List<String> values) {
            addCriterion("tag_photo not in", values, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoBetween(String value1, String value2) {
            addCriterion("tag_photo between", value1, value2, "tagPhoto");
            return (Criteria) this;
        }

        public Criteria andTagPhotoNotBetween(String value1, String value2) {
            addCriterion("tag_photo not between", value1, value2, "tagPhoto");
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