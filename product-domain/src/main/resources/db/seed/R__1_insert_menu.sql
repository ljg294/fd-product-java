INSERT INTO menu (
    menu_id,
    diner_id,
    menu_name,
    menu_price,
    delete_yn,
    created_member_id,
    created_date_time,
    modified_member_id,
    modified_date_time
) VALUES
      (1, 1, 'Burger', 10.50, 'N', 1, '2024-01-01 10:30:00', 1, '2024-01-01 10:30:00'),
      (2, 1, 'Pizza', 15.75, 'N', 1, '2024-01-02 11:15:00', 1, '2024-01-02 11:15:00'),
      (3, 2, 'Pasta', 12.99, 'N', 1, '2024-01-03 12:45:00', 1, '2024-01-03 12:45:00'),
      (4, 2, 'Salad', 8.50, 'N', 1, '2024-01-04 14:00:00', 1, '2024-01-04 14:00:00'),
      (5, 3, 'Sushi', 20.00, 'N', 1, '2024-01-05 15:20:00', 1, '2024-01-05 15:20:00');

COMMIT;