package cn.edu.nwafu.erosion.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class TerrainLandformExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TerrainLandformExample() {
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

        public Criteria andTerrainTypeIsNull() {
            addCriterion("terrain_type is null");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeIsNotNull() {
            addCriterion("terrain_type is not null");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeEqualTo(String value) {
            addCriterion("terrain_type =", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeNotEqualTo(String value) {
            addCriterion("terrain_type <>", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeGreaterThan(String value) {
            addCriterion("terrain_type >", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeGreaterThanOrEqualTo(String value) {
            addCriterion("terrain_type >=", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeLessThan(String value) {
            addCriterion("terrain_type <", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeLessThanOrEqualTo(String value) {
            addCriterion("terrain_type <=", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeLike(String value) {
            addCriterion("terrain_type like", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeNotLike(String value) {
            addCriterion("terrain_type not like", value, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeIn(List<String> values) {
            addCriterion("terrain_type in", values, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeNotIn(List<String> values) {
            addCriterion("terrain_type not in", values, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeBetween(String value1, String value2) {
            addCriterion("terrain_type between", value1, value2, "terrainType");
            return (Criteria) this;
        }

        public Criteria andTerrainTypeNotBetween(String value1, String value2) {
            addCriterion("terrain_type not between", value1, value2, "terrainType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeIsNull() {
            addCriterion("landform_type is null");
            return (Criteria) this;
        }

        public Criteria andLandformTypeIsNotNull() {
            addCriterion("landform_type is not null");
            return (Criteria) this;
        }

        public Criteria andLandformTypeEqualTo(String value) {
            addCriterion("landform_type =", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeNotEqualTo(String value) {
            addCriterion("landform_type <>", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeGreaterThan(String value) {
            addCriterion("landform_type >", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeGreaterThanOrEqualTo(String value) {
            addCriterion("landform_type >=", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeLessThan(String value) {
            addCriterion("landform_type <", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeLessThanOrEqualTo(String value) {
            addCriterion("landform_type <=", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeLike(String value) {
            addCriterion("landform_type like", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeNotLike(String value) {
            addCriterion("landform_type not like", value, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeIn(List<String> values) {
            addCriterion("landform_type in", values, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeNotIn(List<String> values) {
            addCriterion("landform_type not in", values, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeBetween(String value1, String value2) {
            addCriterion("landform_type between", value1, value2, "landformType");
            return (Criteria) this;
        }

        public Criteria andLandformTypeNotBetween(String value1, String value2) {
            addCriterion("landform_type not between", value1, value2, "landformType");
            return (Criteria) this;
        }

        public Criteria andElevationIsNull() {
            addCriterion("elevation is null");
            return (Criteria) this;
        }

        public Criteria andElevationIsNotNull() {
            addCriterion("elevation is not null");
            return (Criteria) this;
        }

        public Criteria andElevationEqualTo(BigDecimal value) {
            addCriterion("elevation =", value, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationNotEqualTo(BigDecimal value) {
            addCriterion("elevation <>", value, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationGreaterThan(BigDecimal value) {
            addCriterion("elevation >", value, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("elevation >=", value, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationLessThan(BigDecimal value) {
            addCriterion("elevation <", value, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationLessThanOrEqualTo(BigDecimal value) {
            addCriterion("elevation <=", value, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationIn(List<BigDecimal> values) {
            addCriterion("elevation in", values, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationNotIn(List<BigDecimal> values) {
            addCriterion("elevation not in", values, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("elevation between", value1, value2, "elevation");
            return (Criteria) this;
        }

        public Criteria andElevationNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("elevation not between", value1, value2, "elevation");
            return (Criteria) this;
        }

        public Criteria andSlopeIsNull() {
            addCriterion("slope is null");
            return (Criteria) this;
        }

        public Criteria andSlopeIsNotNull() {
            addCriterion("slope is not null");
            return (Criteria) this;
        }

        public Criteria andSlopeEqualTo(BigDecimal value) {
            addCriterion("slope =", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeNotEqualTo(BigDecimal value) {
            addCriterion("slope <>", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeGreaterThan(BigDecimal value) {
            addCriterion("slope >", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("slope >=", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeLessThan(BigDecimal value) {
            addCriterion("slope <", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("slope <=", value, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeIn(List<BigDecimal> values) {
            addCriterion("slope in", values, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeNotIn(List<BigDecimal> values) {
            addCriterion("slope not in", values, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("slope between", value1, value2, "slope");
            return (Criteria) this;
        }

        public Criteria andSlopeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("slope not between", value1, value2, "slope");
            return (Criteria) this;
        }

        public Criteria andSoilTypeIsNull() {
            addCriterion("soil_type is null");
            return (Criteria) this;
        }

        public Criteria andSoilTypeIsNotNull() {
            addCriterion("soil_type is not null");
            return (Criteria) this;
        }

        public Criteria andSoilTypeEqualTo(String value) {
            addCriterion("soil_type =", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeNotEqualTo(String value) {
            addCriterion("soil_type <>", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeGreaterThan(String value) {
            addCriterion("soil_type >", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeGreaterThanOrEqualTo(String value) {
            addCriterion("soil_type >=", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeLessThan(String value) {
            addCriterion("soil_type <", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeLessThanOrEqualTo(String value) {
            addCriterion("soil_type <=", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeLike(String value) {
            addCriterion("soil_type like", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeNotLike(String value) {
            addCriterion("soil_type not like", value, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeIn(List<String> values) {
            addCriterion("soil_type in", values, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeNotIn(List<String> values) {
            addCriterion("soil_type not in", values, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeBetween(String value1, String value2) {
            addCriterion("soil_type between", value1, value2, "soilType");
            return (Criteria) this;
        }

        public Criteria andSoilTypeNotBetween(String value1, String value2) {
            addCriterion("soil_type not between", value1, value2, "soilType");
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

        public Criteria andWaterSystemIsNull() {
            addCriterion("water_system is null");
            return (Criteria) this;
        }

        public Criteria andWaterSystemIsNotNull() {
            addCriterion("water_system is not null");
            return (Criteria) this;
        }

        public Criteria andWaterSystemEqualTo(String value) {
            addCriterion("water_system =", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemNotEqualTo(String value) {
            addCriterion("water_system <>", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemGreaterThan(String value) {
            addCriterion("water_system >", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemGreaterThanOrEqualTo(String value) {
            addCriterion("water_system >=", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemLessThan(String value) {
            addCriterion("water_system <", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemLessThanOrEqualTo(String value) {
            addCriterion("water_system <=", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemLike(String value) {
            addCriterion("water_system like", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemNotLike(String value) {
            addCriterion("water_system not like", value, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemIn(List<String> values) {
            addCriterion("water_system in", values, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemNotIn(List<String> values) {
            addCriterion("water_system not in", values, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemBetween(String value1, String value2) {
            addCriterion("water_system between", value1, value2, "waterSystem");
            return (Criteria) this;
        }

        public Criteria andWaterSystemNotBetween(String value1, String value2) {
            addCriterion("water_system not between", value1, value2, "waterSystem");
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