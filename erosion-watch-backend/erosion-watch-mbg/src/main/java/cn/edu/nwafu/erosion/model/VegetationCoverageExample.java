package cn.edu.nwafu.erosion.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class VegetationCoverageExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public VegetationCoverageExample() {
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

        public Criteria andVegetationTypeIsNull() {
            addCriterion("vegetation_type is null");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeIsNotNull() {
            addCriterion("vegetation_type is not null");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeEqualTo(String value) {
            addCriterion("vegetation_type =", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeNotEqualTo(String value) {
            addCriterion("vegetation_type <>", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeGreaterThan(String value) {
            addCriterion("vegetation_type >", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeGreaterThanOrEqualTo(String value) {
            addCriterion("vegetation_type >=", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeLessThan(String value) {
            addCriterion("vegetation_type <", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeLessThanOrEqualTo(String value) {
            addCriterion("vegetation_type <=", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeLike(String value) {
            addCriterion("vegetation_type like", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeNotLike(String value) {
            addCriterion("vegetation_type not like", value, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeIn(List<String> values) {
            addCriterion("vegetation_type in", values, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeNotIn(List<String> values) {
            addCriterion("vegetation_type not in", values, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeBetween(String value1, String value2) {
            addCriterion("vegetation_type between", value1, value2, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andVegetationTypeNotBetween(String value1, String value2) {
            addCriterion("vegetation_type not between", value1, value2, "vegetationType");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageIsNull() {
            addCriterion("coverage_percentage is null");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageIsNotNull() {
            addCriterion("coverage_percentage is not null");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageEqualTo(BigDecimal value) {
            addCriterion("coverage_percentage =", value, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageNotEqualTo(BigDecimal value) {
            addCriterion("coverage_percentage <>", value, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageGreaterThan(BigDecimal value) {
            addCriterion("coverage_percentage >", value, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("coverage_percentage >=", value, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageLessThan(BigDecimal value) {
            addCriterion("coverage_percentage <", value, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageLessThanOrEqualTo(BigDecimal value) {
            addCriterion("coverage_percentage <=", value, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageIn(List<BigDecimal> values) {
            addCriterion("coverage_percentage in", values, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageNotIn(List<BigDecimal> values) {
            addCriterion("coverage_percentage not in", values, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coverage_percentage between", value1, value2, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andCoveragePercentageNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("coverage_percentage not between", value1, value2, "coveragePercentage");
            return (Criteria) this;
        }

        public Criteria andDensityIsNull() {
            addCriterion("density is null");
            return (Criteria) this;
        }

        public Criteria andDensityIsNotNull() {
            addCriterion("density is not null");
            return (Criteria) this;
        }

        public Criteria andDensityEqualTo(String value) {
            addCriterion("density =", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotEqualTo(String value) {
            addCriterion("density <>", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThan(String value) {
            addCriterion("density >", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityGreaterThanOrEqualTo(String value) {
            addCriterion("density >=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThan(String value) {
            addCriterion("density <", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLessThanOrEqualTo(String value) {
            addCriterion("density <=", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityLike(String value) {
            addCriterion("density like", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotLike(String value) {
            addCriterion("density not like", value, "density");
            return (Criteria) this;
        }

        public Criteria andDensityIn(List<String> values) {
            addCriterion("density in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotIn(List<String> values) {
            addCriterion("density not in", values, "density");
            return (Criteria) this;
        }

        public Criteria andDensityBetween(String value1, String value2) {
            addCriterion("density between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andDensityNotBetween(String value1, String value2) {
            addCriterion("density not between", value1, value2, "density");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Integer value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Integer value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Integer value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Integer value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Integer value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Integer> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Integer> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Integer value1, Integer value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Integer value1, Integer value2) {
            addCriterion("status not between", value1, value2, "status");
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