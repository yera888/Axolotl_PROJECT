package com.csc340.axolotl_crud_api.axolotl;

import java.io.IOException;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class AxolotlService {

  @Autowired
  private AxolotlRepository axolotlRepository;

  /**
   * Method to get all axolotls
   *
   * @return List of all axolotls
   */
  public Object getAllAxolotls() {
    return axolotlRepository.findAll();
  }

  /**
   * Method to get an axolotl by ID
   *
   * @param axolotlId The ID of the axolotl to retrieve
   * @return The axolotl with the specified ID
   */
  public Axolotl getAxolotlById(@PathVariable long axolotlId) {
    return axolotlRepository.findById(axolotlId).orElse(null);
  }

  /**
   * Method to get axolotls by name (contains match)
   *
   * @param name The substring to search for in name
   * @return List of axolotls whose name contains the substring
   */
  public Object getAxolotlsByName(String name) {
    return axolotlRepository.getAxolotlsByName(name);
  }

  /**
   * Method to get axolotls by description (contains match)
   *
   * @param description The substring to search for in description
   * @return List of axolotls whose description contains the substring
   */
  public Object getAxolotlsByDescription(String description) {
    return axolotlRepository.getAxolotlsByDescription(description);
  }

  /**
   * Method to get axolotls by morph (category)
   *
   * @param morph The morph to search for
   * @return List of axolotls with the specified morph
   */
  public Object getAxolotlsByMorph(String morph) {
    return axolotlRepository.getAxolotlsByMorph(morph);
  }

  /**
   * Method to get axolotls by sex
   *
   * @param sex The sex to search for
   * @return List of axolotls with the specified sex
   */
  public Object getAxolotlsBySex(String sex) {
    return axolotlRepository.getAxolotlsBySex(sex);
  }

  /**
   * Method to add a new axolotl
   *
   * @param axolotl The axolotl to add
   */
  public Axolotl addAxolotl(Axolotl axolotl) {
    return axolotlRepository.save(axolotl);
  }

  /**
   * Method to update an axolotl
   *
   * @param axolotlId The ID of the axolotl to update
   * @param axolotl   The updated axolotl information
   */
  public Axolotl updateAxolotl(Long axolotlId, Axolotl axolotl) {
    return axolotlRepository.save(axolotl);
  }

  /**
   * Method to delete an axolotl
   *
   * @param axolotlId The ID of the axolotl to delete
   */
  public void deleteAxolotl(Long axolotlId) {
    axolotlRepository.deleteById(axolotlId);
  }

  /**
   * Method to write an axolotl object to a JSON file
   *
   * @param axolotl The axolotl object to write
   */
  public String writeJson(Axolotl axolotl) {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      objectMapper.writeValue(new File("axolotls.json"), axolotl);
      return "Axolotl written to JSON file successfully";
    } catch (IOException e) {
      e.printStackTrace();
      return "Error writing axolotl to JSON file";
    }
  }

  /**
   * Method to read an axolotl object from a JSON file
   *
   * @return The axolotl object read from the JSON file
   */
  public Object readJson() {
    ObjectMapper objectMapper = new ObjectMapper();
    try {
      return objectMapper.readValue(new File("axolotls.json"), Axolotl.class);
    } catch (IOException e) {
      e.printStackTrace();
      return null;
    }
  }
}