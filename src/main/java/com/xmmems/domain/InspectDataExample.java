package com.xmmems.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class InspectDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public InspectDataExample() {
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
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
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

        public Criteria andGenTimeIsNull() {
            addCriterion("genTime is null");
            return (Criteria) this;
        }

        public Criteria andGenTimeIsNotNull() {
            addCriterion("genTime is not null");
            return (Criteria) this;
        }

        public Criteria andGenTimeEqualTo(Date value) {
            addCriterionForJDBCDate("genTime =", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeNotEqualTo(Date value) {
            addCriterionForJDBCDate("genTime <>", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeGreaterThan(Date value) {
            addCriterionForJDBCDate("genTime >", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("genTime >=", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeLessThan(Date value) {
            addCriterionForJDBCDate("genTime <", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("genTime <=", value, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeIn(List<Date> values) {
            addCriterionForJDBCDate("genTime in", values, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeNotIn(List<Date> values) {
            addCriterionForJDBCDate("genTime not in", values, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("genTime between", value1, value2, "genTime");
            return (Criteria) this;
        }

        public Criteria andGenTimeNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("genTime not between", value1, value2, "genTime");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueIsNull() {
            addCriterion("InstrumentValue is null");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueIsNotNull() {
            addCriterion("InstrumentValue is not null");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueEqualTo(String value) {
            addCriterion("InstrumentValue =", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueNotEqualTo(String value) {
            addCriterion("InstrumentValue <>", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueGreaterThan(String value) {
            addCriterion("InstrumentValue >", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueGreaterThanOrEqualTo(String value) {
            addCriterion("InstrumentValue >=", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueLessThan(String value) {
            addCriterion("InstrumentValue <", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueLessThanOrEqualTo(String value) {
            addCriterion("InstrumentValue <=", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueLike(String value) {
            addCriterion("InstrumentValue like", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueNotLike(String value) {
            addCriterion("InstrumentValue not like", value, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueIn(List<String> values) {
            addCriterion("InstrumentValue in", values, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueNotIn(List<String> values) {
            addCriterion("InstrumentValue not in", values, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueBetween(String value1, String value2) {
            addCriterion("InstrumentValue between", value1, value2, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andInstrumentValueNotBetween(String value1, String value2) {
            addCriterion("InstrumentValue not between", value1, value2, "instrumentValue");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeIsNull() {
            addCriterion("certificateCode is null");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeIsNotNull() {
            addCriterion("certificateCode is not null");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeEqualTo(String value) {
            addCriterion("certificateCode =", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotEqualTo(String value) {
            addCriterion("certificateCode <>", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeGreaterThan(String value) {
            addCriterion("certificateCode >", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeGreaterThanOrEqualTo(String value) {
            addCriterion("certificateCode >=", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeLessThan(String value) {
            addCriterion("certificateCode <", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeLessThanOrEqualTo(String value) {
            addCriterion("certificateCode <=", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeLike(String value) {
            addCriterion("certificateCode like", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotLike(String value) {
            addCriterion("certificateCode not like", value, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeIn(List<String> values) {
            addCriterion("certificateCode in", values, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotIn(List<String> values) {
            addCriterion("certificateCode not in", values, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeBetween(String value1, String value2) {
            addCriterion("certificateCode between", value1, value2, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andCertificateCodeNotBetween(String value1, String value2) {
            addCriterion("certificateCode not between", value1, value2, "certificateCode");
            return (Criteria) this;
        }

        public Criteria andSolubilityIsNull() {
            addCriterion("solubility is null");
            return (Criteria) this;
        }

        public Criteria andSolubilityIsNotNull() {
            addCriterion("solubility is not null");
            return (Criteria) this;
        }

        public Criteria andSolubilityEqualTo(String value) {
            addCriterion("solubility =", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityNotEqualTo(String value) {
            addCriterion("solubility <>", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityGreaterThan(String value) {
            addCriterion("solubility >", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityGreaterThanOrEqualTo(String value) {
            addCriterion("solubility >=", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityLessThan(String value) {
            addCriterion("solubility <", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityLessThanOrEqualTo(String value) {
            addCriterion("solubility <=", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityLike(String value) {
            addCriterion("solubility like", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityNotLike(String value) {
            addCriterion("solubility not like", value, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityIn(List<String> values) {
            addCriterion("solubility in", values, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityNotIn(List<String> values) {
            addCriterion("solubility not in", values, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityBetween(String value1, String value2) {
            addCriterion("solubility between", value1, value2, "solubility");
            return (Criteria) this;
        }

        public Criteria andSolubilityNotBetween(String value1, String value2) {
            addCriterion("solubility not between", value1, value2, "solubility");
            return (Criteria) this;
        }

        public Criteria andErrorValueIsNull() {
            addCriterion("errorValue is null");
            return (Criteria) this;
        }

        public Criteria andErrorValueIsNotNull() {
            addCriterion("errorValue is not null");
            return (Criteria) this;
        }

        public Criteria andErrorValueEqualTo(String value) {
            addCriterion("errorValue =", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueNotEqualTo(String value) {
            addCriterion("errorValue <>", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueGreaterThan(String value) {
            addCriterion("errorValue >", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueGreaterThanOrEqualTo(String value) {
            addCriterion("errorValue >=", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueLessThan(String value) {
            addCriterion("errorValue <", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueLessThanOrEqualTo(String value) {
            addCriterion("errorValue <=", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueLike(String value) {
            addCriterion("errorValue like", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueNotLike(String value) {
            addCriterion("errorValue not like", value, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueIn(List<String> values) {
            addCriterion("errorValue in", values, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueNotIn(List<String> values) {
            addCriterion("errorValue not in", values, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueBetween(String value1, String value2) {
            addCriterion("errorValue between", value1, value2, "errorValue");
            return (Criteria) this;
        }

        public Criteria andErrorValueNotBetween(String value1, String value2) {
            addCriterion("errorValue not between", value1, value2, "errorValue");
            return (Criteria) this;
        }

        public Criteria andQualifiedIsNull() {
            addCriterion("qualified is null");
            return (Criteria) this;
        }

        public Criteria andQualifiedIsNotNull() {
            addCriterion("qualified is not null");
            return (Criteria) this;
        }

        public Criteria andQualifiedEqualTo(String value) {
            addCriterion("qualified =", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotEqualTo(String value) {
            addCriterion("qualified <>", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedGreaterThan(String value) {
            addCriterion("qualified >", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedGreaterThanOrEqualTo(String value) {
            addCriterion("qualified >=", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedLessThan(String value) {
            addCriterion("qualified <", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedLessThanOrEqualTo(String value) {
            addCriterion("qualified <=", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedLike(String value) {
            addCriterion("qualified like", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotLike(String value) {
            addCriterion("qualified not like", value, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedIn(List<String> values) {
            addCriterion("qualified in", values, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotIn(List<String> values) {
            addCriterion("qualified not in", values, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedBetween(String value1, String value2) {
            addCriterion("qualified between", value1, value2, "qualified");
            return (Criteria) this;
        }

        public Criteria andQualifiedNotBetween(String value1, String value2) {
            addCriterion("qualified not between", value1, value2, "qualified");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNull() {
            addCriterion("itemName is null");
            return (Criteria) this;
        }

        public Criteria andItemNameIsNotNull() {
            addCriterion("itemName is not null");
            return (Criteria) this;
        }

        public Criteria andItemNameEqualTo(String value) {
            addCriterion("itemName =", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotEqualTo(String value) {
            addCriterion("itemName <>", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThan(String value) {
            addCriterion("itemName >", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameGreaterThanOrEqualTo(String value) {
            addCriterion("itemName >=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThan(String value) {
            addCriterion("itemName <", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLessThanOrEqualTo(String value) {
            addCriterion("itemName <=", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameLike(String value) {
            addCriterion("itemName like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotLike(String value) {
            addCriterion("itemName not like", value, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameIn(List<String> values) {
            addCriterion("itemName in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotIn(List<String> values) {
            addCriterion("itemName not in", values, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameBetween(String value1, String value2) {
            addCriterion("itemName between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemNameNotBetween(String value1, String value2) {
            addCriterion("itemName not between", value1, value2, "itemName");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNull() {
            addCriterion("itemId is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("itemId is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("itemId =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("itemId <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("itemId >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("itemId >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("itemId <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("itemId <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("itemId in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("itemId not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("itemId between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("itemId not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andFlagIsNull() {
            addCriterion("flag is null");
            return (Criteria) this;
        }

        public Criteria andFlagIsNotNull() {
            addCriterion("flag is not null");
            return (Criteria) this;
        }

        public Criteria andFlagEqualTo(String value) {
            addCriterion("flag =", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotEqualTo(String value) {
            addCriterion("flag <>", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThan(String value) {
            addCriterion("flag >", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagGreaterThanOrEqualTo(String value) {
            addCriterion("flag >=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThan(String value) {
            addCriterion("flag <", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLessThanOrEqualTo(String value) {
            addCriterion("flag <=", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagLike(String value) {
            addCriterion("flag like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotLike(String value) {
            addCriterion("flag not like", value, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagIn(List<String> values) {
            addCriterion("flag in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotIn(List<String> values) {
            addCriterion("flag not in", values, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagBetween(String value1, String value2) {
            addCriterion("flag between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andFlagNotBetween(String value1, String value2) {
            addCriterion("flag not between", value1, value2, "flag");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNull() {
            addCriterion("siteId is null");
            return (Criteria) this;
        }

        public Criteria andSiteIdIsNotNull() {
            addCriterion("siteId is not null");
            return (Criteria) this;
        }

        public Criteria andSiteIdEqualTo(Integer value) {
            addCriterion("siteId =", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotEqualTo(Integer value) {
            addCriterion("siteId <>", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThan(Integer value) {
            addCriterion("siteId >", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("siteId >=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThan(Integer value) {
            addCriterion("siteId <", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdLessThanOrEqualTo(Integer value) {
            addCriterion("siteId <=", value, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdIn(List<Integer> values) {
            addCriterion("siteId in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotIn(List<Integer> values) {
            addCriterion("siteId not in", values, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdBetween(Integer value1, Integer value2) {
            addCriterion("siteId between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteIdNotBetween(Integer value1, Integer value2) {
            addCriterion("siteId not between", value1, value2, "siteId");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNull() {
            addCriterion("siteName is null");
            return (Criteria) this;
        }

        public Criteria andSiteNameIsNotNull() {
            addCriterion("siteName is not null");
            return (Criteria) this;
        }

        public Criteria andSiteNameEqualTo(String value) {
            addCriterion("siteName =", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotEqualTo(String value) {
            addCriterion("siteName <>", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThan(String value) {
            addCriterion("siteName >", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameGreaterThanOrEqualTo(String value) {
            addCriterion("siteName >=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThan(String value) {
            addCriterion("siteName <", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLessThanOrEqualTo(String value) {
            addCriterion("siteName <=", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameLike(String value) {
            addCriterion("siteName like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotLike(String value) {
            addCriterion("siteName not like", value, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameIn(List<String> values) {
            addCriterion("siteName in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotIn(List<String> values) {
            addCriterion("siteName not in", values, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameBetween(String value1, String value2) {
            addCriterion("siteName between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andSiteNameNotBetween(String value1, String value2) {
            addCriterion("siteName not between", value1, value2, "siteName");
            return (Criteria) this;
        }

        public Criteria andClaimIsNull() {
            addCriterion("claim is null");
            return (Criteria) this;
        }

        public Criteria andClaimIsNotNull() {
            addCriterion("claim is not null");
            return (Criteria) this;
        }

        public Criteria andClaimEqualTo(String value) {
            addCriterion("claim =", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotEqualTo(String value) {
            addCriterion("claim <>", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimGreaterThan(String value) {
            addCriterion("claim >", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimGreaterThanOrEqualTo(String value) {
            addCriterion("claim >=", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimLessThan(String value) {
            addCriterion("claim <", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimLessThanOrEqualTo(String value) {
            addCriterion("claim <=", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimLike(String value) {
            addCriterion("claim like", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotLike(String value) {
            addCriterion("claim not like", value, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimIn(List<String> values) {
            addCriterion("claim in", values, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotIn(List<String> values) {
            addCriterion("claim not in", values, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimBetween(String value1, String value2) {
            addCriterion("claim between", value1, value2, "claim");
            return (Criteria) this;
        }

        public Criteria andClaimNotBetween(String value1, String value2) {
            addCriterion("claim not between", value1, value2, "claim");
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