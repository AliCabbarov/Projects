package com.library.libmanagesys.repository;

import com.library.libmanagesys.model.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
    @Query("select b from books  b join b.authors a where " +
            "(lower(:name) is null or lower(b.name) like concat ('%',lower(:name) ,'%')) and " +
            "(lower(:genre) is null or lower(b.genre) like  concat('%', :genre,'%' )) and " +
            "(lower(:description) is null  or lower(b.description) like concat('%', lower(:description),'%')) and " +
            "(lower(:authorName) is null  or lower(a.name) like concat('%', lower(:authorName),'%')) and " +
            "(lower(:authorSurname) is null or lower(a.surname) like concat('%', lower(:authorSurname),'%'))")
    List<Book> findBy(@Param("name") String name,
                      @Param("genre") String genre,
                      @Param("description") String description,
                      @Param("authorName") String authorName,
                      @Param("authorSurname") String authorSurname);
    @Query(nativeQuery = true,value = "update books set name = ?1 where id = ?2 ")
    @Modifying
    void updateBook(String name, Long id);



}
