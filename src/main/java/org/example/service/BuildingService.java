package org.example.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.example.dao.BuildingDao;
import org.example.model.Building;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@NoArgsConstructor
public class BuildingService {

    private BuildingDao dao;

    @Autowired
    public BuildingService(BuildingDao dao) {
        this.dao = dao;
    }

    @Transactional
    public List<Building> getAllBuildings() {
        return dao.getBuildingList();
    }
    @Transactional
    public Building getBuildingById(Long id) {
        return dao.getBuildingById(id);
    }
    @Transactional
    public void addBuilding(Building building) {
        dao.addBuilding(building);
    }
    @Transactional
    public void editBuilding(Building building) {
        dao.updateBuilding(building);
    }
    @Transactional
    public void deleteBuilding(Long id) {
        dao.deleteBuilding(id);
    }
}
