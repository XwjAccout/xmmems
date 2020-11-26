package com.xmmems.domain.temp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TempMoniDataExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TempMoniDataExample() {
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

        public Criteria andMoniTimeIsNull() {
            addCriterion("moniTime is null");
            return (Criteria) this;
        }

        public Criteria andMoniTimeIsNotNull() {
            addCriterion("moniTime is not null");
            return (Criteria) this;
        }

        public Criteria andMoniTimeEqualTo(Date value) {
            addCriterion("moniTime =", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeNotEqualTo(Date value) {
            addCriterion("moniTime <>", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeGreaterThan(Date value) {
            addCriterion("moniTime >", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("moniTime >=", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeLessThan(Date value) {
            addCriterion("moniTime <", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeLessThanOrEqualTo(Date value) {
            addCriterion("moniTime <=", value, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeIn(List<Date> values) {
            addCriterion("moniTime in", values, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeNotIn(List<Date> values) {
            addCriterion("moniTime not in", values, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeBetween(Date value1, Date value2) {
            addCriterion("moniTime between", value1, value2, "moniTime");
            return (Criteria) this;
        }

        public Criteria andMoniTimeNotBetween(Date value1, Date value2) {
            addCriterion("moniTime not between", value1, value2, "moniTime");
            return (Criteria) this;
        }

        public Criteria andSwIsNull() {
            addCriterion("sw is null");
            return (Criteria) this;
        }

        public Criteria andSwIsNotNull() {
            addCriterion("sw is not null");
            return (Criteria) this;
        }

        public Criteria andSwEqualTo(String value) {
            addCriterion("sw =", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwNotEqualTo(String value) {
            addCriterion("sw <>", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwGreaterThan(String value) {
            addCriterion("sw >", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwGreaterThanOrEqualTo(String value) {
            addCriterion("sw >=", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwLessThan(String value) {
            addCriterion("sw <", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwLessThanOrEqualTo(String value) {
            addCriterion("sw <=", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwLike(String value) {
            addCriterion("sw like", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwNotLike(String value) {
            addCriterion("sw not like", value, "sw");
            return (Criteria) this;
        }

        public Criteria andSwIn(List<String> values) {
            addCriterion("sw in", values, "sw");
            return (Criteria) this;
        }

        public Criteria andSwNotIn(List<String> values) {
            addCriterion("sw not in", values, "sw");
            return (Criteria) this;
        }

        public Criteria andSwBetween(String value1, String value2) {
            addCriterion("sw between", value1, value2, "sw");
            return (Criteria) this;
        }

        public Criteria andSwNotBetween(String value1, String value2) {
            addCriterion("sw not between", value1, value2, "sw");
            return (Criteria) this;
        }

        public Criteria andPhIsNull() {
            addCriterion("ph is null");
            return (Criteria) this;
        }

        public Criteria andPhIsNotNull() {
            addCriterion("ph is not null");
            return (Criteria) this;
        }

        public Criteria andPhEqualTo(String value) {
            addCriterion("ph =", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotEqualTo(String value) {
            addCriterion("ph <>", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThan(String value) {
            addCriterion("ph >", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhGreaterThanOrEqualTo(String value) {
            addCriterion("ph >=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThan(String value) {
            addCriterion("ph <", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLessThanOrEqualTo(String value) {
            addCriterion("ph <=", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhLike(String value) {
            addCriterion("ph like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotLike(String value) {
            addCriterion("ph not like", value, "ph");
            return (Criteria) this;
        }

        public Criteria andPhIn(List<String> values) {
            addCriterion("ph in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotIn(List<String> values) {
            addCriterion("ph not in", values, "ph");
            return (Criteria) this;
        }

        public Criteria andPhBetween(String value1, String value2) {
            addCriterion("ph between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andPhNotBetween(String value1, String value2) {
            addCriterion("ph not between", value1, value2, "ph");
            return (Criteria) this;
        }

        public Criteria andRjyIsNull() {
            addCriterion("rjy is null");
            return (Criteria) this;
        }

        public Criteria andRjyIsNotNull() {
            addCriterion("rjy is not null");
            return (Criteria) this;
        }

        public Criteria andRjyEqualTo(String value) {
            addCriterion("rjy =", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotEqualTo(String value) {
            addCriterion("rjy <>", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyGreaterThan(String value) {
            addCriterion("rjy >", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyGreaterThanOrEqualTo(String value) {
            addCriterion("rjy >=", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLessThan(String value) {
            addCriterion("rjy <", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLessThanOrEqualTo(String value) {
            addCriterion("rjy <=", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyLike(String value) {
            addCriterion("rjy like", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotLike(String value) {
            addCriterion("rjy not like", value, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyIn(List<String> values) {
            addCriterion("rjy in", values, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotIn(List<String> values) {
            addCriterion("rjy not in", values, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyBetween(String value1, String value2) {
            addCriterion("rjy between", value1, value2, "rjy");
            return (Criteria) this;
        }

        public Criteria andRjyNotBetween(String value1, String value2) {
            addCriterion("rjy not between", value1, value2, "rjy");
            return (Criteria) this;
        }

        public Criteria andDdlIsNull() {
            addCriterion("ddl is null");
            return (Criteria) this;
        }

        public Criteria andDdlIsNotNull() {
            addCriterion("ddl is not null");
            return (Criteria) this;
        }

        public Criteria andDdlEqualTo(String value) {
            addCriterion("ddl =", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotEqualTo(String value) {
            addCriterion("ddl <>", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThan(String value) {
            addCriterion("ddl >", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlGreaterThanOrEqualTo(String value) {
            addCriterion("ddl >=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThan(String value) {
            addCriterion("ddl <", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLessThanOrEqualTo(String value) {
            addCriterion("ddl <=", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlLike(String value) {
            addCriterion("ddl like", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotLike(String value) {
            addCriterion("ddl not like", value, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlIn(List<String> values) {
            addCriterion("ddl in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotIn(List<String> values) {
            addCriterion("ddl not in", values, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlBetween(String value1, String value2) {
            addCriterion("ddl between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andDdlNotBetween(String value1, String value2) {
            addCriterion("ddl not between", value1, value2, "ddl");
            return (Criteria) this;
        }

        public Criteria andZdIsNull() {
            addCriterion("zd is null");
            return (Criteria) this;
        }

        public Criteria andZdIsNotNull() {
            addCriterion("zd is not null");
            return (Criteria) this;
        }

        public Criteria andZdEqualTo(String value) {
            addCriterion("zd =", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotEqualTo(String value) {
            addCriterion("zd <>", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdGreaterThan(String value) {
            addCriterion("zd >", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdGreaterThanOrEqualTo(String value) {
            addCriterion("zd >=", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdLessThan(String value) {
            addCriterion("zd <", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdLessThanOrEqualTo(String value) {
            addCriterion("zd <=", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdLike(String value) {
            addCriterion("zd like", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotLike(String value) {
            addCriterion("zd not like", value, "zd");
            return (Criteria) this;
        }

        public Criteria andZdIn(List<String> values) {
            addCriterion("zd in", values, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotIn(List<String> values) {
            addCriterion("zd not in", values, "zd");
            return (Criteria) this;
        }

        public Criteria andZdBetween(String value1, String value2) {
            addCriterion("zd between", value1, value2, "zd");
            return (Criteria) this;
        }

        public Criteria andZdNotBetween(String value1, String value2) {
            addCriterion("zd not between", value1, value2, "zd");
            return (Criteria) this;
        }

        public Criteria andGmsyIsNull() {
            addCriterion("gmsy is null");
            return (Criteria) this;
        }

        public Criteria andGmsyIsNotNull() {
            addCriterion("gmsy is not null");
            return (Criteria) this;
        }

        public Criteria andGmsyEqualTo(String value) {
            addCriterion("gmsy =", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotEqualTo(String value) {
            addCriterion("gmsy <>", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyGreaterThan(String value) {
            addCriterion("gmsy >", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyGreaterThanOrEqualTo(String value) {
            addCriterion("gmsy >=", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLessThan(String value) {
            addCriterion("gmsy <", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLessThanOrEqualTo(String value) {
            addCriterion("gmsy <=", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyLike(String value) {
            addCriterion("gmsy like", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotLike(String value) {
            addCriterion("gmsy not like", value, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyIn(List<String> values) {
            addCriterion("gmsy in", values, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotIn(List<String> values) {
            addCriterion("gmsy not in", values, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyBetween(String value1, String value2) {
            addCriterion("gmsy between", value1, value2, "gmsy");
            return (Criteria) this;
        }

        public Criteria andGmsyNotBetween(String value1, String value2) {
            addCriterion("gmsy not between", value1, value2, "gmsy");
            return (Criteria) this;
        }

        public Criteria andZlIsNull() {
            addCriterion("zl is null");
            return (Criteria) this;
        }

        public Criteria andZlIsNotNull() {
            addCriterion("zl is not null");
            return (Criteria) this;
        }

        public Criteria andZlEqualTo(String value) {
            addCriterion("zl =", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotEqualTo(String value) {
            addCriterion("zl <>", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThan(String value) {
            addCriterion("zl >", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlGreaterThanOrEqualTo(String value) {
            addCriterion("zl >=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThan(String value) {
            addCriterion("zl <", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLessThanOrEqualTo(String value) {
            addCriterion("zl <=", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlLike(String value) {
            addCriterion("zl like", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotLike(String value) {
            addCriterion("zl not like", value, "zl");
            return (Criteria) this;
        }

        public Criteria andZlIn(List<String> values) {
            addCriterion("zl in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotIn(List<String> values) {
            addCriterion("zl not in", values, "zl");
            return (Criteria) this;
        }

        public Criteria andZlBetween(String value1, String value2) {
            addCriterion("zl between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andZlNotBetween(String value1, String value2) {
            addCriterion("zl not between", value1, value2, "zl");
            return (Criteria) this;
        }

        public Criteria andAdIsNull() {
            addCriterion("ad is null");
            return (Criteria) this;
        }

        public Criteria andAdIsNotNull() {
            addCriterion("ad is not null");
            return (Criteria) this;
        }

        public Criteria andAdEqualTo(String value) {
            addCriterion("ad =", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotEqualTo(String value) {
            addCriterion("ad <>", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThan(String value) {
            addCriterion("ad >", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdGreaterThanOrEqualTo(String value) {
            addCriterion("ad >=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThan(String value) {
            addCriterion("ad <", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLessThanOrEqualTo(String value) {
            addCriterion("ad <=", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdLike(String value) {
            addCriterion("ad like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotLike(String value) {
            addCriterion("ad not like", value, "ad");
            return (Criteria) this;
        }

        public Criteria andAdIn(List<String> values) {
            addCriterion("ad in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotIn(List<String> values) {
            addCriterion("ad not in", values, "ad");
            return (Criteria) this;
        }

        public Criteria andAdBetween(String value1, String value2) {
            addCriterion("ad between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andAdNotBetween(String value1, String value2) {
            addCriterion("ad not between", value1, value2, "ad");
            return (Criteria) this;
        }

        public Criteria andXdIsNull() {
            addCriterion("xd is null");
            return (Criteria) this;
        }

        public Criteria andXdIsNotNull() {
            addCriterion("xd is not null");
            return (Criteria) this;
        }

        public Criteria andXdEqualTo(String value) {
            addCriterion("xd =", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdNotEqualTo(String value) {
            addCriterion("xd <>", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdGreaterThan(String value) {
            addCriterion("xd >", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdGreaterThanOrEqualTo(String value) {
            addCriterion("xd >=", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdLessThan(String value) {
            addCriterion("xd <", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdLessThanOrEqualTo(String value) {
            addCriterion("xd <=", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdLike(String value) {
            addCriterion("xd like", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdNotLike(String value) {
            addCriterion("xd not like", value, "xd");
            return (Criteria) this;
        }

        public Criteria andXdIn(List<String> values) {
            addCriterion("xd in", values, "xd");
            return (Criteria) this;
        }

        public Criteria andXdNotIn(List<String> values) {
            addCriterion("xd not in", values, "xd");
            return (Criteria) this;
        }

        public Criteria andXdBetween(String value1, String value2) {
            addCriterion("xd between", value1, value2, "xd");
            return (Criteria) this;
        }

        public Criteria andXdNotBetween(String value1, String value2) {
            addCriterion("xd not between", value1, value2, "xd");
            return (Criteria) this;
        }

        public Criteria andFhwIsNull() {
            addCriterion("fhw is null");
            return (Criteria) this;
        }

        public Criteria andFhwIsNotNull() {
            addCriterion("fhw is not null");
            return (Criteria) this;
        }

        public Criteria andFhwEqualTo(String value) {
            addCriterion("fhw =", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwNotEqualTo(String value) {
            addCriterion("fhw <>", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwGreaterThan(String value) {
            addCriterion("fhw >", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwGreaterThanOrEqualTo(String value) {
            addCriterion("fhw >=", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwLessThan(String value) {
            addCriterion("fhw <", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwLessThanOrEqualTo(String value) {
            addCriterion("fhw <=", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwLike(String value) {
            addCriterion("fhw like", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwNotLike(String value) {
            addCriterion("fhw not like", value, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwIn(List<String> values) {
            addCriterion("fhw in", values, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwNotIn(List<String> values) {
            addCriterion("fhw not in", values, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwBetween(String value1, String value2) {
            addCriterion("fhw between", value1, value2, "fhw");
            return (Criteria) this;
        }

        public Criteria andFhwNotBetween(String value1, String value2) {
            addCriterion("fhw not between", value1, value2, "fhw");
            return (Criteria) this;
        }

        public Criteria andQhwIsNull() {
            addCriterion("qhw is null");
            return (Criteria) this;
        }

        public Criteria andQhwIsNotNull() {
            addCriterion("qhw is not null");
            return (Criteria) this;
        }

        public Criteria andQhwEqualTo(String value) {
            addCriterion("qhw =", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwNotEqualTo(String value) {
            addCriterion("qhw <>", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwGreaterThan(String value) {
            addCriterion("qhw >", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwGreaterThanOrEqualTo(String value) {
            addCriterion("qhw >=", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwLessThan(String value) {
            addCriterion("qhw <", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwLessThanOrEqualTo(String value) {
            addCriterion("qhw <=", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwLike(String value) {
            addCriterion("qhw like", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwNotLike(String value) {
            addCriterion("qhw not like", value, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwIn(List<String> values) {
            addCriterion("qhw in", values, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwNotIn(List<String> values) {
            addCriterion("qhw not in", values, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwBetween(String value1, String value2) {
            addCriterion("qhw between", value1, value2, "qhw");
            return (Criteria) this;
        }

        public Criteria andQhwNotBetween(String value1, String value2) {
            addCriterion("qhw not between", value1, value2, "qhw");
            return (Criteria) this;
        }

        public Criteria andCdIsNull() {
            addCriterion("cd is null");
            return (Criteria) this;
        }

        public Criteria andCdIsNotNull() {
            addCriterion("cd is not null");
            return (Criteria) this;
        }

        public Criteria andCdEqualTo(String value) {
            addCriterion("cd =", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdNotEqualTo(String value) {
            addCriterion("cd <>", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdGreaterThan(String value) {
            addCriterion("cd >", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdGreaterThanOrEqualTo(String value) {
            addCriterion("cd >=", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdLessThan(String value) {
            addCriterion("cd <", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdLessThanOrEqualTo(String value) {
            addCriterion("cd <=", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdLike(String value) {
            addCriterion("cd like", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdNotLike(String value) {
            addCriterion("cd not like", value, "cd");
            return (Criteria) this;
        }

        public Criteria andCdIn(List<String> values) {
            addCriterion("cd in", values, "cd");
            return (Criteria) this;
        }

        public Criteria andCdNotIn(List<String> values) {
            addCriterion("cd not in", values, "cd");
            return (Criteria) this;
        }

        public Criteria andCdBetween(String value1, String value2) {
            addCriterion("cd between", value1, value2, "cd");
            return (Criteria) this;
        }

        public Criteria andCdNotBetween(String value1, String value2) {
            addCriterion("cd not between", value1, value2, "cd");
            return (Criteria) this;
        }

        public Criteria andPbIsNull() {
            addCriterion("pb is null");
            return (Criteria) this;
        }

        public Criteria andPbIsNotNull() {
            addCriterion("pb is not null");
            return (Criteria) this;
        }

        public Criteria andPbEqualTo(String value) {
            addCriterion("pb =", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotEqualTo(String value) {
            addCriterion("pb <>", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbGreaterThan(String value) {
            addCriterion("pb >", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbGreaterThanOrEqualTo(String value) {
            addCriterion("pb >=", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbLessThan(String value) {
            addCriterion("pb <", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbLessThanOrEqualTo(String value) {
            addCriterion("pb <=", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbLike(String value) {
            addCriterion("pb like", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotLike(String value) {
            addCriterion("pb not like", value, "pb");
            return (Criteria) this;
        }

        public Criteria andPbIn(List<String> values) {
            addCriterion("pb in", values, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotIn(List<String> values) {
            addCriterion("pb not in", values, "pb");
            return (Criteria) this;
        }

        public Criteria andPbBetween(String value1, String value2) {
            addCriterion("pb between", value1, value2, "pb");
            return (Criteria) this;
        }

        public Criteria andPbNotBetween(String value1, String value2) {
            addCriterion("pb not between", value1, value2, "pb");
            return (Criteria) this;
        }

        public Criteria andCuIsNull() {
            addCriterion("cu is null");
            return (Criteria) this;
        }

        public Criteria andCuIsNotNull() {
            addCriterion("cu is not null");
            return (Criteria) this;
        }

        public Criteria andCuEqualTo(String value) {
            addCriterion("cu =", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotEqualTo(String value) {
            addCriterion("cu <>", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuGreaterThan(String value) {
            addCriterion("cu >", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuGreaterThanOrEqualTo(String value) {
            addCriterion("cu >=", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuLessThan(String value) {
            addCriterion("cu <", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuLessThanOrEqualTo(String value) {
            addCriterion("cu <=", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuLike(String value) {
            addCriterion("cu like", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotLike(String value) {
            addCriterion("cu not like", value, "cu");
            return (Criteria) this;
        }

        public Criteria andCuIn(List<String> values) {
            addCriterion("cu in", values, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotIn(List<String> values) {
            addCriterion("cu not in", values, "cu");
            return (Criteria) this;
        }

        public Criteria andCuBetween(String value1, String value2) {
            addCriterion("cu between", value1, value2, "cu");
            return (Criteria) this;
        }

        public Criteria andCuNotBetween(String value1, String value2) {
            addCriterion("cu not between", value1, value2, "cu");
            return (Criteria) this;
        }

        public Criteria andZnIsNull() {
            addCriterion("zn is null");
            return (Criteria) this;
        }

        public Criteria andZnIsNotNull() {
            addCriterion("zn is not null");
            return (Criteria) this;
        }

        public Criteria andZnEqualTo(String value) {
            addCriterion("zn =", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotEqualTo(String value) {
            addCriterion("zn <>", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnGreaterThan(String value) {
            addCriterion("zn >", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnGreaterThanOrEqualTo(String value) {
            addCriterion("zn >=", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnLessThan(String value) {
            addCriterion("zn <", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnLessThanOrEqualTo(String value) {
            addCriterion("zn <=", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnLike(String value) {
            addCriterion("zn like", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotLike(String value) {
            addCriterion("zn not like", value, "zn");
            return (Criteria) this;
        }

        public Criteria andZnIn(List<String> values) {
            addCriterion("zn in", values, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotIn(List<String> values) {
            addCriterion("zn not in", values, "zn");
            return (Criteria) this;
        }

        public Criteria andZnBetween(String value1, String value2) {
            addCriterion("zn between", value1, value2, "zn");
            return (Criteria) this;
        }

        public Criteria andZnNotBetween(String value1, String value2) {
            addCriterion("zn not between", value1, value2, "zn");
            return (Criteria) this;
        }

        public Criteria andFlowIsNull() {
            addCriterion("flow is null");
            return (Criteria) this;
        }

        public Criteria andFlowIsNotNull() {
            addCriterion("flow is not null");
            return (Criteria) this;
        }

        public Criteria andFlowEqualTo(String value) {
            addCriterion("flow =", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotEqualTo(String value) {
            addCriterion("flow <>", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThan(String value) {
            addCriterion("flow >", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowGreaterThanOrEqualTo(String value) {
            addCriterion("flow >=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThan(String value) {
            addCriterion("flow <", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLessThanOrEqualTo(String value) {
            addCriterion("flow <=", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowLike(String value) {
            addCriterion("flow like", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotLike(String value) {
            addCriterion("flow not like", value, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowIn(List<String> values) {
            addCriterion("flow in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotIn(List<String> values) {
            addCriterion("flow not in", values, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowBetween(String value1, String value2) {
            addCriterion("flow between", value1, value2, "flow");
            return (Criteria) this;
        }

        public Criteria andFlowNotBetween(String value1, String value2) {
            addCriterion("flow not between", value1, value2, "flow");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNull() {
            addCriterion("delFlag is null");
            return (Criteria) this;
        }

        public Criteria andDelFlagIsNotNull() {
            addCriterion("delFlag is not null");
            return (Criteria) this;
        }

        public Criteria andDelFlagEqualTo(String value) {
            addCriterion("delFlag =", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotEqualTo(String value) {
            addCriterion("delFlag <>", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThan(String value) {
            addCriterion("delFlag >", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagGreaterThanOrEqualTo(String value) {
            addCriterion("delFlag >=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThan(String value) {
            addCriterion("delFlag <", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLessThanOrEqualTo(String value) {
            addCriterion("delFlag <=", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagLike(String value) {
            addCriterion("delFlag like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotLike(String value) {
            addCriterion("delFlag not like", value, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagIn(List<String> values) {
            addCriterion("delFlag in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotIn(List<String> values) {
            addCriterion("delFlag not in", values, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagBetween(String value1, String value2) {
            addCriterion("delFlag between", value1, value2, "delFlag");
            return (Criteria) this;
        }

        public Criteria andDelFlagNotBetween(String value1, String value2) {
            addCriterion("delFlag not between", value1, value2, "delFlag");
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