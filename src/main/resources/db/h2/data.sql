insert into reviewer (created_date, modified_date, user_id) values (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '3ede0ef2-92b7-4817-a5f3-0c575361f741'),
                                                                   (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '3ede0ef2-92b7-4817-a5f3-0c575361f742'),
                                                                   (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '3ede0ef2-92b7-4817-a5f3-0c575361f743'),
                                                                   (CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '3ede0ef2-92b7-4817-a5f3-0c575361f744');

insert into place(place_id) values('2e4baf1c-5acb-4efb-a1af-eddada31b000'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b001'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b002'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b003'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b004'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b005'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b006'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b007'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b008'),
                                  ('2e4baf1c-5acb-4efb-a1af-eddada31b009');

insert into review (review_num, created_date, modified_date, content, is_deleted, place_id, review_id, reviewer_id)
            values (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null, false , '2e4baf1c-5acb-4efb-a1af-eddada31b000', '240a1658-dc5f-4878-9381-ebb7b2667701', '3ede0ef2-92b7-4817-a5f3-0c575361f741'),
                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '별로에요', false , '2e4baf1c-5acb-4efb-a1af-eddada31b001', '240a1658-dc5f-4878-9381-ebb7b2667702', '3ede0ef2-92b7-4817-a5f3-0c575361f741'),
                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null , false , '2e4baf1c-5acb-4efb-a1af-eddada31b002', '240a1658-dc5f-4878-9381-ebb7b2667703', '3ede0ef2-92b7-4817-a5f3-0c575361f741'),

                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '좋아요', false , '2e4baf1c-5acb-4efb-a1af-eddada31b000', '240a1658-dc5f-4878-9381-ebb7b2667704', '3ede0ef2-92b7-4817-a5f3-0c575361f742'),
                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '좋아요', false , '2e4baf1c-5acb-4efb-a1af-eddada31b005', '240a1658-dc5f-4878-9381-ebb7b2667705', '3ede0ef2-92b7-4817-a5f3-0c575361f742'),

                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, '그냥 그래요' , false , '2e4baf1c-5acb-4efb-a1af-eddada31b005', '240a1658-dc5f-4878-9381-ebb7b2667706', '3ede0ef2-92b7-4817-a5f3-0c575361f743'),

                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null , false , '2e4baf1c-5acb-4efb-a1af-eddada31b007', '240a1658-dc5f-4878-9381-ebb7b2667707', '3ede0ef2-92b7-4817-a5f3-0c575361f744'),
                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null , false , '2e4baf1c-5acb-4efb-a1af-eddada31b008', '240a1658-dc5f-4878-9381-ebb7b2667708', '3ede0ef2-92b7-4817-a5f3-0c575361f744'),
                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null , false , '2e4baf1c-5acb-4efb-a1af-eddada31b009', '240a1658-dc5f-4878-9381-ebb7b2667709', '3ede0ef2-92b7-4817-a5f3-0c575361f744'),
                   (default, CURRENT_TIMESTAMP, CURRENT_TIMESTAMP, null , false , '2e4baf1c-5acb-4efb-a1af-eddada31b001', '240a1658-dc5f-4878-9381-ebb7b2667710', '3ede0ef2-92b7-4817-a5f3-0c575361f744');

insert into point (created_date, modified_date, review_id, reviewer_id, score, type) values (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 1, '3ede0ef2-92b7-4817-a5f3-0c575361f741', 1, 'ADD_REVIEW_FIRST_PLACE'),
                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 1, '3ede0ef2-92b7-4817-a5f3-0c575361f741', 1, 'ATTACH_REVIEW_PHOTO'),

                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 2, '3ede0ef2-92b7-4817-a5f3-0c575361f741', 1, 'ADD_REVIEW_CONTENT'),
                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 2, '3ede0ef2-92b7-4817-a5f3-0c575361f741', 1, 'ADD_REVIEW_FIRST_PLACE'),

                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 3, '3ede0ef2-92b7-4817-a5f3-0c575361f741', 1, 'ATTACH_REVIEW_PHOTO'),
                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 3, '3ede0ef2-92b7-4817-a5f3-0c575361f741', 1, 'ADD_REVIEW_FIRST_PLACE'),

                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 4, '3ede0ef2-92b7-4817-a5f3-0c575361f742', 1, 'ADD_REVIEW_CONTENT'),
                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 4, '3ede0ef2-92b7-4817-a5f3-0c575361f742', 1, 'ATTACH_REVIEW_PHOTO'),

                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 5, '3ede0ef2-92b7-4817-a5f3-0c575361f742', 1, 'ADD_REVIEW_CONTENT'),
                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 5, '3ede0ef2-92b7-4817-a5f3-0c575361f742', 1, 'ADD_REVIEW_FIRST_PLACE'),

                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 6, '3ede0ef2-92b7-4817-a5f3-0c575361f743', 1, 'ADD_REVIEW_CONTENT'),

                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 7, '3ede0ef2-92b7-4817-a5f3-0c575361f744', 1, 'ADD_REVIEW_FIRST_PLACE'),
                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 8, '3ede0ef2-92b7-4817-a5f3-0c575361f744', 1, 'ADD_REVIEW_FIRST_PLACE'),
                                                                                            (CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 9, '3ede0ef2-92b7-4817-a5f3-0c575361f744', 1, 'ADD_REVIEW_FIRST_PLACE');



insert into attached_photo (attaced_photo_num, attached_photo_id, review_id) values (default, 'e4d1a64e-a531-46de-88d0-ff0ed70c0b01', 1),
                                                                                    (default, 'e4d1a64e-a531-46de-88d0-ff0ed70c0b02', 3),
                                                                                    (default, 'e4d1a64e-a531-46de-88d0-ff0ed70c0b03', 4);