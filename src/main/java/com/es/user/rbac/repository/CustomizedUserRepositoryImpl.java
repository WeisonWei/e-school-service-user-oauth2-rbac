package com.es.user.rbac.repository;/*
package com.es.user.db.repository;

import com.es.user.session.entity.User;
import com.es.user.session.entity.UserLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.springframework.data.mongodb.core.aggregation.Aggregation.*;
import static org.springframework.data.mongodb.core.aggregation.LookupOperation.newLookup;
import static org.springframework.data.mongodb.core.query.Criteria.where;
import static org.springframework.data.mongodb.core.query.Query.query;

@Repository
public class CustomizedUserRepositoryImpl implements CustomizedUserRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UserLogin findUserLogin(String name) {
        return null;
    }


    public List<User> findUserListByAgeAndSexAndHobbies() {
        Query query = query(where("age").gte(10)
                .and("sex").is("Male")
                .orOperator(where("hobbies").is("YuWen"),
                        where("hobbies").is("English")));
        List<User> users = mongoTemplate.find(query, User.class, "students");
        return users;
    }

    public List<UserLogin> findUserLoginList() {
        Aggregation aggregation = Aggregation.newAggregation(
                newLookup()
                        .from("scores")
                        .localField("name")
                        .foreignField("studentName")
                        .as("scores"),
                project()
                        .andExpression("name").as("name")
                        .andExpression("age").as("age")
                        .andExpression("sex").as("sex")
                        .andExpression("scores").as("scoreList"));

        AggregationResults<UserLogin> aggregationResults = mongoTemplate.aggregate(aggregation, "students", UserLogin.class);
        List<UserLogin> userLogins = aggregationResults.getMappedResults();
        return userLogins;
    }


    public List<UserLogin> findUserLogins() {
        Aggregation aggregation = Aggregation.newAggregation(
                newLookup()
                        .from("scores")
                        .localField("name")
                        .foreignField("studentName")
                        .as("scores"),
                match(where("age").gte(10)
                        .and("sex").is("Male")
                        //.and("scores.subjectScore").gt(60) 这里不生效
                        .orOperator(where("hobbies").is("YuWen"), where("hobbies").is("English"))),
                project()
                        .andExpression("name").as("name")
                        .andExpression("age").as("age")
                        .andExpression("sex").as("sex")
                        .andExpression("scores").as("score"),
                unwind("score"),
                match(where("score.subject").is("English")));

        AggregationResults<UserLogin> aggregationResults = mongoTemplate.aggregate(aggregation, "lgoins", UserLogin.class);
        List<UserLogin> userLogins = aggregationResults.getMappedResults();
        return userLogins;
    }
}


*/
