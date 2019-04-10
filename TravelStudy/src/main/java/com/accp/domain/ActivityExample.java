package com.accp.domain;

import java.util.ArrayList;
import java.util.List;

public class ActivityExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ActivityExample() {
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

        public Criteria andANameIsNull() {
            addCriterion("A_name is null");
            return (Criteria) this;
        }

        public Criteria andANameIsNotNull() {
            addCriterion("A_name is not null");
            return (Criteria) this;
        }

        public Criteria andANameEqualTo(String value) {
            addCriterion("A_name =", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotEqualTo(String value) {
            addCriterion("A_name <>", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThan(String value) {
            addCriterion("A_name >", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameGreaterThanOrEqualTo(String value) {
            addCriterion("A_name >=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThan(String value) {
            addCriterion("A_name <", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLessThanOrEqualTo(String value) {
            addCriterion("A_name <=", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameLike(String value) {
            addCriterion("A_name like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotLike(String value) {
            addCriterion("A_name not like", value, "aName");
            return (Criteria) this;
        }

        public Criteria andANameIn(List<String> values) {
            addCriterion("A_name in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotIn(List<String> values) {
            addCriterion("A_name not in", values, "aName");
            return (Criteria) this;
        }

        public Criteria andANameBetween(String value1, String value2) {
            addCriterion("A_name between", value1, value2, "aName");
            return (Criteria) this;
        }

        public Criteria andANameNotBetween(String value1, String value2) {
            addCriterion("A_name not between", value1, value2, "aName");
            return (Criteria) this;
        }

        public Criteria andAZbfIsNull() {
            addCriterion("A_zbf is null");
            return (Criteria) this;
        }

        public Criteria andAZbfIsNotNull() {
            addCriterion("A_zbf is not null");
            return (Criteria) this;
        }

        public Criteria andAZbfEqualTo(String value) {
            addCriterion("A_zbf =", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfNotEqualTo(String value) {
            addCriterion("A_zbf <>", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfGreaterThan(String value) {
            addCriterion("A_zbf >", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfGreaterThanOrEqualTo(String value) {
            addCriterion("A_zbf >=", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfLessThan(String value) {
            addCriterion("A_zbf <", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfLessThanOrEqualTo(String value) {
            addCriterion("A_zbf <=", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfLike(String value) {
            addCriterion("A_zbf like", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfNotLike(String value) {
            addCriterion("A_zbf not like", value, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfIn(List<String> values) {
            addCriterion("A_zbf in", values, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfNotIn(List<String> values) {
            addCriterion("A_zbf not in", values, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfBetween(String value1, String value2) {
            addCriterion("A_zbf between", value1, value2, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAZbfNotBetween(String value1, String value2) {
            addCriterion("A_zbf not between", value1, value2, "aZbf");
            return (Criteria) this;
        }

        public Criteria andAPriceIsNull() {
            addCriterion("A_price is null");
            return (Criteria) this;
        }

        public Criteria andAPriceIsNotNull() {
            addCriterion("A_price is not null");
            return (Criteria) this;
        }

        public Criteria andAPriceEqualTo(String value) {
            addCriterion("A_price =", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceNotEqualTo(String value) {
            addCriterion("A_price <>", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceGreaterThan(String value) {
            addCriterion("A_price >", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceGreaterThanOrEqualTo(String value) {
            addCriterion("A_price >=", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceLessThan(String value) {
            addCriterion("A_price <", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceLessThanOrEqualTo(String value) {
            addCriterion("A_price <=", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceLike(String value) {
            addCriterion("A_price like", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceNotLike(String value) {
            addCriterion("A_price not like", value, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceIn(List<String> values) {
            addCriterion("A_price in", values, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceNotIn(List<String> values) {
            addCriterion("A_price not in", values, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceBetween(String value1, String value2) {
            addCriterion("A_price between", value1, value2, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAPriceNotBetween(String value1, String value2) {
            addCriterion("A_price not between", value1, value2, "aPrice");
            return (Criteria) this;
        }

        public Criteria andAJieshaoIsNull() {
            addCriterion("A_jieshao is null");
            return (Criteria) this;
        }

        public Criteria andAJieshaoIsNotNull() {
            addCriterion("A_jieshao is not null");
            return (Criteria) this;
        }

        public Criteria andAJieshaoEqualTo(String value) {
            addCriterion("A_jieshao =", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoNotEqualTo(String value) {
            addCriterion("A_jieshao <>", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoGreaterThan(String value) {
            addCriterion("A_jieshao >", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoGreaterThanOrEqualTo(String value) {
            addCriterion("A_jieshao >=", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoLessThan(String value) {
            addCriterion("A_jieshao <", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoLessThanOrEqualTo(String value) {
            addCriterion("A_jieshao <=", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoLike(String value) {
            addCriterion("A_jieshao like", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoNotLike(String value) {
            addCriterion("A_jieshao not like", value, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoIn(List<String> values) {
            addCriterion("A_jieshao in", values, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoNotIn(List<String> values) {
            addCriterion("A_jieshao not in", values, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoBetween(String value1, String value2) {
            addCriterion("A_jieshao between", value1, value2, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAJieshaoNotBetween(String value1, String value2) {
            addCriterion("A_jieshao not between", value1, value2, "aJieshao");
            return (Criteria) this;
        }

        public Criteria andAAgeIsNull() {
            addCriterion("A_age is null");
            return (Criteria) this;
        }

        public Criteria andAAgeIsNotNull() {
            addCriterion("A_age is not null");
            return (Criteria) this;
        }

        public Criteria andAAgeEqualTo(String value) {
            addCriterion("A_age =", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeNotEqualTo(String value) {
            addCriterion("A_age <>", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeGreaterThan(String value) {
            addCriterion("A_age >", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeGreaterThanOrEqualTo(String value) {
            addCriterion("A_age >=", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeLessThan(String value) {
            addCriterion("A_age <", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeLessThanOrEqualTo(String value) {
            addCriterion("A_age <=", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeLike(String value) {
            addCriterion("A_age like", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeNotLike(String value) {
            addCriterion("A_age not like", value, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeIn(List<String> values) {
            addCriterion("A_age in", values, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeNotIn(List<String> values) {
            addCriterion("A_age not in", values, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeBetween(String value1, String value2) {
            addCriterion("A_age between", value1, value2, "aAge");
            return (Criteria) this;
        }

        public Criteria andAAgeNotBetween(String value1, String value2) {
            addCriterion("A_age not between", value1, value2, "aAge");
            return (Criteria) this;
        }

        public Criteria andAHaochuIsNull() {
            addCriterion("A_haochu is null");
            return (Criteria) this;
        }

        public Criteria andAHaochuIsNotNull() {
            addCriterion("A_haochu is not null");
            return (Criteria) this;
        }

        public Criteria andAHaochuEqualTo(String value) {
            addCriterion("A_haochu =", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuNotEqualTo(String value) {
            addCriterion("A_haochu <>", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuGreaterThan(String value) {
            addCriterion("A_haochu >", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuGreaterThanOrEqualTo(String value) {
            addCriterion("A_haochu >=", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuLessThan(String value) {
            addCriterion("A_haochu <", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuLessThanOrEqualTo(String value) {
            addCriterion("A_haochu <=", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuLike(String value) {
            addCriterion("A_haochu like", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuNotLike(String value) {
            addCriterion("A_haochu not like", value, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuIn(List<String> values) {
            addCriterion("A_haochu in", values, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuNotIn(List<String> values) {
            addCriterion("A_haochu not in", values, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuBetween(String value1, String value2) {
            addCriterion("A_haochu between", value1, value2, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andAHaochuNotBetween(String value1, String value2) {
            addCriterion("A_haochu not between", value1, value2, "aHaochu");
            return (Criteria) this;
        }

        public Criteria andCountIsNull() {
            addCriterion("count is null");
            return (Criteria) this;
        }

        public Criteria andCountIsNotNull() {
            addCriterion("count is not null");
            return (Criteria) this;
        }

        public Criteria andCountEqualTo(Integer value) {
            addCriterion("count =", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotEqualTo(Integer value) {
            addCriterion("count <>", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThan(Integer value) {
            addCriterion("count >", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("count >=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThan(Integer value) {
            addCriterion("count <", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountLessThanOrEqualTo(Integer value) {
            addCriterion("count <=", value, "count");
            return (Criteria) this;
        }

        public Criteria andCountIn(List<Integer> values) {
            addCriterion("count in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotIn(List<Integer> values) {
            addCriterion("count not in", values, "count");
            return (Criteria) this;
        }

        public Criteria andCountBetween(Integer value1, Integer value2) {
            addCriterion("count between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andCountNotBetween(Integer value1, Integer value2) {
            addCriterion("count not between", value1, value2, "count");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNull() {
            addCriterion("Spare1 is null");
            return (Criteria) this;
        }

        public Criteria andSpare1IsNotNull() {
            addCriterion("Spare1 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare1EqualTo(String value) {
            addCriterion("Spare1 =", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotEqualTo(String value) {
            addCriterion("Spare1 <>", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThan(String value) {
            addCriterion("Spare1 >", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1GreaterThanOrEqualTo(String value) {
            addCriterion("Spare1 >=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThan(String value) {
            addCriterion("Spare1 <", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1LessThanOrEqualTo(String value) {
            addCriterion("Spare1 <=", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Like(String value) {
            addCriterion("Spare1 like", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotLike(String value) {
            addCriterion("Spare1 not like", value, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1In(List<String> values) {
            addCriterion("Spare1 in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotIn(List<String> values) {
            addCriterion("Spare1 not in", values, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1Between(String value1, String value2) {
            addCriterion("Spare1 between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare1NotBetween(String value1, String value2) {
            addCriterion("Spare1 not between", value1, value2, "spare1");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNull() {
            addCriterion("Spare2 is null");
            return (Criteria) this;
        }

        public Criteria andSpare2IsNotNull() {
            addCriterion("Spare2 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare2EqualTo(String value) {
            addCriterion("Spare2 =", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotEqualTo(String value) {
            addCriterion("Spare2 <>", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThan(String value) {
            addCriterion("Spare2 >", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2GreaterThanOrEqualTo(String value) {
            addCriterion("Spare2 >=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThan(String value) {
            addCriterion("Spare2 <", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2LessThanOrEqualTo(String value) {
            addCriterion("Spare2 <=", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Like(String value) {
            addCriterion("Spare2 like", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotLike(String value) {
            addCriterion("Spare2 not like", value, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2In(List<String> values) {
            addCriterion("Spare2 in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotIn(List<String> values) {
            addCriterion("Spare2 not in", values, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2Between(String value1, String value2) {
            addCriterion("Spare2 between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare2NotBetween(String value1, String value2) {
            addCriterion("Spare2 not between", value1, value2, "spare2");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNull() {
            addCriterion("Spare3 is null");
            return (Criteria) this;
        }

        public Criteria andSpare3IsNotNull() {
            addCriterion("Spare3 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare3EqualTo(String value) {
            addCriterion("Spare3 =", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotEqualTo(String value) {
            addCriterion("Spare3 <>", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThan(String value) {
            addCriterion("Spare3 >", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3GreaterThanOrEqualTo(String value) {
            addCriterion("Spare3 >=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThan(String value) {
            addCriterion("Spare3 <", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3LessThanOrEqualTo(String value) {
            addCriterion("Spare3 <=", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Like(String value) {
            addCriterion("Spare3 like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotLike(String value) {
            addCriterion("Spare3 not like", value, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3In(List<String> values) {
            addCriterion("Spare3 in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotIn(List<String> values) {
            addCriterion("Spare3 not in", values, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3Between(String value1, String value2) {
            addCriterion("Spare3 between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare3NotBetween(String value1, String value2) {
            addCriterion("Spare3 not between", value1, value2, "spare3");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNull() {
            addCriterion("Spare4 is null");
            return (Criteria) this;
        }

        public Criteria andSpare4IsNotNull() {
            addCriterion("Spare4 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare4EqualTo(String value) {
            addCriterion("Spare4 =", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotEqualTo(String value) {
            addCriterion("Spare4 <>", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThan(String value) {
            addCriterion("Spare4 >", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4GreaterThanOrEqualTo(String value) {
            addCriterion("Spare4 >=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThan(String value) {
            addCriterion("Spare4 <", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4LessThanOrEqualTo(String value) {
            addCriterion("Spare4 <=", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Like(String value) {
            addCriterion("Spare4 like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotLike(String value) {
            addCriterion("Spare4 not like", value, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4In(List<String> values) {
            addCriterion("Spare4 in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotIn(List<String> values) {
            addCriterion("Spare4 not in", values, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4Between(String value1, String value2) {
            addCriterion("Spare4 between", value1, value2, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare4NotBetween(String value1, String value2) {
            addCriterion("Spare4 not between", value1, value2, "spare4");
            return (Criteria) this;
        }

        public Criteria andSpare5IsNull() {
            addCriterion("Spare5 is null");
            return (Criteria) this;
        }

        public Criteria andSpare5IsNotNull() {
            addCriterion("Spare5 is not null");
            return (Criteria) this;
        }

        public Criteria andSpare5EqualTo(String value) {
            addCriterion("Spare5 =", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotEqualTo(String value) {
            addCriterion("Spare5 <>", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5GreaterThan(String value) {
            addCriterion("Spare5 >", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5GreaterThanOrEqualTo(String value) {
            addCriterion("Spare5 >=", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5LessThan(String value) {
            addCriterion("Spare5 <", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5LessThanOrEqualTo(String value) {
            addCriterion("Spare5 <=", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5Like(String value) {
            addCriterion("Spare5 like", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotLike(String value) {
            addCriterion("Spare5 not like", value, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5In(List<String> values) {
            addCriterion("Spare5 in", values, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotIn(List<String> values) {
            addCriterion("Spare5 not in", values, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5Between(String value1, String value2) {
            addCriterion("Spare5 between", value1, value2, "spare5");
            return (Criteria) this;
        }

        public Criteria andSpare5NotBetween(String value1, String value2) {
            addCriterion("Spare5 not between", value1, value2, "spare5");
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