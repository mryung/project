package com.project.entity;

import java.util.ArrayList;
import java.util.List;

public class TbRightExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRightExample() {
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

        public Criteria andRightParentIdIsNull() {
            addCriterion("right_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andRightParentIdIsNotNull() {
            addCriterion("right_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andRightParentIdEqualTo(Integer value) {
            addCriterion("right_parent_id =", value, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdNotEqualTo(Integer value) {
            addCriterion("right_parent_id <>", value, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdGreaterThan(Integer value) {
            addCriterion("right_parent_id >", value, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("right_parent_id >=", value, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdLessThan(Integer value) {
            addCriterion("right_parent_id <", value, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("right_parent_id <=", value, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdIn(List<Integer> values) {
            addCriterion("right_parent_id in", values, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdNotIn(List<Integer> values) {
            addCriterion("right_parent_id not in", values, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdBetween(Integer value1, Integer value2) {
            addCriterion("right_parent_id between", value1, value2, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("right_parent_id not between", value1, value2, "rightParentId");
            return (Criteria) this;
        }

        public Criteria andRightParentsIsNull() {
            addCriterion("right_parents is null");
            return (Criteria) this;
        }

        public Criteria andRightParentsIsNotNull() {
            addCriterion("right_parents is not null");
            return (Criteria) this;
        }

        public Criteria andRightParentsEqualTo(String value) {
            addCriterion("right_parents =", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsNotEqualTo(String value) {
            addCriterion("right_parents <>", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsGreaterThan(String value) {
            addCriterion("right_parents >", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsGreaterThanOrEqualTo(String value) {
            addCriterion("right_parents >=", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsLessThan(String value) {
            addCriterion("right_parents <", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsLessThanOrEqualTo(String value) {
            addCriterion("right_parents <=", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsLike(String value) {
            addCriterion("right_parents like", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsNotLike(String value) {
            addCriterion("right_parents not like", value, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsIn(List<String> values) {
            addCriterion("right_parents in", values, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsNotIn(List<String> values) {
            addCriterion("right_parents not in", values, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsBetween(String value1, String value2) {
            addCriterion("right_parents between", value1, value2, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightParentsNotBetween(String value1, String value2) {
            addCriterion("right_parents not between", value1, value2, "rightParents");
            return (Criteria) this;
        }

        public Criteria andRightNameIsNull() {
            addCriterion("right_name is null");
            return (Criteria) this;
        }

        public Criteria andRightNameIsNotNull() {
            addCriterion("right_name is not null");
            return (Criteria) this;
        }

        public Criteria andRightNameEqualTo(String value) {
            addCriterion("right_name =", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameNotEqualTo(String value) {
            addCriterion("right_name <>", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameGreaterThan(String value) {
            addCriterion("right_name >", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameGreaterThanOrEqualTo(String value) {
            addCriterion("right_name >=", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameLessThan(String value) {
            addCriterion("right_name <", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameLessThanOrEqualTo(String value) {
            addCriterion("right_name <=", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameLike(String value) {
            addCriterion("right_name like", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameNotLike(String value) {
            addCriterion("right_name not like", value, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameIn(List<String> values) {
            addCriterion("right_name in", values, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameNotIn(List<String> values) {
            addCriterion("right_name not in", values, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameBetween(String value1, String value2) {
            addCriterion("right_name between", value1, value2, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightNameNotBetween(String value1, String value2) {
            addCriterion("right_name not between", value1, value2, "rightName");
            return (Criteria) this;
        }

        public Criteria andRightUrlIsNull() {
            addCriterion("right_url is null");
            return (Criteria) this;
        }

        public Criteria andRightUrlIsNotNull() {
            addCriterion("right_url is not null");
            return (Criteria) this;
        }

        public Criteria andRightUrlEqualTo(String value) {
            addCriterion("right_url =", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlNotEqualTo(String value) {
            addCriterion("right_url <>", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlGreaterThan(String value) {
            addCriterion("right_url >", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlGreaterThanOrEqualTo(String value) {
            addCriterion("right_url >=", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlLessThan(String value) {
            addCriterion("right_url <", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlLessThanOrEqualTo(String value) {
            addCriterion("right_url <=", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlLike(String value) {
            addCriterion("right_url like", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlNotLike(String value) {
            addCriterion("right_url not like", value, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlIn(List<String> values) {
            addCriterion("right_url in", values, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlNotIn(List<String> values) {
            addCriterion("right_url not in", values, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlBetween(String value1, String value2) {
            addCriterion("right_url between", value1, value2, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightUrlNotBetween(String value1, String value2) {
            addCriterion("right_url not between", value1, value2, "rightUrl");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionIsNull() {
            addCriterion("right_description is null");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionIsNotNull() {
            addCriterion("right_description is not null");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionEqualTo(String value) {
            addCriterion("right_description =", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionNotEqualTo(String value) {
            addCriterion("right_description <>", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionGreaterThan(String value) {
            addCriterion("right_description >", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("right_description >=", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionLessThan(String value) {
            addCriterion("right_description <", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionLessThanOrEqualTo(String value) {
            addCriterion("right_description <=", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionLike(String value) {
            addCriterion("right_description like", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionNotLike(String value) {
            addCriterion("right_description not like", value, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionIn(List<String> values) {
            addCriterion("right_description in", values, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionNotIn(List<String> values) {
            addCriterion("right_description not in", values, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionBetween(String value1, String value2) {
            addCriterion("right_description between", value1, value2, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightDescriptionNotBetween(String value1, String value2) {
            addCriterion("right_description not between", value1, value2, "rightDescription");
            return (Criteria) this;
        }

        public Criteria andRightCodeIsNull() {
            addCriterion("right_code is null");
            return (Criteria) this;
        }

        public Criteria andRightCodeIsNotNull() {
            addCriterion("right_code is not null");
            return (Criteria) this;
        }

        public Criteria andRightCodeEqualTo(String value) {
            addCriterion("right_code =", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotEqualTo(String value) {
            addCriterion("right_code <>", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeGreaterThan(String value) {
            addCriterion("right_code >", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeGreaterThanOrEqualTo(String value) {
            addCriterion("right_code >=", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeLessThan(String value) {
            addCriterion("right_code <", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeLessThanOrEqualTo(String value) {
            addCriterion("right_code <=", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeLike(String value) {
            addCriterion("right_code like", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotLike(String value) {
            addCriterion("right_code not like", value, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeIn(List<String> values) {
            addCriterion("right_code in", values, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotIn(List<String> values) {
            addCriterion("right_code not in", values, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeBetween(String value1, String value2) {
            addCriterion("right_code between", value1, value2, "rightCode");
            return (Criteria) this;
        }

        public Criteria andRightCodeNotBetween(String value1, String value2) {
            addCriterion("right_code not between", value1, value2, "rightCode");
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

        public Criteria andSortedIsNull() {
            addCriterion("sorted is null");
            return (Criteria) this;
        }

        public Criteria andSortedIsNotNull() {
            addCriterion("sorted is not null");
            return (Criteria) this;
        }

        public Criteria andSortedEqualTo(Integer value) {
            addCriterion("sorted =", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedNotEqualTo(Integer value) {
            addCriterion("sorted <>", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedGreaterThan(Integer value) {
            addCriterion("sorted >", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedGreaterThanOrEqualTo(Integer value) {
            addCriterion("sorted >=", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedLessThan(Integer value) {
            addCriterion("sorted <", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedLessThanOrEqualTo(Integer value) {
            addCriterion("sorted <=", value, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedIn(List<Integer> values) {
            addCriterion("sorted in", values, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedNotIn(List<Integer> values) {
            addCriterion("sorted not in", values, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedBetween(Integer value1, Integer value2) {
            addCriterion("sorted between", value1, value2, "sorted");
            return (Criteria) this;
        }

        public Criteria andSortedNotBetween(Integer value1, Integer value2) {
            addCriterion("sorted not between", value1, value2, "sorted");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNull() {
            addCriterion("is_show is null");
            return (Criteria) this;
        }

        public Criteria andIsShowIsNotNull() {
            addCriterion("is_show is not null");
            return (Criteria) this;
        }

        public Criteria andIsShowEqualTo(Byte value) {
            addCriterion("is_show =", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotEqualTo(Byte value) {
            addCriterion("is_show <>", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThan(Byte value) {
            addCriterion("is_show >", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowGreaterThanOrEqualTo(Byte value) {
            addCriterion("is_show >=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThan(Byte value) {
            addCriterion("is_show <", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowLessThanOrEqualTo(Byte value) {
            addCriterion("is_show <=", value, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowIn(List<Byte> values) {
            addCriterion("is_show in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotIn(List<Byte> values) {
            addCriterion("is_show not in", values, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowBetween(Byte value1, Byte value2) {
            addCriterion("is_show between", value1, value2, "isShow");
            return (Criteria) this;
        }

        public Criteria andIsShowNotBetween(Byte value1, Byte value2) {
            addCriterion("is_show not between", value1, value2, "isShow");
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