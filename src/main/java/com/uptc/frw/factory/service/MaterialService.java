package com.uptc.frw.factory.service;

import com.uptc.frw.factory.jpa.entity.Machine;
import com.uptc.frw.factory.jpa.entity.Material;
import com.uptc.frw.factory.jpa.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MaterialService {
    @Autowired
    public MaterialRepository repository;

    @Autowired
    private LogService logService;

    public List<Material> findAllMaterials(){
        List<Material> materials = repository.findAll();
        logService.createLogList(Material.class.getSimpleName(),materials);
        return materials;
    }
    public Material findMaterial(Long materialId){
        Material material = repository.findById(materialId).get();
        logService.createLogRead(material.toString(),material.getIdMaterial().toString(),
                material.getClass().getSimpleName());
        return material;
    }
    public Material saveMaterial(Material material){
       Material materialAux = repository.save(material);
        logService.createLogAdd(material.toString(), String.valueOf(materialAux.getIdMaterial()),
                material.getClass().getSimpleName());
        return materialAux;
    }
    public String updateMaterial(Long idMaterial,String name){
        Material material = findMaterial(idMaterial);
        String materialAux = findMaterial(idMaterial).toString();
        material.setName(name);
        logService.createLogUpdate(materialAux,material.toString(),
                material.getIdMaterial().toString(),material.getClass().getSimpleName());
        repository.save(material);
        return "Material con ID "+idMaterial+" actualizado con exito.";
    }
    public String deleteMaterial(Long idMaterial){
        Material material = repository.findById(idMaterial).get();
        logService.createLogDelete(material.toString(),material.getIdMaterial().toString(),
                 material.getClass().getSimpleName());
        repository.deleteById(idMaterial);
        return "Material con id "+idMaterial+" eliminado con exito.";
    }
}
