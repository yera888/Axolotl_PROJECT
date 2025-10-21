package com.csc340.axolotl_crud_api.axolotl;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface AxolotlRepository extends JpaRepository<Axolotl, Long> {

  List<Axolotl> getAxolotlsByMorph(String morph);

  List<Axolotl> getAxolotlsBySex(String sex);

  @Query(value = "select * from axolotls a where a.name like %?1%", nativeQuery = true)
  List<Axolotl> getAxolotlsByName(String name);

  @Query(value = "select * from axolotls a where a.description like %?1%", nativeQuery = true)
  List<Axolotl> getAxolotlsByDescription(String description);
}









