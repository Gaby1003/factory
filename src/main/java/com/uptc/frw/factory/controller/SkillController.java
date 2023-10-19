package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.Skill;
import com.uptc.frw.factory.service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/skill")
public class SkillController {
    @Autowired
    private SkillService service;
    @GetMapping
    public List<Skill> findAll() {
        return service.findAllSkill();
    }
    @PostMapping
    public Skill saveSkill(@RequestBody Skill skill){
        return service.saveSkill(skill);
    }
    @GetMapping("/{id}")
    public Skill findSkill(@PathVariable Long id) {
        return service.findSkill(id);
    }
    @DeleteMapping("/{id}")
    public void deleteSkill(@PathVariable Long id){
        service.deleteSkill(id);
    }
    @PutMapping("/{id}")
    public Skill updateSkill(@PathVariable Long id,@RequestParam String description){
        return service.updateDescription(id,description);
    }
}
