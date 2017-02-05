package com.project.entity;

import java.util.ArrayList;
import java.util.List;

public class TbUserGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbUserGroupExample() {
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

        public Criteria andUserGroupIdIsNull() {
            addCriterion("user_group_id is null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIsNotNull() {
            addCriterion("user_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdEqualTo(Integer value) {
            addCriterion("user_group_id =", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotEqualTo(Integer value) {
            addCriterion("user_group_id <>", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThan(Integer value) {
            addCriterion("user_group_id >", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_group_id >=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThan(Integer value) {
            addCriterion("user_group_id <", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_group_id <=", value, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdIn(List<Integer> values) {
            addCriterion("user_group_id in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotIn(List<Integer> values) {
            addCriterion("user_group_id not in", values, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("user_group_id between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andUserGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_group_id not between", value1, value2, "userGroupId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdIsNull() {
            addCriterion("tb_user_id is null");
            return (Criteria) this;
        }

        public Criteria andTbUserIdIsNotNull() {
            addCriterion("tb_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbUserIdEqualTo(Integer value) {
            addCriterion("tb_user_id =", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdNotEqualTo(Integer value) {
            addCriterion("tb_user_id <>", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdGreaterThan(Integer value) {
            addCriterion("tb_user_id >", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_user_id >=", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdLessThan(Integer value) {
            addCriterion("tb_user_id <", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("tb_user_id <=", value, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdIn(List<Integer> values) {
            addCriterion("tb_user_id in", values, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdNotIn(List<Integer> values) {
            addCriterion("tb_user_id not in", values, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdBetween(Integer value1, Integer value2) {
            addCriterion("tb_user_id between", value1, value2, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_user_id not between", value1, value2, "tbUserId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdIsNull() {
            addCriterion("tb_group_id is null");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdIsNotNull() {
            addCriterion("tb_group_id is not null");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdEqualTo(Integer value) {
            addCriterion("tb_group_id =", value, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdNotEqualTo(Integer value) {
            addCriterion("tb_group_id <>", value, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdGreaterThan(Integer value) {
            addCriterion("tb_group_id >", value, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("tb_group_id >=", value, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdLessThan(Integer value) {
            addCriterion("tb_group_id <", value, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdLessThanOrEqualTo(Integer value) {
            addCriterion("tb_group_id <=", value, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdIn(List<Integer> values) {
            addCriterion("tb_group_id in", values, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdNotIn(List<Integer> values) {
            addCriterion("tb_group_id not in", values, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdBetween(Integer value1, Integer value2) {
            addCriterion("tb_group_id between", value1, value2, "tbGroupId");
            return (Criteria) this;
        }

        public Criteria andTbGroupIdNotBetween(Integer value1, Integer value2) {
            addCriterion("tb_group_id not between", value1, value2, "tbGroupId");
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