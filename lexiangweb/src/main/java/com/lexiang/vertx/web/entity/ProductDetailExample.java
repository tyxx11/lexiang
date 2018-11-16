package com.lexiang.vertx.web.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductDetailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ProductDetailExample() {
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

        public Criteria andProductIdIsNull() {
            addCriterion("product_id is null");
            return (Criteria) this;
        }

        public Criteria andProductIdIsNotNull() {
            addCriterion("product_id is not null");
            return (Criteria) this;
        }

        public Criteria andProductIdEqualTo(Integer value) {
            addCriterion("product_id =", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotEqualTo(Integer value) {
            addCriterion("product_id <>", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThan(Integer value) {
            addCriterion("product_id >", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("product_id >=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThan(Integer value) {
            addCriterion("product_id <", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdLessThanOrEqualTo(Integer value) {
            addCriterion("product_id <=", value, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdIn(List<Integer> values) {
            addCriterion("product_id in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotIn(List<Integer> values) {
            addCriterion("product_id not in", values, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdBetween(Integer value1, Integer value2) {
            addCriterion("product_id between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andProductIdNotBetween(Integer value1, Integer value2) {
            addCriterion("product_id not between", value1, value2, "productId");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitIsNull() {
            addCriterion("team_member_upper_limit is null");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitIsNotNull() {
            addCriterion("team_member_upper_limit is not null");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitEqualTo(Integer value) {
            addCriterion("team_member_upper_limit =", value, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitNotEqualTo(Integer value) {
            addCriterion("team_member_upper_limit <>", value, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitGreaterThan(Integer value) {
            addCriterion("team_member_upper_limit >", value, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitGreaterThanOrEqualTo(Integer value) {
            addCriterion("team_member_upper_limit >=", value, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitLessThan(Integer value) {
            addCriterion("team_member_upper_limit <", value, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitLessThanOrEqualTo(Integer value) {
            addCriterion("team_member_upper_limit <=", value, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitIn(List<Integer> values) {
            addCriterion("team_member_upper_limit in", values, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitNotIn(List<Integer> values) {
            addCriterion("team_member_upper_limit not in", values, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitBetween(Integer value1, Integer value2) {
            addCriterion("team_member_upper_limit between", value1, value2, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andTeamMemberUpperLimitNotBetween(Integer value1, Integer value2) {
            addCriterion("team_member_upper_limit not between", value1, value2, "teamMemberUpperLimit");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleIsNull() {
            addCriterion("sign_up_people is null");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleIsNotNull() {
            addCriterion("sign_up_people is not null");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleEqualTo(String value) {
            addCriterion("sign_up_people =", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleNotEqualTo(String value) {
            addCriterion("sign_up_people <>", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleGreaterThan(String value) {
            addCriterion("sign_up_people >", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleGreaterThanOrEqualTo(String value) {
            addCriterion("sign_up_people >=", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleLessThan(String value) {
            addCriterion("sign_up_people <", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleLessThanOrEqualTo(String value) {
            addCriterion("sign_up_people <=", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleLike(String value) {
            addCriterion("sign_up_people like", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleNotLike(String value) {
            addCriterion("sign_up_people not like", value, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleIn(List<String> values) {
            addCriterion("sign_up_people in", values, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleNotIn(List<String> values) {
            addCriterion("sign_up_people not in", values, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleBetween(String value1, String value2) {
            addCriterion("sign_up_people between", value1, value2, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andSignUpPeopleNotBetween(String value1, String value2) {
            addCriterion("sign_up_people not between", value1, value2, "signUpPeople");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceIsNull() {
            addCriterion("gathering_place is null");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceIsNotNull() {
            addCriterion("gathering_place is not null");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceEqualTo(String value) {
            addCriterion("gathering_place =", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceNotEqualTo(String value) {
            addCriterion("gathering_place <>", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceGreaterThan(String value) {
            addCriterion("gathering_place >", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("gathering_place >=", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceLessThan(String value) {
            addCriterion("gathering_place <", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceLessThanOrEqualTo(String value) {
            addCriterion("gathering_place <=", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceLike(String value) {
            addCriterion("gathering_place like", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceNotLike(String value) {
            addCriterion("gathering_place not like", value, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceIn(List<String> values) {
            addCriterion("gathering_place in", values, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceNotIn(List<String> values) {
            addCriterion("gathering_place not in", values, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceBetween(String value1, String value2) {
            addCriterion("gathering_place between", value1, value2, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andGatheringPlaceNotBetween(String value1, String value2) {
            addCriterion("gathering_place not between", value1, value2, "gatheringPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceIsNull() {
            addCriterion("disbanded_place is null");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceIsNotNull() {
            addCriterion("disbanded_place is not null");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceEqualTo(String value) {
            addCriterion("disbanded_place =", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceNotEqualTo(String value) {
            addCriterion("disbanded_place <>", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceGreaterThan(String value) {
            addCriterion("disbanded_place >", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceGreaterThanOrEqualTo(String value) {
            addCriterion("disbanded_place >=", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceLessThan(String value) {
            addCriterion("disbanded_place <", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceLessThanOrEqualTo(String value) {
            addCriterion("disbanded_place <=", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceLike(String value) {
            addCriterion("disbanded_place like", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceNotLike(String value) {
            addCriterion("disbanded_place not like", value, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceIn(List<String> values) {
            addCriterion("disbanded_place in", values, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceNotIn(List<String> values) {
            addCriterion("disbanded_place not in", values, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceBetween(String value1, String value2) {
            addCriterion("disbanded_place between", value1, value2, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andDisbandedPlaceNotBetween(String value1, String value2) {
            addCriterion("disbanded_place not between", value1, value2, "disbandedPlace");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdIsNull() {
            addCriterion("travel_topo_id is null");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdIsNotNull() {
            addCriterion("travel_topo_id is not null");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdEqualTo(Integer value) {
            addCriterion("travel_topo_id =", value, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdNotEqualTo(Integer value) {
            addCriterion("travel_topo_id <>", value, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdGreaterThan(Integer value) {
            addCriterion("travel_topo_id >", value, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("travel_topo_id >=", value, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdLessThan(Integer value) {
            addCriterion("travel_topo_id <", value, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdLessThanOrEqualTo(Integer value) {
            addCriterion("travel_topo_id <=", value, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdIn(List<Integer> values) {
            addCriterion("travel_topo_id in", values, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdNotIn(List<Integer> values) {
            addCriterion("travel_topo_id not in", values, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdBetween(Integer value1, Integer value2) {
            addCriterion("travel_topo_id between", value1, value2, "travelTopoId");
            return (Criteria) this;
        }

        public Criteria andTravelTopoIdNotBetween(Integer value1, Integer value2) {
            addCriterion("travel_topo_id not between", value1, value2, "travelTopoId");
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