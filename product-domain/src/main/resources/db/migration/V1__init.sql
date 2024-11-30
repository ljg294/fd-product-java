DROP TABLE IF EXISTS menu;

#-----------------------------------------------------------------------------------------------------------------------
#-- Table 명 : menu (메뉴)
#-----------------------------------------------------------------------------------------------------------------------
CREATE TABLE menu
(
    menu_id                          BIGINT                      NOT NULL         AUTO_INCREMENT  COMMENT '메뉴 ID',
    diner_id                         BIGINT                      NOT NULL                         COMMENT '음식점 ID',
    menu_name                        VARCHAR(255)                NOT NULL                         COMMENT '메뉴 명',
    menu_price                       BIGDECIMAL(10,2)            NOT NULL                         COMMENT '메뉴 가격',
    delete_yn                        varchar(1)                  NOT NULL                         COMMENT '삭제여부',
    created_member_id                BIGINT                      NOT NULL                         COMMENT '등록자ID',
    created_date_time                DATETIME                    NOT NULL                         COMMENT '등록일시',
    modified_member_id               BIGINT                      NOT NULL                         COMMENT '수정자ID',
    modified_date_time               DATETIME                    NOT NULL                         COMMENT '수정일시',

    CONSTRAINT pk_menu PRIMARY KEY (menu_id),
    CONSTRAINT chk_member_delete_yn CHECK (delete_yn IN ('Y', 'N')),
) ENGINE = INNODB DEFAULT CHARSET=utf8mb4 COMMENT='menu';