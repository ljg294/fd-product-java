package com.fitdine.product.domain.repository;

import com.fitdine.product.domain.entity.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface MenuRepository extends JpaRepository<MenuEntity, Long> {

    List<MenuEntity> findByDinerId(Long dinerId);
}
