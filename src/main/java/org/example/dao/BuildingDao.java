package org.example.dao;

import org.example.model.Building;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class BuildingDao {

    private SessionFactory sessionFactory;

    private static long ID = 0;
    private static Map<Long, Building> buildings = new HashMap<>();

    public BuildingDao() {
    }

    @Autowired
    public BuildingDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public List<Building> getBuildingList() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("FROM Building").list();
    }

    public Building getBuildingById(Long id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Building.class, id);
    }

    public void addBuilding(Building building) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(building);
    }

    public void updateBuilding(Building building) {
        Session session = sessionFactory.getCurrentSession();
        session.update(building);
    }

    public void deleteBuilding(Long id) {
        Session session = sessionFactory.getCurrentSession();
        Building building = session.get(Building.class, id);
        session.delete(building);
    }
}
