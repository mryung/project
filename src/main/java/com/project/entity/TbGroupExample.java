package com.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbGroupExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbGroupExample() {
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

        public Criteria andGroupNameIsNull() {
            addCriterion("group_name is null");
            return (Criteria) this;
        }

        public Criteria andGroupNameIsNotNull() {
            addCriterion("group_name is not null");
            return (Criteria) this;
        }

        public Criteria andGroupNameEqualTo(String value) {
            addCriterion("group_name =", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotEqualTo(String value) {
            addCriterion("group_name <>", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThan(String value) {
            addCriterion("group_name >", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameGreaterThanOrEqualTo(String value) {
            addCriterion("group_name >=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThan(String value) {
            addCriterion("group_name <", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLessThanOrEqualTo(String value) {
            addCriterion("group_name <=", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameLike(String value) {
            addCriterion("group_name like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotLike(String value) {
            addCriterion("group_name not like", value, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameIn(List<String> values) {
            addCriterion("group_name in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotIn(List<String> values) {
            addCriterion("group_name not in", values, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameBetween(String value1, String value2) {
            addCriterion("group_name between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupNameNotBetween(String value1, String value2) {
            addCriterion("group_name not between", value1, value2, "groupName");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdIsNull() {
            addCriterion("group_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdIsNotNull() {
            addCriterion("group_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdEqualTo(Integer value) {
            addCriterion("group_parent_id =", value, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdNotEqualTo(Integer value) {
            addCriterion("group_parent_id <>", value, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdGreaterThan(Integer value) {
            addCriterion("group_parent_id >", value, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("group_parent_id >=", value, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdLessThan(Integer value) {
            addCriterion("group_parent_id <", value, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("group_parent_id <=", value, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdIn(List<Integer> values) {
            addCriterion("group_parent_id in", values, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdNotIn(List<Integer> values) {
            addCriterion("group_parent_id not in", values, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdBetween(Integer value1, Integer value2) {
            addCriterion("group_parent_id between", value1, value2, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("group_parent_id not between", value1, value2, "groupParentId");
            return (Criteria) this;
        }

        public Criteria andGroupParentsIsNull() {
            addCriterion("group_parents is null");
            return (Criteria) this;
        }

        public Criteria andGroupParentsIsNotNull() {
            addCriterion("group_parents is not null");
            return (Criteria) this;
        }

        public Criteria andGroupParentsEqualTo(String value) {
            addCriterion("group_parents =", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsNotEqualTo(String value) {
            addCriterion("group_parents <>", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsGreaterThan(String value) {
            addCriterion("group_parents >", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsGreaterThanOrEqualTo(String value) {
            addCriterion("group_parents >=", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsLessThan(String value) {
            addCriterion("group_parents <", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsLessThanOrEqualTo(String value) {
            addCriterion("group_parents <=", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsLike(String value) {
            addCriterion("group_parents like", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsNotLike(String value) {
            addCriterion("group_parents not like", value, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsIn(List<String> values) {
            addCriterion("group_parents in", values, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsNotIn(List<String> values) {
            addCriterion("group_parents not in", values, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsBetween(String value1, String value2) {
            addCriterion("group_parents between", value1, value2, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupParentsNotBetween(String value1, String value2) {
            addCriterion("group_parents not between", value1, value2, "groupParents");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeIsNull() {
            addCriterion("group_gen_time is null");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeIsNotNull() {
            addCriterion("group_gen_time is not null");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeEqualTo(Date value) {
            addCriterion("group_gen_time =", value, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeNotEqualTo(Date value) {
            addCriterion("group_gen_time <>", value, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeGreaterThan(Date value) {
            addCriterion("group_gen_time >", value, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("group_gen_time >=", value, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeLessThan(Date value) {
            addCriterion("group_gen_time <", value, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeLessThanOrEqualTo(Date value) {
            addCriterion("group_gen_time <=", value, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeIn(List<Date> values) {
            addCriterion("group_gen_time in", values, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeNotIn(List<Date> values) {
            addCriterion("group_gen_time not in", values, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeBetween(Date value1, Date value2) {
            addCriterion("group_gen_time between", value1, value2, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupGenTimeNotBetween(Date value1, Date value2) {
            addCriterion("group_gen_time not between", value1, value2, "groupGenTime");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionIsNull() {
            addCriterion("group_description is null");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionIsNotNull() {
            addCriterion("group_description is not null");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionEqualTo(String value) {
            addCriterion("group_description =", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionNotEqualTo(String value) {
            addCriterion("group_description <>", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionGreaterThan(String value) {
            addCriterion("group_description >", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("group_description >=", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionLessThan(String value) {
            addCriterion("group_description <", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionLessThanOrEqualTo(String value) {
            addCriterion("group_description <=", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionLike(String value) {
            addCriterion("group_description like", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionNotLike(String value) {
            addCriterion("group_description not like", value, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionIn(List<String> values) {
            addCriterion("group_description in", values, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionNotIn(List<String> values) {
            addCriterion("group_description not in", values, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionBetween(String value1, String value2) {
            addCriterion("group_description between", value1, value2, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andGroupDescriptionNotBetween(String value1, String value2) {
            addCriterion("group_description not between", value1, value2, "groupDescription");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNull() {
            addCriterion("available is null");
            return (Criteria) this;
        }

        public Criteria andAvailableIsNotNull() {
            addCriterion("available is not null");
            return (Criteria) this;
        }

        public Criteria andAvailableEqualTo(Integer value) {
            addCriterion("available =", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotEqualTo(Integer value) {
            addCriterion("available <>", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThan(Integer value) {
            addCriterion("available >", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThanOrEqualTo(Integer value) {
            addCriterion("available >=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThan(Integer value) {
            addCriterion("available <", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThanOrEqualTo(Integer value) {
            addCriterion("available <=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableIn(List<Integer> values) {
            addCriterion("available in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotIn(List<Integer> values) {
            addCriterion("available not in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableBetween(Integer value1, Integer value2) {
            addCriterion("available between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotBetween(Integer value1, Integer value2) {
            addCriterion("available not between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIsNull() {
            addCriterion("group_code is null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIsNotNull() {
            addCriterion("group_code is not null");
            return (Criteria) this;
        }

        public Criteria andGroupCodeEqualTo(String value) {
            addCriterion("group_code =", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotEqualTo(String value) {
            addCriterion("group_code <>", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThan(String value) {
            addCriterion("group_code >", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeGreaterThanOrEqualTo(String value) {
            addCriterion("group_code >=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThan(String value) {
            addCriterion("group_code <", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLessThanOrEqualTo(String value) {
            addCriterion("group_code <=", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeLike(String value) {
            addCriterion("group_code like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotLike(String value) {
            addCriterion("group_code not like", value, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeIn(List<String> values) {
            addCriterion("group_code in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotIn(List<String> values) {
            addCriterion("group_code not in", values, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeBetween(String value1, String value2) {
            addCriterion("group_code between", value1, value2, "groupCode");
            return (Criteria) this;
        }

        public Criteria andGroupCodeNotBetween(String value1, String value2) {
            addCriterion("group_code not between", value1, value2, "groupCode");
            return (Criteria) this;
        }

        public Criteria andSortedIsNull() {
            addCriterion("sorted is null");
            return (Criteria) this;
        }

        public Criteria andSortedIsNotNull() {
            addCriterion("sorted is not null");
            return (Criteria) this;
        }

        public Criteria andSortedEqualTo(Byte value) {
            addCriterion("sorted =", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedNotEqualTo(Byte value) {
            addCriterion("sorted <>", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedGreaterThan(Byte value) {
            addCriterion("sorted >", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedGreaterThanOrEqualTo(Byte value) {
            addCriterion("sorted >=", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedLessThan(Byte value) {
            addCriterion("sorted <", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedLessThanOrEqualTo(Byte value) {
            addCriterion("sorted <=", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedIn(List<Byte> values) {
            addCriterion("sorted in", values, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedNotIn(List<Byte> values) {
            addCriterion("sorted not in", values, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedBetween(Byte value1, Byte value2) {
            addCriterion("sorted between", value1, value2, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedNotBetween(Byte value1, Byte value2) {
            addCriterion("sorted not between", value1, value2, "sorted");
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