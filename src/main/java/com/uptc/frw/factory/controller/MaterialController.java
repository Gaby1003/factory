package com.uptc.frw.factory.controller;

import com.uptc.frw.factory.jpa.entity.Material;
import com.uptc.frw.factory.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/material")
public class MaterialController {
    @Autowired
    private MaterialService service;

    @GetMapping
    public List<Material> findAllMaterials() {
        return service.findAllMaterials();
    }
    @GetMapping("/{materialId}")
    public Material findMaterial(@PathVariable Long materialId) {
        return service.findMaterial(materialId);
    }
    @PostMapping
    public Material saveMaterial(@RequestBody Material material) {
        return service.saveMaterial(material);
    }
    @PutMapping("/{idMaterial}")
    public String updateMaterial(@PathVariable Long idMaterial,@RequestParam String name) {
        return service.updateMaterial(idMaterial, name);
    }
    @DeleteMapping("/{idMaterial}")
    public String deleteMaterial(@PathVariable Long idMaterial) {
        return service.deleteMaterial(idMaterial);
    }
}
