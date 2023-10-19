package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Material;
import com.uptc.frw.factory.jpa.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    public MaterialRepository repository;

    public List<Material> findAllMaterials(){
        return repository.findAll();
    }
    public Material findMaterial(Long materialId){
        return repository.findById(materialId).get();
    }
    public Material saveMaterial(Material material){
        return repository.save(material);
    }
    public String updateMaterial(Long idMaterial,String name){
        Material material= findMaterial(idMaterial);
        material.setName(name);
        repository.save(material);
        return "Material con ID "+idMaterial+" actualizado con exito.";
    }
    public String deleteMaterial(Long idMaterial){
        repository.deleteById(idMaterial);
        return "Material con id "+idMaterial+" eliminado con exito.";
    }
}
