package org.example.controller;

import org.example.model.Building;
import org.example.service.BuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class BuildingController {

    private BuildingService service;

    public BuildingController() {
    }

    @Autowired
    public BuildingController(BuildingService service) {
        this.service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView getAllPage() {
        List<Building> buildingList = service.getAllBuildings();

        ModelAndView view = new ModelAndView();
        view.setViewName("allBuildings");
        view.addObject("buildingList", buildingList);
        return view;
    }

    @RequestMapping(value = "/build/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable Long id) {
        Building building = service.getBuildingById(id);

        ModelAndView view = new ModelAndView();
        view.setViewName("editBuilding");
        view.addObject("building", building);
        return view;
    }

    @RequestMapping(value = "/build/edit", method = RequestMethod.POST)
    public ModelAndView editBuilding(@ModelAttribute Building building) {
        service.editBuilding(building);

        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/");
        return view;
    }

    @RequestMapping(value = "/build/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        return new ModelAndView("addBuilding");
    }

    @RequestMapping(value = "/build/add", method = RequestMethod.POST)
    public ModelAndView addBuilding(@ModelAttribute Building building) {
        service.addBuilding(building);

        ModelAndView view = new ModelAndView();
        view.setViewName("redirect:/");
        return view;
    }

    @RequestMapping(value = "/build/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete(@PathVariable Long id) {
        service.deleteBuilding(id);

        return new ModelAndView("redirect:/");
    }
}
