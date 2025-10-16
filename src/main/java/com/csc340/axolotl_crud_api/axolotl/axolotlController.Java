package com.csc340.axolotl_crud_api.axolotl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AxolotlController {

  @Autowired
  private AxolotlService service;

  /**
   * Get all animals
   */
  @GetMapping("/animals")
  public List<Axolotl> getAll() {
    return service.getAllAnimals();
  }

  /**
   * Get one animal by ID
   */
  @GetMapping("/animals/{id}")
  public ResponseEntity<Axolotl> getById(@PathVariable long id) {
    Axolotl a = service.getAnimalById(id);
    if (a == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(a);
  }

  /**
   * Get animals whose name contains substring
   * Example: /animals/search?name=mo
   */
  @GetMapping("/animals/search")
  public List<Axolotl> searchByName(@RequestParam(name = "name") String key) {
    return service.getByNameContains(key);
  }

  /**
   * Get all animals of a given category (morph)
   * Example: /animals/category/leucistic
   */
  @GetMapping("/animals/category/{morph}")
  public List<Axolotl> byCategory(@PathVariable String morph) {
    return service.getByCategory(morph);
  }

  /**
   * Add a new animal
   */
  @PostMapping("/animals")
  public Axolotl add(@RequestBody Axolotl body) {
    return service.addAnimal(body);
  }

  /**
   * Update existing animal
   */
  @PutMapping("/animals/{id}")
  public ResponseEntity<Axolotl> update(@PathVariable Long id, @RequestBody Axolotl body) {
    Axolotl updated = service.updateAnimal(id, body);
    if (updated == null) return ResponseEntity.notFound().build();
    return ResponseEntity.ok(updated);
  }

  /**
   * Delete existing animal
   */
  @DeleteMapping("/animals/{id}")
  public List<Axolotl> delete(@PathVariable Long id) {
    service.deleteAnimal(id);
    return service.getAllAnimals();
  }
}
