package com.xmmems.domain.temp;

import java.util.ArrayList;
import java.util.List;

public class TempManaymetaYz02Example {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TempManaymetaYz02Example() {
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

        public Criteria andYz_cateIsNull() {
            addCriterion("yz_cate is null");
            return (Criteria) this;
        }

        public Criteria andYz_cateIsNotNull() {
            addCriterion("yz_cate is not null");
            return (Criteria) this;
        }

        public Criteria andYz_cateEqualTo(String value) {
            addCriterion("yz_cate =", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateNotEqualTo(String value) {
            addCriterion("yz_cate <>", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateGreaterThan(String value) {
            addCriterion("yz_cate >", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateGreaterThanOrEqualTo(String value) {
            addCriterion("yz_cate >=", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateLessThan(String value) {
            addCriterion("yz_cate <", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateLessThanOrEqualTo(String value) {
            addCriterion("yz_cate <=", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateLike(String value) {
            addCriterion("yz_cate like", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateNotLike(String value) {
            addCriterion("yz_cate not like", value, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateIn(List<String> values) {
            addCriterion("yz_cate in", values, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateNotIn(List<String> values) {
            addCriterion("yz_cate not in", values, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateBetween(String value1, String value2) {
            addCriterion("yz_cate between", value1, value2, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andYz_cateNotBetween(String value1, String value2) {
            addCriterion("yz_cate not between", value1, value2, "yz_cate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateIsNull() {
            addCriterion("anlyDate is null");
            return (Criteria) this;
        }

        public Criteria andAnlyDateIsNotNull() {
            addCriterion("anlyDate is not null");
            return (Criteria) this;
        }

        public Criteria andAnlyDateEqualTo(String value) {
            addCriterion("anlyDate =", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateNotEqualTo(String value) {
            addCriterion("anlyDate <>", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateGreaterThan(String value) {
            addCriterion("anlyDate >", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateGreaterThanOrEqualTo(String value) {
            addCriterion("anlyDate >=", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateLessThan(String value) {
            addCriterion("anlyDate <", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateLessThanOrEqualTo(String value) {
            addCriterion("anlyDate <=", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateLike(String value) {
            addCriterion("anlyDate like", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateNotLike(String value) {
            addCriterion("anlyDate not like", value, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateIn(List<String> values) {
            addCriterion("anlyDate in", values, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateNotIn(List<String> values) {
            addCriterion("anlyDate not in", values, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateBetween(String value1, String value2) {
            addCriterion("anlyDate between", value1, value2, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andAnlyDateNotBetween(String value1, String value2) {
            addCriterion("anlyDate not between", value1, value2, "anlyDate");
            return (Criteria) this;
        }

        public Criteria andRateIsNull() {
            addCriterion("rate is null");
            return (Criteria) this;
        }

        public Criteria andRateIsNotNull() {
            addCriterion("rate is not null");
            return (Criteria) this;
        }

        public Criteria andRateEqualTo(String value) {
            addCriterion("rate =", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotEqualTo(String value) {
            addCriterion("rate <>", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThan(String value) {
            addCriterion("rate >", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateGreaterThanOrEqualTo(String value) {
            addCriterion("rate >=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThan(String value) {
            addCriterion("rate <", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLessThanOrEqualTo(String value) {
            addCriterion("rate <=", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateLike(String value) {
            addCriterion("rate like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotLike(String value) {
            addCriterion("rate not like", value, "rate");
            return (Criteria) this;
        }

        public Criteria andRateIn(List<String> values) {
            addCriterion("rate in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotIn(List<String> values) {
            addCriterion("rate not in", values, "rate");
            return (Criteria) this;
        }

        public Criteria andRateBetween(String value1, String value2) {
            addCriterion("rate between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andRateNotBetween(String value1, String value2) {
            addCriterion("rate not between", value1, value2, "rate");
            return (Criteria) this;
        }

        public Criteria andTempIsNull() {
            addCriterion("temp is null");
            return (Criteria) this;
        }

        public Criteria andTempIsNotNull() {
            addCriterion("temp is not null");
            return (Criteria) this;
        }

        public Criteria andTempEqualTo(String value) {
            addCriterion("temp =", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotEqualTo(String value) {
            addCriterion("temp <>", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThan(String value) {
            addCriterion("temp >", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempGreaterThanOrEqualTo(String value) {
            addCriterion("temp >=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThan(String value) {
            addCriterion("temp <", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLessThanOrEqualTo(String value) {
            addCriterion("temp <=", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempLike(String value) {
            addCriterion("temp like", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotLike(String value) {
            addCriterion("temp not like", value, "temp");
            return (Criteria) this;
        }

        public Criteria andTempIn(List<String> values) {
            addCriterion("temp in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotIn(List<String> values) {
            addCriterion("temp not in", values, "temp");
            return (Criteria) this;
        }

        public Criteria andTempBetween(String value1, String value2) {
            addCriterion("temp between", value1, value2, "temp");
            return (Criteria) this;
        }

        public Criteria andTempNotBetween(String value1, String value2) {
            addCriterion("temp not between", value1, value2, "temp");
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

        public Criteria andGeIsNull() {
            addCriterion("ge is null");
            return (Criteria) this;
        }

        public Criteria andGeIsNotNull() {
            addCriterion("ge is not null");
            return (Criteria) this;
        }

        public Criteria andGeEqualTo(String value) {
            addCriterion("ge =", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotEqualTo(String value) {
            addCriterion("ge <>", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeGreaterThan(String value) {
            addCriterion("ge >", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeGreaterThanOrEqualTo(String value) {
            addCriterion("ge >=", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeLessThan(String value) {
            addCriterion("ge <", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeLessThanOrEqualTo(String value) {
            addCriterion("ge <=", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeLike(String value) {
            addCriterion("ge like", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotLike(String value) {
            addCriterion("ge not like", value, "ge");
            return (Criteria) this;
        }

        public Criteria andGeIn(List<String> values) {
            addCriterion("ge in", values, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotIn(List<String> values) {
            addCriterion("ge not in", values, "ge");
            return (Criteria) this;
        }

        public Criteria andGeBetween(String value1, String value2) {
            addCriterion("ge between", value1, value2, "ge");
            return (Criteria) this;
        }

        public Criteria andGeNotBetween(String value1, String value2) {
            addCriterion("ge not between", value1, value2, "ge");
            return (Criteria) this;
        }

        public Criteria andQIsNull() {
            addCriterion("q is null");
            return (Criteria) this;
        }

        public Criteria andQIsNotNull() {
            addCriterion("q is not null");
            return (Criteria) this;
        }

        public Criteria andQEqualTo(String value) {
            addCriterion("q =", value, "q");
            return (Criteria) this;
        }

        public Criteria andQNotEqualTo(String value) {
            addCriterion("q <>", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThan(String value) {
            addCriterion("q >", value, "q");
            return (Criteria) this;
        }

        public Criteria andQGreaterThanOrEqualTo(String value) {
            addCriterion("q >=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThan(String value) {
            addCriterion("q <", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLessThanOrEqualTo(String value) {
            addCriterion("q <=", value, "q");
            return (Criteria) this;
        }

        public Criteria andQLike(String value) {
            addCriterion("q like", value, "q");
            return (Criteria) this;
        }

        public Criteria andQNotLike(String value) {
            addCriterion("q not like", value, "q");
            return (Criteria) this;
        }

        public Criteria andQIn(List<String> values) {
            addCriterion("q in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQNotIn(List<String> values) {
            addCriterion("q not in", values, "q");
            return (Criteria) this;
        }

        public Criteria andQBetween(String value1, String value2) {
            addCriterion("q between", value1, value2, "q");
            return (Criteria) this;
        }

        public Criteria andQNotBetween(String value1, String value2) {
            addCriterion("q not between", value1, value2, "q");
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

        public Criteria andLIsNull() {
            addCriterion("l is null");
            return (Criteria) this;
        }

        public Criteria andLIsNotNull() {
            addCriterion("l is not null");
            return (Criteria) this;
        }

        public Criteria andLEqualTo(String value) {
            addCriterion("l =", value, "l");
            return (Criteria) this;
        }

        public Criteria andLNotEqualTo(String value) {
            addCriterion("l <>", value, "l");
            return (Criteria) this;
        }

        public Criteria andLGreaterThan(String value) {
            addCriterion("l >", value, "l");
            return (Criteria) this;
        }

        public Criteria andLGreaterThanOrEqualTo(String value) {
            addCriterion("l >=", value, "l");
            return (Criteria) this;
        }

        public Criteria andLLessThan(String value) {
            addCriterion("l <", value, "l");
            return (Criteria) this;
        }

        public Criteria andLLessThanOrEqualTo(String value) {
            addCriterion("l <=", value, "l");
            return (Criteria) this;
        }

        public Criteria andLLike(String value) {
            addCriterion("l like", value, "l");
            return (Criteria) this;
        }

        public Criteria andLNotLike(String value) {
            addCriterion("l not like", value, "l");
            return (Criteria) this;
        }

        public Criteria andLIn(List<String> values) {
            addCriterion("l in", values, "l");
            return (Criteria) this;
        }

        public Criteria andLNotIn(List<String> values) {
            addCriterion("l not in", values, "l");
            return (Criteria) this;
        }

        public Criteria andLBetween(String value1, String value2) {
            addCriterion("l between", value1, value2, "l");
            return (Criteria) this;
        }

        public Criteria andLNotBetween(String value1, String value2) {
            addCriterion("l not between", value1, value2, "l");
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