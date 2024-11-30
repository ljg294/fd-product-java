package com.fitdine.product.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Getter
@Table(name = "menu")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class MenuEntity extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long menuId;

    @Column(name = "diner_id", nullable = false, columnDefinition = "bigint COMMENT '음식점 ID'")
    private Long dinerId;

    @Column(name = "menu_name", nullable = false, columnDefinition = "varchar(25) COMMENT '메뉴 명'")
    private String menuName;

    @Column(name = "menu_price", nullable = false, columnDefinition = "decimal(10,2) COMMENT '메뉴 가격'")
    private BigDecimal menuPrice;

    @Builder
    public MenuEntity(Long menuId,
                      Long dinerId,
                      String menuName,
                      BigDecimal menuPrice) {
        this.menuId = menuId;
        this.dinerId = dinerId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }

    @Builder(builderClassName = "createBuilder", builderMethodName = "createBuilder")
    public MenuEntity(Long dinerId,
                      String menuName,
                      BigDecimal menuPrice) {
        this.dinerId = dinerId;
        this.menuName = menuName;
        this.menuPrice = menuPrice;
    }
}
