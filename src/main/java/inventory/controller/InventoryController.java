package inventory.controller;


import inventory.model.InventoryObject;
import inventory.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class InventoryController {


    private InventoryService inventoryService;

    @Autowired
    public void setInventoryService(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView allObjects() {
        List<InventoryObject> objects = inventoryService.allObjects();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("objects");
        modelAndView.addObject("objectsList", objects);
        return modelAndView;
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public ModelAndView editPage(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        modelAndView.addObject("obj", inventoryService.getById(id));
        return modelAndView;
    }
    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public ModelAndView editObject(@ModelAttribute("obj") InventoryObject inventoryObject) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        inventoryService.edit(inventoryObject);
        return modelAndView;
    }


    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public ModelAndView addPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("editPage");
        return modelAndView;
    }
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView addObject(@ModelAttribute("obj") InventoryObject inventoryObject) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        inventoryService.add(inventoryObject);
        return modelAndView;
    }


    @RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
    public ModelAndView deleteObject(@PathVariable("id") int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/");
        InventoryObject inventoryObject = inventoryService.getById(id);
        inventoryService.delete(inventoryObject);
        return modelAndView;
    }




}