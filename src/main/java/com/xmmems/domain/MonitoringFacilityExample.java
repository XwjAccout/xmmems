package com.xmmems.domain;

import java.util.ArrayList;
import java.util.List;

public class MonitoringFacilityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public MonitoringFacilityExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andUnitIDIsNull() {
            addCriterion("unitID is null");
            return (Criteria) this;
        }

        public Criteria andUnitIDIsNotNull() {
            addCriterion("unitID is not null");
            return (Criteria) this;
        }

        public Criteria andUnitIDEqualTo(Integer value) {
            addCriterion("unitID =", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDNotEqualTo(Integer value) {
            addCriterion("unitID <>", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDGreaterThan(Integer value) {
            addCriterion("unitID >", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDGreaterThanOrEqualTo(Integer value) {
            addCriterion("unitID >=", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDLessThan(Integer value) {
            addCriterion("unitID <", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDLessThanOrEqualTo(Integer value) {
            addCriterion("unitID <=", value, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDIn(List<Integer> values) {
            addCriterion("unitID in", values, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDNotIn(List<Integer> values) {
            addCriterion("unitID not in", values, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDBetween(Integer value1, Integer value2) {
            addCriterion("unitID between", value1, value2, "unitID");
            return (Criteria) this;
        }

        public Criteria andUnitIDNotBetween(Integer value1, Integer value2) {
            addCriterion("unitID not between", value1, value2, "unitID");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNull() {
            addCriterion("equipmentName is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIsNotNull() {
            addCriterion("equipmentName is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameEqualTo(String value) {
            addCriterion("equipmentName =", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotEqualTo(String value) {
            addCriterion("equipmentName <>", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThan(String value) {
            addCriterion("equipmentName >", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameGreaterThanOrEqualTo(String value) {
            addCriterion("equipmentName >=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThan(String value) {
            addCriterion("equipmentName <", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLessThanOrEqualTo(String value) {
            addCriterion("equipmentName <=", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameLike(String value) {
            addCriterion("equipmentName like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotLike(String value) {
            addCriterion("equipmentName not like", value, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameIn(List<String> values) {
            addCriterion("equipmentName in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotIn(List<String> values) {
            addCriterion("equipmentName not in", values, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameBetween(String value1, String value2) {
            addCriterion("equipmentName between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentNameNotBetween(String value1, String value2) {
            addCriterion("equipmentName not between", value1, value2, "equipmentName");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelIsNull() {
            addCriterion("equipmentModel is null");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelIsNotNull() {
            addCriterion("equipmentModel is not null");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelEqualTo(String value) {
            addCriterion("equipmentModel =", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelNotEqualTo(String value) {
            addCriterion("equipmentModel <>", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelGreaterThan(String value) {
            addCriterion("equipmentModel >", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelGreaterThanOrEqualTo(String value) {
            addCriterion("equipmentModel >=", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelLessThan(String value) {
            addCriterion("equipmentModel <", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelLessThanOrEqualTo(String value) {
            addCriterion("equipmentModel <=", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelLike(String value) {
            addCriterion("equipmentModel like", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelNotLike(String value) {
            addCriterion("equipmentModel not like", value, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelIn(List<String> values) {
            addCriterion("equipmentModel in", values, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelNotIn(List<String> values) {
            addCriterion("equipmentModel not in", values, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelBetween(String value1, String value2) {
            addCriterion("equipmentModel between", value1, value2, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andEquipmentModelNotBetween(String value1, String value2) {
            addCriterion("equipmentModel not between", value1, value2, "equipmentModel");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayIsNull() {
            addCriterion("analysisWay is null");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayIsNotNull() {
            addCriterion("analysisWay is not null");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayEqualTo(String value) {
            addCriterion("analysisWay =", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayNotEqualTo(String value) {
            addCriterion("analysisWay <>", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayGreaterThan(String value) {
            addCriterion("analysisWay >", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayGreaterThanOrEqualTo(String value) {
            addCriterion("analysisWay >=", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayLessThan(String value) {
            addCriterion("analysisWay <", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayLessThanOrEqualTo(String value) {
            addCriterion("analysisWay <=", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayLike(String value) {
            addCriterion("analysisWay like", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayNotLike(String value) {
            addCriterion("analysisWay not like", value, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayIn(List<String> values) {
            addCriterion("analysisWay in", values, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayNotIn(List<String> values) {
            addCriterion("analysisWay not in", values, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayBetween(String value1, String value2) {
            addCriterion("analysisWay between", value1, value2, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andAnalysisWayNotBetween(String value1, String value2) {
            addCriterion("analysisWay not between", value1, value2, "analysisWay");
            return (Criteria) this;
        }

        public Criteria andTestOptionIsNull() {
            addCriterion("testOption is null");
            return (Criteria) this;
        }

        public Criteria andTestOptionIsNotNull() {
            addCriterion("testOption is not null");
            return (Criteria) this;
        }

        public Criteria andTestOptionEqualTo(String value) {
            addCriterion("testOption =", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionNotEqualTo(String value) {
            addCriterion("testOption <>", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionGreaterThan(String value) {
            addCriterion("testOption >", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionGreaterThanOrEqualTo(String value) {
            addCriterion("testOption >=", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionLessThan(String value) {
            addCriterion("testOption <", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionLessThanOrEqualTo(String value) {
            addCriterion("testOption <=", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionLike(String value) {
            addCriterion("testOption like", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionNotLike(String value) {
            addCriterion("testOption not like", value, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionIn(List<String> values) {
            addCriterion("testOption in", values, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionNotIn(List<String> values) {
            addCriterion("testOption not in", values, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionBetween(String value1, String value2) {
            addCriterion("testOption between", value1, value2, "testOption");
            return (Criteria) this;
        }

        public Criteria andTestOptionNotBetween(String value1, String value2) {
            addCriterion("testOption not between", value1, value2, "testOption");
            return (Criteria) this;
        }

        public Criteria andReagentIsNull() {
            addCriterion("reagent is null");
            return (Criteria) this;
        }

        public Criteria andReagentIsNotNull() {
            addCriterion("reagent is not null");
            return (Criteria) this;
        }

        public Criteria andReagentEqualTo(String value) {
            addCriterion("reagent =", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentNotEqualTo(String value) {
            addCriterion("reagent <>", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentGreaterThan(String value) {
            addCriterion("reagent >", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentGreaterThanOrEqualTo(String value) {
            addCriterion("reagent >=", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentLessThan(String value) {
            addCriterion("reagent <", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentLessThanOrEqualTo(String value) {
            addCriterion("reagent <=", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentLike(String value) {
            addCriterion("reagent like", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentNotLike(String value) {
            addCriterion("reagent not like", value, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentIn(List<String> values) {
            addCriterion("reagent in", values, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentNotIn(List<String> values) {
            addCriterion("reagent not in", values, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentBetween(String value1, String value2) {
            addCriterion("reagent between", value1, value2, "reagent");
            return (Criteria) this;
        }

        public Criteria andReagentNotBetween(String value1, String value2) {
            addCriterion("reagent not between", value1, value2, "reagent");
            return (Criteria) this;
        }

        public Criteria andLimitIsNull() {
            addCriterion("limit is null");
            return (Criteria) this;
        }

        public Criteria andLimitIsNotNull() {
            addCriterion("limit is not null");
            return (Criteria) this;
        }

        public Criteria andLimitEqualTo(String value) {
            addCriterion("limit =", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitNotEqualTo(String value) {
            addCriterion("limit <>", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitGreaterThan(String value) {
            addCriterion("limit >", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitGreaterThanOrEqualTo(String value) {
            addCriterion("limit >=", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitLessThan(String value) {
            addCriterion("limit <", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitLessThanOrEqualTo(String value) {
            addCriterion("limit <=", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitLike(String value) {
            addCriterion("limit like", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitNotLike(String value) {
            addCriterion("limit not like", value, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitIn(List<String> values) {
            addCriterion("limit in", values, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitNotIn(List<String> values) {
            addCriterion("limit not in", values, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitBetween(String value1, String value2) {
            addCriterion("limit between", value1, value2, "limit");
            return (Criteria) this;
        }

        public Criteria andLimitNotBetween(String value1, String value2) {
            addCriterion("limit not between", value1, value2, "limit");
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