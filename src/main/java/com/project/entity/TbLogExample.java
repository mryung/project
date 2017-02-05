package com.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbLogExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbLogExample() {
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

        public Criteria andLogIdIsNull() {
            addCriterion("log_id is null");
            return (Criteria) this;
        }

        public Criteria andLogIdIsNotNull() {
            addCriterion("log_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogIdEqualTo(Integer value) {
            addCriterion("log_id =", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotEqualTo(Integer value) {
            addCriterion("log_id <>", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThan(Integer value) {
            addCriterion("log_id >", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_id >=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThan(Integer value) {
            addCriterion("log_id <", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_id <=", value, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdIn(List<Integer> values) {
            addCriterion("log_id in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotIn(List<Integer> values) {
            addCriterion("log_id not in", values, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdBetween(Integer value1, Integer value2) {
            addCriterion("log_id between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_id not between", value1, value2, "logId");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeIsNull() {
            addCriterion("log_operate_type is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeIsNotNull() {
            addCriterion("log_operate_type is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeEqualTo(Integer value) {
            addCriterion("log_operate_type =", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeNotEqualTo(Integer value) {
            addCriterion("log_operate_type <>", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeGreaterThan(Integer value) {
            addCriterion("log_operate_type >", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_operate_type >=", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeLessThan(Integer value) {
            addCriterion("log_operate_type <", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeLessThanOrEqualTo(Integer value) {
            addCriterion("log_operate_type <=", value, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeIn(List<Integer> values) {
            addCriterion("log_operate_type in", values, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeNotIn(List<Integer> values) {
            addCriterion("log_operate_type not in", values, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeBetween(Integer value1, Integer value2) {
            addCriterion("log_operate_type between", value1, value2, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("log_operate_type not between", value1, value2, "logOperateType");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentIsNull() {
            addCriterion("log_operate_content is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentIsNotNull() {
            addCriterion("log_operate_content is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentEqualTo(String value) {
            addCriterion("log_operate_content =", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentNotEqualTo(String value) {
            addCriterion("log_operate_content <>", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentGreaterThan(String value) {
            addCriterion("log_operate_content >", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentGreaterThanOrEqualTo(String value) {
            addCriterion("log_operate_content >=", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentLessThan(String value) {
            addCriterion("log_operate_content <", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentLessThanOrEqualTo(String value) {
            addCriterion("log_operate_content <=", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentLike(String value) {
            addCriterion("log_operate_content like", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentNotLike(String value) {
            addCriterion("log_operate_content not like", value, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentIn(List<String> values) {
            addCriterion("log_operate_content in", values, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentNotIn(List<String> values) {
            addCriterion("log_operate_content not in", values, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentBetween(String value1, String value2) {
            addCriterion("log_operate_content between", value1, value2, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateContentNotBetween(String value1, String value2) {
            addCriterion("log_operate_content not between", value1, value2, "logOperateContent");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdIsNull() {
            addCriterion("log_operate_user_id is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdIsNotNull() {
            addCriterion("log_operate_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdEqualTo(Integer value) {
            addCriterion("log_operate_user_id =", value, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdNotEqualTo(Integer value) {
            addCriterion("log_operate_user_id <>", value, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdGreaterThan(Integer value) {
            addCriterion("log_operate_user_id >", value, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("log_operate_user_id >=", value, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdLessThan(Integer value) {
            addCriterion("log_operate_user_id <", value, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("log_operate_user_id <=", value, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdIn(List<Integer> values) {
            addCriterion("log_operate_user_id in", values, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdNotIn(List<Integer> values) {
            addCriterion("log_operate_user_id not in", values, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdBetween(Integer value1, Integer value2) {
            addCriterion("log_operate_user_id between", value1, value2, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("log_operate_user_id not between", value1, value2, "logOperateUserId");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeIsNull() {
            addCriterion("log_operate_time is null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeIsNotNull() {
            addCriterion("log_operate_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeEqualTo(Date value) {
            addCriterion("log_operate_time =", value, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeNotEqualTo(Date value) {
            addCriterion("log_operate_time <>", value, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeGreaterThan(Date value) {
            addCriterion("log_operate_time >", value, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_operate_time >=", value, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeLessThan(Date value) {
            addCriterion("log_operate_time <", value, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_operate_time <=", value, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeIn(List<Date> values) {
            addCriterion("log_operate_time in", values, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeNotIn(List<Date> values) {
            addCriterion("log_operate_time not in", values, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeBetween(Date value1, Date value2) {
            addCriterion("log_operate_time between", value1, value2, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogOperateTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_operate_time not between", value1, value2, "logOperateTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNull() {
            addCriterion("log_time is null");
            return (Criteria) this;
        }

        public Criteria andLogTimeIsNotNull() {
            addCriterion("log_time is not null");
            return (Criteria) this;
        }

        public Criteria andLogTimeEqualTo(Date value) {
            addCriterion("log_time =", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotEqualTo(Date value) {
            addCriterion("log_time <>", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThan(Date value) {
            addCriterion("log_time >", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("log_time >=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThan(Date value) {
            addCriterion("log_time <", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeLessThanOrEqualTo(Date value) {
            addCriterion("log_time <=", value, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeIn(List<Date> values) {
            addCriterion("log_time in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotIn(List<Date> values) {
            addCriterion("log_time not in", values, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeBetween(Date value1, Date value2) {
            addCriterion("log_time between", value1, value2, "logTime");
            return (Criteria) this;
        }

        public Criteria andLogTimeNotBetween(Date value1, Date value2) {
            addCriterion("log_time not between", value1, value2, "logTime");
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