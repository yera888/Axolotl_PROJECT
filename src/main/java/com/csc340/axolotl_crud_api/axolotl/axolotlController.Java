package com.csc340.axolotl_crud_api.axolotl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AxolotlController {

  @Autowired
  private AxolotlService axolotlService;

  /**
   * Endpoint to get all axolotls
   *
   * @return List of all axolotls
   */
  @GetMapping("/axolotls")
  public Object getAllAxolotls() {
    return axolotlService.getAllAxolotls();
  }

  /**
   * Endpoint to get an axolotl by ID
   *
   * @param id The ID of the axolotl to retrieve
   * @return The axolotl with the specified ID
   */
  @GetMapping("/axolotls/{id}")
  public Axolotl getAxolotlById(@PathVariable long id) {
    return axolotlService.getAxolotlById(id);
  }

  /**
   * Endpoint to get axolotls by name
   *
   * @param key The name substring to search for
   * @return List of axolotls whose name contains the key
   */
  @GetMapping("/axolotls/name")
  public Object getAxolotlsByName(@RequestParam String key) {
    if (key != null) {
      return axolotlService.getAxolotlsByName(key);
    } else {
      return axolotlService.getAllAxolotls();
    }
  }

  /**
   * Endpoint to get axolotls by morph (category)
   *
   * @param morph The morph to search for
   * @return List of axolotls with the specified morph
   */
  @GetMapping("/axolotls/morph/{morph}")
  public Object getAxolotlsByMorph(@PathVariable String morph) {
    return axolotlService.getAxolotlsByMorph(morph);
  }

  /**
   * Endpoint to get axolotls by sex
   *
   * @param sex The sex to filter by (e.g., "MALE", "FEMALE", "UNKNOWN")
   * @return List of axolotls matching the specified sex
   */
  @GetMapping("/axolotls/sex")
  public Object getAxolotlsBySex(@RequestParam(name = "sex", defaultValue = "UNKNOWN") String sex) {
    return new ResponseEntity<>(axolotlService.getAxolotlsBySex(sex), HttpStatus.OK);
  }

  /**
   * Endpoint to add a new axolotl
   *
   * @param axolotl The axolotl to add
   * @return The created axolotl
   */
  @PostMapping("/axolotls")
  public Object addAxolotl(@RequestBody Axolotl axolotl) {
    return axolotlService.addAxolotl(axolotl);
  }

  /**
   * Endpoint to update an axolotl
   *
   * @param id      The ID of the axolotl to update
   * @param axolotl The updated axolotl information
   * @return The updated axolotl
   */
  @PutMapping("/axolotls/{id}")
  public Axolotl updateAxolotl(@PathVariable Long id, @RequestBody Axolotl axolotl) {
    axolotlService.updateAxolotl(id, axolotl);
    return axolotlService.getAxolotlById(id);
  }

  /**
   * Endpoint to delete an axolotl
   *
   * @param id The ID of the axolotl to delete
   * @return List of all remaining axolotls
   */
  @DeleteMapping("/axolotls/{id}")
  public Object deleteAxolotl(@PathVariable Long id) {
    axolotlService.deleteAxolotl(id);
    return axolotlService.getAllAxolotls();
  }

  /**
   * Endpoint to write an axolotl to a JSON file
   *
   * @param axolotl The axolotl to write
   * @return A status string
   */
  @PostMapping("/axolotls/writeFile")
  public Object writeJson(@RequestBody Axolotl axolotl) {
    return axolotlService.writeJson(axolotl);
  }

  /**
   * Endpoint to read a JSON file and return its contents
   *
   * @return The contents of the JSON file
   */
  @GetMapping("/axolotls/readFile")
  public Object readJson() {
    return axolotlService.readJson();
  }
}






