package com.project.entity.project;

import java.util.ArrayList;
import java.util.List;

public class TmrWindElcpower201702Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TmrWindElcpower201702Example() {
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

        public Criteria andMeterpointnoIsNull() {
            addCriterion("Meterpointno is null");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoIsNotNull() {
            addCriterion("Meterpointno is not null");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoEqualTo(Integer value) {
            addCriterion("Meterpointno =", value, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoNotEqualTo(Integer value) {
            addCriterion("Meterpointno <>", value, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoGreaterThan(Integer value) {
            addCriterion("Meterpointno >", value, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoGreaterThanOrEqualTo(Integer value) {
            addCriterion("Meterpointno >=", value, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoLessThan(Integer value) {
            addCriterion("Meterpointno <", value, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoLessThanOrEqualTo(Integer value) {
            addCriterion("Meterpointno <=", value, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoIn(List<Integer> values) {
            addCriterion("Meterpointno in", values, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoNotIn(List<Integer> values) {
            addCriterion("Meterpointno not in", values, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoBetween(Integer value1, Integer value2) {
            addCriterion("Meterpointno between", value1, value2, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andMeterpointnoNotBetween(Integer value1, Integer value2) {
            addCriterion("Meterpointno not between", value1, value2, "meterpointno");
            return (Criteria) this;
        }

        public Criteria andClecttimeIsNull() {
            addCriterion("CLECTTIME is null");
            return (Criteria) this;
        }

        public Criteria andClecttimeIsNotNull() {
            addCriterion("CLECTTIME is not null");
            return (Criteria) this;
        }

        public Criteria andClecttimeEqualTo(Integer value) {
            addCriterion("CLECTTIME =", value, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeNotEqualTo(Integer value) {
            addCriterion("CLECTTIME <>", value, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeGreaterThan(Integer value) {
            addCriterion("CLECTTIME >", value, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("CLECTTIME >=", value, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeLessThan(Integer value) {
            addCriterion("CLECTTIME <", value, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeLessThanOrEqualTo(Integer value) {
            addCriterion("CLECTTIME <=", value, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeIn(List<Integer> values) {
            addCriterion("CLECTTIME in", values, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeNotIn(List<Integer> values) {
            addCriterion("CLECTTIME not in", values, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeBetween(Integer value1, Integer value2) {
            addCriterion("CLECTTIME between", value1, value2, "clecttime");
            return (Criteria) this;
        }

        public Criteria andClecttimeNotBetween(Integer value1, Integer value2) {
            addCriterion("CLECTTIME not between", value1, value2, "clecttime");
            return (Criteria) this;
        }

        public Criteria andWhpcodeIsNull() {
            addCriterion("WHPCODE is null");
            return (Criteria) this;
        }

        public Criteria andWhpcodeIsNotNull() {
            addCriterion("WHPCODE is not null");
            return (Criteria) this;
        }

        public Criteria andWhpcodeEqualTo(Double value) {
            addCriterion("WHPCODE =", value, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeNotEqualTo(Double value) {
            addCriterion("WHPCODE <>", value, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeGreaterThan(Double value) {
            addCriterion("WHPCODE >", value, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeGreaterThanOrEqualTo(Double value) {
            addCriterion("WHPCODE >=", value, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeLessThan(Double value) {
            addCriterion("WHPCODE <", value, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeLessThanOrEqualTo(Double value) {
            addCriterion("WHPCODE <=", value, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeIn(List<Double> values) {
            addCriterion("WHPCODE in", values, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeNotIn(List<Double> values) {
            addCriterion("WHPCODE not in", values, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeBetween(Double value1, Double value2) {
            addCriterion("WHPCODE between", value1, value2, "whpcode");
            return (Criteria) this;
        }

        public Criteria andWhpcodeNotBetween(Double value1, Double value2) {
            addCriterion("WHPCODE not between", value1, value2, "whpcode");
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