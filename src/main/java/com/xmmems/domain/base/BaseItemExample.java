package com.xmmems.domain.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BaseItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BaseItemExample() {
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

        public Criteria andCodeIsNull() {
            addCriterion("code is null");
            return (Criteria) this;
        }

        public Criteria andCodeIsNotNull() {
            addCriterion("code is not null");
            return (Criteria) this;
        }

        public Criteria andCodeEqualTo(String value) {
            addCriterion("code =", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotEqualTo(String value) {
            addCriterion("code <>", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThan(String value) {
            addCriterion("code >", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeGreaterThanOrEqualTo(String value) {
            addCriterion("code >=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThan(String value) {
            addCriterion("code <", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLessThanOrEqualTo(String value) {
            addCriterion("code <=", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeLike(String value) {
            addCriterion("code like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotLike(String value) {
            addCriterion("code not like", value, "code");
            return (Criteria) this;
        }

        public Criteria andCodeIn(List<String> values) {
            addCriterion("code in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotIn(List<String> values) {
            addCriterion("code not in", values, "code");
            return (Criteria) this;
        }

        public Criteria andCodeBetween(String value1, String value2) {
            addCriterion("code between", value1, value2, "code");
            return (Criteria) this;
        }

        public Criteria andCodeNotBetween(String value1, String value2) {
            addCriterion("code not between", value1, value2, "code");
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

        public Criteria andTypeNameIsNull() {
            addCriterion("typeName is null");
            return (Criteria) this;
        }

        public Criteria andTypeNameIsNotNull() {
            addCriterion("typeName is not null");
            return (Criteria) this;
        }

        public Criteria andTypeNameEqualTo(String value) {
            addCriterion("typeName =", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotEqualTo(String value) {
            addCriterion("typeName <>", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThan(String value) {
            addCriterion("typeName >", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameGreaterThanOrEqualTo(String value) {
            addCriterion("typeName >=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThan(String value) {
            addCriterion("typeName <", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLessThanOrEqualTo(String value) {
            addCriterion("typeName <=", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameLike(String value) {
            addCriterion("typeName like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotLike(String value) {
            addCriterion("typeName not like", value, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameIn(List<String> values) {
            addCriterion("typeName in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotIn(List<String> values) {
            addCriterion("typeName not in", values, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameBetween(String value1, String value2) {
            addCriterion("typeName between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeNameNotBetween(String value1, String value2) {
            addCriterion("typeName not between", value1, value2, "typeName");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNull() {
            addCriterion("typeId is null");
            return (Criteria) this;
        }

        public Criteria andTypeIdIsNotNull() {
            addCriterion("typeId is not null");
            return (Criteria) this;
        }

        public Criteria andTypeIdEqualTo(Integer value) {
            addCriterion("typeId =", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotEqualTo(Integer value) {
            addCriterion("typeId <>", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThan(Integer value) {
            addCriterion("typeId >", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("typeId >=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThan(Integer value) {
            addCriterion("typeId <", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdLessThanOrEqualTo(Integer value) {
            addCriterion("typeId <=", value, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdIn(List<Integer> values) {
            addCriterion("typeId in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotIn(List<Integer> values) {
            addCriterion("typeId not in", values, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdBetween(Integer value1, Integer value2) {
            addCriterion("typeId between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andTypeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("typeId not between", value1, value2, "typeId");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNull() {
            addCriterion("shortName is null");
            return (Criteria) this;
        }

        public Criteria andShortNameIsNotNull() {
            addCriterion("shortName is not null");
            return (Criteria) this;
        }

        public Criteria andShortNameEqualTo(String value) {
            addCriterion("shortName =", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotEqualTo(String value) {
            addCriterion("shortName <>", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThan(String value) {
            addCriterion("shortName >", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("shortName >=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThan(String value) {
            addCriterion("shortName <", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLessThanOrEqualTo(String value) {
            addCriterion("shortName <=", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameLike(String value) {
            addCriterion("shortName like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotLike(String value) {
            addCriterion("shortName not like", value, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameIn(List<String> values) {
            addCriterion("shortName in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotIn(List<String> values) {
            addCriterion("shortName not in", values, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameBetween(String value1, String value2) {
            addCriterion("shortName between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andShortNameNotBetween(String value1, String value2) {
            addCriterion("shortName not between", value1, value2, "shortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameIsNull() {
            addCriterion("inteShortName is null");
            return (Criteria) this;
        }

        public Criteria andInteShortNameIsNotNull() {
            addCriterion("inteShortName is not null");
            return (Criteria) this;
        }

        public Criteria andInteShortNameEqualTo(String value) {
            addCriterion("inteShortName =", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameNotEqualTo(String value) {
            addCriterion("inteShortName <>", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameGreaterThan(String value) {
            addCriterion("inteShortName >", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameGreaterThanOrEqualTo(String value) {
            addCriterion("inteShortName >=", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameLessThan(String value) {
            addCriterion("inteShortName <", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameLessThanOrEqualTo(String value) {
            addCriterion("inteShortName <=", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameLike(String value) {
            addCriterion("inteShortName like", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameNotLike(String value) {
            addCriterion("inteShortName not like", value, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameIn(List<String> values) {
            addCriterion("inteShortName in", values, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameNotIn(List<String> values) {
            addCriterion("inteShortName not in", values, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameBetween(String value1, String value2) {
            addCriterion("inteShortName between", value1, value2, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andInteShortNameNotBetween(String value1, String value2) {
            addCriterion("inteShortName not between", value1, value2, "inteShortName");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitIsNull() {
            addCriterion("validUpperLimit is null");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitIsNotNull() {
            addCriterion("validUpperLimit is not null");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitEqualTo(String value) {
            addCriterion("validUpperLimit =", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitNotEqualTo(String value) {
            addCriterion("validUpperLimit <>", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitGreaterThan(String value) {
            addCriterion("validUpperLimit >", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitGreaterThanOrEqualTo(String value) {
            addCriterion("validUpperLimit >=", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitLessThan(String value) {
            addCriterion("validUpperLimit <", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitLessThanOrEqualTo(String value) {
            addCriterion("validUpperLimit <=", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitLike(String value) {
            addCriterion("validUpperLimit like", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitNotLike(String value) {
            addCriterion("validUpperLimit not like", value, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitIn(List<String> values) {
            addCriterion("validUpperLimit in", values, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitNotIn(List<String> values) {
            addCriterion("validUpperLimit not in", values, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitBetween(String value1, String value2) {
            addCriterion("validUpperLimit between", value1, value2, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidUpperLimitNotBetween(String value1, String value2) {
            addCriterion("validUpperLimit not between", value1, value2, "validUpperLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitIsNull() {
            addCriterion("validLowerLimit is null");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitIsNotNull() {
            addCriterion("validLowerLimit is not null");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitEqualTo(String value) {
            addCriterion("validLowerLimit =", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitNotEqualTo(String value) {
            addCriterion("validLowerLimit <>", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitGreaterThan(String value) {
            addCriterion("validLowerLimit >", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitGreaterThanOrEqualTo(String value) {
            addCriterion("validLowerLimit >=", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitLessThan(String value) {
            addCriterion("validLowerLimit <", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitLessThanOrEqualTo(String value) {
            addCriterion("validLowerLimit <=", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitLike(String value) {
            addCriterion("validLowerLimit like", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitNotLike(String value) {
            addCriterion("validLowerLimit not like", value, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitIn(List<String> values) {
            addCriterion("validLowerLimit in", values, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitNotIn(List<String> values) {
            addCriterion("validLowerLimit not in", values, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitBetween(String value1, String value2) {
            addCriterion("validLowerLimit between", value1, value2, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andValidLowerLimitNotBetween(String value1, String value2) {
            addCriterion("validLowerLimit not between", value1, value2, "validLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitIsNull() {
            addCriterion("outUpperLimit is null");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitIsNotNull() {
            addCriterion("outUpperLimit is not null");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitEqualTo(String value) {
            addCriterion("outUpperLimit =", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitNotEqualTo(String value) {
            addCriterion("outUpperLimit <>", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitGreaterThan(String value) {
            addCriterion("outUpperLimit >", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitGreaterThanOrEqualTo(String value) {
            addCriterion("outUpperLimit >=", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitLessThan(String value) {
            addCriterion("outUpperLimit <", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitLessThanOrEqualTo(String value) {
            addCriterion("outUpperLimit <=", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitLike(String value) {
            addCriterion("outUpperLimit like", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitNotLike(String value) {
            addCriterion("outUpperLimit not like", value, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitIn(List<String> values) {
            addCriterion("outUpperLimit in", values, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitNotIn(List<String> values) {
            addCriterion("outUpperLimit not in", values, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitBetween(String value1, String value2) {
            addCriterion("outUpperLimit between", value1, value2, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutUpperLimitNotBetween(String value1, String value2) {
            addCriterion("outUpperLimit not between", value1, value2, "outUpperLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitIsNull() {
            addCriterion("outLowerLimit is null");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitIsNotNull() {
            addCriterion("outLowerLimit is not null");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitEqualTo(String value) {
            addCriterion("outLowerLimit =", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitNotEqualTo(String value) {
            addCriterion("outLowerLimit <>", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitGreaterThan(String value) {
            addCriterion("outLowerLimit >", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitGreaterThanOrEqualTo(String value) {
            addCriterion("outLowerLimit >=", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitLessThan(String value) {
            addCriterion("outLowerLimit <", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitLessThanOrEqualTo(String value) {
            addCriterion("outLowerLimit <=", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitLike(String value) {
            addCriterion("outLowerLimit like", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitNotLike(String value) {
            addCriterion("outLowerLimit not like", value, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitIn(List<String> values) {
            addCriterion("outLowerLimit in", values, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitNotIn(List<String> values) {
            addCriterion("outLowerLimit not in", values, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitBetween(String value1, String value2) {
            addCriterion("outLowerLimit between", value1, value2, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andOutLowerLimitNotBetween(String value1, String value2) {
            addCriterion("outLowerLimit not between", value1, value2, "outLowerLimit");
            return (Criteria) this;
        }

        public Criteria andUnitIsNull() {
            addCriterion("unit is null");
            return (Criteria) this;
        }

        public Criteria andUnitIsNotNull() {
            addCriterion("unit is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEqualTo(String value) {
            addCriterion("unit =", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotEqualTo(String value) {
            addCriterion("unit <>", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThan(String value) {
            addCriterion("unit >", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitGreaterThanOrEqualTo(String value) {
            addCriterion("unit >=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThan(String value) {
            addCriterion("unit <", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLessThanOrEqualTo(String value) {
            addCriterion("unit <=", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitLike(String value) {
            addCriterion("unit like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotLike(String value) {
            addCriterion("unit not like", value, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitIn(List<String> values) {
            addCriterion("unit in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotIn(List<String> values) {
            addCriterion("unit not in", values, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitBetween(String value1, String value2) {
            addCriterion("unit between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andUnitNotBetween(String value1, String value2) {
            addCriterion("unit not between", value1, value2, "unit");
            return (Criteria) this;
        }

        public Criteria andDigitsIsNull() {
            addCriterion("digits is null");
            return (Criteria) this;
        }

        public Criteria andDigitsIsNotNull() {
            addCriterion("digits is not null");
            return (Criteria) this;
        }

        public Criteria andDigitsEqualTo(Integer value) {
            addCriterion("digits =", value, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsNotEqualTo(Integer value) {
            addCriterion("digits <>", value, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsGreaterThan(Integer value) {
            addCriterion("digits >", value, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsGreaterThanOrEqualTo(Integer value) {
            addCriterion("digits >=", value, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsLessThan(Integer value) {
            addCriterion("digits <", value, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsLessThanOrEqualTo(Integer value) {
            addCriterion("digits <=", value, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsIn(List<Integer> values) {
            addCriterion("digits in", values, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsNotIn(List<Integer> values) {
            addCriterion("digits not in", values, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsBetween(Integer value1, Integer value2) {
            addCriterion("digits between", value1, value2, "digits");
            return (Criteria) this;
        }

        public Criteria andDigitsNotBetween(Integer value1, Integer value2) {
            addCriterion("digits not between", value1, value2, "digits");
            return (Criteria) this;
        }

        public Criteria andMaxRangeIsNull() {
            addCriterion("maxRange is null");
            return (Criteria) this;
        }

        public Criteria andMaxRangeIsNotNull() {
            addCriterion("maxRange is not null");
            return (Criteria) this;
        }

        public Criteria andMaxRangeEqualTo(String value) {
            addCriterion("maxRange =", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeNotEqualTo(String value) {
            addCriterion("maxRange <>", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeGreaterThan(String value) {
            addCriterion("maxRange >", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeGreaterThanOrEqualTo(String value) {
            addCriterion("maxRange >=", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeLessThan(String value) {
            addCriterion("maxRange <", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeLessThanOrEqualTo(String value) {
            addCriterion("maxRange <=", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeLike(String value) {
            addCriterion("maxRange like", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeNotLike(String value) {
            addCriterion("maxRange not like", value, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeIn(List<String> values) {
            addCriterion("maxRange in", values, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeNotIn(List<String> values) {
            addCriterion("maxRange not in", values, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeBetween(String value1, String value2) {
            addCriterion("maxRange between", value1, value2, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMaxRangeNotBetween(String value1, String value2) {
            addCriterion("maxRange not between", value1, value2, "maxRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeIsNull() {
            addCriterion("minRange is null");
            return (Criteria) this;
        }

        public Criteria andMinRangeIsNotNull() {
            addCriterion("minRange is not null");
            return (Criteria) this;
        }

        public Criteria andMinRangeEqualTo(String value) {
            addCriterion("minRange =", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeNotEqualTo(String value) {
            addCriterion("minRange <>", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeGreaterThan(String value) {
            addCriterion("minRange >", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeGreaterThanOrEqualTo(String value) {
            addCriterion("minRange >=", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeLessThan(String value) {
            addCriterion("minRange <", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeLessThanOrEqualTo(String value) {
            addCriterion("minRange <=", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeLike(String value) {
            addCriterion("minRange like", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeNotLike(String value) {
            addCriterion("minRange not like", value, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeIn(List<String> values) {
            addCriterion("minRange in", values, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeNotIn(List<String> values) {
            addCriterion("minRange not in", values, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeBetween(String value1, String value2) {
            addCriterion("minRange between", value1, value2, "minRange");
            return (Criteria) this;
        }

        public Criteria andMinRangeNotBetween(String value1, String value2) {
            addCriterion("minRange not between", value1, value2, "minRange");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("createTime is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("createTime is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("createTime =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("createTime <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("createTime >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("createTime >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("createTime <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("createTime <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("createTime in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("createTime not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("createTime between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("createTime not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("updateTime is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("updateTime is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("updateTime =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("updateTime <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("updateTime >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updateTime >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("updateTime <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("updateTime <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("updateTime in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("updateTime not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("updateTime between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("updateTime not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andRankIsNull() {
            addCriterion("rank is null");
            return (Criteria) this;
        }

        public Criteria andRankIsNotNull() {
            addCriterion("rank is not null");
            return (Criteria) this;
        }

        public Criteria andRankEqualTo(Integer value) {
            addCriterion("rank =", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotEqualTo(Integer value) {
            addCriterion("rank <>", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThan(Integer value) {
            addCriterion("rank >", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankGreaterThanOrEqualTo(Integer value) {
            addCriterion("rank >=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThan(Integer value) {
            addCriterion("rank <", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankLessThanOrEqualTo(Integer value) {
            addCriterion("rank <=", value, "rank");
            return (Criteria) this;
        }

        public Criteria andRankIn(List<Integer> values) {
            addCriterion("rank in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotIn(List<Integer> values) {
            addCriterion("rank not in", values, "rank");
            return (Criteria) this;
        }

        public Criteria andRankBetween(Integer value1, Integer value2) {
            addCriterion("rank between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andRankNotBetween(Integer value1, Integer value2) {
            addCriterion("rank not between", value1, value2, "rank");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNull() {
            addCriterion("isvalid is null");
            return (Criteria) this;
        }

        public Criteria andIsvalidIsNotNull() {
            addCriterion("isvalid is not null");
            return (Criteria) this;
        }

        public Criteria andIsvalidEqualTo(String value) {
            addCriterion("isvalid =", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotEqualTo(String value) {
            addCriterion("isvalid <>", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThan(String value) {
            addCriterion("isvalid >", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidGreaterThanOrEqualTo(String value) {
            addCriterion("isvalid >=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThan(String value) {
            addCriterion("isvalid <", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLessThanOrEqualTo(String value) {
            addCriterion("isvalid <=", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidLike(String value) {
            addCriterion("isvalid like", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotLike(String value) {
            addCriterion("isvalid not like", value, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidIn(List<String> values) {
            addCriterion("isvalid in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotIn(List<String> values) {
            addCriterion("isvalid not in", values, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidBetween(String value1, String value2) {
            addCriterion("isvalid between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andIsvalidNotBetween(String value1, String value2) {
            addCriterion("isvalid not between", value1, value2, "isvalid");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionIsNull() {
            addCriterion("zeroSolution is null");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionIsNotNull() {
            addCriterion("zeroSolution is not null");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionEqualTo(Integer value) {
            addCriterion("zeroSolution =", value, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionNotEqualTo(Integer value) {
            addCriterion("zeroSolution <>", value, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionGreaterThan(Integer value) {
            addCriterion("zeroSolution >", value, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionGreaterThanOrEqualTo(Integer value) {
            addCriterion("zeroSolution >=", value, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionLessThan(Integer value) {
            addCriterion("zeroSolution <", value, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionLessThanOrEqualTo(Integer value) {
            addCriterion("zeroSolution <=", value, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionIn(List<Integer> values) {
            addCriterion("zeroSolution in", values, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionNotIn(List<Integer> values) {
            addCriterion("zeroSolution not in", values, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionBetween(Integer value1, Integer value2) {
            addCriterion("zeroSolution between", value1, value2, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSolutionNotBetween(Integer value1, Integer value2) {
            addCriterion("zeroSolution not between", value1, value2, "zeroSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionIsNull() {
            addCriterion("spanSolution is null");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionIsNotNull() {
            addCriterion("spanSolution is not null");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionEqualTo(Integer value) {
            addCriterion("spanSolution =", value, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionNotEqualTo(Integer value) {
            addCriterion("spanSolution <>", value, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionGreaterThan(Integer value) {
            addCriterion("spanSolution >", value, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionGreaterThanOrEqualTo(Integer value) {
            addCriterion("spanSolution >=", value, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionLessThan(Integer value) {
            addCriterion("spanSolution <", value, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionLessThanOrEqualTo(Integer value) {
            addCriterion("spanSolution <=", value, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionIn(List<Integer> values) {
            addCriterion("spanSolution in", values, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionNotIn(List<Integer> values) {
            addCriterion("spanSolution not in", values, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionBetween(Integer value1, Integer value2) {
            addCriterion("spanSolution between", value1, value2, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andSpanSolutionNotBetween(Integer value1, Integer value2) {
            addCriterion("spanSolution not between", value1, value2, "spanSolution");
            return (Criteria) this;
        }

        public Criteria andZeroSpanIsNull() {
            addCriterion("zeroSpan is null");
            return (Criteria) this;
        }

        public Criteria andZeroSpanIsNotNull() {
            addCriterion("zeroSpan is not null");
            return (Criteria) this;
        }

        public Criteria andZeroSpanEqualTo(Integer value) {
            addCriterion("zeroSpan =", value, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanNotEqualTo(Integer value) {
            addCriterion("zeroSpan <>", value, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanGreaterThan(Integer value) {
            addCriterion("zeroSpan >", value, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanGreaterThanOrEqualTo(Integer value) {
            addCriterion("zeroSpan >=", value, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanLessThan(Integer value) {
            addCriterion("zeroSpan <", value, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanLessThanOrEqualTo(Integer value) {
            addCriterion("zeroSpan <=", value, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanIn(List<Integer> values) {
            addCriterion("zeroSpan in", values, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanNotIn(List<Integer> values) {
            addCriterion("zeroSpan not in", values, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanBetween(Integer value1, Integer value2) {
            addCriterion("zeroSpan between", value1, value2, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andZeroSpanNotBetween(Integer value1, Integer value2) {
            addCriterion("zeroSpan not between", value1, value2, "zeroSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanIsNull() {
            addCriterion("spanSpan is null");
            return (Criteria) this;
        }

        public Criteria andSpanSpanIsNotNull() {
            addCriterion("spanSpan is not null");
            return (Criteria) this;
        }

        public Criteria andSpanSpanEqualTo(Integer value) {
            addCriterion("spanSpan =", value, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanNotEqualTo(Integer value) {
            addCriterion("spanSpan <>", value, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanGreaterThan(Integer value) {
            addCriterion("spanSpan >", value, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanGreaterThanOrEqualTo(Integer value) {
            addCriterion("spanSpan >=", value, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanLessThan(Integer value) {
            addCriterion("spanSpan <", value, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanLessThanOrEqualTo(Integer value) {
            addCriterion("spanSpan <=", value, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanIn(List<Integer> values) {
            addCriterion("spanSpan in", values, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanNotIn(List<Integer> values) {
            addCriterion("spanSpan not in", values, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanBetween(Integer value1, Integer value2) {
            addCriterion("spanSpan between", value1, value2, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andSpanSpanNotBetween(Integer value1, Integer value2) {
            addCriterion("spanSpan not between", value1, value2, "spanSpan");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorIsNull() {
            addCriterion("zeroAbsError is null");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorIsNotNull() {
            addCriterion("zeroAbsError is not null");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorEqualTo(Double value) {
            addCriterion("zeroAbsError =", value, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorNotEqualTo(Double value) {
            addCriterion("zeroAbsError <>", value, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorGreaterThan(Double value) {
            addCriterion("zeroAbsError >", value, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorGreaterThanOrEqualTo(Double value) {
            addCriterion("zeroAbsError >=", value, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorLessThan(Double value) {
            addCriterion("zeroAbsError <", value, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorLessThanOrEqualTo(Double value) {
            addCriterion("zeroAbsError <=", value, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorIn(List<Double> values) {
            addCriterion("zeroAbsError in", values, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorNotIn(List<Double> values) {
            addCriterion("zeroAbsError not in", values, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorBetween(Double value1, Double value2) {
            addCriterion("zeroAbsError between", value1, value2, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroAbsErrorNotBetween(Double value1, Double value2) {
            addCriterion("zeroAbsError not between", value1, value2, "zeroAbsError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorIsNull() {
            addCriterion("zeroRelaError is null");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorIsNotNull() {
            addCriterion("zeroRelaError is not null");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorEqualTo(Double value) {
            addCriterion("zeroRelaError =", value, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorNotEqualTo(Double value) {
            addCriterion("zeroRelaError <>", value, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorGreaterThan(Double value) {
            addCriterion("zeroRelaError >", value, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorGreaterThanOrEqualTo(Double value) {
            addCriterion("zeroRelaError >=", value, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorLessThan(Double value) {
            addCriterion("zeroRelaError <", value, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorLessThanOrEqualTo(Double value) {
            addCriterion("zeroRelaError <=", value, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorIn(List<Double> values) {
            addCriterion("zeroRelaError in", values, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorNotIn(List<Double> values) {
            addCriterion("zeroRelaError not in", values, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorBetween(Double value1, Double value2) {
            addCriterion("zeroRelaError between", value1, value2, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andZeroRelaErrorNotBetween(Double value1, Double value2) {
            addCriterion("zeroRelaError not between", value1, value2, "zeroRelaError");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1IsNull() {
            addCriterion("spanRelaError1 is null");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1IsNotNull() {
            addCriterion("spanRelaError1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1EqualTo(Double value) {
            addCriterion("spanRelaError1 =", value, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1NotEqualTo(Double value) {
            addCriterion("spanRelaError1 <>", value, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1GreaterThan(Double value) {
            addCriterion("spanRelaError1 >", value, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1GreaterThanOrEqualTo(Double value) {
            addCriterion("spanRelaError1 >=", value, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1LessThan(Double value) {
            addCriterion("spanRelaError1 <", value, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1LessThanOrEqualTo(Double value) {
            addCriterion("spanRelaError1 <=", value, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1In(List<Double> values) {
            addCriterion("spanRelaError1 in", values, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1NotIn(List<Double> values) {
            addCriterion("spanRelaError1 not in", values, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1Between(Double value1, Double value2) {
            addCriterion("spanRelaError1 between", value1, value2, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError1NotBetween(Double value1, Double value2) {
            addCriterion("spanRelaError1 not between", value1, value2, "spanRelaError1");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2IsNull() {
            addCriterion("spanRelaError2 is null");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2IsNotNull() {
            addCriterion("spanRelaError2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2EqualTo(Double value) {
            addCriterion("spanRelaError2 =", value, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2NotEqualTo(Double value) {
            addCriterion("spanRelaError2 <>", value, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2GreaterThan(Double value) {
            addCriterion("spanRelaError2 >", value, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2GreaterThanOrEqualTo(Double value) {
            addCriterion("spanRelaError2 >=", value, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2LessThan(Double value) {
            addCriterion("spanRelaError2 <", value, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2LessThanOrEqualTo(Double value) {
            addCriterion("spanRelaError2 <=", value, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2In(List<Double> values) {
            addCriterion("spanRelaError2 in", values, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2NotIn(List<Double> values) {
            addCriterion("spanRelaError2 not in", values, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2Between(Double value1, Double value2) {
            addCriterion("spanRelaError2 between", value1, value2, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andSpanRelaError2NotBetween(Double value1, Double value2) {
            addCriterion("spanRelaError2 not between", value1, value2, "spanRelaError2");
            return (Criteria) this;
        }

        public Criteria andOftenIsNull() {
            addCriterion("often is null");
            return (Criteria) this;
        }

        public Criteria andOftenIsNotNull() {
            addCriterion("often is not null");
            return (Criteria) this;
        }

        public Criteria andOftenEqualTo(String value) {
            addCriterion("often =", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenNotEqualTo(String value) {
            addCriterion("often <>", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenGreaterThan(String value) {
            addCriterion("often >", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenGreaterThanOrEqualTo(String value) {
            addCriterion("often >=", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenLessThan(String value) {
            addCriterion("often <", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenLessThanOrEqualTo(String value) {
            addCriterion("often <=", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenLike(String value) {
            addCriterion("often like", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenNotLike(String value) {
            addCriterion("often not like", value, "often");
            return (Criteria) this;
        }

        public Criteria andOftenIn(List<String> values) {
            addCriterion("often in", values, "often");
            return (Criteria) this;
        }

        public Criteria andOftenNotIn(List<String> values) {
            addCriterion("often not in", values, "often");
            return (Criteria) this;
        }

        public Criteria andOftenBetween(String value1, String value2) {
            addCriterion("often between", value1, value2, "often");
            return (Criteria) this;
        }

        public Criteria andOftenNotBetween(String value1, String value2) {
            addCriterion("often not between", value1, value2, "often");
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