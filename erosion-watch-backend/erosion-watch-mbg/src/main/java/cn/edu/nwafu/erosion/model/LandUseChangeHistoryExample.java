package cn.edu.nwafu.erosion.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class LandUseChangeHistoryExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public LandUseChangeHistoryExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNull() {
            addCriterion("area_id is null");
            return (Criteria) this;
        }

        public Criteria andAreaIdIsNotNull() {
            addCriterion("area_id is not null");
            return (Criteria) this;
        }

        public Criteria andAreaIdEqualTo(Long value) {
            addCriterion("area_id =", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotEqualTo(Long value) {
            addCriterion("area_id <>", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThan(Long value) {
            addCriterion("area_id >", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdGreaterThanOrEqualTo(Long value) {
            addCriterion("area_id >=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThan(Long value) {
            addCriterion("area_id <", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdLessThanOrEqualTo(Long value) {
            addCriterion("area_id <=", value, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdIn(List<Long> values) {
            addCriterion("area_id in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotIn(List<Long> values) {
            addCriterion("area_id not in", values, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdBetween(Long value1, Long value2) {
            addCriterion("area_id between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andAreaIdNotBetween(Long value1, Long value2) {
            addCriterion("area_id not between", value1, value2, "areaId");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNull() {
            addCriterion("change_date is null");
            return (Criteria) this;
        }

        public Criteria andChangeDateIsNotNull() {
            addCriterion("change_date is not null");
            return (Criteria) this;
        }

        public Criteria andChangeDateEqualTo(Date value) {
            addCriterionForJDBCDate("change_date =", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("change_date <>", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThan(Date value) {
            addCriterionForJDBCDate("change_date >", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("change_date >=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThan(Date value) {
            addCriterionForJDBCDate("change_date <", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("change_date <=", value, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateIn(List<Date> values) {
            addCriterionForJDBCDate("change_date in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("change_date not in", values, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("change_date between", value1, value2, "changeDate");
            return (Criteria) this;
        }

        public Criteria andChangeDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("change_date not between", value1, value2, "changeDate");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseIsNull() {
            addCriterion("previous_land_use is null");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseIsNotNull() {
            addCriterion("previous_land_use is not null");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseEqualTo(String value) {
            addCriterion("previous_land_use =", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseNotEqualTo(String value) {
            addCriterion("previous_land_use <>", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseGreaterThan(String value) {
            addCriterion("previous_land_use >", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseGreaterThanOrEqualTo(String value) {
            addCriterion("previous_land_use >=", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseLessThan(String value) {
            addCriterion("previous_land_use <", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseLessThanOrEqualTo(String value) {
            addCriterion("previous_land_use <=", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseLike(String value) {
            addCriterion("previous_land_use like", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseNotLike(String value) {
            addCriterion("previous_land_use not like", value, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseIn(List<String> values) {
            addCriterion("previous_land_use in", values, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseNotIn(List<String> values) {
            addCriterion("previous_land_use not in", values, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseBetween(String value1, String value2) {
            addCriterion("previous_land_use between", value1, value2, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andPreviousLandUseNotBetween(String value1, String value2) {
            addCriterion("previous_land_use not between", value1, value2, "previousLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseIsNull() {
            addCriterion("current_land_use is null");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseIsNotNull() {
            addCriterion("current_land_use is not null");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseEqualTo(String value) {
            addCriterion("current_land_use =", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseNotEqualTo(String value) {
            addCriterion("current_land_use <>", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseGreaterThan(String value) {
            addCriterion("current_land_use >", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseGreaterThanOrEqualTo(String value) {
            addCriterion("current_land_use >=", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseLessThan(String value) {
            addCriterion("current_land_use <", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseLessThanOrEqualTo(String value) {
            addCriterion("current_land_use <=", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseLike(String value) {
            addCriterion("current_land_use like", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseNotLike(String value) {
            addCriterion("current_land_use not like", value, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseIn(List<String> values) {
            addCriterion("current_land_use in", values, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseNotIn(List<String> values) {
            addCriterion("current_land_use not in", values, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseBetween(String value1, String value2) {
            addCriterion("current_land_use between", value1, value2, "currentLandUse");
            return (Criteria) this;
        }

        public Criteria andCurrentLandUseNotBetween(String value1, String value2) {
            addCriterion("current_land_use not between", value1, value2, "currentLandUse");
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