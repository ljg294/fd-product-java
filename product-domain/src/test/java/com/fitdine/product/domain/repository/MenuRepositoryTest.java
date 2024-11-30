package com.fitdine.product.domain.repository;

import com.fitdine.product.domain.DomainIntegrationTest;
import com.fitdine.product.domain.entity.MenuEntity;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

@DomainIntegrationTest
class MenuRepositoryTest {

    @Autowired
    private MenuRepository menuRepository;

    private MenuEntity menu;

    @BeforeEach
    void setUp() {
        // Arrange
        menu = MenuEntity.builder()
                .dinerId(1L)
                .menuName("Burger")
                .menuPrice(BigDecimal.valueOf(10.50))
                .build();

        menuRepository.save(menu);
    }

    @AfterEach
    void tearDown() {
        menuRepository.deleteAllInBatch();
    }

    @Test
    @DisplayName("메뉴 저장 성공")
    void testSaveMenuSuccess() {
        // Arrange
        MenuEntity savedMenu = MenuEntity.createBuilder()
                .dinerId(2L)
                .menuName("Pizza")
                .menuPrice(BigDecimal.valueOf(15.75))
                .build();

        // Act
        menuRepository.save(savedMenu);

        // Assert
        assertThat(savedMenu.getMenuId()).isNotNull();
        assertThat(savedMenu.getMenuName()).isEqualTo("Pizza");
        assertThat(savedMenu.getMenuPrice()).isEqualTo(BigDecimal.valueOf(15.75));
    }

    @Test
    @DisplayName("메뉴 ID로 메뉴 조회 성공")
    void testFindByIdSuccess() {
        // Act
        Optional<MenuEntity> retrievedMenu = menuRepository.findById(menu.getMenuId());

        // Assert
        assertThat(retrievedMenu).isPresent();
        assertThat(retrievedMenu.get().getMenuName()).isEqualTo("Burger");
    }

    @Test
    @DisplayName("음식점 ID로 메뉴 조회 성공")
    void testFindByDinerIdSuccess() {
        // Act
        List<MenuEntity> retrievedMenus = menuRepository.findByDinerId(menu.getDinerId());

        // Assert
        assertThat(retrievedMenus).isNotEmpty();
        assertThat(retrievedMenus.get(0).getMenuName()).isEqualTo("Burger");
    }
}