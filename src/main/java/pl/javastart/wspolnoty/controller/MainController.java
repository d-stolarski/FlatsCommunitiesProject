package pl.javastart.wspolnoty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.javastart.wspolnoty.model.Community;
import pl.javastart.wspolnoty.model.Dweller;
import pl.javastart.wspolnoty.model.Flat;
import pl.javastart.wspolnoty.db.CommunityRepository;
import pl.javastart.wspolnoty.db.DwellerRepository;
import pl.javastart.wspolnoty.db.FlatRepository;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private CommunityRepository communityRepository;

    @Autowired
    private DwellerRepository dwellerRepository;

    @Autowired
    private FlatRepository flatRepository;


    @GetMapping("/")
    public String home(){
        return "mainPage";
    }

    @GetMapping("/dwellers/add")
    public String addDwellerForm(Model model, Dweller dweller){
        model.addAttribute("dweller", new Dweller());
        return "addDweller";
    }

    @PostMapping("/dwellers/add")
    @ResponseBody
    public String addDweller(Dweller dweller) {
        dwellerRepository.save(dweller);
        return "Dodano mieszkańca!";
    }

    @GetMapping("/communities/add")
    public String addCommunitiesForm(Model model, Community community){
        model.addAttribute("community", new Community());
        return "addCommunity";
    }

    @PostMapping("/communities/add")
    @ResponseBody
    public String addCommunity(Community community) {
        communityRepository.save(community);
        return "Dodano wspólnotę!";
    }

    @GetMapping("/flats/add")
    public String addFlatsForm(Model model, Flat flat){
        model.addAttribute("flat", new Flat());
        return "addFlat";
    }

    @PostMapping("/flats/add")
    @ResponseBody
    public String addFlat(Flat flat) {
        flatRepository.save(flat);
        return "Dodano mieszkanie!";
    }

    @GetMapping("/dwellers/edit/{id}")
    public String editDwellerForm(@PathVariable Long id, Model model) {
        Dweller dweller = dwellerRepository.findOne(id);
        model.addAttribute("dweller", dweller);
        return "editDweller";
    }

    @PostMapping("/dwellers/edit/{id}")
    public String editDweller(Dweller dweller, @PathVariable Long id)  {
        Dweller newDweller = dwellerRepository.findOne(id);
        newDweller.setFirstName(dweller.getFirstName());
        newDweller.setLastName(dweller.getLastName());
        newDweller.setGender(dweller.getGender());
        newDweller.setFlat(dweller.getFlat());

        dwellerRepository.save(newDweller);
        return "redirect:/dwellers/edit/" + dweller.getId();
    }

    @GetMapping("/communities/edit/{id}")
    public String editCommunitiesForm(@PathVariable Long id, Model model) {
        Community community = communityRepository.findOne(id);
        model.addAttribute("community", community);
        return "editCommunity";
    }

    @PostMapping("/communities/edit/{id}")
    public String editCommunity(Community community, @PathVariable Long id)  {
        Community newCommunity = communityRepository.findOne(id);
        newCommunity.setName(community.getName());
        newCommunity.setAdress(community.getAdress());

        communityRepository.save(newCommunity);
        return "redirect:/communities/edit/" + community.getId();
    }

    @GetMapping("/flats/edit/{id}")
    public String editFlatsForm(@PathVariable Long id, Model model) {
        Flat flat = flatRepository.findOne(id);
        model.addAttribute("flat", flat);
        return "editFlat";
    }

    @PostMapping("/flats/edit/{id}")
    public String editFlat(Flat flat, @PathVariable Long id)  {
        Flat newFlat = flatRepository.findOne(id);
        newFlat.setNumber(flat.getNumber());
        newFlat.setArea(flat.getArea());
        newFlat.setCommunity(flat.getCommunity());

        flatRepository.save(newFlat);
        return "redirect:/flats/edit/" + flat.getId();
    }

    @GetMapping("/dwellers/delete/{id}")
    @ResponseBody
    public String deleteDweller(@PathVariable Long id) {
        dwellerRepository.delete(id);
        return "Usunięto mieszkańca!";
    }

    @GetMapping("/flats/delete/{id}")
    @ResponseBody
    public String deleteFlat(@PathVariable Long id) {
        flatRepository.delete(id);
        return "Usunięto mieszkanie!";
    }

    @GetMapping("/communities/delete/{id}")
    @ResponseBody
    public String deleteCommunity(@PathVariable Long id) {
        communityRepository.delete(id);
        return "Usunięto wspólnotę!";
    }

    @GetMapping("/communities/list")
    public String communitiesList(Model model) {
        model.addAttribute("communities", communityRepository.findAll());
        return "communitiesList";
    }

    @GetMapping("/flats/list")
    public String flatsList(Model model) {
        model.addAttribute("flats", flatRepository.findAll());
        return "flatsList";
    }

    @GetMapping("/dwellers/list")
    public String dwellersList(Model model) {
        model.addAttribute("dwellers", dwellerRepository.findAll());
        return "dwellerList";
    }

    @GetMapping("/communities/flats-area/{id}")
    @ResponseBody
    public String communityFlatsArea(@PathVariable Long id) {
        Double areaSum = flatRepository.returnAllFlatsFromCommunity(id);
        return "Suma powierzchni wszystkich mieszkań we wspólnocie: " + Math.round(areaSum*100)/100.00 + " m2";
    }

    @GetMapping("/flats/flat-dwellers/{id}")
    public String getFlatDwellers(@PathVariable Long id, Model model) {
        model.addAttribute("dwellers", dwellerRepository.getFlatDwellers(id));
        return "flatDwellersList";
    }

    @GetMapping("/communities/dwellers-list/{id}")
    public String getCommunityDwellers(@PathVariable Long id, Model model) {
        List<Dweller> dwellersList = new ArrayList<>();
        List<Dweller> dwellers = new ArrayList<>();
        List<Flat> flatList = flatRepository.getCommunityFlats(id);

        for (Flat flat : flatList) {
            dwellersList = dwellerRepository.getFlatDwellers(flat.getId());
            for (Dweller dweller : dwellersList) {
                dwellers.add(dweller);
            }
        }

        model.addAttribute("flats", flatRepository.getCommunityFlats(id));
        model.addAttribute("dwellers", dwellers);
        return "communityDwellersList";
    }



}
