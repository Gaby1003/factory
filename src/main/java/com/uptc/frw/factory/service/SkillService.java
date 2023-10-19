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

    public List<Skill> findAllSkill() {
        return repository.findAll();
    }

    public Skill saveSkill(Skill skill) {
        return repository.save(skill);
    }

    public Skill findSkill(Long id) {
        return repository.findById(id).get();
    }

    public void deleteSkill(Long id) { repository.deleteById(id);}
    public Skill updateDescription(Long id,String description){
        Skill skill = findSkill(id);
        skill.setDescription(description);
        return saveSkill(skill);
    }
}