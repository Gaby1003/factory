package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Skill;
import com.uptc.frw.factory.jpa.repository.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SkillService {
    @Autowired
    public SkillRepository repository;

    @Autowired
    private LogService logService;

    public List<Skill> findAllSkill() {
        List<Skill> skills = repository.findAll();
        logService.createLogList(Skill.class.getSimpleName(),skills);
        return skills;
    }

    public Skill saveSkill(Skill skill) {
        Skill skillAux = repository.save(skill);
        logService.createLogAdd(skill.toString(), String.valueOf(skillAux.getId()),
                skill.getClass().getSimpleName());
        return skillAux;
    }

    public Skill findSkill(Long id) {
        Skill skill = repository.findById(id).get();
        logService.createLogRead(skill.toString(),skill.getId().toString(),
                skill.getClass().getSimpleName());
        return repository.findById(id).get();
    }

    public void deleteSkill(Long id) {
        Skill skill = repository.findById(id).get();
        logService.createLogDelete(skill.toString(),skill.getId().toString(),
                skill.getClass().getSimpleName());
        repository.deleteById(id);
    }
    public Skill updateDescription(Long id,String description){
        Skill skill = findSkill(id);
        String skillAux = findSkill(id).toString();
        skill.setDescription(description);
        logService.createLogUpdate(skillAux,skill.toString(),
                skill.getId().toString(),skill.getClass().getSimpleName());
        return repository.save(skill);
    }
}