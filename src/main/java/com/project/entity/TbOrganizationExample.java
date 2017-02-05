package com.project.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TbOrganizationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TbOrganizationExample() {
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

        public Criteria andOrgIdIsNull() {
            addCriterion("org_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgIdIsNotNull() {
            addCriterion("org_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgIdEqualTo(Integer value) {
            addCriterion("org_id =", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotEqualTo(Integer value) {
            addCriterion("org_id <>", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThan(Integer value) {
            addCriterion("org_id >", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_id >=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThan(Integer value) {
            addCriterion("org_id <", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdLessThanOrEqualTo(Integer value) {
            addCriterion("org_id <=", value, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdIn(List<Integer> values) {
            addCriterion("org_id in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotIn(List<Integer> values) {
            addCriterion("org_id not in", values, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdBetween(Integer value1, Integer value2) {
            addCriterion("org_id between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgIdNotBetween(Integer value1, Integer value2) {
            addCriterion("org_id not between", value1, value2, "orgId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdIsNull() {
            addCriterion("org_parent_id is null");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdIsNotNull() {
            addCriterion("org_parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdEqualTo(Integer value) {
            addCriterion("org_parent_id =", value, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdNotEqualTo(Integer value) {
            addCriterion("org_parent_id <>", value, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdGreaterThan(Integer value) {
            addCriterion("org_parent_id >", value, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("org_parent_id >=", value, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdLessThan(Integer value) {
            addCriterion("org_parent_id <", value, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdLessThanOrEqualTo(Integer value) {
            addCriterion("org_parent_id <=", value, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdIn(List<Integer> values) {
            addCriterion("org_parent_id in", values, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdNotIn(List<Integer> values) {
            addCriterion("org_parent_id not in", values, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdBetween(Integer value1, Integer value2) {
            addCriterion("org_parent_id between", value1, value2, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgParentIdNotBetween(Integer value1, Integer value2) {
            addCriterion("org_parent_id not between", value1, value2, "orgParentId");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNull() {
            addCriterion("org_name is null");
            return (Criteria) this;
        }

        public Criteria andOrgNameIsNotNull() {
            addCriterion("org_name is not null");
            return (Criteria) this;
        }

        public Criteria andOrgNameEqualTo(String value) {
            addCriterion("org_name =", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotEqualTo(String value) {
            addCriterion("org_name <>", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThan(String value) {
            addCriterion("org_name >", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameGreaterThanOrEqualTo(String value) {
            addCriterion("org_name >=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThan(String value) {
            addCriterion("org_name <", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLessThanOrEqualTo(String value) {
            addCriterion("org_name <=", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameLike(String value) {
            addCriterion("org_name like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotLike(String value) {
            addCriterion("org_name not like", value, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameIn(List<String> values) {
            addCriterion("org_name in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotIn(List<String> values) {
            addCriterion("org_name not in", values, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameBetween(String value1, String value2) {
            addCriterion("org_name between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgNameNotBetween(String value1, String value2) {
            addCriterion("org_name not between", value1, value2, "orgName");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeIsNull() {
            addCriterion("org_gen_time is null");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeIsNotNull() {
            addCriterion("org_gen_time is not null");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeEqualTo(Date value) {
            addCriterion("org_gen_time =", value, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeNotEqualTo(Date value) {
            addCriterion("org_gen_time <>", value, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeGreaterThan(Date value) {
            addCriterion("org_gen_time >", value, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("org_gen_time >=", value, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeLessThan(Date value) {
            addCriterion("org_gen_time <", value, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeLessThanOrEqualTo(Date value) {
            addCriterion("org_gen_time <=", value, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeIn(List<Date> values) {
            addCriterion("org_gen_time in", values, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeNotIn(List<Date> values) {
            addCriterion("org_gen_time not in", values, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeBetween(Date value1, Date value2) {
            addCriterion("org_gen_time between", value1, value2, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgGenTimeNotBetween(Date value1, Date value2) {
            addCriterion("org_gen_time not between", value1, value2, "orgGenTime");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionIsNull() {
            addCriterion("org_description is null");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionIsNotNull() {
            addCriterion("org_description is not null");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionEqualTo(String value) {
            addCriterion("org_description =", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionNotEqualTo(String value) {
            addCriterion("org_description <>", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionGreaterThan(String value) {
            addCriterion("org_description >", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("org_description >=", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionLessThan(String value) {
            addCriterion("org_description <", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionLessThanOrEqualTo(String value) {
            addCriterion("org_description <=", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionLike(String value) {
            addCriterion("org_description like", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionNotLike(String value) {
            addCriterion("org_description not like", value, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionIn(List<String> values) {
            addCriterion("org_description in", values, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionNotIn(List<String> values) {
            addCriterion("org_description not in", values, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionBetween(String value1, String value2) {
            addCriterion("org_description between", value1, value2, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgDescriptionNotBetween(String value1, String value2) {
            addCriterion("org_description not between", value1, value2, "orgDescription");
            return (Criteria) this;
        }

        public Criteria andOrgParentsIsNull() {
            addCriterion("org_parents is null");
            return (Criteria) this;
        }

        public Criteria andOrgParentsIsNotNull() {
            addCriterion("org_parents is not null");
            return (Criteria) this;
        }

        public Criteria andOrgParentsEqualTo(String value) {
            addCriterion("org_parents =", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsNotEqualTo(String value) {
            addCriterion("org_parents <>", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsGreaterThan(String value) {
            addCriterion("org_parents >", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsGreaterThanOrEqualTo(String value) {
            addCriterion("org_parents >=", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsLessThan(String value) {
            addCriterion("org_parents <", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsLessThanOrEqualTo(String value) {
            addCriterion("org_parents <=", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsLike(String value) {
            addCriterion("org_parents like", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsNotLike(String value) {
            addCriterion("org_parents not like", value, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsIn(List<String> values) {
            addCriterion("org_parents in", values, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsNotIn(List<String> values) {
            addCriterion("org_parents not in", values, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsBetween(String value1, String value2) {
            addCriterion("org_parents between", value1, value2, "orgParents");
            return (Criteria) this;
        }

        public Criteria andOrgParentsNotBetween(String value1, String value2) {
            addCriterion("org_parents not between", value1, value2, "orgParents");
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

        public Criteria andAvailableEqualTo(Byte value) {
            addCriterion("available =", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotEqualTo(Byte value) {
            addCriterion("available <>", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThan(Byte value) {
            addCriterion("available >", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableGreaterThanOrEqualTo(Byte value) {
            addCriterion("available >=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThan(Byte value) {
            addCriterion("available <", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableLessThanOrEqualTo(Byte value) {
            addCriterion("available <=", value, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableIn(List<Byte> values) {
            addCriterion("available in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotIn(List<Byte> values) {
            addCriterion("available not in", values, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableBetween(Byte value1, Byte value2) {
            addCriterion("available between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andAvailableNotBetween(Byte value1, Byte value2) {
            addCriterion("available not between", value1, value2, "available");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNull() {
            addCriterion("org_code is null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIsNotNull() {
            addCriterion("org_code is not null");
            return (Criteria) this;
        }

        public Criteria andOrgCodeEqualTo(String value) {
            addCriterion("org_code =", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotEqualTo(String value) {
            addCriterion("org_code <>", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThan(String value) {
            addCriterion("org_code >", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeGreaterThanOrEqualTo(String value) {
            addCriterion("org_code >=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThan(String value) {
            addCriterion("org_code <", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLessThanOrEqualTo(String value) {
            addCriterion("org_code <=", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeLike(String value) {
            addCriterion("org_code like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotLike(String value) {
            addCriterion("org_code not like", value, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeIn(List<String> values) {
            addCriterion("org_code in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotIn(List<String> values) {
            addCriterion("org_code not in", values, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeBetween(String value1, String value2) {
            addCriterion("org_code between", value1, value2, "orgCode");
            return (Criteria) this;
        }

        public Criteria andOrgCodeNotBetween(String value1, String value2) {
            addCriterion("org_code not between", value1, value2, "orgCode");
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