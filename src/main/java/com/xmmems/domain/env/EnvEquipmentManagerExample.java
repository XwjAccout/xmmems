package com.xmmems.domain.env;

import java.util.ArrayList;
import java.util.List;

public class EnvEquipmentManagerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EnvEquipmentManagerExample() {
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

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNull() {
            addCriterion("displayName is null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIsNotNull() {
            addCriterion("displayName is not null");
            return (Criteria) this;
        }

        public Criteria andDisplayNameEqualTo(String value) {
            addCriterion("displayName =", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotEqualTo(String value) {
            addCriterion("displayName <>", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThan(String value) {
            addCriterion("displayName >", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameGreaterThanOrEqualTo(String value) {
            addCriterion("displayName >=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThan(String value) {
            addCriterion("displayName <", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLessThanOrEqualTo(String value) {
            addCriterion("displayName <=", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameLike(String value) {
            addCriterion("displayName like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotLike(String value) {
            addCriterion("displayName not like", value, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameIn(List<String> values) {
            addCriterion("displayName in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotIn(List<String> values) {
            addCriterion("displayName not in", values, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameBetween(String value1, String value2) {
            addCriterion("displayName between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andDisplayNameNotBetween(String value1, String value2) {
            addCriterion("displayName not between", value1, value2, "displayName");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNull() {
            addCriterion("stationName is null");
            return (Criteria) this;
        }

        public Criteria andStationNameIsNotNull() {
            addCriterion("stationName is not null");
            return (Criteria) this;
        }

        public Criteria andStationNameEqualTo(String value) {
            addCriterion("stationName =", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotEqualTo(String value) {
            addCriterion("stationName <>", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThan(String value) {
            addCriterion("stationName >", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameGreaterThanOrEqualTo(String value) {
            addCriterion("stationName >=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThan(String value) {
            addCriterion("stationName <", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLessThanOrEqualTo(String value) {
            addCriterion("stationName <=", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameLike(String value) {
            addCriterion("stationName like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotLike(String value) {
            addCriterion("stationName not like", value, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameIn(List<String> values) {
            addCriterion("stationName in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotIn(List<String> values) {
            addCriterion("stationName not in", values, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameBetween(String value1, String value2) {
            addCriterion("stationName between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationNameNotBetween(String value1, String value2) {
            addCriterion("stationName not between", value1, value2, "stationName");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNull() {
            addCriterion("stationId is null");
            return (Criteria) this;
        }

        public Criteria andStationIdIsNotNull() {
            addCriterion("stationId is not null");
            return (Criteria) this;
        }

        public Criteria andStationIdEqualTo(Integer value) {
            addCriterion("stationId =", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotEqualTo(Integer value) {
            addCriterion("stationId <>", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThan(Integer value) {
            addCriterion("stationId >", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("stationId >=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThan(Integer value) {
            addCriterion("stationId <", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdLessThanOrEqualTo(Integer value) {
            addCriterion("stationId <=", value, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdIn(List<Integer> values) {
            addCriterion("stationId in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotIn(List<Integer> values) {
            addCriterion("stationId not in", values, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdBetween(Integer value1, Integer value2) {
            addCriterion("stationId between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andStationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("stationId not between", value1, value2, "stationId");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andDirectiveIsNull() {
            addCriterion("directive is null");
            return (Criteria) this;
        }

        public Criteria andDirectiveIsNotNull() {
            addCriterion("directive is not null");
            return (Criteria) this;
        }

        public Criteria andDirectiveEqualTo(String value) {
            addCriterion("directive =", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveNotEqualTo(String value) {
            addCriterion("directive <>", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveGreaterThan(String value) {
            addCriterion("directive >", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveGreaterThanOrEqualTo(String value) {
            addCriterion("directive >=", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveLessThan(String value) {
            addCriterion("directive <", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveLessThanOrEqualTo(String value) {
            addCriterion("directive <=", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveLike(String value) {
            addCriterion("directive like", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveNotLike(String value) {
            addCriterion("directive not like", value, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveIn(List<String> values) {
            addCriterion("directive in", values, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveNotIn(List<String> values) {
            addCriterion("directive not in", values, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveBetween(String value1, String value2) {
            addCriterion("directive between", value1, value2, "directive");
            return (Criteria) this;
        }

        public Criteria andDirectiveNotBetween(String value1, String value2) {
            addCriterion("directive not between", value1, value2, "directive");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqIsNull() {
            addCriterion("doubleSeq is null");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqIsNotNull() {
            addCriterion("doubleSeq is not null");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqEqualTo(String value) {
            addCriterion("doubleSeq =", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqNotEqualTo(String value) {
            addCriterion("doubleSeq <>", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqGreaterThan(String value) {
            addCriterion("doubleSeq >", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqGreaterThanOrEqualTo(String value) {
            addCriterion("doubleSeq >=", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqLessThan(String value) {
            addCriterion("doubleSeq <", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqLessThanOrEqualTo(String value) {
            addCriterion("doubleSeq <=", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqLike(String value) {
            addCriterion("doubleSeq like", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqNotLike(String value) {
            addCriterion("doubleSeq not like", value, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqIn(List<String> values) {
            addCriterion("doubleSeq in", values, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqNotIn(List<String> values) {
            addCriterion("doubleSeq not in", values, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqBetween(String value1, String value2) {
            addCriterion("doubleSeq between", value1, value2, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andDoubleSeqNotBetween(String value1, String value2) {
            addCriterion("doubleSeq not between", value1, value2, "doubleSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqIsNull() {
            addCriterion("bitSeq is null");
            return (Criteria) this;
        }

        public Criteria andBitSeqIsNotNull() {
            addCriterion("bitSeq is not null");
            return (Criteria) this;
        }

        public Criteria andBitSeqEqualTo(String value) {
            addCriterion("bitSeq =", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqNotEqualTo(String value) {
            addCriterion("bitSeq <>", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqGreaterThan(String value) {
            addCriterion("bitSeq >", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqGreaterThanOrEqualTo(String value) {
            addCriterion("bitSeq >=", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqLessThan(String value) {
            addCriterion("bitSeq <", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqLessThanOrEqualTo(String value) {
            addCriterion("bitSeq <=", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqLike(String value) {
            addCriterion("bitSeq like", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqNotLike(String value) {
            addCriterion("bitSeq not like", value, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqIn(List<String> values) {
            addCriterion("bitSeq in", values, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqNotIn(List<String> values) {
            addCriterion("bitSeq not in", values, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqBetween(String value1, String value2) {
            addCriterion("bitSeq between", value1, value2, "bitSeq");
            return (Criteria) this;
        }

        public Criteria andBitSeqNotBetween(String value1, String value2) {
            addCriterion("bitSeq not between", value1, value2, "bitSeq");
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

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andControlFlagIsNull() {
            addCriterion("controlFlag is null");
            return (Criteria) this;
        }

        public Criteria andControlFlagIsNotNull() {
            addCriterion("controlFlag is not null");
            return (Criteria) this;
        }

        public Criteria andControlFlagEqualTo(String value) {
            addCriterion("controlFlag =", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagNotEqualTo(String value) {
            addCriterion("controlFlag <>", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagGreaterThan(String value) {
            addCriterion("controlFlag >", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagGreaterThanOrEqualTo(String value) {
            addCriterion("controlFlag >=", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagLessThan(String value) {
            addCriterion("controlFlag <", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagLessThanOrEqualTo(String value) {
            addCriterion("controlFlag <=", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagLike(String value) {
            addCriterion("controlFlag like", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagNotLike(String value) {
            addCriterion("controlFlag not like", value, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagIn(List<String> values) {
            addCriterion("controlFlag in", values, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagNotIn(List<String> values) {
            addCriterion("controlFlag not in", values, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagBetween(String value1, String value2) {
            addCriterion("controlFlag between", value1, value2, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andControlFlagNotBetween(String value1, String value2) {
            addCriterion("controlFlag not between", value1, value2, "controlFlag");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNull() {
            addCriterion("warnLevel is null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIsNotNull() {
            addCriterion("warnLevel is not null");
            return (Criteria) this;
        }

        public Criteria andWarnLevelEqualTo(String value) {
            addCriterion("warnLevel =", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotEqualTo(String value) {
            addCriterion("warnLevel <>", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThan(String value) {
            addCriterion("warnLevel >", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelGreaterThanOrEqualTo(String value) {
            addCriterion("warnLevel >=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThan(String value) {
            addCriterion("warnLevel <", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLessThanOrEqualTo(String value) {
            addCriterion("warnLevel <=", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelLike(String value) {
            addCriterion("warnLevel like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotLike(String value) {
            addCriterion("warnLevel not like", value, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelIn(List<String> values) {
            addCriterion("warnLevel in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotIn(List<String> values) {
            addCriterion("warnLevel not in", values, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelBetween(String value1, String value2) {
            addCriterion("warnLevel between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andWarnLevelNotBetween(String value1, String value2) {
            addCriterion("warnLevel not between", value1, value2, "warnLevel");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("remark is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("remark is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("remark =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("remark <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("remark >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("remark >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("remark <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("remark <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("remark like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("remark not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("remark in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("remark not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("remark between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("remark not between", value1, value2, "remark");
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