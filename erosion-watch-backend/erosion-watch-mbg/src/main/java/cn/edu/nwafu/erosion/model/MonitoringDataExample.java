package cn.edu.nwafu.erosion.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class MonitoringDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitoringDataExample() {
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

        public Criteria andMonitoringDateIsNull() {
            addCriterion("monitoring_date is null");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateIsNotNull() {
            addCriterion("monitoring_date is not null");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateEqualTo(Date value) {
            addCriterionForJDBCDate("monitoring_date =", value, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("monitoring_date <>", value, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateGreaterThan(Date value) {
            addCriterionForJDBCDate("monitoring_date >", value, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("monitoring_date >=", value, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateLessThan(Date value) {
            addCriterionForJDBCDate("monitoring_date <", value, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("monitoring_date <=", value, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateIn(List<Date> values) {
            addCriterionForJDBCDate("monitoring_date in", values, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("monitoring_date not in", values, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("monitoring_date between", value1, value2, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andMonitoringDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("monitoring_date not between", value1, value2, "monitoringDate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateIsNull() {
            addCriterion("soil_erosion_rate is null");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateIsNotNull() {
            addCriterion("soil_erosion_rate is not null");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateEqualTo(BigDecimal value) {
            addCriterion("soil_erosion_rate =", value, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateNotEqualTo(BigDecimal value) {
            addCriterion("soil_erosion_rate <>", value, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateGreaterThan(BigDecimal value) {
            addCriterion("soil_erosion_rate >", value, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("soil_erosion_rate >=", value, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateLessThan(BigDecimal value) {
            addCriterion("soil_erosion_rate <", value, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("soil_erosion_rate <=", value, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateIn(List<BigDecimal> values) {
            addCriterion("soil_erosion_rate in", values, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateNotIn(List<BigDecimal> values) {
            addCriterion("soil_erosion_rate not in", values, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("soil_erosion_rate between", value1, value2, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andSoilErosionRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("soil_erosion_rate not between", value1, value2, "soilErosionRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateIsNull() {
            addCriterion("vegetation_coverage_rate is null");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateIsNotNull() {
            addCriterion("vegetation_coverage_rate is not null");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateEqualTo(BigDecimal value) {
            addCriterion("vegetation_coverage_rate =", value, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateNotEqualTo(BigDecimal value) {
            addCriterion("vegetation_coverage_rate <>", value, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateGreaterThan(BigDecimal value) {
            addCriterion("vegetation_coverage_rate >", value, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("vegetation_coverage_rate >=", value, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateLessThan(BigDecimal value) {
            addCriterion("vegetation_coverage_rate <", value, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateLessThanOrEqualTo(BigDecimal value) {
            addCriterion("vegetation_coverage_rate <=", value, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateIn(List<BigDecimal> values) {
            addCriterion("vegetation_coverage_rate in", values, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateNotIn(List<BigDecimal> values) {
            addCriterion("vegetation_coverage_rate not in", values, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vegetation_coverage_rate between", value1, value2, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andVegetationCoverageRateNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("vegetation_coverage_rate not between", value1, value2, "vegetationCoverageRate");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountIsNull() {
            addCriterion("rainfall_amount is null");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountIsNotNull() {
            addCriterion("rainfall_amount is not null");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountEqualTo(BigDecimal value) {
            addCriterion("rainfall_amount =", value, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountNotEqualTo(BigDecimal value) {
            addCriterion("rainfall_amount <>", value, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountGreaterThan(BigDecimal value) {
            addCriterion("rainfall_amount >", value, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("rainfall_amount >=", value, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountLessThan(BigDecimal value) {
            addCriterion("rainfall_amount <", value, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountLessThanOrEqualTo(BigDecimal value) {
            addCriterion("rainfall_amount <=", value, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountIn(List<BigDecimal> values) {
            addCriterion("rainfall_amount in", values, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountNotIn(List<BigDecimal> values) {
            addCriterion("rainfall_amount not in", values, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rainfall_amount between", value1, value2, "rainfallAmount");
            return (Criteria) this;
        }

        public Criteria andRainfallAmountNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("rainfall_amount not between", value1, value2, "rainfallAmount");
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