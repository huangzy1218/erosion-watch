package cn.edu.nwafu.erosion.model;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AreaInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AreaInfoExample() {
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

        public Criteria andAreaNameIsNull() {
            addCriterion("area_name is null");
            return (Criteria) this;
        }

        public Criteria andAreaNameIsNotNull() {
            addCriterion("area_name is not null");
            return (Criteria) this;
        }

        public Criteria andAreaNameEqualTo(String value) {
            addCriterion("area_name =", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotEqualTo(String value) {
            addCriterion("area_name <>", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThan(String value) {
            addCriterion("area_name >", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameGreaterThanOrEqualTo(String value) {
            addCriterion("area_name >=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThan(String value) {
            addCriterion("area_name <", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLessThanOrEqualTo(String value) {
            addCriterion("area_name <=", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameLike(String value) {
            addCriterion("area_name like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotLike(String value) {
            addCriterion("area_name not like", value, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameIn(List<String> values) {
            addCriterion("area_name in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotIn(List<String> values) {
            addCriterion("area_name not in", values, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameBetween(String value1, String value2) {
            addCriterion("area_name between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAreaNameNotBetween(String value1, String value2) {
            addCriterion("area_name not between", value1, value2, "areaName");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeIsNull() {
            addCriterion("administrative_code is null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeIsNotNull() {
            addCriterion("administrative_code is not null");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeEqualTo(String value) {
            addCriterion("administrative_code =", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeNotEqualTo(String value) {
            addCriterion("administrative_code <>", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeGreaterThan(String value) {
            addCriterion("administrative_code >", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeGreaterThanOrEqualTo(String value) {
            addCriterion("administrative_code >=", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeLessThan(String value) {
            addCriterion("administrative_code <", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeLessThanOrEqualTo(String value) {
            addCriterion("administrative_code <=", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeLike(String value) {
            addCriterion("administrative_code like", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeNotLike(String value) {
            addCriterion("administrative_code not like", value, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeIn(List<String> values) {
            addCriterion("administrative_code in", values, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeNotIn(List<String> values) {
            addCriterion("administrative_code not in", values, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeBetween(String value1, String value2) {
            addCriterion("administrative_code between", value1, value2, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andAdministrativeCodeNotBetween(String value1, String value2) {
            addCriterion("administrative_code not between", value1, value2, "administrativeCode");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNull() {
            addCriterion("latitude is null");
            return (Criteria) this;
        }

        public Criteria andLatitudeIsNotNull() {
            addCriterion("latitude is not null");
            return (Criteria) this;
        }

        public Criteria andLatitudeEqualTo(BigDecimal value) {
            addCriterion("latitude =", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotEqualTo(BigDecimal value) {
            addCriterion("latitude <>", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThan(BigDecimal value) {
            addCriterion("latitude >", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude >=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThan(BigDecimal value) {
            addCriterion("latitude <", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("latitude <=", value, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeIn(List<BigDecimal> values) {
            addCriterion("latitude in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotIn(List<BigDecimal> values) {
            addCriterion("latitude not in", values, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLatitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("latitude not between", value1, value2, "latitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNull() {
            addCriterion("longitude is null");
            return (Criteria) this;
        }

        public Criteria andLongitudeIsNotNull() {
            addCriterion("longitude is not null");
            return (Criteria) this;
        }

        public Criteria andLongitudeEqualTo(BigDecimal value) {
            addCriterion("longitude =", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotEqualTo(BigDecimal value) {
            addCriterion("longitude <>", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThan(BigDecimal value) {
            addCriterion("longitude >", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude >=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThan(BigDecimal value) {
            addCriterion("longitude <", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("longitude <=", value, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeIn(List<BigDecimal> values) {
            addCriterion("longitude in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotIn(List<BigDecimal> values) {
            addCriterion("longitude not in", values, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andLongitudeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("longitude not between", value1, value2, "longitude");
            return (Criteria) this;
        }

        public Criteria andAreaIsNull() {
            addCriterion("area is null");
            return (Criteria) this;
        }

        public Criteria andAreaIsNotNull() {
            addCriterion("area is not null");
            return (Criteria) this;
        }

        public Criteria andAreaEqualTo(BigDecimal value) {
            addCriterion("area =", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotEqualTo(BigDecimal value) {
            addCriterion("area <>", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThan(BigDecimal value) {
            addCriterion("area >", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("area >=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThan(BigDecimal value) {
            addCriterion("area <", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaLessThanOrEqualTo(BigDecimal value) {
            addCriterion("area <=", value, "area");
            return (Criteria) this;
        }

        public Criteria andAreaIn(List<BigDecimal> values) {
            addCriterion("area in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotIn(List<BigDecimal> values) {
            addCriterion("area not in", values, "area");
            return (Criteria) this;
        }

        public Criteria andAreaBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andAreaNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("area not between", value1, value2, "area");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNull() {
            addCriterion("population is null");
            return (Criteria) this;
        }

        public Criteria andPopulationIsNotNull() {
            addCriterion("population is not null");
            return (Criteria) this;
        }

        public Criteria andPopulationEqualTo(Integer value) {
            addCriterion("population =", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotEqualTo(Integer value) {
            addCriterion("population <>", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThan(Integer value) {
            addCriterion("population >", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationGreaterThanOrEqualTo(Integer value) {
            addCriterion("population >=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThan(Integer value) {
            addCriterion("population <", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationLessThanOrEqualTo(Integer value) {
            addCriterion("population <=", value, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationIn(List<Integer> values) {
            addCriterion("population in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotIn(List<Integer> values) {
            addCriterion("population not in", values, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationBetween(Integer value1, Integer value2) {
            addCriterion("population between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andPopulationNotBetween(Integer value1, Integer value2) {
            addCriterion("population not between", value1, value2, "population");
            return (Criteria) this;
        }

        public Criteria andClimateTypeIsNull() {
            addCriterion("climate_type is null");
            return (Criteria) this;
        }

        public Criteria andClimateTypeIsNotNull() {
            addCriterion("climate_type is not null");
            return (Criteria) this;
        }

        public Criteria andClimateTypeEqualTo(String value) {
            addCriterion("climate_type =", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeNotEqualTo(String value) {
            addCriterion("climate_type <>", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeGreaterThan(String value) {
            addCriterion("climate_type >", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeGreaterThanOrEqualTo(String value) {
            addCriterion("climate_type >=", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeLessThan(String value) {
            addCriterion("climate_type <", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeLessThanOrEqualTo(String value) {
            addCriterion("climate_type <=", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeLike(String value) {
            addCriterion("climate_type like", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeNotLike(String value) {
            addCriterion("climate_type not like", value, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeIn(List<String> values) {
            addCriterion("climate_type in", values, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeNotIn(List<String> values) {
            addCriterion("climate_type not in", values, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeBetween(String value1, String value2) {
            addCriterion("climate_type between", value1, value2, "climateType");
            return (Criteria) this;
        }

        public Criteria andClimateTypeNotBetween(String value1, String value2) {
            addCriterion("climate_type not between", value1, value2, "climateType");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureIsNull() {
            addCriterion("terrain_feature is null");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureIsNotNull() {
            addCriterion("terrain_feature is not null");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureEqualTo(String value) {
            addCriterion("terrain_feature =", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureNotEqualTo(String value) {
            addCriterion("terrain_feature <>", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureGreaterThan(String value) {
            addCriterion("terrain_feature >", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("terrain_feature >=", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureLessThan(String value) {
            addCriterion("terrain_feature <", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureLessThanOrEqualTo(String value) {
            addCriterion("terrain_feature <=", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureLike(String value) {
            addCriterion("terrain_feature like", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureNotLike(String value) {
            addCriterion("terrain_feature not like", value, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureIn(List<String> values) {
            addCriterion("terrain_feature in", values, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureNotIn(List<String> values) {
            addCriterion("terrain_feature not in", values, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureBetween(String value1, String value2) {
            addCriterion("terrain_feature between", value1, value2, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andTerrainFeatureNotBetween(String value1, String value2) {
            addCriterion("terrain_feature not between", value1, value2, "terrainFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureIsNull() {
            addCriterion("landform_feature is null");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureIsNotNull() {
            addCriterion("landform_feature is not null");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureEqualTo(String value) {
            addCriterion("landform_feature =", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureNotEqualTo(String value) {
            addCriterion("landform_feature <>", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureGreaterThan(String value) {
            addCriterion("landform_feature >", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureGreaterThanOrEqualTo(String value) {
            addCriterion("landform_feature >=", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureLessThan(String value) {
            addCriterion("landform_feature <", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureLessThanOrEqualTo(String value) {
            addCriterion("landform_feature <=", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureLike(String value) {
            addCriterion("landform_feature like", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureNotLike(String value) {
            addCriterion("landform_feature not like", value, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureIn(List<String> values) {
            addCriterion("landform_feature in", values, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureNotIn(List<String> values) {
            addCriterion("landform_feature not in", values, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureBetween(String value1, String value2) {
            addCriterion("landform_feature between", value1, value2, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandformFeatureNotBetween(String value1, String value2) {
            addCriterion("landform_feature not between", value1, value2, "landformFeature");
            return (Criteria) this;
        }

        public Criteria andLandUseIsNull() {
            addCriterion("land_use is null");
            return (Criteria) this;
        }

        public Criteria andLandUseIsNotNull() {
            addCriterion("land_use is not null");
            return (Criteria) this;
        }

        public Criteria andLandUseEqualTo(String value) {
            addCriterion("land_use =", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotEqualTo(String value) {
            addCriterion("land_use <>", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseGreaterThan(String value) {
            addCriterion("land_use >", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseGreaterThanOrEqualTo(String value) {
            addCriterion("land_use >=", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseLessThan(String value) {
            addCriterion("land_use <", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseLessThanOrEqualTo(String value) {
            addCriterion("land_use <=", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseLike(String value) {
            addCriterion("land_use like", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotLike(String value) {
            addCriterion("land_use not like", value, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseIn(List<String> values) {
            addCriterion("land_use in", values, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotIn(List<String> values) {
            addCriterion("land_use not in", values, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseBetween(String value1, String value2) {
            addCriterion("land_use between", value1, value2, "landUse");
            return (Criteria) this;
        }

        public Criteria andLandUseNotBetween(String value1, String value2) {
            addCriterion("land_use not between", value1, value2, "landUse");
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