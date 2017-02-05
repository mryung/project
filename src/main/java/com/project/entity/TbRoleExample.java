package com.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbRoleExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbRoleExample() {
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

        public Criteria andRoleIdIsNull() {
            addCriterion("role_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleIdIsNotNull() {
            addCriterion("role_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleIdEqualTo(Integer value) {
            addCriterion("role_id =", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotEqualTo(Integer value) {
            addCriterion("role_id <>", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThan(Integer value) {
            addCriterion("role_id >", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_id >=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThan(Integer value) {
            addCriterion("role_id <", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_id <=", value, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdIn(List<Integer> values) {
            addCriterion("role_id in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotIn(List<Integer> values) {
            addCriterion("role_id not in", values, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdBetween(Integer value1, Integer value2) {
            addCriterion("role_id between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_id not between", value1, value2, "roleId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdIsNull() {
            addCriterion("role_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdIsNotNull() {
            addCriterion("role_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdEqualTo(Integer value) {
            addCriterion("role_parent_id =", value, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdNotEqualTo(Integer value) {
            addCriterion("role_parent_id <>", value, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdGreaterThan(Integer value) {
            addCriterion("role_parent_id >", value, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("role_parent_id >=", value, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdLessThan(Integer value) {
            addCriterion("role_parent_id <", value, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("role_parent_id <=", value, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdIn(List<Integer> values) {
            addCriterion("role_parent_id in", values, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdNotIn(List<Integer> values) {
            addCriterion("role_parent_id not in", values, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdBetween(Integer value1, Integer value2) {
            addCriterion("role_parent_id between", value1, value2, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("role_parent_id not between", value1, value2, "roleParentId");
            return (Criteria) this;
        }

        public Criteria andRoleParentsIsNull() {
            addCriterion("role_parents is null");
            return (Criteria) this;
        }

        public Criteria andRoleParentsIsNotNull() {
            addCriterion("role_parents is not null");
            return (Criteria) this;
        }

        public Criteria andRoleParentsEqualTo(String value) {
            addCriterion("role_parents =", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsNotEqualTo(String value) {
            addCriterion("role_parents <>", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsGreaterThan(String value) {
            addCriterion("role_parents >", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsGreaterThanOrEqualTo(String value) {
            addCriterion("role_parents >=", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsLessThan(String value) {
            addCriterion("role_parents <", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsLessThanOrEqualTo(String value) {
            addCriterion("role_parents <=", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsLike(String value) {
            addCriterion("role_parents like", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsNotLike(String value) {
            addCriterion("role_parents not like", value, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsIn(List<String> values) {
            addCriterion("role_parents in", values, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsNotIn(List<String> values) {
            addCriterion("role_parents not in", values, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsBetween(String value1, String value2) {
            addCriterion("role_parents between", value1, value2, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleParentsNotBetween(String value1, String value2) {
            addCriterion("role_parents not between", value1, value2, "roleParents");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNull() {
            addCriterion("role_name is null");
            return (Criteria) this;
        }

        public Criteria andRoleNameIsNotNull() {
            addCriterion("role_name is not null");
            return (Criteria) this;
        }

        public Criteria andRoleNameEqualTo(String value) {
            addCriterion("role_name =", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotEqualTo(String value) {
            addCriterion("role_name <>", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThan(String value) {
            addCriterion("role_name >", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameGreaterThanOrEqualTo(String value) {
            addCriterion("role_name >=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThan(String value) {
            addCriterion("role_name <", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLessThanOrEqualTo(String value) {
            addCriterion("role_name <=", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameLike(String value) {
            addCriterion("role_name like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotLike(String value) {
            addCriterion("role_name not like", value, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameIn(List<String> values) {
            addCriterion("role_name in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotIn(List<String> values) {
            addCriterion("role_name not in", values, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameBetween(String value1, String value2) {
            addCriterion("role_name between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleNameNotBetween(String value1, String value2) {
            addCriterion("role_name not between", value1, value2, "roleName");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeIsNull() {
            addCriterion("role_gen_time is null");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeIsNotNull() {
            addCriterion("role_gen_time is not null");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeEqualTo(Date value) {
            addCriterion("role_gen_time =", value, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeNotEqualTo(Date value) {
            addCriterion("role_gen_time <>", value, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeGreaterThan(Date value) {
            addCriterion("role_gen_time >", value, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("role_gen_time >=", value, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeLessThan(Date value) {
            addCriterion("role_gen_time <", value, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeLessThanOrEqualTo(Date value) {
            addCriterion("role_gen_time <=", value, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeIn(List<Date> values) {
            addCriterion("role_gen_time in", values, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeNotIn(List<Date> values) {
            addCriterion("role_gen_time not in", values, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeBetween(Date value1, Date value2) {
            addCriterion("role_gen_time between", value1, value2, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleGenTimeNotBetween(Date value1, Date value2) {
            addCriterion("role_gen_time not between", value1, value2, "roleGenTime");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionIsNull() {
            addCriterion("role_description is null");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionIsNotNull() {
            addCriterion("role_description is not null");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionEqualTo(String value) {
            addCriterion("role_description =", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotEqualTo(String value) {
            addCriterion("role_description <>", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionGreaterThan(String value) {
            addCriterion("role_description >", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("role_description >=", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionLessThan(String value) {
            addCriterion("role_description <", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionLessThanOrEqualTo(String value) {
            addCriterion("role_description <=", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionLike(String value) {
            addCriterion("role_description like", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotLike(String value) {
            addCriterion("role_description not like", value, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionIn(List<String> values) {
            addCriterion("role_description in", values, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotIn(List<String> values) {
            addCriterion("role_description not in", values, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionBetween(String value1, String value2) {
            addCriterion("role_description between", value1, value2, "roleDescription");
            return (Criteria) this;
        }

        public Criteria andRoleDescriptionNotBetween(String value1, String value2) {
            addCriterion("role_description not between", value1, value2, "roleDescription");
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

        public Criteria andAvailableEqualTo(String value) {
            addCriterion("available =", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotEqualTo(String value) {
            addCriterion("available <>", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThan(String value) {
            addCriterion("available >", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThanOrEqualTo(String value) {
            addCriterion("available >=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThan(String value) {
            addCriterion("available <", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThanOrEqualTo(String value) {
            addCriterion("available <=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLike(String value) {
            addCriterion("available like", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotLike(String value) {
            addCriterion("available not like", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableIn(List<String> values) {
            addCriterion("available in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotIn(List<String> values) {
            addCriterion("available not in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableBetween(String value1, String value2) {
            addCriterion("available between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotBetween(String value1, String value2) {
            addCriterion("available not between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNull() {
            addCriterion("role_code is null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIsNotNull() {
            addCriterion("role_code is not null");
            return (Criteria) this;
        }

        public Criteria andRoleCodeEqualTo(String value) {
            addCriterion("role_code =", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotEqualTo(String value) {
            addCriterion("role_code <>", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThan(String value) {
            addCriterion("role_code >", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeGreaterThanOrEqualTo(String value) {
            addCriterion("role_code >=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThan(String value) {
            addCriterion("role_code <", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLessThanOrEqualTo(String value) {
            addCriterion("role_code <=", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeLike(String value) {
            addCriterion("role_code like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotLike(String value) {
            addCriterion("role_code not like", value, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeIn(List<String> values) {
            addCriterion("role_code in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotIn(List<String> values) {
            addCriterion("role_code not in", values, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeBetween(String value1, String value2) {
            addCriterion("role_code between", value1, value2, "roleCode");
            return (Criteria) this;
        }

        public Criteria andRoleCodeNotBetween(String value1, String value2) {
            addCriterion("role_code not between", value1, value2, "roleCode");
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