package ru.durnov.dao;

import ru.durnov.expressions.ArithmeticExpression;
import ru.durnov.expressions.Expression;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ExpressionDataBase implements DataBase{
    private final EntityManagerFactory entityManagerFactory;

    public ExpressionDataBase(){
        this.entityManagerFactory = Persistence.createEntityManagerFactory("ExpressionEntity");
    }

    @Override
    public void saveExpression(Expression expression) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        ExpressionEntity expressionEntity = new ExpressionEntity(expression);
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();
        entityManager.persist(expressionEntity);
        if (expressionEntity.getId() > 10){
            entityManager
                    .createQuery("delete from ExpressionEntity e where e.id <" + (expressionEntity.getId()-9))
                    .executeUpdate();
        }
        transaction.commit();
        entityManager.close();
    }

    @Override
    public List<ExpressionEntity> expressionList() {
        List<Expression> expressions = new ArrayList<>();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        List<ExpressionEntity> expressionEntities = entityManager
                .createQuery("select e from ExpressionEntity e")
                .setMaxResults(10)
                .getResultList();
        return expressionEntities.stream().sorted(new ExpressionEntityComparator()).collect(Collectors.toList());
    }
}
