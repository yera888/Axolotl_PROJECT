package com.csc340.axolotl_crud_api.axolotl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AxolotlRepository extends JpaRepository<Axolotl, Long> {

  // Category filter (assignment requires “all animals of a given category”)
  List<Axolotl> findByMorphIgnoreCase(String morph);

  // Custom SQL (assignment rubric asks for at least one custom query)
  @Query(value = """
      select * from axolotls a
      where lower(a.name) like lower(concat('%', ?1, '%'))
      """, nativeQuery = true)
  List<Axolotl> searchByName(String key);
}
