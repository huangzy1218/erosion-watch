package cn.edu.nwafu.erosion.model;

import java.util.ArrayList;
import java.util.List;

public class SoilErosionGradeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SoilErosionGradeExample() {
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

        public Criteria andErosionTypeIsNull() {
            addCriterion("erosion_type is null");
            return (Criteria) this;
        }

        public Criteria andErosionTypeIsNotNull() {
            addCriterion("erosion_type is not null");
            return (Criteria) this;
        }

        public Criteria andErosionTypeEqualTo(String value) {
            addCriterion("erosion_type =", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeNotEqualTo(String value) {
            addCriterion("erosion_type <>", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeGreaterThan(String value) {
            addCriterion("erosion_type >", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeGreaterThanOrEqualTo(String value) {
            addCriterion("erosion_type >=", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeLessThan(String value) {
            addCriterion("erosion_type <", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeLessThanOrEqualTo(String value) {
            addCriterion("erosion_type <=", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeLike(String value) {
            addCriterion("erosion_type like", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeNotLike(String value) {
            addCriterion("erosion_type not like", value, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeIn(List<String> values) {
            addCriterion("erosion_type in", values, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeNotIn(List<String> values) {
            addCriterion("erosion_type not in", values, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeBetween(String value1, String value2) {
            addCriterion("erosion_type between", value1, value2, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionTypeNotBetween(String value1, String value2) {
            addCriterion("erosion_type not between", value1, value2, "erosionType");
            return (Criteria) this;
        }

        public Criteria andErosionGradeIsNull() {
            addCriterion("erosion_grade is null");
            return (Criteria) this;
        }

        public Criteria andErosionGradeIsNotNull() {
            addCriterion("erosion_grade is not null");
            return (Criteria) this;
        }

        public Criteria andErosionGradeEqualTo(String value) {
            addCriterion("erosion_grade =", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeNotEqualTo(String value) {
            addCriterion("erosion_grade <>", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeGreaterThan(String value) {
            addCriterion("erosion_grade >", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeGreaterThanOrEqualTo(String value) {
            addCriterion("erosion_grade >=", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeLessThan(String value) {
            addCriterion("erosion_grade <", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeLessThanOrEqualTo(String value) {
            addCriterion("erosion_grade <=", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeLike(String value) {
            addCriterion("erosion_grade like", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeNotLike(String value) {
            addCriterion("erosion_grade not like", value, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeIn(List<String> values) {
            addCriterion("erosion_grade in", values, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeNotIn(List<String> values) {
            addCriterion("erosion_grade not in", values, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeBetween(String value1, String value2) {
            addCriterion("erosion_grade between", value1, value2, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionGradeNotBetween(String value1, String value2) {
            addCriterion("erosion_grade not between", value1, value2, "erosionGrade");
            return (Criteria) this;
        }

        public Criteria andErosionYearsIsNull() {
            addCriterion("erosion_years is null");
            return (Criteria) this;
        }

        public Criteria andErosionYearsIsNotNull() {
            addCriterion("erosion_years is not null");
            return (Criteria) this;
        }

        public Criteria andErosionYearsEqualTo(Integer value) {
            addCriterion("erosion_years =", value, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsNotEqualTo(Integer value) {
            addCriterion("erosion_years <>", value, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsGreaterThan(Integer value) {
            addCriterion("erosion_years >", value, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsGreaterThanOrEqualTo(Integer value) {
            addCriterion("erosion_years >=", value, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsLessThan(Integer value) {
            addCriterion("erosion_years <", value, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsLessThanOrEqualTo(Integer value) {
            addCriterion("erosion_years <=", value, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsIn(List<Integer> values) {
            addCriterion("erosion_years in", values, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsNotIn(List<Integer> values) {
            addCriterion("erosion_years not in", values, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsBetween(Integer value1, Integer value2) {
            addCriterion("erosion_years between", value1, value2, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andErosionYearsNotBetween(Integer value1, Integer value2) {
            addCriterion("erosion_years not between", value1, value2, "erosionYears");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNull() {
            addCriterion("risk_level is null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIsNotNull() {
            addCriterion("risk_level is not null");
            return (Criteria) this;
        }

        public Criteria andRiskLevelEqualTo(String value) {
            addCriterion("risk_level =", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotEqualTo(String value) {
            addCriterion("risk_level <>", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThan(String value) {
            addCriterion("risk_level >", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelGreaterThanOrEqualTo(String value) {
            addCriterion("risk_level >=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThan(String value) {
            addCriterion("risk_level <", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLessThanOrEqualTo(String value) {
            addCriterion("risk_level <=", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelLike(String value) {
            addCriterion("risk_level like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotLike(String value) {
            addCriterion("risk_level not like", value, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelIn(List<String> values) {
            addCriterion("risk_level in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotIn(List<String> values) {
            addCriterion("risk_level not in", values, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelBetween(String value1, String value2) {
            addCriterion("risk_level between", value1, value2, "riskLevel");
            return (Criteria) this;
        }

        public Criteria andRiskLevelNotBetween(String value1, String value2) {
            addCriterion("risk_level not between", value1, value2, "riskLevel");
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