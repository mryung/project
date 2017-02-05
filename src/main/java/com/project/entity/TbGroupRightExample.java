package com.project.entity;

import java.util.ArrayList;
import java.util.List;

public class TbGroupRightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGroupRightExample() {
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

        public Criteria andGroupRightIdIsNull() {
            addCriterion("group_right_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdIsNotNull() {
            addCriterion("group_right_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdEqualTo(Integer value) {
            addCriterion("group_right_id =", value, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdNotEqualTo(Integer value) {
            addCriterion("group_right_id <>", value, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdGreaterThan(Integer value) {
            addCriterion("group_right_id >", value, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_right_id >=", value, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdLessThan(Integer value) {
            addCriterion("group_right_id <", value, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_right_id <=", value, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdIn(List<Integer> values) {
            addCriterion("group_right_id in", values, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdNotIn(List<Integer> values) {
            addCriterion("group_right_id not in", values, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdBetween(Integer value1, Integer value2) {
            addCriterion("group_right_id between", value1, value2, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupRightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_right_id not between", value1, value2, "groupRightId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(Integer value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(Integer value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(Integer value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(Integer value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<Integer> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<Integer> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andRightIdIsNull() {
            addCriterion("right_id is null");
            return (Criteria) this;
        }

        public Criteria andRightIdIsNotNull() {
            addCriterion("right_id is not null");
            return (Criteria) this;
        }

        public Criteria andRightIdEqualTo(Integer value) {
            addCriterion("right_id =", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdNotEqualTo(Integer value) {
            addCriterion("right_id <>", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdGreaterThan(Integer value) {
            addCriterion("right_id >", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("right_id >=", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdLessThan(Integer value) {
            addCriterion("right_id <", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdLessThanOrEqualTo(Integer value) {
            addCriterion("right_id <=", value, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdIn(List<Integer> values) {
            addCriterion("right_id in", values, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdNotIn(List<Integer> values) {
            addCriterion("right_id not in", values, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdBetween(Integer value1, Integer value2) {
            addCriterion("right_id between", value1, value2, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightIdNotBetween(Integer value1, Integer value2) {
            addCriterion("right_id not between", value1, value2, "rightId");
            return (Criteria) this;
        }

        public Criteria andRightTypeIsNull() {
            addCriterion("right_type is null");
            return (Criteria) this;
        }

        public Criteria andRightTypeIsNotNull() {
            addCriterion("right_type is not null");
            return (Criteria) this;
        }

        public Criteria andRightTypeEqualTo(Integer value) {
            addCriterion("right_type =", value, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeNotEqualTo(Integer value) {
            addCriterion("right_type <>", value, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeGreaterThan(Integer value) {
            addCriterion("right_type >", value, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("right_type >=", value, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeLessThan(Integer value) {
            addCriterion("right_type <", value, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeLessThanOrEqualTo(Integer value) {
            addCriterion("right_type <=", value, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeIn(List<Integer> values) {
            addCriterion("right_type in", values, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeNotIn(List<Integer> values) {
            addCriterion("right_type not in", values, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeBetween(Integer value1, Integer value2) {
            addCriterion("right_type between", value1, value2, "rightType");
            return (Criteria) this;
        }

        public Criteria andRightTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("right_type not between", value1, value2, "rightType");
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